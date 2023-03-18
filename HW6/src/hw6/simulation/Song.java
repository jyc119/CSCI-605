/*
 * HW6: Jukebox
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw6.simulation;

import java.util.Objects;

/**
 * Represents a song in the Jukebox
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class Song implements Comparable<Song> {

    private String name;
    private String artist;

    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
    }

    public int hashcode(){return this.name.hashCode() + this.artist.hashCode();}
    public Boolean equals(Song song){return song.name == this.name && song.artist == this.artist;}

    public String toString(){return "Artist: " + this.artist + ", Song: " + this.name;}

    @Override
    public int compareTo(Song o) {
        return 0;
    }
}
