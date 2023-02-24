package hw4.heroes;

import hw4.game.*;


public class Healer extends Hero{
    public static final int BASE_HP = 35;
    public static final int ATTACK_DAMAGE = 10;
    public static final int HEAL_AMOUNT = 10;
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
            super.health = 0;
        }
        System.out.println(super.name
                + " takes " + damage + " damage");
    }
    @Override
    public void attack(Hero enemy) {
        if (this.party.getHeroes().get(0).getRole() != Heroes.Role.HEALER){
            this.heal(HEAL_AMOUNT);
            for(int i = 0; i < party.getHeroes().size(); i++) {
                party.getHeroes().get(i).heal(HEAL_AMOUNT);
            }
        } else {
            for (int i = 0; i < party.getHeroes().size(); i++) {
                party.getHeroes().get(i).heal(HEAL_AMOUNT);
            }
        }
        enemy.takeDamage(ATTACK_DAMAGE);
    }

    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
        System.out.println(super.name + " heals " + heal + " points");
    }

}
