package dao;


import message.Message;

import java.util.ArrayList;


public class ClientImpl implements IClient {


    //a list for storing last message to be sent to dialog screen in class "Controller". After sending messages are erased.
    private ArrayList<Message> messageBufferList = new ArrayList<Message>();


    public ClientImpl() {
    }

    @Override
    public void addToMessageBufferList(Message msg) {
        messageBufferList.add(msg);
    }

    @Override
    public ArrayList<Message> getMessageBufferList() {
        return messageBufferList;
    }


}

