package com.thervieu.swingy.controllers.console;

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

    public static void saveAndQuit(Player player) {
        return;
    }

    public static void Game() {
        Player player = playerCreation();
        player.Print();
        
        while (true) {
            if (winMap(player) == true) {
                player.setMapSize(player.getLevel() * 5 + 9);
                player.setX(0);
                player.setY(0);
                continue;
            }
            System.out.printf("[Direction] You are currently on (%d,%d)\n", player.getX(), player.getY());
            String choice = Create.ChooseDirection();

            if (choice.equals("save")) {
                saveAndQuit(player);
                break;
            }

            player.Move(choice);
            // if (player.FightOrFlight() == true) {
            //     break;
            // }
        }
        // if player.getLevel()
        return ;
    }
}
