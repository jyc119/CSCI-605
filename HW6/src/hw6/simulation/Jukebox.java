/*
 * HW6: Jukebox
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw6.simulation;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Jukebox {

    /** The seed to for the random number generator */
    private static int seed;

    /**
     * Create the jukebox
     *
     * @param seed the seed for the random number generator
     */
    public Jukebox(int seed) {
        this.seed = seed;
    }

    /**
     * Reads in the lines from a file and creates a song from each line.
     * The songs aare added to a hash set and the set is then converted
     * to an arraylist.
     *
     * @param file the file object to get the songs from
     * @return the arraylist songs
     */
    public ArrayList<Song> createSongs(File file) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        HashSet<Song> songSet = new HashSet<>();
        while (line != null) {
            String[] testLine = line.split("<SEP>", 4);
            Song newSong = new Song(testLine[3], testLine[2]);
            songSet.add(newSong);
            line = reader.readLine();
        }
        ArrayList<Song> songs = new ArrayList<Song>(songSet);
        return songs;
    }

    /**
     * Uses the arraylist of songs to simulate the Birthday Paradox and print
     * various statistics relating to the simulation.
     *
     * @param songs the arraylist of the songs
     */
    public void runSimulation(ArrayList<Song> songs) {
        ArrayList<Song> first5Songs = new ArrayList<>();
        HashMap<Song, Integer> allSongs = new HashMap<>();
        int runs = 50000;
        Random rand = new Random(seed);
        long startTime = System.currentTimeMillis();
        int totalSongs = 0;
        System.out.println("Jukebox of " + songs.size() +
                " songs starts rockin'...");
        while (runs > 0) {
            int numberOfSongs = 0;
            Set<Song> songsPlayed = new HashSet<>();
            while (true) {
                Song nextSong = songs.get(rand.nextInt(songs.size()));
                if (songsPlayed.add(nextSong)) {
                    songsPlayed.add(nextSong);
                    if (first5Songs.size() < 5) {
                        first5Songs.add(nextSong);
                    }
                    if (allSongs.containsKey(nextSong)) {
                        allSongs.replace(nextSong, allSongs.get(nextSong) + 1);
                    } else {
                        allSongs.put(nextSong, 1);
                    }
                } else {
                    break;
                }
                numberOfSongs += 1;
            }
            totalSongs += numberOfSongs;
            runs--;
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        runs = 50000;
        int max = 0;
        for (Integer value : allSongs.values()) {
            if (value > max) {
                max = value;
            }
        }
        Song mostPlayed = null;
        for (Song song : allSongs.keySet()) {
            if (allSongs.get(song) == max) {
                mostPlayed = song;
            }
        }
        TreeSet<Song> songsBymostPlayed = new TreeSet<>();
        for (Song song: songs) {
            if (song.getArtist().equals(mostPlayed.getArtist())) {
                songsBymostPlayed.add(song);
            }
        }
        System.out.println("Printing first 5 songs played...");
        for (Song first5 : first5Songs) {
            System.out.println("    " + first5.toString());
        }
        System.out.println("Simulation took " + Long.toString((long) (runTime
                * 0.001)) + " second/s");
        System.out.println("Number of simulations run: " +
                Integer.toString(runs));
        System.out.println("Total number of songs played: " +
                Integer.toString(totalSongs));
        System.out.println("Average number of songs played per simulation to " +
                "get duplicate: " + Integer.toString(totalSongs / runs));
        System.out.println("Most played song: " + '"' + mostPlayed.getName()
                + '"' + " by " + '"'
                + mostPlayed.getArtist() + '"');
        System.out.println("All songs alphabetically by " + '"' +
                mostPlayed.getArtist() + '"' + ":");
        for (Song song : songsBymostPlayed) {
            System.out.println("    " + '"' + song.getName() + '"' +
                    " with " + allSongs.get(song) + " plays");
        }
    }


    /**
     * Main function. Checks the number of commandline arguments and displays a
     * usage statement and exits the program if not equal to two. If equal to
     * two, the simulation is initialized and run.
     *
     * @param args the file name and seed number as command line arguments
     */
    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Jukebox filename seed");
        } else {
            Jukebox jukebox = new Jukebox(Integer.parseInt(args[1]));
            ArrayList<Song> songs = jukebox.createSongs(new File(args[0]));
            jukebox.runSimulation(songs);
        }
    }
}
