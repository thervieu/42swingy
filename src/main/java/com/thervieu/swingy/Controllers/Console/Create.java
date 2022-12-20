package com.thervieu.swingy.controllers.console;

import java.util.Scanner;
import com.thervieu.swingy.models.Player;

public class Create {
    public static String CreateOrDB() {
        System.out.println("[Start] Welcome to swingy, a text-based RPG.");
        System.out.println("[Start] To start off you can create a new player or choose one from a previous adventure.");
        
        String choice = "";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("create") || choice.equals("choose")) {
                break;
            }
            System.out.println("[Start] Either input create or choose.");
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

    
    public static String Class() {
        System.out.println("[Character] Your class will determine the base stats");
        
        String choice = "";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("warrior") || choice.equals("paladin")) {
                break;
            }
            System.out.println("[Character] Either input warrior or paladin.");
        }
        return choice;
    }


    public static String ChooseDirection() {
        System.out.println("[Direction] Choose you next destination");
        
        String choice = "";
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("north") || choice.equals("west") || choice.equals("east")
                || choice.equals("south") || choice.equals("save")) {
                break;
            }
            System.out.println("[Direction] Either input north, west, east or south.");
            System.out.println("[Direction] You can also save and quit by inputing save.");
        }
        return choice;
    }

    
    public static Player CreatePlayer(String name, String name2) {
        if (name2.equals("warrior")) {
            System.out.println("[Character] Creating warrior");
            return new Player(name, name2, 10, 5, 30);
        } else if (name2.equals("paladin")) {
            System.out.println("[Character] Creating paladin");
            return new Player(name, name2, 7, 8, 40);
        }
        return null;
    }

}
