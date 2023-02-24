package hw4.heroes;

import hw4.game.*;

public class Healer extends Hero{
    public static final int BASE_HP = 35;
    public static final int ATTACK_DAMAGE = 10;
    public static final int HEAL_AMOUNT = 10;
    private Team team;
    private Party party;


    public Healer(Team team, Party party){
        super(Heroes.getName(team, Heroes.Role.HEALER), BASE_HP);
        this.party = party;
        super.role = Heroes.Role.HEALER;
        super.team = team;
        super.health = BASE_HP;
    }
    @Override
    public void takeDamage(int damage) {
        super.health -= damage;
        if (super.health <= 0){
            super.hasFallen();
        }
    }

    public String getHealMessage(String hero, int heal){
        return hero + " heals " + heal + " points";
    }

    @Override
    public String attack(Hero enemy) {
        for (int i = 0; i < party.getHeroes().size(); i++) {
            party.getHeroes().get(i).heal(HEAL_AMOUNT);
            System.out.println(party.getHeroes().get(i) + " heals " +
                    HEAL_AMOUNT + " points");
        }
        enemy.takeDamage(ATTACK_DAMAGE);
        return enemy + " takes " + ATTACK_DAMAGE + " damage";//super.getAttackMessage(enemy.getName(), ATTACK_DAMAGE);
    }

    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
    }

}
