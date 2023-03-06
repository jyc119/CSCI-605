package hw6.simulation;

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

    public boolean equals(Song song2) {
        return name.equals(song2.name) && artist.equals(song2.artist);
    }

    @Override
    public final int hashCode() {
        return name.hashCode() + artist.hashCode();
    }

    @Override
    public int compareTo(Song song2) {
        return artist.compareTo(song2.artist);
    }
}
