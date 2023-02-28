package hw5.simulation;

public class Patron implements Comparable<Patron>{
    
    private final String name;

    private final int coolness;

    private final boolean regularity;

    public Patron(String name, int coolness, boolean regularity) {
        this.name = name;
        this.coolness = coolness;
        this.regularity = regularity;
    }

    public String getName() {return name;}

    public int getCoolness() {return coolness;}

    @Override
    public int compareTo(Patron patron) {
        if (this.coolness > patron.coolness) {
            return 1;
        }
        else if (this.coolness < patron.coolness) {
            return -1;
        }
        else {
            return Boolean.compare(this.regularity, patron.regularity);
        }
    }
}
