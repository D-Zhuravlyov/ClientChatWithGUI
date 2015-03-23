package dao;

import com.sun.tools.javadoc.Start;
import gui.Controller;
import gui.StartFrame;
import javafx.fxml.FXMLLoader;
import message.Message;
import sun.text.resources.no.CollationData_no;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

