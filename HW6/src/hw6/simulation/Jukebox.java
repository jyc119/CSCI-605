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

    public static List<Song> getSongs(String filename){
        BufferedReader reader;
        List<Song> songs = new ArrayList<>();
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while (line != null) {
                String[] arrOfStr = line.split("<SEP>", 4);
                songs.add(new Song(arrOfStr[3],arrOfStr[2]));
                // read next line
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return songs;
    }

    public static void openingLine(int songs){
        System.out.println("Jukebox of " + songs + " songs starts rockin'...");
        System.out.println("Printing first 5 songs played...");
    }

    public static void main(String[] args){
        if (args.length != 1) {
            System.out.println("Usage: java HeroStorm " +
                    "dragon_seed_# lion_seed_#");
        } else {
            String filename = args[0];
            List<Song> newsongs = new ArrayList<>();
            newsongs = getSongs(filename);
            System.out.println(newsongs);
        }
    }

}
