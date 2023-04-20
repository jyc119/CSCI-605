package server;

import common.ConcentrationProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConcentrationClientServerThread extends Thread {

    private Socket socket = null;

    private ConcentrationServer server;


    public ConcentrationClientServerThread(Socket socket) {
        super("ConcentrationClientServerThread");
        this.socket = socket;
        System.out.println("CLient #" + this.getId() + ": Client " +
                this.getId() + " connected: " + socket);
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(),
                        true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
            //ADD ACTUAL CODE HERE
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
