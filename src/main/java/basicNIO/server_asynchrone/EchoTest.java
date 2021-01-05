package basicNIO.server_asynchrone;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EchoTest {

    Process server;
    EchoClient client1;
    EchoClient client2;
    EchoClient client3;

    @Before
    public void setup() throws IOException, InterruptedException {
        server = EchoServer.start();
        client1 = new EchoClient(3030);
        client2 = new EchoClient(3030);
        client3 = new EchoClient(3030);
    }

    @Test
    public void givenServerClient__whenServerEchosMessage__thenCorrect() {
        String resp1 = client1.sendMessage("hello1");
        String resp2 = client1.sendMessage("world1");
        String resp3 = client2.sendMessage("hello2");
        String resp4 = client2.sendMessage("world2");
        String resp5 = client3.sendMessage("hello3");
        String resp6 = client3.sendMessage("world3");
        assertEquals("hello", resp1);
        assertEquals("world", resp2);
        assertEquals("hello", resp3);
        assertEquals("world", resp4);
        assertEquals("hello", resp5);
        assertEquals("world", resp6);
    }

    @After
    public void teardown() throws IOException {
        server.destroy();
        client1.stop();
        client2.stop();
        client3.stop();
    }
}