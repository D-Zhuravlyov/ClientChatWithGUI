package gui;

import dao.ClientServiceImpl;
import dao.IClientService;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import clientServer.ClientSocket;


public class StartFrame extends Application {

    public static void main(String[] args) {

        IClientService service = new ClientServiceImpl();
        try {
            Application.launch(StartFrame.class,args);

            ClientSocket.ClientSocketHolder clientSocketHolder = new ClientSocket.ClientSocketHolder();
            ClientSocket.getInstance().start(service);



        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    @Override
    public void start(final Stage stage) throws Exception {

        FXMLLoader f = new FXMLLoader();
        final Parent fxmlRoot = FXMLLoader.load(getClass().getResource("/ChatClient.fxml"));
        stage.setScene(new Scene(fxmlRoot));
        stage.setTitle("Chat client");
        stage.setResizable(false);
        stage.show();
        ControllerHolder.setController(f.getController());

        //this method to be extended for saving history before exit
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(1);
            }
        });
    }
}

