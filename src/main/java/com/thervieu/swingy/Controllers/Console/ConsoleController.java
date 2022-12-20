package com.thervieu.swingy.controllers.console;

import java.util.Scanner;
import com.thervieu.swingy.models.Player;

public class ConsoleController {
    public static Player playerCreation() {

        String choice = Create.CreateOrDB();
        if (choice.equals("create")) {
            String name = Create.Name();
            return Create.CreatePlayer(name, Create.Class());
        } else {
            String name = Create.Name();
            return Create.CreatePlayer(name, Create.Class());
        }
    }

    public static Boolean winMap(Player player) {
        int x = player.getX();
        int y = player.getY();
        int goal = player.getMapSize() / 2;

        if (x == goal || Math.abs(x) == goal
            || y == goal || Math.abs(y) == goal)
            return true;
        return false;
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
    

    public static void saveAndQuit(Player player) {
        return;
    }

    public static int FightOrFlight(int level) {
        double rand = Math.random();
        
        if (rand < 0.7) {
        
            int levelEnemy = level + (int)Math.floor(Math.random() * 3);

            System.out.printf("[Encounter] In front of you there is a zombie level %d\n", levelEnemy);
            System.out.println("[Encounter] Do you wish to fight it ?");

            String choice = "";
            Scanner sc=new Scanner(System.in);
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
    
    public static void Game() {
        Player player = playerCreation();
        player.Print();
        
        while (true) {
            if (winMap(player) == true) {
                if (player.getLevel() == 6) {
                    break;
                }
                player.setMapSize(player.getLevel() * 5 + 9);
                player.setX(0);
                player.setY(0);
                continue;
            }
            System.out.printf("[Direction] You are currently on (%d,%d)\n", player.getX(), player.getY());
            String choice = ChooseDirection();

            if (choice.equals("save")) {
                saveAndQuit(player);
                break;
            }

            player.Move(choice);
            
            int enemy = FightOrFlight(player.getLevel());
            if (enemy > 0) {
                System.out.printf("Fighting enemy level %d\n", enemy);
            }
        }
        return ;
    }
}
