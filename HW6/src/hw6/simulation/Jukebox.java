package hw6.simulation;


import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Jukebox {

    public ArrayList<Song> createSongs(File file) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        ArrayList<Song> songs = new ArrayList<>();
        while (line != null) {
            String[] testLine = line.split("<SEP>", 4);
            Song newSong = new Song(testLine[2], testLine[3]);
            if (!songs.contains(newSong)) {
                songs.add(new Song(testLine[2], testLine[3]));
            }
            line = reader.readLine();
        }
        return songs;
    }

    public void runSimulation(ArrayList<Song> songs) {
        ArrayList<Song> first5Songs = new ArrayList<Song>();
        int runs = 50000;
        Random rand = new Random();
        System.out.println("Jukebox of " + songs.size() +
                " songs starts rockin'...");
        long startTime = System.currentTimeMillis();
        int totalSongs = 0;
        while (runs > 0) {
            // while loop until a song is repeated
            int numberOfSongs = 0;
            Set<Song> songsPlayed = new TreeSet<>();
//            while (next.get()) {
//                Song nextSong = songs.get(rand.nextInt(songs.size()));
//                if (first5Songs.size() < 5) {
//                    first5Songs.add(nextSong);
//                }
//                songsPlayed.add(nextSong);
//                numberOfSongs += 1;
//        }
            totalSongs += numberOfSongs;
            runs --;
        }
        runs = 50000;
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        System.out.println("Printing first 5 songs played...");
        for (Song song: first5Songs) {
            System.out.println("    " + song.toString());
        }
        System.out.println("Simulation took " + Long.toString((long) (runTime * 0.001)) + " second/s");
        System.out.println("Number of simulations run: " + Integer.toString(runs));
        System.out.println("Total number of songs played: " + Integer.toString(totalSongs));
        System.out.println("Average number of songs played per simulation to get duplicate: " + Integer.toString(totalSongs/runs)); // Add duplicate component
        System.out.println("Most played song: " ); // Add most played song component
        System.out.println("All songs alphabetically by "); // Add artist of most played song
        // Print Songs by artist above in alphabetical order
    }


    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Jukebox filename seed");
        } else {
            Jukebox jukebox = new Jukebox();
            ArrayList<Song> songs = jukebox.createSongs(new File(args[0]));
            jukebox.runSimulation(songs);
        }
    }
}
