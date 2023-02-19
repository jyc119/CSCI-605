package hw4.game;

import hw4.heroes.Hero;
import hw4.heroes.Party;

public class HeroParty implements Party {

    private Team team;

    private int seed;

    private Hero hero;
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

    }
    /**
     * Description copied from interface: Party
     * Add a hero to the back of the collection.
     *
     * @param hero the new hero
     */
    @Override
    public void addHero(Hero hero) {

    }

    /**
     * Description copied from interface: Party
     * Remove the hero at the front of the collection.
     *
     * @return the hero at the front
     */
    @Override
    public Hero removeHero() {
    }
    /**
     * Description copied from interface: Party
     * Get the number of fallen heroes.
     *
     * @return the number of heroes in the party
     */
    @Override
    public int numHeroes() {
    }
    /**
     * Description copied from interface: Party
     * The team which this party is affiliated with.
     *
     * @return the team
     */
    @Override
    public Team getTeam() {
    }
    /**
     * Description copied from interface: Party
     * Get all the undefeated heroes in the party.
     *
     * @return the party
     */
    @Override
    public List<Hero> getHeroes() {
    }
    /**
     * Returns a string representation of th party.
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

    }
}
