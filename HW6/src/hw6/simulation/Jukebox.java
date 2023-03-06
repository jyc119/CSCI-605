package hw6.simulation;


import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Jukebox {

    private static int seed;

    public Jukebox(int seed) {
        this.seed = seed;
    }

    public ArrayList<Song> createSongs(File file) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        ArrayList<Song> songs = new ArrayList<>();
        while (line != null) {
            String[] testLine = line.split("<SEP>", 4);
            Song newSong = new Song(testLine[3], testLine[2]);
            if (!songs.contains(newSong)) {
                songs.add(newSong);
            }
            line = reader.readLine();
        }
        return songs;
    }

    public void runSimulation(ArrayList<Song> songs) {
        ArrayList<Song> first5Songs = new ArrayList<>();
        TreeMap<Song, Integer> allSongs = new TreeMap<>();
        int runs = 50000;
        Random rand = new Random(seed);
        long startTime = System.currentTimeMillis();
        int totalSongs = 0;
        while (runs > 0) {
            int numberOfSongs = 0;
            Set<Song> songsPlayed = new HashSet<>();
            //Iterator<Song> itr = songs.iterator();
            while (true) {
                Song nextSong = songs.get(rand.nextInt(songs.size()));
                if (first5Songs.size() < 5) {
                    first5Songs.add(nextSong);
                }
                if (songsPlayed.add(nextSong)) {
                    songsPlayed.add(nextSong);
                    if (allSongs.containsKey(nextSong)) {
                        allSongs.replace(nextSong, allSongs.get(nextSong) + 1);
                    }
                    else {
                        allSongs.put(nextSong, 1);
                    }
                }
                else {
                    break;
                }
                numberOfSongs += 1;
        }
            totalSongs += numberOfSongs;
            runs --;
        }
        long endTime = System.currentTimeMillis();
        long runTime = endTime - startTime;
        runs = 50000;
        TreeSet<Song> songsBymostPlayed = new TreeSet<>();
        for (Song song: songs) {
            if (song.getArtist().equals(allSongs.lastEntry().getKey().getArtist())) {
                songsBymostPlayed.add(song);
            }
        }
        System.out.println("Jukebox of " + songs.size() +
                " songs starts rockin'...");
        System.out.println("Printing first 5 songs played...");
        for (Song song: first5Songs) {
            System.out.println("    " + song.toString());
        }
        System.out.println("Simulation took " + Long.toString((long) (runTime * 0.001)) + " second/s");
        System.out.println("Number of simulations run: " + Integer.toString(runs));
        System.out.println("Total number of songs played: " + Integer.toString(totalSongs));
        System.out.println("Average number of songs played per simulation to get duplicate: " + Integer.toString(totalSongs/runs));
        System.out.println("Most played song: " + '"' + allSongs.lastEntry().getKey().getName() + '"' + " by " + '"' + allSongs.lastEntry().getKey().getArtist() + '"');
        System.out.println("All songs alphabetically by " + '"' + allSongs.lastEntry().getKey().getArtist() + '"' + ":");
        for (Song song: songsBymostPlayed) {
            System.out.println("    " + '"' + song.getName() + '"' + " with " + allSongs.get(song) + " plays");
        }
    }


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
