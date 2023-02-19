package hw4.heroes;
import hw4.heroes.Heroes.Role;
import hw4.game.Team;

public abstract class Hero {

    private String name;

    private Role role;

    private Team team;

    private Party party;

    public Hero(String name, int heores){}

    public static Hero createHero(Role role, Team team, Party party){
        Heroes heroes = new Heroes();
        String heroName = Heroes.getName(team,role);
    }

    public String getName(){return name;}

    public Team getTeam(){return team;}

    public Role getRole(){return role;}

    public Party getParty(){return party;}






}
