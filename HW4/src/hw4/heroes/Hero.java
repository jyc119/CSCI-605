package hw4.heroes;
import hw4.heroes.Heroes.Role;
import hw4.game.Team;

public abstract class Hero {

    protected Role role;

    protected Team team;

    private Party party;

    private String name;

    protected int health;

    public Hero(){}
    public Hero(String name, int health){
        this.name = name;
        this.health = health;
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

    public String getName(){return Heroes.getName(team,role);}

    public Team getTeam(){return team;}

    public Role getRole(){return role;}

    public Party getParty(){return party;}


    public abstract void takeDamage(int damage);

    public abstract void attack(Hero enemy);

    public abstract void heal(int heal);

    public boolean hasFallen(){
        if(health <= 0) {
            System.out.println(team + " Berserker has fallen");
            return true;
        }else{
            return false;
        }
    }
    @Override
    public String toString() {
        return getName() + ", " + getRole() + ", " +
                this.health + "/" + getHeroHealth(getRole());
    }
}
