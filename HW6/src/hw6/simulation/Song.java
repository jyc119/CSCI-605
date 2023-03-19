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
    public String getSong(){return this.name;}

    public String getArtist(){return this.artist;}
    @Override
    public int hashCode(){return this.name.hashCode() + this.artist.hashCode();}

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song2 = (Song) o;
        return Objects.equals(name, song2.name) && Objects.equals
                (artist, song2.artist);
    }

    @Override
    public String toString(){return "Artist: " + this.artist + ", Song: " + this.name;}

    @Override
    public int compareTo(Song o) {
        return this.name.compareTo(o.name);
    }
}
