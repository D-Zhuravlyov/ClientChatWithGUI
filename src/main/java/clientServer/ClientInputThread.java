package clientServer;

import dao.ClientServiceImpl;
import dao.IClientService;
import gui.Controller;
import model.Message;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.GregorianCalendar;


public class ClientInputThread implements Runnable {
    private IClientService client = new ClientServiceImpl();
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
                message.setDate(new GregorianCalendar());
                client.addToMessageBufferList(message);
                //for(Message m : client.getMessageListInstance()) {

                    //ControllerHelper.ctrl.receiveMessage();
                //}
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }

        }
    }

    public static class ControllerHelper extends Controller {
        static ControllerHelper ctrl = new ControllerHelper();

    }
}


