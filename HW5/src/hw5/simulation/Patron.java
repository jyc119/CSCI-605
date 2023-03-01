/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.simulation;

/**
 * Represents a Patron in the queue simulation
 * <pre>
 * $ java GateKeeper
 * Usage: java GateKeeper
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Patron implements Comparable<Patron>{

    /** name of the patron */
    private final String name;

    /** coolness of the patron */
    private final int coolness;

    /** boolean representation of the regularity of the patron */
    private final boolean regularity;

    /**
     * Create the patron.
     *
     * @param name the name of the patron
     * @param coolness the coolness rating of the patron
     * @param regularity the regularity of the patron
     */
    public Patron(String name, int coolness, boolean regularity) {
        this.name = name;
        this.coolness = coolness;
        this.regularity = regularity;
    }

    /**
     * Get the name of the patron.
     *
     * @return the name
     */
    public String getName() {return name;}

    /**
     * Get the coolness rating of the patron.
     *
     * @return the coolness rating
     */
    public int getCoolness() {return coolness;}

    /**
     * Compare the patron to another patron.
     *
     * @param patron the patron being compared with
     * @return 1 if the instance patron has a higher coolness than the
     * patron being compared to or equal coolness but is a regular and the
     * patron being compared to is not. -1 if the opposite is true. 0 if they
     * have equal coolness and the same regularity.
     */
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
