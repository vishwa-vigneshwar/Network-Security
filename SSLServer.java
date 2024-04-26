import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SSLServer {
    public static void main(String[] args) throws Exception {
        SSLServerSocketFactory serverSocketFactory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket serverSocket = (SSLServerSocket) serverSocketFactory.createServerSocket(9999);
        System.out.println("Server started. Waiting for a connection...");

        SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
        System.out.println("Connection established.");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String message = in.readLine();
        System.out.println("Received message: " + message);

        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
