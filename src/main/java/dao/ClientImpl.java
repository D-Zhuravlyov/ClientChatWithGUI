package dao;

import gui.Controller;
import message.Message;

import java.net.Socket;
import java.util.ArrayList;

public class ClientImpl implements IClient {
    //list for storing session history of messages to be saved to file before exiting the chat
    private ArrayList<Message> messageSessionList = new ArrayList<Message>();
    public ClientImpl() {
    }

    public void addToSessionList(Message msg) {
        messageSessionList.add(msg);
    }




    @Override
    public void sendToTextArea(Message message) {
        System.out.println(message.toString());
    }

}

