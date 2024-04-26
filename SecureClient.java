import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SecureClient {
    public static void main(String[] args) throws Exception {
        String serverAddress = "localhost"; // The address of the server
        int serverPort = 4433; // The port to connect to
        SSLSocketFactory socketFactory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket socket = (SSLSocket) socketFactory.createSocket(serverAddress, serverPort);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        out.println("Hello, Server!");
        String serverResponse = in.readLine();
        System.out.println("Server Response: " + serverResponse);
        socket.close();
    }
}
