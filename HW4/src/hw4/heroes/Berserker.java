package hw4.heroes;

import hw4.game.Team;

public class Berserker extends Hero{

    public static final int BASE_HP = 30;
    public static final int ATTACK_DAMAGE = 20;

    public Berserker(Team team){
        super(Heroes.getName(team, Heroes.Role.BERSERKER), BASE_HP);
        super.role = Heroes.Role.BERSERKER;
        super.team = team;
    }

    @Override
    public void takeDamage(int damage) {
        this.HIT_POINTS -= damage;
        if (this.HIT_POINTS <= 0) {
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
        this.HIT_POINTS += heal;
        if (this.HIT_POINTS > BASE_HP){
            this.HIT_POINTS = BASE_HP;
        }
    }
}
