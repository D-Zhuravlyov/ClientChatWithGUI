package dao;

import message.Message;

/**
 * Created by nofuruct on 12.02.15.
 */
public interface IClient  {
    public void sendToTextArea(Message message);
    public void addToSessionList(Message msg);


}