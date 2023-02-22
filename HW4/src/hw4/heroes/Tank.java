package hw4.heroes;

import hw4.game.*;

public class Tank extends Hero {
    private static final int BASE_HP = 40;
    public int HIT_POINTS = 40;
    public static final int ATTACK_DAMAGE = 15;

    public static final int DEFENSE = 10;

    private Team team;
    public Tank(Team team){

    }

    @Override
    public void takeDamage(int damage) {
        this.HIT_POINTS -= damage * 0.9;
        if (this.HIT_POINTS <= 0) {
            super.fellEnemy(getName());
        }
    }

    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(ATTACK_DAMAGE);
    }

    @Override
    public void heal(int heal) {
        this.HIT_POINTS += heal;
        if (this.HIT_POINTS > BASE_HP){
            this.HIT_POINTS = BASE_HP;
        }
    }
}
