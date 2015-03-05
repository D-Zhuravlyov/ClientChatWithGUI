package testServer;

/**
 * Created by Кирилл on 13.02.2015.
 */
public class RunServer {


    public static void main(String[] args) {


        ChatServer server = new ChatServer(9091, "Server");

        server.start();
    }
}
