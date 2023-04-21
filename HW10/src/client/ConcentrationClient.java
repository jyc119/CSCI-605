package client;


import common.ConcentrationException;
import common.ConcentrationProtocol;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConcentrationClient {

    private static final String WHITESPACE = "\\s+";

    /** What to display when the program is ready for a user command */
    public static final String Prompt = "> ";

    private ConcentrationClientBoard board;

    String hostName;

    int portNumber;

    public ConcentrationClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    private void play() {
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(),
                        true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
            BufferedReader input =
                    new BufferedReader(new InputStreamReader(System.in));
            String fromServer;
            String fromClient;
            while ((fromServer = in.readLine()) != null) {
                String[] message = fromServer.split(WHITESPACE);
                if (message[0].equals(ConcentrationProtocol.BOARD_DIM)) {
                    board = new ConcentrationClientBoard(Integer.parseInt
                            (message[1]));
                }
                System.out.println(board);
                System.out.print(Prompt);
                fromClient = input.readLine();
                String[] cor = fromClient.split(WHITESPACE);
                try {
                    board.getCard(Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])).reveal();
                } catch (ConcentrationException e) {
                    System.out.println(e);
                }
                out.println(String.format(ConcentrationProtocol.
                                REVEAL_MSG, Integer.parseInt(cor[0]),
                        Integer.parseInt(cor[1])));
                if (message[0].equals(ConcentrationProtocol.GAME_OVER_MSG)) {
                    break;
                }
                if (message[0].equals("MISMATCH")) {
                    System.out.println(board);
                    board.getCard(Integer.parseInt(message[1]),
                            Integer.parseInt(message[2])).hide();
                    board.getCard(Integer.parseInt(message[3]),
                            Integer.parseInt(message[4])).hide();
                }
            }
//            fromServer = in.readLine();
//            board = new ConcentrationClientBoard(Integer.parseInt
//                    (fromServer.split(WHITESPACE)[1]));
//            BufferedReader input =
//                    new BufferedReader(new InputStreamReader(System.in));
//            while (true) {
//                System.out.println(board);
//                System.out.print(Prompt);
//                fromClient = input.readLine();
//                String[] cor = fromClient.split(WHITESPACE);
//                board.getCard(Integer.parseInt(cor[0]),
//                        Integer.parseInt(cor[1])).reveal();
//                out.println(String.format(ConcentrationProtocol.
//                        REVEAL_MSG, Integer.parseInt(cor[0]),
//                        Integer.parseInt(cor[1])));
//                in.readLine();
//                if ((fromServer = in.readLine()) != null) {
//                    String[] checkMatch = fromServer.split(WHITESPACE);
//                    if (checkMatch[0].equals("MISMATCH")) {
//                        board.getCard(Integer.parseInt(checkMatch[1]),
//                                Integer.parseInt(checkMatch[2])).hide();
//                        board.getCard(Integer.parseInt(checkMatch[3]),
//                                Integer.parseInt(checkMatch[4])).hide();
//                    }
//                }
                //May not work
//                if (in.readLine().equals(ConcentrationProtocol.GAME_OVER_MSG)) {
//                    break;
//                }
//            }
            System.out.println("You won!");
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        } catch (ConcentrationException e) {
            e.getMessage();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println(
                    "Usage: java ConcentrationPTUI <host name> <port number>");
            System.exit(1);
        }
        ConcentrationClient client = new ConcentrationClient(args[0],
                Integer.parseInt(args[1]));
        client. play();
    }
}
