package com.thervieu.swingy.Utils;

import java.io.*;

import com.thervieu.swingy.Models.Player;

public class Reader {

    public Reader() {}

    public static String getLine() {
        try {
            String player = null;

            File f = new File("player.txt");
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

    public static Player CreateFromArray(String[] arr) {
        return new Player(arr[0], arr[1], Integer.parseInt(arr[2]),
            Integer.parseInt(arr[3]), Integer.parseInt(arr[4]),
            Integer.parseInt(arr[5]), Integer.parseInt(arr[6]),
            arr[7], Integer.parseInt(arr[8]), Integer.parseInt(arr[9]), Integer.parseInt(arr[10]));
    }
}
