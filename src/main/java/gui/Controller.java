package gui;

import clienServer.ClientSocket;
import dao.ClientImpl;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import message.Message;
import sun.security.x509.IPAddressName;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by nofuruct on 20.02.15.
 */
public class Controller  {

    private ClientSocket clientSocket= new ClientSocket();


    public Controller() {
    }

    @FXML private TextArea messageTextArea;
    @FXML private TextArea dialogueTextArea;
    @FXML private TextField userName;

    @FXML private TextField userStatus;

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        String str = "";
        str += messageTextArea.getText();
        Message message = new Message(str);
        clientSocket.sendMessage(message);
        messageTextArea.clear();
    }

    @FXML
    public void receiveMessage(Message message){
        dialogueTextArea.appendText(message.toString());
    }



   /* public void sendMessage(Message message){
        ObjectOutputStream oos;
        try {
            oos = new ObjectOutputStream(clientSocket.getSocket().getOutputStream());
            oos.writeObject(message);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/

    public void sendToTextArea(Message message) {
        receiveMessage(message);
    }
}


