package testServer;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.LinkedList;


public class ServerRun {


    public static void main(String[] args) {
        OutStreamsContainer oosContainer = new OutStreamsContainer(new LinkedList<ObjectOutputStream>());
        new Thread(new ServerThread(oosContainer)).start();
    }
}