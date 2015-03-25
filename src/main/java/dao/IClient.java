package dao;

import message.Message;

import java.util.ArrayList;

/**
 * Created by nofuruct on 12.02.15.
 */
public interface IClient {
    public void addToMessageBufferList(Message msg);

    public ArrayList<Message> getMessageBufferList();

}