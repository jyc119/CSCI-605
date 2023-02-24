package hw4.heroes;

import hw4.game.Team;

public class Berserker extends Hero{

    public static final int BASE_HP = 30;
    public static final int ATTACK_DAMAGE = 20;

    public Berserker(Team team){
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BASE_HP);
        super.role = Heroes.Role.BERSERKER;
        super.team = team;
        super.health = BASE_HP;
    }

    @Override
    public void takeDamage(int damage) {
        super.health -= damage;
        if (super.health <= 0) {
            super.hasFallen();
        }
    }

    @Override
    public String attack(Hero enemy) {
        enemy.takeDamage(ATTACK_DAMAGE);
        return enemy.getName() + " takes " + ATTACK_DAMAGE + " damage"; //super.getAttackMessage(enemy.getName(), ATTACK_DAMAGE) + "\n"
                //+ enemy.toString();
    }

    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
    }
}
