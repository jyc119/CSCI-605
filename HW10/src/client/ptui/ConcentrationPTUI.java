package client.ptui;

import client.model.ConcentrationModel;
import client.model.Observer;
import game.ConcentrationBoard;

public class ConcentrationPTUI implements Observer<ConcentrationModel, ConcentrationModel.CardMatch> {

    private static final String WHITESPACE = "\\s+";

    private static final String QUIT = "q";

    private ConcentrationModel board;

    private void go() {
        //While game not over

    }

    public void close() {
        
    }
    public static void main(String[] args) {

    }

    @Override
    public void update(ConcentrationModel concentrationModel, ConcentrationModel.CardMatch cardMatch) {

    }
}
