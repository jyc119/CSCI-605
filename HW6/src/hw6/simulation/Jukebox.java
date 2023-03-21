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
    private static final int SIM_RUNS = 50000;

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

    }

    public static void openingLine(int songs){
        System.out.println("Jukebox of " + songs + " songs starts rockin'...");
        System.out.println("Printing first 5 songs played...");
    }

    public void startSimulation(String filename, int seed){
        long startTime = System.currentTimeMillis();
        int simulations = 50000;
        Random rnd = new Random(seed);
        List<Song> newSongs = new ArrayList<>();
        List<Song> firstFiveSongs = new ArrayList<>();
        HashMap<Song, Integer> songToPlays = new HashMap<>();
        TreeMap<String,HashSet<Song>> artistToSongs = new TreeMap<>();
        newSongs = getSongs(filename);
        int songsInBox = newSongs.size();
        int numOfSongs = 0;

        while(simulations > 0){
            Set<Song> songSet = new HashSet<>();
            int nextSong = rnd.nextInt(songsInBox);
            if(firstFiveSongs.size() == 0){
                firstFiveSongs.add(newSongs.get(nextSong));
            }

            // Adding to hashmap song to plays
            songSet.add(newSongs.get(nextSong));
            Integer count = songToPlays.get(newSongs.get(nextSong));
            if(count == null){
                songToPlays.put(newSongs.get(nextSong),1);
            }else{
                songToPlays.put(newSongs.get(nextSong),count+1);
            }

            if(artistToSongs.containsKey(newSongs.get(nextSong).getArtist())){
                artistToSongs.get(newSongs.get(nextSong).getArtist()).add(newSongs.get(nextSong));
            }else{
                HashSet<Song> songs = new HashSet<>();
                artistToSongs.put(newSongs.get(nextSong).getArtist(),songs);
            }

            numOfSongs += 1;
            nextSong = rnd.nextInt(songsInBox);

            while(!songSet.contains(newSongs.get(nextSong))){
                if(firstFiveSongs.size() < 5){
                    firstFiveSongs.add(newSongs.get(nextSong));
                }
                numOfSongs += 1;
                songSet.add(newSongs.get(nextSong));
                count = songToPlays.get(newSongs.get(nextSong));
                if(count == null){
                    songToPlays.put(newSongs.get(nextSong),1);
                }else{
                    songToPlays.put(newSongs.get(nextSong),count+1);
                }

                if(artistToSongs.containsKey(newSongs.get(nextSong).getArtist())){
                    artistToSongs.get(newSongs.get(nextSong).getArtist()).add(newSongs.get(nextSong));
                }else{
                    HashSet<Song> songs = new HashSet<>();
                    artistToSongs.put(newSongs.get(nextSong).getArtist(),songs);
                }

                nextSong = rnd.nextInt(songsInBox);
            }

            simulations -= 1;
        }
        openingLine(newSongs.size());
        for(Song x: firstFiveSongs)
            System.out.println("    " + x);
        //Iterate through songsToPlays

        Iterator songToPlaysIterator = songToPlays.entrySet().iterator();
        Song mostPlayedSong = null;
        int mostPlays=0;
        while(songToPlaysIterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)songToPlaysIterator.next();
            int plays = (int)mapElement.getValue();
            if(plays > mostPlays){
                mostPlayedSong = (Song)mapElement.getKey();
                mostPlays = plays;
            }
        }

        //Loop through songs
        //HashSet<Song> highestKey = artistToSongs.get(artistToSongs.lastKey());

        System.out.println("Printing list of songs");
        /*
        for(Song x: highestKey)
            System.out.println(songToPlays.get(x));

         */
        System.out.println(artistToSongs.get(mostPlayedSong.getArtist()));
        long endTime = System.currentTimeMillis();
        System.out.println("Simulation took " + (endTime-startTime)/1000 + " second/s: ");
        System.out.println("Number of simulations run: " + SIM_RUNS);
        System.out.println("Total number of songs played: " + numOfSongs);
        System.out.println("Average number of songs played per simulation to get duplicate: " + numOfSongs/SIM_RUNS);
        System.out.println("Most played song: " + "\"" + mostPlayedSong.getSong() + "\"" + " by " + "\"" + mostPlayedSong.getArtist() + "\":");
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
