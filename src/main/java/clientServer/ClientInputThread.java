package clientServer;

import dao.ClientImpl;
import dao.IClient;
import gui.Controller;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import message.Message;
import sun.misc.resources.Messages_es;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * Created by nofuruct on 20.02.15.
 */


public class ClientInputThread implements Runnable {
    private IClient client = new ClientImpl();
    private ObjectInputStream objectInputStream;
    private ClientSocket socket;


    public ClientInputThread() {
    }


    public ClientInputThread(InputStream inputStream) {
        try {
            objectInputStream = new ObjectInputStream(inputStream); // the las point in debug-mod
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
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


