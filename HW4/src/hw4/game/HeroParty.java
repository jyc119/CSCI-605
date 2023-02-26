/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw4.game;

import hw4.heroes.Hero;
import hw4.heroes.Heroes;
import hw4.heroes.Party;
import java.util.*;

/**
 * Creates the arraylist of heroes
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class HeroParty implements Party {

    /** Team associated with hero */
    private Team team;

    /** List of heroes in party */
    private List<Hero> heroes;
    /**
     * Create the party. Here we associate the team with the party.
     * We then add the heroes in the following order: Berserker,
     * Healer and Tank. The collection is then shuffled using the random number
     * generator seed value. To shuffle the collection of heroes (assumed to be
     * either an ArrayList or LinkedList):
     *
     * Collections.shuffle(this.heroes, new Random(seed));
     *
     * @param team the team
     * @param seed the random number generator seed
     */
    public HeroParty(Team team, int seed){
        this.heroes = new ArrayList<>();
        this.heroes.add(Hero.createHero(Heroes.Role.BERSERKER, team,
                this));
        this.heroes.add(Hero.createHero(Heroes.Role.HEALER, team, this));
        this.heroes.add(Hero.createHero(Heroes.Role.TANK, team, this));
        this.team = team;

        Collections.shuffle(this.heroes, new Random(seed));
    }
    /**
     * Description copied from interface: hw4.heroes.Party
     * Add a hero to the back of the collection.
     *
     * @param hero the new hero
     */
    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Description copied from interface: hw4.heroes.Party
     * Remove the hero at the front of the collection.
     *
     * @return the hero at the front that was removed
     */
    @Override
    public Hero removeHero() {
        Hero removedHero = heroes.get(0);
        heroes.remove(0);
        return removedHero;
    }

    /**
     * Description copied from interface: hw4.heroes.Party
     * Get the number of fallen heroes.
     *
     * @return the number of heroes in the party
     */
    @Override
    public int numHeroes() {
        return heroes.size();
    }

    /**
     * Description copied from interface: hw4.heroes.Party
     * The team which this party is affiliated with.
     *
     * @return the team
     */
    @Override
    public Team getTeam() {
        return team;
    }

    /**
     * Description copied from interface: hw4.heroes.Party
     * Get all the undefeated heroes in the party.
     *
     * @return the party
     */
    @Override
    public List<Hero> getHeroes() {
        return heroes;
    }
    /**
     * Returns a string representation of the party.
     *
     * {Dragons|Lions}:
     * Hero1, Role, currentHP/maxHP
     * ...
     *
     * To get the hero string details you should call Hero::toString.
     *
     * @return the string
     */
    @Override
    public String toString(){
        StringBuilder partyRepresentation = new StringBuilder();
        partyRepresentation.append(getTeam() + ":\n");
        for(int i=0; i<numHeroes();i++){
            partyRepresentation.append(getHeroes().get(i).toString() + "\n");
        }
        return partyRepresentation.toString();
    }

    /**
     * Rotates the order of the heroes in arraylist by removing front hero
     * and placing him at the end of the list
     */
    public void getNextRotation(){
        Hero hero = removeHero();
        addHero(hero);
    }
}
