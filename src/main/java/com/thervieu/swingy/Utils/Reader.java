package com.thervieu.swingy.Utils;

import java.io.*;

public class Reader {

    public Reader() {}

    public static int numberOfLines() {
        try {
            File f = new File("players.txt");
            FileReader fileReader = new FileReader(f);
            LineNumberReader lnr = new LineNumberReader(fileReader);
            lnr.skip(Integer.MAX_VALUE);
            int nb = lnr.getLineNumber();
            lnr.close();
            return nb;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static String[] getLines() {
        try {
            String str = null;
            String[] lines = new String[numberOfLines()];

            File f = new File("players.txt");
            FileReader fileReader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            int i = 0;
            while ((str = bufferedReader.readLine()) != null) {
                lines[i] = str;
                i++;
            }
            bufferedReader.close();
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void printPlayers() {
        int i = 0;
        int count = 0;
        System.out.println("[Player]: Choose a player\n");
        String[] players = getLines();
        int len = numberOfLines();
        while (i < len) {
            System.out.printf("%3d: %s\n", count++, players[i++]);
        }
        return ;
    }

    public static String getPlayer(int nb) {
        if (nb >= numberOfLines()) {
            System.out.println("too high");
            return "TooHigh";
        }
        String[] players = getLines();
        return players[nb];
    }

    
}
