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

    private final String hostName;

    private final int portNumber;

    private int counter;



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
                    System.out.println(board);
                    System.out.print(Prompt);
                    // Reads the coordinate of the line flipped
                    fromClient = input.readLine();
                    String[] cor = fromClient.split(WHITESPACE);
                    out.println(String.format(ConcentrationProtocol.
                                    REVEAL_MSG, Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])));
                }
                else if (message[0].equals(ConcentrationProtocol.GAME_OVER_MSG)) {
                    System.out.println("You won!");
                    break;
                }
                else if (message[0].equals(ConcentrationProtocol.CARD)) {
//                    message[0] = in.readLine().split(WHITESPACE)[0];
                    counter++;
                    if(board.getCard(Integer.parseInt(message[1]),
                            Integer.parseInt(message[2])).equals(".")){
                        board.setCard(Integer.parseInt(message[1]),
                                Integer.parseInt(message[2]), message[3]);
                    }else{
                        System.out.println("ERROR Card is already revealed. " +
                                "Try again.");
                    }
                    System.out.println(board);
                    if (counter % 2 != 0) {
                        System.out.print(Prompt);
                        // Reads the coordinate of the line flipped
                        fromClient = input.readLine();
                        String[] cor = fromClient.split(WHITESPACE);
                        out.println(String.format(ConcentrationProtocol.
                                        REVEAL_MSG, Integer.parseInt(cor[0]),
                                Integer.parseInt(cor[1])));
                    }
                }
                else if (message[0].equals(ConcentrationProtocol.MISMATCH)) {
                    board.setCard(Integer.parseInt(message[1]),
                            Integer.parseInt(message[2]), ".");
                    board.setCard(Integer.parseInt(message[3]),
                            Integer.parseInt(message[4]), ".");
                    System.out.println(board);
                    System.out.print(Prompt);
                    // Reads the coordinate of the line flipped
                    fromClient = input.readLine();
                    String[] cor = fromClient.split(WHITESPACE);
                    out.println(String.format(ConcentrationProtocol.
                                    REVEAL_MSG, Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])));
                }
                else if (message[0].equals(ConcentrationProtocol.MATCH)) {
                    System.out.println(board);
                    System.out.print(Prompt);
                    // Reads the coordinate of the line flipped
                    fromClient = input.readLine();
                    String[] cor = fromClient.split(WHITESPACE);
                    out.println(String.format(ConcentrationProtocol.
                                    REVEAL_MSG, Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])));
                }
                else if (message[0].equals(ConcentrationProtocol.ERROR)) {
                    System.out.println(board);
                    System.out.print(Prompt);
                    // Reads the coordinate of the line flipped
                    fromClient = input.readLine();
                    String[] cor = fromClient.split(WHITESPACE);
                    out.println(String.format(ConcentrationProtocol.
                                    REVEAL_MSG, Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])));
                }
                else {
                    System.out.print(Prompt);
                    // Reads the coordinate of the line flipped
                    fromClient = input.readLine();
                    String[] cor = fromClient.split(WHITESPACE);
                    out.println(String.format(ConcentrationProtocol.
                                    REVEAL_MSG, Integer.parseInt(cor[0]),
                            Integer.parseInt(cor[1])));
                }
//                try {
//                    board.setCard(Integer.parseInt(cor[0]),
//                            Integer.parseInt(cor[1]), cor[2].charAt(0));
//                    ConcentrationCard card = board.getCard(Integer.parseInt(cor[0]),
//                            Integer.parseInt(cor[1]));
//                    if (card.isHidden()) {
//                        card.reveal();
//                    }
//                    else {
//                        System.out.println("ERROR Card is already revealed. " +
//                                "Try again.");
//                    }
//                } catch (ConcentrationException e) {
//                    System.out.println(e);
//                }
//                out.println(String.format(ConcentrationProtocol.
//                                REVEAL_MSG, Integer.parseInt(cor[0]),
//                        Integer.parseInt(cor[1])));
//                if (message[0].equals(ConcentrationProtocol.CARD)) {
//                    message[0] = in.readLine().split(WHITESPACE)[0];
//                }
//                if (message[0].equals(ConcentrationProtocol.MISMATCH)) {
//                    board.getCard(Integer.parseInt(message[1]),
//                            Integer.parseInt(message[2])).hide();
//                    board.getCard(Integer.parseInt(message[3]),
//                            Integer.parseInt(message[4])).hide();
//                }
//                System.out.println(board);
//                System.out.print(Prompt);
//                fromClient = input.readLine();
//                String[] cor = fromClient.split(WHITESPACE);
//                try {
//                    ConcentrationCard card = board.getCard(Integer.parseInt(cor[0]),
//                                    Integer.parseInt(cor[1]));
//                    if (card.isHidden()) {
//                        card.reveal();
//                    }
//                    else {
//                        System.out.println("ERROR Card is already revealed. " +
//                                "Try again.");
//                    }
//                } catch (ConcentrationException e) {
//                    System.out.println(e);
//                }
//                out.println(String.format(ConcentrationProtocol.
//                                REVEAL_MSG, Integer.parseInt(cor[0]),
//                        Integer.parseInt(cor[1])));
            }
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                    hostName);
            System.exit(1);
        } catch (ConcentrationException e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
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
