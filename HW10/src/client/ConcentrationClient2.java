package client;


import common.ConcentrationException;
import common.ConcentrationProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConcentrationClient2 {

    private static final String WHITESPACE = "\\s+";

    /** What to display when the program is ready for a user command */
    public static final String Prompt = "> ";

    public static final String QUIT = "q";

    private ConcentrationClientBoard board;

    private final String hostName;

    private final int portNumber;

    private int counter;

    private int matches;



    public ConcentrationClient2(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;
    }

    private void getInput(PrintWriter out, BufferedReader input) {
        String fromClient;
        System.out.print(Prompt);
        // Reads the coordinate of the line flipped
        try {
            fromClient = input.readLine();
            String[] cor = fromClient.split(WHITESPACE);
            if (cor[0].equals(QUIT)) {
                out.println(QUIT);
                System.exit(1);
            }
            out.println(String.format(ConcentrationProtocol.
                            REVEAL_MSG, Integer.parseInt(cor[0]),
                    Integer.parseInt(cor[1])));
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to input");
            System.exit(1);
        } catch (Exception e) {
            System.out.println("Input must be two integers in the form (# #)");
            getInput(out, input);
        }
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
            while ((fromServer = in.readLine()) != null) {
                String[] message = fromServer.split(WHITESPACE);
                if (message[0].equals(ConcentrationProtocol.BOARD_DIM)) {
                    board = new ConcentrationClientBoard(Integer.parseInt
                            (message[1]));
                    System.out.println(board);
                    getInput(out, input);
                }
                else if (message[0].equals(ConcentrationProtocol.
                        GAME_OVER_MSG)) {
                    System.out.println("You won!");
                    break;
                }
                else if (message[0].equals(ConcentrationProtocol.CARD)) {
                    counter++;
                    board.setCard(Integer.parseInt(message[1]),
                            Integer.parseInt(message[2]), message[3]);
                    System.out.println(board);
                    if (counter % 2 != 0) {
                        getInput(out, input);
                    }
                }
                else if (message[0].equals(ConcentrationProtocol.MISMATCH)) {
                    board.setCard(Integer.parseInt(message[1]),
                            Integer.parseInt(message[2]), ".");
                    board.setCard(Integer.parseInt(message[3]),
                            Integer.parseInt(message[4]), ".");
                    System.out.println(board);
                    getInput(out, input);
                }
                else if (message[0].equals(ConcentrationProtocol.MATCH)) {
                    matches++;
                    System.out.println(board);
                    if (matches != board.getDIM() * board.getDIM() / 2) {
                        getInput(out, input);
                    }
                }
                else if (message[0].equals(ConcentrationProtocol.ERROR)) {
                    System.out.println(board);
                    System.out.println("Try again.");
                    getInput(out, input);
                }
                else {
                    getInput(out, input);
                }
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
        ConcentrationClient2 client = new ConcentrationClient2(args[0],
                Integer.parseInt(args[1]));
        client.play();
    }
}
