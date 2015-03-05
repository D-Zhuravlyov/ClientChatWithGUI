package testServer;

import message.Message;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Dmitry on 12.02.2015.
 */
public class ChatServer {

    private String serverName;
    private ServerSocket serverSocket;
    private Socket socket = null;
    private PrintWriter out = null;
    private Scanner in = null;

    ArrayList<Message> messages = new ArrayList<Message>();

    public ChatServer(int port, String serverName) {
        this.serverName = serverName;
        try {
            if (port > 0 && port < 65536) {
                this.serverSocket = new ServerSocket(port);
                System.out.println(serverSocket.getInetAddress().getHostAddress().toString());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        try {
            messages.add(new Message("START MESSAGE"));
            socket = serverSocket.accept();
            Thread input = new Thread(new ReadInputThread());
            Thread output = new Thread(new WriteOutputThread());
            input.start();
            output.start();


        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    class ReadInputThread implements Runnable {

        @Override
        public void run() {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                try {
                    Message message = (Message) objectInputStream.readObject();
                    messages.add(message);
                    System.out.println(message);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    class WriteOutputThread implements Runnable {

        @Override
        public void run() {
            ObjectOutputStream oos;
                try {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    for(Message m: messages) {
                        oos.writeObject(m);
                        oos.flush();
                    }
                    messages.clear();
                }
                catch(IOException e1){
                    e1.printStackTrace();
            }
        }
    }
}