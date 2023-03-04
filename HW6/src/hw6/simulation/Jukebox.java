package hw6.simulation;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Jukebox {

    public void play(File file) throws IOException {
        BufferedReader reader;
        reader = new BufferedReader(new FileReader(file));
        String line = reader.readLine();
        while (line != null) {
            String[] testLine = line.split("<SEP>", 4);
            System.out.println(Arrays.toString(testLine));
            line = reader.readLine();
        }

        reader.close();
    }


    public static void main(String args[]) throws IOException {
        if (args.length != 2) {
            System.out.println("Usage: java Jukebox filename seed");
        } else {
            Jukebox jukebox = new Jukebox();
            jukebox.play(new File(args[0]));
        }
    }
}
