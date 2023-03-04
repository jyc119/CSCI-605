package hw6.simulation;


import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jukebox {


    public Set<Song> createSongs(File file) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        Set<Song> songs = new HashSet<Song>();
        while (line != null) {
            String[] testLine = line.split("<SEP>", 4);
            songs.add(new Song(testLine[2], testLine[3]));
            line = reader.readLine(); // Need to implement a method so songs are not added twice if repeated in txt file
        }
        return songs;
    }

    public void runSimulation(Set<Song> songs) {
        int runs = 50000;
        System.out.println("Jukebox of " + songs.size() +
                " songs starts rockin'...");
//        long startTime = System.nanoTime();
//        for(int i = 0; i < runs; i++) {
//
//        }
//        long endTime = System.nanoTime();
//        long runTime = endTime - startTime;
        //System.out.println("Simulation took " + Long.toString(runTime) + " second/s");
        System.out.println(songs);
        System.out.println("Number of simulations run: " + Integer.toString(runs));
        System.out.println("Total number of songs played: "); // Add songs played component
        System.out.println("Average number of songs played per simulation to get duplicate: "); // Add duplicate component
        System.out.println("Most played song: " ); // Add most played song component
        System.out.println("All songs alphabetically by "); // Add artist of most played song
        // Print Songs by artist above in alphabetical order
    }


    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Jukebox filename seed");
        } else {
            Jukebox jukebox = new Jukebox();
            Set<Song> songs = jukebox.createSongs(new File(args[0]));
            jukebox.runSimulation(songs);
        }
    }
}
