/*
 * HW3: Arithmetic Interpreter
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

    void addHero(Hero hero);

    Hero removeHero();

    int numHeroes();

    Team getTeam();

    List<Hero> getHeroes();

}
