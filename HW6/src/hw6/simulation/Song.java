package hw6.simulation;

import java.util.Objects;

public class Song implements Comparable<Song> {

    private String name;

    private String artist;

    public Song(String name, String artist){
        this.name = name;
        this.artist = artist;

    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Artist: " + artist + ", Song: " + name;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song2 = (Song) o;
        return Objects.equals(name, song2.name) && Objects.equals(artist, song2.artist);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + this.artist.hashCode();
    }

    @Override
    public int compareTo(Song song2) {
        return name.compareTo(song2.name);
    }
}
