/*
 * HW4: HeroStorm
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */


package hw4.heroes;

import hw4.heroes.Heroes.Role;
import hw4.game.Team;

/**
 * The abstract class Hero
 * <pre>
 * $ java HeroStorm dragon_seed_# lion_seed_#
 * Usage: java HeroStorm dragon_seed_# lion_seed_#
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public abstract class Hero {

    /** The role of the hero (e.g. Berserker, Tank, Healer)*/
    protected Role role;

    /** The hero's team (e.g. Dragon, Prince)*/
    protected Team team;

    /** The name of the hero*/
    protected String name;

    /** The hero's health*/
    protected int health;

    /**
     * The Hero class constructor which assigns the
     * name and health to their respective fields.
     *
     * @param name The name of the hero
     * @param health The health of the hero
     */
    public Hero(String name, int health){
        this.name = name;
        this.health = health;
    }

    public static Hero createHero(Role role, Team team, Party party){
        if (role == Role.BERSERKER){
            return new Berserker(team);
        }

        else if (role == Role.HEALER){
            return new Healer(team, party);
        }

        else{
            return new Tank(team);
        }

    }

    /**
     * Gets the base health points of a hero based on the role.
     *
     * @param role The role of the hero
     * @return The health points
     */
    public static int getHeroHealth(Role role){
        if (role == Role.BERSERKER){
            return Berserker.BASE_HP;
        }
        else if (role == Role.HEALER){
            return Healer.BASE_HP;
        }
        else{
            return Tank.BASE_HP;
        }
    }

    /**
     * Uses the Heroes.getName() function to obtain
     * the name depending on the team and role
     *
     * @return Name of the hero
     */
    public String getName(){return Heroes.getName(team,role);}

    /**
     * Returns the team of the hero
     *
     * @return Team of the hero
     */
    public Team getTeam(){return team;}

    /**
     * Returns the role of the hero
     *
     * @return Role of the hero
     */
    public Role getRole(){return role;}

    /**
     * The hero takes damage based on the parameter
     *
     * @param damage The amount of damage the hero takes
     */
    public abstract void takeDamage(int damage);

    /**
     * The hero attacks another hero
     *
     * @param enemy The hero that is being attacked by this hero
     */
    public abstract void attack(Hero enemy);

    /**
     * The hero heals based on parameter
     *
     * @param heal The amount the hero heals by
     */
    public abstract void heal(int heal);

    /**
     * If the hero is dead, print a message and return true.
     * If the hero is alive, return false.
     *
     * @return If the hero has fallen
     */
    public boolean hasFallen(){
        if(health <= 0) {
            System.out.println(getName() + " has fallen!");
            return true;
        }else{
            return false;
        }
    }

    /**
     * Prints the hero in the following format
     * 'name , role , health / basehealth'
     *
     * @return The hero characteristics
     */
    @Override
    public String toString() {
        return getName() + ", " + getRole() + ", " +
                this.health + "/" + getHeroHealth(getRole());
    }
}
