package dao;


import model.Message;

import java.util.ArrayList;


public class ClientServiceImpl implements IClientService {

    public ClientServiceImpl() {
    }


    public static class MessageListHolder {
        public static final ArrayList<Message> MESSAGES = new ArrayList<Message>();
    }

    @Override
    public synchronized void addToMessageBufferList(Message msg) {
    MessageListHolder.MESSAGES.add(msg);
    }

    @Override
    public synchronized ArrayList<Message> getMessageListInstance() {
    return MessageListHolder.MESSAGES;
    }





}

