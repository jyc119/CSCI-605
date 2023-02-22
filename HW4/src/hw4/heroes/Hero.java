package hw4.heroes;
import hw4.heroes.Heroes.Role;
import hw4.game.Team;

public abstract class Hero {

    private Role role;

    private Team team;

    private Party party;

    private Heroes heroes;

    public Hero(String name, int health){
    }

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

    public static Hero createHero(Role role, Team team, Party party){
        Heroes heroes = new Heroes();
        String heroName = Heroes.getName(team,role);
        int heroHealth = getHeroHealth(role);

        if (role == Role.BERSERKER){
            return new Berserker(team);
        }

    }

    public String getName(){return Heroes.getName(team,role);}

    public Team getTeam(){return team;}

    public Role getRole(){return role;}

    public Party getParty(){return party;}


    public abstract void takeDamage(int damage);

    public abstract void attack(Hero enemy);

    public abstract void heal(int heal);

    public String hasFallen(){
        //party.removeHero(hero);
        return this + " has fallen!";
    }

    @Override
    public String toString() {
        return getName();
    }
}
