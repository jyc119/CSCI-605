/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw4.game;

/**
 * Main class, takes in seed parameters and produces gameplay
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class HeroStorm {

    /** Seed for dragon random number generator */
    private static int dragonSeed;

    /** Seed for lion random number generator */
    private static int lionSeed;
    /**
     * Create the parties and initialize the round counter.
     *
     * @param dragonSeed the seed for the dragon random number generator
     * @param lionSeed the seed for the lion random number generator
     */
    public HeroStorm(int dragonSeed, int lionSeed){
        this.dragonSeed = dragonSeed;
        this.lionSeed = lionSeed;
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
        HeroParty party1 = new HeroParty(Team.DRAGON, dragonSeed);
        HeroParty party2 = new HeroParty(Team.LION, lionSeed );
        int battle = 1;
        while (party1.numHeroes() != 0 & party2.numHeroes() != 0){
            System.out.println("Battle #" + battle);
            System.out.println("==========");
            System.out.println(party1);
            System.out.println(party2);
            if (battle % 2 != 0){
                System.out.println("*** " + party1.getHeroes().get(0).getName()
                        + " vs " + party2.getHeroes().get(0).getName() + "!\n");
                party1.getHeroes().get(0).attack(party2.getHeroes().get(0));
                if (!party2.getHeroes().get(0).hasFallen()){
                    party2.getHeroes().get(0).attack(party1.getHeroes().get(0));
                    party2.getNextRotation();
                } else {
                    party2.removeHero();
                }
                if (party1.getHeroes().get(0).hasFallen()){
                    party1.removeHero();
                } else {
                    party1.getNextRotation();
                }
            } else {
                System.out.println("*** " + party2.getHeroes().get(0).getName() +
                        " vs " + party1.getHeroes().get(0).getName() + "!\n");
                party2.getHeroes().get(0).attack(party1.getHeroes().get(0));
                if (!party1.getHeroes().get(0).hasFallen()) {
                    party1.getHeroes().get(0).attack(party2.getHeroes().get(0));
                    party1.getNextRotation();
                } else {
                    party1.removeHero();
                }
                if (party2.getHeroes().get(0).hasFallen()) {
                    party2.removeHero();
                } else {
                    party2.getNextRotation();
                }
            }
            System.out.println();
            battle++;
        }
        if (party1.numHeroes() > 0){
            System.out.println("Team Dragon wins!");
        } else {
            System.out.println("Team Lion wins!");
        }
    }
    /**
     * The main method. It checks the number of command line arguments,
     * then creates and plays the game.
     *
     * @param args the command line arguments, two integers for the dragon and
     * lion random number generator seeds
     */
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Usage: java HeroStorm " +
                    "dragon_seed_# lion_seed_#");
        } else {
        int dragSeed = Integer.parseInt(args[0]);
        int lSeed = Integer.parseInt(args[1]);
        HeroStorm startGame = new HeroStorm(dragSeed, lSeed);
        startGame.play();


        }
    }
}
