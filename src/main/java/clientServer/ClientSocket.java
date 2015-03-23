package clientServer;

import dao.IClient;
import gui.Controller;
import gui.StartFrame;
import message.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by nofuruct on 13.02.15.
 */
public class ClientSocket {
    private Socket socket;
    private ObjectOutputStream oos;




   public ClientSocket() {
   }

    public ClientSocket(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
            System.out.println("Constructor ClientSocket.class (ip, port); socket =  " +this.socket);
            oos = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientSocketHolder {
        public static final ClientSocket CLIENT_SOCKET = new ClientSocket("127.0.0.1", 9091);
    }

    public static ClientSocket getInstance() {
        return ClientSocketHolder.CLIENT_SOCKET;
    }


    public void sendMessage(Message message){
        try {
            System.out.println("Method sendMessage in ClientSocket.class; socket = " + socket +
                    "message: " + message);
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void start() throws SocketException{
        Thread clientInputThread = null;
        try {
            clientInputThread = new Thread(new ClientInputThread(socket.getInputStream()));
            clientInputThread.start();
            clientInputThread.setName("clientInputThread");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
