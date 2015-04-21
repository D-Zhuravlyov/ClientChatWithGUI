package gui;

import clientServer.ClientSocket;
import dao.ClientServiceImpl;
import dao.IClientService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import model.Message;


public class Controller {

    private IClientService client = new ClientServiceImpl();

    public Controller() {
    }

    @FXML
    private TextArea messageTextArea;

    @FXML
    private TextArea dialogueTextArea;

    @FXML
    public void receiveMessage() {
       // client.getMessageBufferList().sort(Comparator.<Message>naturalOrder());
        for (Message m : client.getMessageListInstance()) {
        dialogueTextArea.appendText(m.toString());
        }
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

}


