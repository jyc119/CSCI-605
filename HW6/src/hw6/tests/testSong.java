/*
 * HW6: Jukebox
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw6.tests;

import hw6.simulation.Song;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * A test class for Song class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class testSong {

    /** first test song */
    private static Song song1;

    /** second test song */
    private static Song song2;

    @BeforeClass
    public static void init() {
        song1 = new Song("DNA", "Kendrick Lamar");
        song2 = new Song("Hello", "Adele");
    }

    @Test
    public void test1Init() {
        assertEquals("test song1 name",
                "DNA",
                song1.getName());
        assertEquals("test song2 name",
                "Hello",
                song2.getName());
        assertEquals("test song1 artist",
                "Kendrick Lamar",
                song1.getArtist());
        assertEquals("test song2 artist",
                "Adele",
                song2.getArtist());
    }
    @Test
    public void test2toString() {
        assertEquals("test song1 toString",
                "Artist: Kendrick Lamar, Song: DNA", song1.toString());
        assertEquals("test song2 toString",
                "Artist: Adele, Song: Hello", song2.toString());
    }

    @Test
    public void test3equals() {
        assertEquals("test if song1 equals song2",
                false, song1.equals(song2));
    }

    @Test
    public void test4compareTo() {
        assertEquals("test song1 compareTo song2",
                -4, song1.compareTo(song2));
    }
}
