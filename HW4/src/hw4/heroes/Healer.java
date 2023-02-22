package hw4.heroes;

import hw4.game.*;

public class Healer extends Hero implements Party{
    public static final int BASE_HP = 35;
    public int HIT_POINTS = 35;
    public static final int ATTACK_DAMAGE = 10;
    public static final int HEAL_AMOUNT = 10;


    public Healer(Team team, Party party){

    }
    @Override
    public void takeDamage(int damage) {
        this.HIT_POINTS -= damage;
        if (this.HIT_POINTS <= 0){
            super.hasFallen(getName());
        }
    }

    public String getHealMessage(String hero, int heal){
        return hero + " heals " + heal + " points";
    }

    @Override
    public void attack(Hero enemy) {
        // heal remaining


        enemy.takeDamage(ATTACK_DAMAGE);
        // Heal message for each remaining player on team
        super.getAttackMessage(enemy.getName(), ATTACK_DAMAGE);

    }

    @Override
    public void heal(int heal) {
        this.HIT_POINTS += heal;
        if (this.HIT_POINTS > BASE_HP){
            this.HIT_POINTS = BASE_HP;
        }
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
