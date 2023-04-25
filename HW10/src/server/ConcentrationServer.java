/*
 * HW10: Concentration
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package server;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * The concentration server for the game
 *
 * @author RIT CS
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class ConcentrationServer {

    /** The port number for the server*/
    private final int portNumber;

    /** The dimension of the board*/
    private final int dimension;

    /** The total number of clients that connected to the server*/
    private int clientNumber;

    /** The number of clients currently connected to the server*/
    static int numClients;

    /**
     * Creates the server
     * @param portNumber The port number for the server
     * @param dimension Board dimenstion
     */
    public ConcentrationServer(int portNumber, int dimension) {
        this.portNumber = portNumber;
        this.dimension = dimension;
        this.clientNumber = 1;
        numClients = 0;
        System.out.println("Concentration server starting on port " +
                portNumber + " DIM=" + dimension);
    }

    /**
     * Run the server thread
     */
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            while (true) {
                new ConcentrationClientServerThread(serverSocket.accept(),
                        dimension, clientNumber).start();
                clientNumber ++;
            }
        } catch (IOException e) {
            System.err.println("Incorrect port number: " + portNumber);
            System.exit(-1);
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
