import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.PrintWriter;

public class SSLClient {
    public static void main(String[] args) throws Exception {
        SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) socketFactory.createSocket("localhost", 9999);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello, server! This is a secure message.");
        System.out.println("Message sent.");

        out.close();
        socket.close();
    }
}
