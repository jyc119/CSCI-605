package server;

import java.io.IOException;
import java.net.ServerSocket;

public class ConcentrationServer {

    int portNumber;

    int dimension;

    public ConcentrationServer(int portNumber, int dimension) {
        this.portNumber = portNumber;
        this.dimension = dimension;
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new ConcentrationClientServerThread(serverSocket.accept())
                        .start();
            }
        } catch (IOException e) {
            System.err.println("Incorrect port number: " + portNumber);
            System.exit(-1);;
        }
    }

        public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java ConcentrationServer " +
                    "<port number> <dimension>");
            System.exit(1);
        }
        ConcentrationServer server = new ConcentrationServer
                (Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        server.run();
    }
}
