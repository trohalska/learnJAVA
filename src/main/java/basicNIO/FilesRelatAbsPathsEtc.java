package basicNIO;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class FilesRelatAbsPathsEtc {
	public static void main(String[] args) throws IOException, URISyntaxException {
		System.out.println("User dir: " + System.getProperty("user.dir"));
		File file = new File("\\\\folder\\file");
		URI uri = new URI("file:///temp/a");
		System.out.println(new File(uri).isDirectory());
		System.out.println(file.getAbsolutePath());
		System.out.println("Hidden " + Files.isHidden(Paths.get("./.classpath")));
		System.out.println(file.getParent());
		System.out.println("Current path: " + file.getAbsolutePath());
		System.out.println("Current canonical path: " + file.getCanonicalPath());
		file = new File("\\folder\\file");
		System.out.println("Win style current path: " + file.getAbsolutePath());
		file = new File("d:\\folder\\file");
		System.out.println("Win style current path: " + file.getAbsolutePath());
		file = new File("/folder/file");
		System.out.println("Linux style current path: " + file.getAbsolutePath());
		file = new File("d:/folder/file");
		System.out.println("Linux style current path: " + file.getAbsolutePath());
		System.out.println("Linux style current path: " + file.getCanonicalFile());

		System.out.println("Files in the current dir: ");
		printFiles();

		System.out.println("Directories: ");
		filterFiles(new FileFilter() {
			@Override
			public boolean accept(File pathname) {
//				return pathname.toString().endsWith(".txt");
//				return pathname.isFile();
				return pathname.isDirectory();
			}
		});

		file.mkdirs();

		final int[] countFiles = {0};
		Files.walkFileTree(Paths.get(new File("").getAbsolutePath()), new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
				return super.preVisitDirectory(dir, attrs);
			}
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//				System.out.println(file);
//				System.out.println(attrs.isRegularFile());
				countFiles[0]++;
				return super.visitFile(file, attrs);
			}
		});
		System.out.println(countFiles[0]);
	}

	private static void printFiles() {
		File file = new File("").getAbsoluteFile();
		File[] files = file.listFiles();
		for (File f : files) {
			System.out.println(f);
		}
	}

	private static void filterFiles(FileFilter filter) {
		File file = new File("").getAbsoluteFile();
		File[] files = file.listFiles(filter);
		for (File f : files) {
			System.out.println(f);
		}
	}

	private void mkdir(String path) {
		File f = new File(path);
		f.mkdirs();
	}
}
