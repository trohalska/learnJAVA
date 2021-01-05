package basicNIO;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.DoubleBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Nio {
	
	private static final String TEMP_TEST_TXT = "/temp/test.txt";
	private static final String TEST_DAT = "test.dat";

	public static void main(String[] args) throws Exception {
//		pathTest();
//		filesTest();
//		buffersTest();
//		fileChannelScatterGatherTest();
		asyncChannelTest();
	}
	
	static void filesTest() throws IOException {
		UserPrincipal owner = Files.getOwner(Paths.get(TEMP_TEST_TXT));
		System.out.println(owner);
		Set<PosixFilePermission> permissions = Files.getPosixFilePermissions(Paths.get(TEMP_TEST_TXT));
		for (PosixFilePermission p : permissions) {
			System.out.println(p);
		}
	}
	static void pathTest() throws URISyntaxException, IOException {
		Path path = Paths.get("/temp");
		System.out.println(path.toUri());
		
		path = Paths.get(new URI("file:///temp/"));
		System.out.println(path.toUri());
		
		path = Paths.get("");
		System.out.println(path.toUri());
		
		FileSystem fs = FileSystems.getDefault();
		Iterator<FileStore> fsit = fs.getFileStores().iterator();
		while (fsit.hasNext()) {
			FileStore fileStore = (FileStore) fsit.next();
			System.out.println(fileStore);
			System.out.printf("Type: %s, Total: %s, Useable: %s%n", fileStore.type(), fileStore.getTotalSpace(),
					fileStore.getUsableSpace());
		}
		
	}
	
	private static void buffersTest() {
		ByteBuffer bbuf = ByteBuffer.allocate(16);
		DoubleBuffer dbuf = bbuf.asDoubleBuffer();
		dbuf.mark();
		dbuf.put(1D);
		dbuf.put(2D);
		dbuf.reset();
		System.out.println(Arrays.toString(bbuf.array()));
//		System.out.println(Arrays.toString(dbuf.array()));  // exception
	}

	private static void fileChannelScatterGatherTest() throws IOException {
		
		ByteBuffer header = ByteBuffer.allocate(128);
		fillBufWithChars(header);
		ByteBuffer body   = ByteBuffer.allocate(1024);
		fillBufWithChars(body);
		System.out.println(new String(header.array(), StandardCharsets.UTF_16));
		System.out.println(header);
		System.out.println(new String(body.array(), StandardCharsets.UTF_16));
		System.out.println(body);
		
		FileChannel channel = FileChannel.open(Paths.get(TEST_DAT), 
				StandardOpenOption.CREATE,
				StandardOpenOption.READ,
				StandardOpenOption.WRITE);

		//write data into buffers
		ByteBuffer[] bufferArray = { header, body };
		System.out.println("Writing...");
		channel.write(bufferArray);
		
		header = ByteBuffer.allocate(128);
		body   = ByteBuffer.allocate(1024);
		channel.position(0);
		ByteBuffer[] bufferArray2 = { header, body };
		//read data into buffers
		System.out.println("Reading...");
		channel.read(bufferArray2);
		System.out.println(new String(header.array(), StandardCharsets.UTF_16));
		System.out.println(header);
		System.out.println(new String(body.array(), StandardCharsets.UTF_16));
		System.out.println(body);
		channel.close();
	}
	
	private static void asyncChannelTest() throws IOException, InterruptedException, ExecutionException {
		ByteBuffer buf = ByteBuffer.allocate(1024 * 1024);
		fillBufWithDoubles(buf);
		AsynchronousFileChannel afc = AsynchronousFileChannel.open(Paths.get("./test.dat"), 
				StandardOpenOption.CREATE,
				StandardOpenOption.READ,
				StandardOpenOption.WRITE);
		
		// (1) way with Future
		System.out.println("~~~~~~ Future ~~~~~~~");
		buf.mark();
		Future<Integer> f = afc.write(buf, 0);
		// while cycle for test purpose only
		while (!f.isDone()) {
			System.out.println("Waiting");
		}
		System.out.println(f.get()); // waiting for result
		System.out.println(buf);
		
		// (2) way with CompletionHandler
		System.out.println("~~~~~~ CompletionHandler ~~~~~~~");
		// reset buf position to the start point
		buf.reset();
		afc.write(buf, 0, buf, new CompletionHandler<Integer, ByteBuffer>() {

			@Override
			public void completed(Integer result, ByteBuffer attachment) {
				System.out.println("Result: " + result + ", Attach: " + attachment);
			}

			@Override
			public void failed(Throwable exc, ByteBuffer attachment) {
				System.out.println(exc.getMessage());
			}
		});
		afc.close();
	}

	static void fillBufWithDoubles(ByteBuffer buf) {
		buf.mark();
		int size = buf.remaining();
		for (int i = 0; i < size / 8; i++) {
			buf.putDouble(i);
		}
		buf.reset();
	}
	
	static void fillBufWithChars(ByteBuffer buf) {
		buf.mark();
		int size = buf.remaining();
		for (int i = 0; i < size / 2; i++) {
			buf.putChar((char) (i + '0'));
		}
		buf.reset();
	}
}
