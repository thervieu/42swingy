package com.thervieu.swingy.Utils;

import java.io.*;

public class Reader {

    public Reader() {}

    public static String getLine() {
        try {
            String player = null;

            File f = new File("players.txt");
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            player = bufferedReader.readLine();
            bufferedReader.close();
            return player;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
