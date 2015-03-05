package gui;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import clienServer.ClientSocket;

import java.io.IOException;

/**
 * Created by Dmitry on 13.02.15.
 */
public class StartFrame extends Application {


    public static void main(String[] args) {
        try {
            ClientSocket clientSocket = new ClientSocket("127.0.0.1", 9091);
            clientSocket.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Application.launch(StartFrame.class, args);
    }


        @Override
        public void start(final Stage stage) throws Exception
        {
            FXMLLoader f = new FXMLLoader();
            final Parent fxmlRoot = f.load(getClass().getResource("/ChatClient.fxml"));
            stage.setScene(new Scene(fxmlRoot));
            stage.setTitle("Chat client");
            stage.setResizable(false);
            stage.show();

            //this method to be extended for saving history before exit
            stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                @Override
                public void handle(WindowEvent event) {
                    System.exit(1);
                }
            });
        }


}