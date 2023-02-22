package hw4.heroes;
import hw4.heroes.Heroes.Role;
import hw4.game.Team;

public abstract class Hero {

    private Role role;

    private Team team;

    private Party party;

    private Heroes heroes;

    public Hero(String name, int health){
        this.heroes = new Heroes();
    }

    public static int getHeroHealth(Role role){
        if (role == Role.BERSERKER){
            return 30;
        }
        else if (role == Role.HEALER){
            return 35;
        }
        else{
            return 40;
        }
    }

    public static Hero createHero(Role role, Team team, Party party){
        Heroes heroes = new Heroes();
        String heroName = Heroes.getName(team,role);
        int heroHealth = getHeroHealth(role);

        return new Hero(heroName, heroHealth);

    }

    public String getName(){return Heroes.getName(team,role);}

    public Team getTeam(){return team;}

    public Role getRole(){return role;}

    public Party getParty(){return party;}


    public abstract void takeDamage(int damage);

    public abstract void attack(Hero enemy);

    public abstract void heal(int heal);

    public String fellEnemy(String hero){
        //party.removeHero(hero);
        return hero + " has fallen!";
    }

    public String
}
