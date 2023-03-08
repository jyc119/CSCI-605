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

    /** the name of the song */
    private String name;

    /** the song's artist */
    private String artist;

    /**
     * Create a song
     *
     * @param name the name of the song
     * @param artist the song's artist
     */
    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;
    }

    /**
     * Get the name of the song
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the artist of the song
     *
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Returns the string representation of a song in the form "Artist: ARTIST,
     * Song: NAME"
     *
     * @return The string representation
     */
    @Override
    public String toString() {
        return "Artist: " + artist + ", Song: " + name;
    }

    /**
     * Determines whether two songs are equal. They are equal if they have the
     * same name and artist
     *
     * @param o the object being compared to
     * @return whether they are equal or not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song2 = (Song) o;
        return Objects.equals(name, song2.name) && Objects.equals
                (artist, song2.artist);
    }

    /**
     * Returns the hash code of a song. Song hash code is name hash code plus
     * artist hashCode
     *
     * @return hash code
     */
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.artist.hashCode();
    }

    /**
     * Compares two songs by name
     *
     * @param song2 the song to compare instance to
     * @return the difference in ascii value of first differing
     * character in song names
     */
    @Override
    public int compareTo(Song song2) {
        return name.compareTo(song2.name);
    }
}
