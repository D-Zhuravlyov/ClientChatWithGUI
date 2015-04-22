package dao;


import gui.Controller;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import model.Message;


public class ClientServiceImpl implements IClientService {



    public ClientServiceImpl() {
    }

    public static class MessageListHolder {
        public static final ObservableList<Message> MESSAGES = new ObservableListBase<Message>() {
            @Override
            public Message get(int index) {
                return MESSAGES.get(index);
            }

            @Override
            public int size() {
                return MESSAGES.size();
            }
        };
    }

    @Override
    public synchronized void addToMessageBufferList(Message msg) {
    MessageListHolder.MESSAGES.add(msg);
    }

    @Override
    public synchronized ObservableList<Message> getMessageListInstance() {
    return MessageListHolder.MESSAGES;
    }

}

