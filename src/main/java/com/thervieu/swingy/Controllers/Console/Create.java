package com.thervieu.swingy.controllers.console;

import java.util.Scanner;

public class Create {
    public static String CreateOrDB() {
        System.out.println("[Start] Welcome to swingy, a text-based RPG.");
        System.out.println("[Start] To start off you can create a new player or choose one from a previous adventure.");
        
        String choice = "";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            System.out.println("[Start] Either input create or choose.");
            choice = sc.nextLine();
            if (choice.equals("create") || choice.equals("choose")) {
                break;
            }
        }
        return choice;
    }

    public static String Name() {
        System.out.println("[Character] What's your character's name ?");
        
        String name = "";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            name = sc.nextLine();
            name = name.trim();
            if (name.length() > 10) {
                System.out.println("[Character] Max length of 10");
                continue;
            }
            if (name.length() > 0) {
                String[] array = name.split(" ");
                if (array.length > 0) {
                    name = String.join("_", array);
                    break;
                }
            }
        }
        return name;
    }
    // public static String ClassChoice() {
    //     System.out.println("[Character] Your class will determine the base stats");

    //     String class = "";
        // Scanner sc=new Scanner(System.in);
        // while (sc.hasNextLine()) {
        //     System.out.println("[Character] You can choose a class between warrior and paladin.");
        //     class = sc.NextLine();
        //     if (choice.equals("warrior") || choice.equals("paladin")) {
        //         break;
        //     }
        // }
    //     return class;
    // }
    
    // public Player CreatePlayer(String name, String class) {
    //     if (class.equals("warrior")) {
    //         System.out.println("Creating warrior");
    //         return new Player(name, class, 1, 0, 10, 30, 6, 0, 0, 0);
    //     }
    //     if (class.equals("paladin")) {
    //         System.out.println("Creating paladin");
    //         return new Player(name, class, 1, 0, 6, 50, 7, 0, 0, 0);
    //     }
    //     return null;
    // }

}
