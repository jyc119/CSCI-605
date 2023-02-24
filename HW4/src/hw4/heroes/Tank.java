/*
 * HW3: Arithmetic Interpreter
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw4.heroes;

import hw4.game.*;

/**
 * Class associated with Tank role
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Tank extends Hero {

    /** Initial health points of tank */
    public static final int BASE_HP = 40;

    /** Attack damage of tank */
    public static final int ATTACK_DAMAGE = 15;

    /** Percentage of damage shielded by tank */
    public static final int DEFENSE = 10;

    /**
     * The constructor calls the hero constructor using the Heroes.getName() function and the BASE_HP constant variable.
     * The role, team and health is passed to the hero class using the super keyword.
     * @param team
     */
    public Tank(Team team){
        super(Heroes.getName(team, Heroes.Role.TANK), BASE_HP);
        super.role = Heroes.Role.TANK;
        super.team = team;
        super.health = BASE_HP;
    }

    /**
     * The hero takes reduced damage based on the parameter and defense stat
     *
     * @param damage The amount of damage the hero takes
     */
    @Override
    public void takeDamage(int damage) {
        float reducedDamage = (float) DEFENSE/100 *  (float) damage;
        int shieldedDamage = (int) (damage - reducedDamage);
        super.health -= shieldedDamage;
        if (super.health <= 0) {
            super.health = 0;
        }
        System.out.println(super.name
                + " takes " + shieldedDamage + " damage");
    }

    /**
     * The hero attacks another hero
     *
     * @param enemy The hero that is being attacked by this hero
     */
    @Override
    public void attack(Hero enemy) {
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
