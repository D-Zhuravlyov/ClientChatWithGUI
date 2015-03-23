package gui;

import clientServer.ClientSocket;
import dao.ClientImpl;
import dao.IClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import message.Message;

import java.net.Socket;
import java.util.GregorianCalendar;


public class Controller  {

    private  IClient client = new ClientImpl();

    public Controller() {
    }

    @FXML private  TextArea messageTextArea;

    @FXML private TextField userName;
    @FXML private TextField userStatus;
    @FXML private TextArea dialogueTextArea;

    @FXML
    public void receiveMessage(){
        for(Message m: client.getMessageBufferList()) {
            m.setDate(new GregorianCalendar());
            dialogueTextArea.appendText(m.toString());
           // client.getMessageBufferList();
        }
    }

    @FXML
    public void sendMessage(ActionEvent actionEvent) {
        String str = "";
        str += messageTextArea.getText();
        Message message = new Message(str);
        System.out.println(message);
       // dialogueTextArea.appendText(message.toString()); //checking workability
        ClientSocket.getInstance().sendMessage(message);
        messageTextArea.clear();
        client.addToMessageBufferList(message);
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

}


