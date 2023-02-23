package hw4.heroes;

import hw4.game.*;

public class Healer extends Hero{
    public static final int BASE_HP = 35;
    public int HIT_POINTS = 35;
    public static final int ATTACK_DAMAGE = 10;
    public static final int HEAL_AMOUNT = 10;
    private Team team;
    private Party party;


    public Healer(Team team, Party party){
        super(Heroes.getName(team, Heroes.Role.HEALER), BASE_HP);
        this.party = party;
    }
    @Override
    public void takeDamage(int damage) {
        this.HIT_POINTS -= damage;
        if (this.HIT_POINTS <= 0){
            super.hasFallen();
        }
    }

    public String getHealMessage(String hero, int heal){
        return hero + " heals " + heal + " points";
    }

    @Override
    public void attack(Hero enemy) {
        for (int i = 0; i < party.getHeroes().size(); i++) {
            party.getHeroes().get(i).heal(HEAL_AMOUNT);
            System.out.println(party.getHeroes().get(i) + " heals " +
                    HEAL_AMOUNT + " points");
        }
        enemy.takeDamage(ATTACK_DAMAGE);
        super.getAttackMessage(enemy.getName(), ATTACK_DAMAGE);

    }

    @Override
    public void heal(int heal) {
        this.HIT_POINTS += heal;
        if (this.HIT_POINTS > BASE_HP){
            this.HIT_POINTS = BASE_HP;
        }
    }

    @Override
    public void addHero(Hero hero) {

    }

    @Override
    public Hero removeHero() {
        return null;
    }

    @Override
    public int numHeroes() {
        return 0;
    }

    @Override
    public List<Hero> getHeroes() {
        return null;
    }
}
