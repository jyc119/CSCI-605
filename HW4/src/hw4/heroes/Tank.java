package hw4.heroes;

import hw4.game.*;

public class Tank extends Hero {
    public static final int BASE_HP = 40;
    public static final int ATTACK_DAMAGE = 15;
    public static final int DEFENSE = 10;

    private Team team;
    public Tank(Team team){
        super(Heroes.getName(team, Heroes.Role.HEALER), BASE_HP);
        super.health = BASE_HP;
    }

    @Override
    public void takeDamage(int damage) {
        super.health -= damage * 0.9;
        if (super.health <= 0) {
            super.hasFallen();
        }
    }

    @Override
    public void attack(Hero enemy) {
        enemy.takeDamage(ATTACK_DAMAGE);
        super.getAttackMessage(enemy.getName(), ATTACK_DAMAGE);
    }

    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
    }
}
