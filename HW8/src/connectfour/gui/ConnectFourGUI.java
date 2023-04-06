package connectfour.gui;

import connectfour.model.ConnectFourBoard;
import connectfour.model.Observer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConnectFourGUI extends Application implements Observer<ConnectFourBoard> {

    private ConnectFourBoard board;

    private BorderPane borderPane;

    private GridPane gridpane;

    private Label moves;

    private Label currentPlayer;

    private Label status;

//    private connectFourButton[][] buttons;

    /** number of rows */
    private final static int ROWS = 6;

    /** number of columns */
    private final static int COLS = 7;

    /** empty location */
    private Image empty = new Image(getClass()
            .getResourceAsStream("empty.png"));

    /** player 1 filled location (black) */
    private Image p1black = new Image(getClass()
            .getResourceAsStream("p1black.png"));

    /** player 2 filled location (red) */
    private Image p2red = new Image(getClass()
            .getResourceAsStream("p2red.png"));

    private static final Background GRAY =
            new Background( new BackgroundFill(Color.GRAY, null, null));

    @Override
    public void init() {
        // create the model and add ourselves as an observer
        this.board = new ConnectFourBoard();
        this.board.addObserver(this);
    }

    private void refresh(ConnectFourBoard board) {
        this.currentPlayer.setText("Current Player: " + this.board.getCurrentPlayer());
        this.moves.setText(this.board.getMovesMade() + " moves made");
        this.status.setText("Status: " + this.board.getGameStatus());
        System.out.println(board);
    }
    @Override
    public void update(ConnectFourBoard board) {
        if ( Platform.isFxApplicationThread() ) {
            this.refresh(board);
        }
        else {
            Platform.runLater( () -> this.refresh(board) );
        }
    }

    private enum Player {
        P1,
        P2,
        None
    }

    private GridPane makeGridPane() {
        this.gridpane = new GridPane();
        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col){
                connectFourButton button = new connectFourButton(Player.None, col, row);
//                this.buttons[row][col] = button;
                button.setOnAction(event -> {
                    if (this.board.isValidMove(button.col)) {
//                        int topRow;
//                        for (int rows=0; rows <= ROWS; ++rows) {
//                            if (this.buttons[rows][button.col].player == Player.None) {
//                                topRow = rows;
//                                break;
//                            }
//                        }
                        if (board.getCurrentPlayer() == ConnectFourBoard.Player.P1) {
                            button.player = Player.P1;
                            button.setGraphic(new ImageView(p1black));
                        }
                        else {
                            button.player = Player.P2;
                            button.setGraphic(new ImageView(p2red));
                        }
                        this.board.makeMove(button.col);
                    }
                        });
                gridpane.add(button, col, row);
            }
        }
        gridpane.setPadding(new Insets(0, 0, 50, 0));
        return gridpane;
    }

    private class connectFourButton extends Button {

        private Player player;

        private final int col;

        private final int row;

        public connectFourButton(Player player, int col, int row) {
            this.col = col;
            this.row = row;
            this.player = player;
            Image image;
            switch (player) {
                case P1:
                    image = p1black;
                    break;
                case P2:
                    image = p2red;
                    break;
                case None:
                default:
                    image = empty;
            }
            this.setGraphic(new ImageView(image));
            this.setBackground(GRAY);
        }
    }

    @Override
    public void start(Stage primaryStage) {
       this.borderPane = new BorderPane();
        GridPane gridPane = makeGridPane();
        borderPane.setCenter(gridPane);
        this.currentPlayer = new Label("Current Player: " +
                this.board.getCurrentPlayer());
        this.moves = new Label(this.board.getMovesMade() + " moves made");
        this.status = new Label("Status: " + this.board.getGameStatus());
        this.currentPlayer.setStyle("-fx-font: " + 20 + " arial;");
        this.status.setStyle("-fx-font: " + 20 + " arial;");
        this.moves.setStyle("-fx-font: " + 20 + " arial;");
        HBox bottom = new HBox(this.moves, this.currentPlayer, this.status);
        bottom.setSpacing(40);
        bottom.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottom);

        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Connect Four GUI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    public static void main(String[] args) {Application.launch(args);}
}