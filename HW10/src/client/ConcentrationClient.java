package client;


public class ConcentrationClient {

    private static final String WHITESPACE = "\\s+";

    private static final String QUIT = "q";

    private ConcentrationClientBoard board;

    String hostName;

    int portNumber;

    public ConcentrationClient(String hostName, int portNumber) {
        this.hostName = hostName;
        this.portNumber = portNumber;

    }

    private void play() {
        //While game not over

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
