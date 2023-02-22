package hw4.heroes;

public class Healer extends Hero implements Party{
    public int HIT_POINTS = 35;
    public static final int ATTACK_DAMAGE = 10;
    public static final int HEAL_AMOUNT = 10;

    @Override
    public void takeDamage() {

    }

    @Override
    public void attack() {

    }

    @Override
    public void heal() {

    }

    @Override
    public void addHero(Hero hero) {

    }

    @Override
    public Hero removeHero() {
        return null;
    }

    @Override
    public int numHeroes() {
        return 0;
    }

    @Override
    public List<Hero> getHeroes() {
        return null;
    }
}
