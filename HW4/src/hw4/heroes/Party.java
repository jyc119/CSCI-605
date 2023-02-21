package hw4.heroes;

import hw4.game.Team;
import java.util.List;

public interface Party {

    void addHero(Hero hero);

    Hero removeHero();

    int numHeroes();

    Team getTeam();

    List<Hero> getHeroes();

}
