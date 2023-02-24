package hw4.heroes;

import hw4.game.*;

import java.util.ArrayList;
import java.util.List;

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
            super.health = 0;
        }
        System.out.println(getName()
                + " takes " + damage + " damage");
    }

    public String getHealMessage(String hero, int heal){
        return hero + " heals " + heal + " points";
    }

    @Override
    public void attack(Hero enemy) {
        ArrayList<Integer> partyList = getSeedOrder(0);
        for(int i=0; i<party.getHeroes().size(); i++) {
            party.getHeroes().get(partyList.get(i)).heal(HEAL_AMOUNT);
        }
        enemy.takeDamage(ATTACK_DAMAGE);
    }

    public ArrayList<Integer> getSeedOrder(int seed){
        ArrayList<Integer> l1 = new ArrayList<Integer>();
        switch (seed){
            case 0,3:
                l1.add(1);
                l1.add(0);
                l1.add(2);
                return l1;

            case 1,5:
                l1.add(0);
                l1.add(1);
                l1.add(2);
                return l1;

            case 2,7:
                l1.add(2);
                l1.add(0);
                l1.add(1);
                return l1;
        }
        return l1;
    }

    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
        System.out.println(getName() + " heals " + heal + " points");
    }

}
