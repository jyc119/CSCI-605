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


/**
 * The main program for the jukebox simulation
 * <pre>
 * $ java Jukebox filename seed
 * Usage: java Jukebox filename seed
 *</pre>
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
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

    public static List<Song> getSongs(String filename){
        BufferedReader reader;
        HashSet<Song> songSet = new HashSet<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] arrOfStr = line.split("<SEP>", 4);
                Song newSong = new Song(arrOfStr[3],arrOfStr[2]);
                songSet.add(newSong);
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<Song> songs = new ArrayList<>(songSet);
        return songs;

        //return songs;
    }

    public static void openingLine(int songs){
        System.out.println("Jukebox of " + songs + " songs starts rockin'...");
        System.out.println("Printing first 5 songs played...");
    }

    public void startSimulation(String filename, int seed){
        long startTime = System.currentTimeMillis();
        int simulations = 1;
        Random rnd = new Random(seed);
        List<Song> newSongs = new ArrayList<>();
        List<Song> firstFiveSongs = new ArrayList<>();
        newSongs = getSongs(filename);
        int songsInBox = newSongs.size();
        int numOfSongs = 0;

        while(simulations > 0){
            Set<Song> songSet = new HashSet<>();
            int nextSong = rnd.nextInt(songsInBox);
            firstFiveSongs.add(newSongs.get(nextSong));
            songSet.add(newSongs.get(nextSong));
            numOfSongs += 1;
            nextSong = rnd.nextInt(songsInBox);

            while(!songSet.contains(newSongs.get(nextSong))){
                if(firstFiveSongs.size() < 5){
                    firstFiveSongs.add(newSongs.get(nextSong));
                }
                numOfSongs += 1;
                songSet.add(newSongs.get(nextSong));
                nextSong = rnd.nextInt(songsInBox);
            }

            simulations -= 1;
        }
        openingLine(newSongs.size());
        for(Song x: firstFiveSongs)
            System.out.println("    " + x);
        System.out.println("Number of songs played: " + numOfSongs);
        long endTime = System.currentTimeMillis();
        System.out.println("Simulation took " + (endTime-startTime)/1000 + " second/s: ");
    }

    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("Usage: java Jukebox filename seed");
        } else {
            String filename = args[0];
            int seed = Integer.parseInt(args[1]);
            Jukebox sim = new Jukebox(seed);
            sim.startSimulation(filename, seed);
        }
    }

}
