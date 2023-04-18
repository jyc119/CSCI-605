package util;

import java.util.Random;

/**
 * An unseeded random number generator that is suitable for generating random
 * numbers in an inclusive range provided by the caller.
 *
 * @author RIT CS
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class RandomBee {
    /** Random number generator usable by all classes */
    private static Random rand = new Random();

    /**
     * Generate a random integer between min and max inclusive.  For example: <br>
     * <br>
     * <tt>BeeRandom.nextInt(1, 5): A random number, 1-5</tt><br>
     * <br>
     *
     * @param min the smallest value allowed.
     * @param max the largest value allowed.
     * @return A random integer
     */
    public static int nextInt(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }

    /**
     * Generates a random percentage to get a new bee type
     * @return A random percentage
     */
    public static int get_bee_type(){
        Random r = new Random();
        int percentage = r.nextInt(100);
        return percentage;
    }
}
