package com.thervieu.swingy.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public Writer() {}

    public static void write(String playerLine) {
        try {
            File f = new File("player.txt");
            FileWriter fileWriter = new FileWriter(f, false);
            fileWriter.write(playerLine);
            fileWriter.close();
            System.out.printf("Save player to player.txt\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
