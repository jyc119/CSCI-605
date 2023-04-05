package connectfour.gui;

import connectfour.model.ConnectFourBoard;
import connectfour.model.Observer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ConnectFourGUI extends Application implements Observer<ConnectFourBoard> {

//    private ConnectFourBoard board;

    private Label moves;

    private Label currentPlayer;

    private Label status;

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
    public void update(ConnectFourBoard connectFourBoard) {
        this.currentPlayer = new Label("Current Player: " + connectFourBoard.getCurrentPlayer());
        this.moves = new Label(connectFourBoard.getMovesMade() + " moves made");
        this.status = new Label("Status: " + connectFourBoard.getGameStatus());

    }

    private enum Player {
        P1,
        P2,
        None
    }

    private GridPane makeGridPane() {
        GridPane gridpane = new GridPane();

        for (int row = 0; row < ROWS; ++row) {
            for (int col = 0; col < COLS; ++col){
                connectFourButton button = new connectFourButton(Player.None);

//                button.setOnAction(event -> this.label.set);
                gridpane.add(button, col, row);
            }
        }
        return gridpane;
    }

    private class connectFourButton extends Button {

        private Player player;

        public connectFourButton(Player player) {
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
    public void start(Stage primaryStage) throws Exception {
        ConnectFourBoard test = new ConnectFourBoard();
        BorderPane borderPane = new BorderPane();
        GridPane gridPane = makeGridPane();
        borderPane.setCenter(gridPane);
        update(test);
        this.currentPlayer.setStyle("-fx-font: " + 20 + " arial;");
        this.status.setStyle("-fx-font: " + 20 + " arial;");
        this.moves.setStyle("-fx-font: " + 20 + " arial;");
        HBox bottom = new HBox(this.moves, this.currentPlayer, this.status);
        bottom.setSpacing(40);
        bottom.setAlignment(Pos.CENTER);
        borderPane.setBottom(bottom);
//        BorderPane.setAlignment(this.currentPlayer, Pos.BOTTOM_CENTER);
//        BorderPane.setAlignment(this.moves, Pos.BOTTOM_LEFT);
//        BorderPane.setAlignment(this.status, Pos.BOTTOM_RIGHT);



        Scene scene = new Scene(borderPane);
        primaryStage.setTitle("Connect Four GUI");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }
}
