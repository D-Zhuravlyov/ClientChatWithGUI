package clientServer;

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
            System.out.println("Constructor ClientSocket.class (ip, port); socket =  " +this.socket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket getSocket(){
        System.out.println("Method getSocket in ClientSocket.class; socket =  " +socket);
        return this.socket;
    }

    public void sendMessage(Message message){
        ObjectOutputStream oos;
        try {
            socket = new Socket("127.0.0.1", 9091);
            System.out.println("Method sendMessage in ClientSocket.class; socket = " + socket);// why is the socket null ?
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
