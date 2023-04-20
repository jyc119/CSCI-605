package client;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConcentrationClient {

    private static final String WHITESPACE = "\\s+";

    private static final String QUIT = "q";

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
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));
        ) {
                BufferedReader input =
                        new BufferedReader(new InputStreamReader(System.in));
            //            while (!board.gameOver()) {
//            System.out.println(board);
            System.out.print(Prompt);
//            }
        } catch (UnknownHostException e) {
            //Put something here
        } catch (IOException e) {
            //Put something here
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
