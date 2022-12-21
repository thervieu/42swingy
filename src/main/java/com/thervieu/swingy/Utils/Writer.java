package com.thervieu.swingy.Utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    public Writer() {}

    public static void write(String playerLine) {
        try {
            File f = new File("players.txt");
            FileWriter fileWriter = new FileWriter(f, true);
            fileWriter.append(playerLine);
            fileWriter.append("\n");
            fileWriter.close();
            System.out.printf("Wrote \"%s\" to players.txt\n", playerLine);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
