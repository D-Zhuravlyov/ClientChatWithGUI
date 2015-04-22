package dao;

import javafx.collections.ObservableList;
import model.Message;

import java.util.ArrayList;

/**
 * Created by nofuruct on 12.02.15.
 */
public interface IClientService {

    public void addToMessageBufferList(Message msg);

    public ObservableList<Message> getMessageListInstance();
}