package hw4.heroes;

import java.util.List;
import hw4.game.Team;

public interface Party {

    void addHero(Hero hero);

    Hero removeHero();

    int numHeroes();

    Team getTeam();

    List<Hero> getHeroes();

}
