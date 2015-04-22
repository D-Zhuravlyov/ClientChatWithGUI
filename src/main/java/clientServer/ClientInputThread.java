package clientServer;

import dao.ClientServiceImpl;
import dao.IClientService;
import gui.Controller;
import gui.ControllerHolder;
import model.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.GregorianCalendar;


public class ClientInputThread implements Runnable {
    private IClientService client = new ClientServiceImpl();
    private InputStream inputStream;
    private Controller controller;
    ObjectInputStream objectInputStream;


    public ClientInputThread(InputStream inputStream, IClientService clientService) {

        client = clientService;

        this.inputStream = inputStream;
        try {
            objectInputStream = new ObjectInputStream(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        controller = ControllerHolder.getController();
    }

    @Override
    public void run() {
        while (true) {
            try {

                Message message = (Message) objectInputStream.readObject();
                message.setDate(new GregorianCalendar());
                client.addToMessageBufferList(message);
                // use controller
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    /*public static class ControllerHelper extends Controller {
        static ControllerHelper ctrl = new ControllerHelper();

    }*/
}


