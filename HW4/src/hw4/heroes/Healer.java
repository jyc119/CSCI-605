/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw4.heroes;

import hw4.game.*;

/**
 * Class associated with healer role
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Healer extends Hero{

    /** Initial health points for healer */
    public static final int BASE_HP = 35;

    /** Attack damage for healer */
    public static final int ATTACK_DAMAGE = 10;

    /** Amount healed by healer */
    public static final int HEAL_AMOUNT = 10;

    /** Party associated with healer */
    private Party party;

    /**
     *
     *
     * @param team the team of hero
     * @param party the party of hero
     */
    public Healer(Team team, Party party){
        super(Heroes.getName(team, Heroes.Role.HEALER), BASE_HP);
        this.party = party;
        super.role = Heroes.Role.HEALER;
        super.team = team;
        super.health = BASE_HP;
    }

    /**
     * The hero takes damage based on the parameter
     *
     * @param damage The amount of damage the hero takes
     */
    @Override
    public void takeDamage(int damage) {
        super.health -= damage;
        if (super.health <= 0){
            super.health = 0;
        }
        System.out.println(super.name
                + " takes " + damage + " damage");
    }

    /**
     * The hero heals their party and attacks another hero
     *
     * @param enemy The hero that is being attacked by this hero
     */
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

    /**
     * The hero heals based on parameter
     *
     * @param heal The amount the hero heals by
     */
    @Override
    public void heal(int heal) {
        super.health += heal;
        if (super.health > BASE_HP){
            super.health = BASE_HP;
        }
        System.out.println(super.name + " heals " + heal + " points");
    }

}
