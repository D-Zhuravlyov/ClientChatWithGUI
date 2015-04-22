package gui;

import clientServer.ClientSocket;
import dao.ClientServiceImpl;
import dao.IClientService;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableListBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Message;

import java.util.Objects;


public class Controller {

    private IClientService client;

    public Controller() {


    }


    @FXML
    private TextArea messageTextArea;

    @FXML
    private TextArea dialogueTextArea;

    @FXML
    public void receiveMessage() {

    }




    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        String str = "";
        str += messageTextArea.getText();
        Message message = new Message(str);
        System.out.println(message);
        ClientSocket.getInstance().sendMessage(message);
        messageTextArea.clear();
        receiveMessage();
        //  client.addToMessageBufferList(message);
    }

    public IClientService getClient() {
        return client;
    }

    public void setClient(IClientService client) {
        this.client = client;
    }
}


