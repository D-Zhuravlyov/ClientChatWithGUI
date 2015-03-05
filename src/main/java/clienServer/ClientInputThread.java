package clienServer;

import dao.ClientImpl;
import dao.IClient;
import message.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by nofuruct on 20.02.15.
 */
public class ClientInputThread implements Runnable {
    private IClient client= new ClientImpl();
    private InputStream inputStream;

    public ClientInputThread(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Message message = (Message) objectInputStream.readObject();
                if (message != null) {
                    client.addToSessionList(message);
                    client.sendToTextArea(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
    }
}


