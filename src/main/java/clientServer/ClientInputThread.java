package clientServer;

import dao.ClientImpl;
import dao.IClient;
import gui.Controller;
import message.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;


public class ClientInputThread implements Runnable {
    private IClient client = new ClientImpl();
    private InputStream inputStream;

    public ClientInputThread() {
    }


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
                    client.addToMessageBufferList(message);
                    client.getMessageBufferList().forEach(System.out::println);
                    ControllerHelper.ctrl.receiveMessage();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static class ControllerHelper extends Controller {
        static ControllerHelper ctrl = new ControllerHelper();

    }
}


