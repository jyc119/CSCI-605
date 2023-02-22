package hw4.game;

import hw4.heroes.Hero;
import hw4.heroes.Heroes;
import hw4.heroes.Party;
import java.util.Collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HeroParty implements Party {

    private Team team;

    private int seed;

    private Hero hero;

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
        this.heroes = new LinkedList<>();
        this.heroes.add(Hero.create(Heroes.Role.BERSERKER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.HEALER, team, this));
        this.heroes.add(Hero.create(Heroes.Role.TANK, team, this));

        Collections.shuffle(this.heroes, new Random(seed));
    }
    /**
     * Description copied from interface: Party
     * Add a hero to the back of the collection.
     *
     * @param hero the new hero
     */
    @Override
    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    /**
     * Description copied from interface: Party
     * Remove the hero at the front of the collection.
     *
     * @return the hero at the front
     */
    @Override
    public Hero removeHero() {
        Hero removedHero = heroes.get(0);
        heroes.remove(0);
        return removedHero;
    }
    /**
     * Description copied from interface: Party
     * Get the number of fallen heroes.
     *
     * @return the number of heroes in the party
     */
    @Override
    public int numHeroes() {
        return heroes.size();
    }
    /**
     * Description copied from interface: Party
     * The team which this party is affiliated with.
     *
     * @return the team
     */
    @Override
    public Team getTeam() {
        return team;
    }
    /**
     * Description copied from interface: Party
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
    public String toString(){}
}
