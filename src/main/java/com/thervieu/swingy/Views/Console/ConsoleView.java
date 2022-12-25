package com.thervieu.swingy.Views.Console;

import java.util.Scanner;

import com.thervieu.swingy.Models.Player;

public class ConsoleView {
    private final Scanner sc=new Scanner(System.in);

    public ConsoleView() {
    }

    public String CreateOrDB() {
        System.out.println("[Start] Welcome to swingy, a text-based RPG.");
        System.out.println("[Start] To start off you can create a new player or continue the previous adventure.");
        
        String choice = "";
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("create") || choice.equals("continue")) {
                break;
            }
            System.out.println("[Start] Either input create or continue.");
        }
        return choice;
    }

    public String Name() {
        System.out.println("[Character] What's your character's name ?");
        
        String name = "";
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

    
    public String Class() {
        System.out.println("[Character] Your class will determine the base stats");
        
        String choice = "";
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("warrior") || choice.equals("paladin")) {
                break;
            }
            System.out.println("[Character] Either input warrior or paladin.");
        }
        return choice;
    }

    
    public Player CreatePlayer(String name, String name2) {
        if (name2.equals("warrior")) {
            System.out.println("[Character] Creating warrior");
            return new Player(name, name2, 10, 5, 30);
        } else if (name2.equals("paladin")) {
            System.out.println("[Character] Creating paladin");
            return new Player(name, name2, 7, 8, 40);
        }
        return null;
    }

    public String ChooseDirection() {
        System.out.println("[Direction] Choose you next destination");
        System.out.println("[Action] Input north, west, east or south.");
        System.out.println("[Action] You can print your player' stats by inputing stats.");
        System.out.println("[Action] You can also save and quit by inputing save.");
        
        String choice = "";
        while (sc.hasNextLine()) {
            choice = sc.nextLine();
            if (choice.equals("north") || choice.equals("west") || choice.equals("east")
                || choice.equals("south") || choice.equals("save") || choice.equals("stats")) {
                break;
            }
            System.out.println("[Action] Input north, west, east or south.");
            System.out.println("[Action] You can print your player' stats by inputing stats.");
            System.out.println("[Action] You can also save and quit by inputing save.");
        }
        return choice;
    }

    public int FightOrFlight(int level) {
        double rand = Math.random();
        
        if (rand < 0.6) {
        
            int levelEnemy = level + (int)Math.floor(Math.random() * 3) + 1;

            System.out.printf("[Encounter] In front of you there is a zombie level %d\n", levelEnemy);
            System.out.println("[Encounter] Do you wish to fight it ?");

            String choice = "";
            while (sc.hasNextLine()) {
                choice = sc.nextLine();
                if (choice.equals("fight") || choice.equals("flight")) {
                    break;
                }
                System.out.println("[Direction] Either input fight or flight.");
            }
            if (choice.equals("flight") && Math.random() < 0.5) {
                return 0;
            }
            return levelEnemy;
        }
        return 0;
    }
}
