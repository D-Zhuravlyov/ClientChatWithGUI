package testServer;


import message.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;

/**
 * pattern Observer(Listener)
 */
public class OutStreamsContainer {

    private List<ObjectOutputStream> clientOutputStreamList;

    public OutStreamsContainer(List<ObjectOutputStream> clientOutputStreamList) {
        this.clientOutputStreamList = clientOutputStreamList;
    }

    public List<ObjectOutputStream> getClientOutputStreamList() {
        return clientOutputStreamList;
    }

    public void setClientOutputStreamList(List<ObjectOutputStream> clientOutputStreamList) {
        this.clientOutputStreamList = clientOutputStreamList;
    }

    public void addOutputStream(OutputStream outputStream) {
        try {
            clientOutputStreamList.add(new ObjectOutputStream(outputStream));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void notifyAllClients(Message message) {
        for (ObjectOutputStream oos : clientOutputStreamList) {
            try {
                oos.writeObject(message);
                oos.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}