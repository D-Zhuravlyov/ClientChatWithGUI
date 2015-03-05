package clienServer;

import message.Message;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;

/**
 * Created by nofuruct on 13.02.15.
 */
public class ClientSocket {
    private Socket socket;

    public ClientSocket() {
    }

    public ClientSocket(String ip, int port) {
        try {
            this.socket = new Socket(ip, port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket(){
        System.out.println(socket);
        return socket;
    }

    public void sendMessage(Message message){
        ObjectOutputStream oos;
        try {
            System.out.println(socket);// why is the socket null ?
            oos = new ObjectOutputStream(socket.getOutputStream());
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
