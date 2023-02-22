package hw4.heroes;

import hw4.game.Team;

public class Berserker extends Hero{

    public static final int BASE_HP = 30;
    private int HIT_POINTS = 30;
    public static final int ATTACK_DAMAGE = 20;

    public Berserker(Team team){
        super
    }

    @Override
    public void takeDamage(int damage) {
        this.HIT_POINTS -= damage;
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
