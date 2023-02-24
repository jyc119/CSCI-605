package hw4.game;

public class HeroStorm {

    private static int dragonSeed;
    private static int lionSeed;
    /**
     * Create the parties and initialize the round counter.
     *
     * @param dragonSeed the seed for the dragon random number generator
     * @param lionSeed the seed for the lion random number generator
     */
    public HeroStorm(int dragonSeed, int lionSeed){
    }

    /**
     * The game is played in battle rounds. A round is one attack between the
     * "front" heroes of the two teams who are temporarily removed from the
     * party. The first hero to attack alternates by round, starting with Team
     * Dragon. If the hero who is attacked is not defeated, they can attack the
     * first hero back. Afterwards each non-defeated hero is added to the back
     * of their party. Defeated heroes merely "disappear" with a farewell
     * message about having fallen. The rounds continue until one of the teams
     * has all of their members defeated. The other team is declared the winner.
     * There is no interaction by the user in this game. Refer to the sample
     * outputs for details on the output formatting.
     */
    public void play(){
        HeroParty party1 = new HeroParty(Team.DRAGON, 1);
        HeroParty party2 = new HeroParty(Team.LION, 2);
        System.out.println(party1);
        System.out.println(party2);
    }
    /**
     * The main method. It checks the number of command line arguments,
     * then creates and plays the game.
     *
     * @param args the command line arguments, two integers for the dragon and
     * lion random number generator seeds
     */
    public static void main(String[] args){
        //if (args.length != 3) {
        //    System.out.println("Usage: java HeroStorm " +
        //            "dragon_seed_# lion_seed_#");
        //} else {
        HeroStorm startGame = new HeroStorm(dragonSeed, lionSeed);
        startGame.play();


        //}
    }
}
