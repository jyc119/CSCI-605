/*
 * HW4: HeroStorm
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */


package hw4.heroes;

import java.util.List;
import hw4.game.Team;

/**
 * Class associated with berserker role
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public interface Party {

    /**
     * Add a hero to the back of the collection.
     *
     * @param hero the new hero
     */
    void addHero(Hero hero);

    /**
     * Remove the hero at the front of the collection.
     *
     * @return the hero at the front that was removed
     */
    Hero removeHero();

    /**
     * Get the number of fallen heroes.
     *
     * @return the number of heroes in the party
     */
    int numHeroes();

    /**
     * The team which this party is affiliated with.
     *
     * @return the team
     */
    Team getTeam();

    /**
     * Get all the undefeated heroes in the party.
     *
     * @return the party
     */
    List<Hero> getHeroes();

}
