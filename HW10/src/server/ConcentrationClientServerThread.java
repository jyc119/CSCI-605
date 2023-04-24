package server;

import client.ConcentrationClient;
import common.ConcentrationException;
import common.ConcentrationProtocol;
import game.ConcentrationBoard;
import game.ConcentrationCard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConcentrationClientServerThread extends Thread {

    private static final String WHITESPACE = "\\s+";

    private Socket socket = null;

    private final int dimension;

    private ConcentrationBoard board;

    private final int clientNumber;

    private String client = "Client #";


    public ConcentrationClientServerThread(Socket socket, int dimension,
                                           int clientNumber) {
        super("ConcentrationClientServerThread");
        this.socket = socket;
        this.dimension = dimension;
        this.clientNumber = clientNumber;
        System.out.println(client + clientNumber + ": Client connected: " +
                socket);
    }

    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(),
                        true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
            this.board = new ConcentrationBoard(dimension, true);
            System.out.println(client + clientNumber + ": Client started...");
            System.out.println(client + clientNumber + ":");
            System.out.println(board);
            String boardDim = String.format(ConcentrationProtocol.BOARD_DIM_MSG,
                    dimension);
            out.println(boardDim);
            while (!this.board.gameOver()) {
                String reveal = in.readLine();
                System.out.println(client + clientNumber + ": received: " +
                        reveal);
                String[] coordinates = reveal.split(WHITESPACE);
                if (coordinates[0].equals(ConcentrationClient.QUIT)) {
                    socket.close();
                    System.out.println(client + clientNumber +
                            ": Client ending...");
                    return;
                }
                try {
                    ConcentrationBoard.CardMatch cardMatch =
                            board.reveal(Integer.parseInt(coordinates[1]),
                                    Integer.parseInt(coordinates[2]));
                    ConcentrationCard card = board.getCard(Integer.parseInt
                            (coordinates[1]), Integer.parseInt(coordinates[2]));
                    String sendCard = String.format
                            (ConcentrationProtocol.CARD_MSG, card.getRow(),
                                    card.getCol(), card.getLetter());
                    out.println(sendCard);
                    System.out.println(client + clientNumber + ": sending: "
                            + sendCard);
                    if (cardMatch.isReady()) {
                        if (cardMatch.isMatch()) {
                            out.println(String.format
                                    (ConcentrationProtocol.MATCH_MSG,
                                            cardMatch.getCard1().getRow(),
                                            cardMatch.getCard1().getCol(),
                                            cardMatch.getCard2().getRow(),
                                            cardMatch.getCard2().getCol()));
                            System.out.println(client + clientNumber +
                                    ": sending: " +
                                    String.format(ConcentrationProtocol.
                                                    MATCH_MSG,
                                            cardMatch.getCard1().getRow(),
                                            cardMatch.getCard1().getCol(),
                                            cardMatch.getCard2().getRow(),
                                            cardMatch.getCard2().getCol()));
                        } else {
                            out.println(String.format
                                    (ConcentrationProtocol.MISMATCH_MSG,
                                            cardMatch.getCard1().getRow(),
                                            cardMatch.getCard1().getCol(),
                                            cardMatch.getCard2().getRow(),
                                            cardMatch.getCard2().getCol()));
                            System.out.println(client + clientNumber +
                                    ": sending: " +
                                    String.format(ConcentrationProtocol.
                                                    MISMATCH_MSG,
                                            cardMatch.getCard1().getRow(),
                                            cardMatch.getCard1().getCol(),
                                            cardMatch.getCard2().getRow(),
                                            cardMatch.getCard2().getCol()));
                        }
                    }
                    System.out.println(client);
                    System.out.println(board);
                } catch (ConcentrationException e) {
                    out.println(String.format(ConcentrationProtocol.ERROR_MSG,
                            Integer.parseInt(coordinates[1]),
                            Integer.parseInt(coordinates[2])));
                    System.out.println(e);
                }
            }
            out.println(ConcentrationProtocol.GAME_OVER_MSG);
            socket.close();
            System.out.println(client + clientNumber + ": Client ending...");
        } catch (IOException e) {
            System.out.println(e);
        } catch (NullPointerException e) {
            System.out.println(client + clientNumber + ": Terminated");
        } catch (ConcentrationException e) {
            System.out.println(e);
            System.exit(1);
        }
    }
}
