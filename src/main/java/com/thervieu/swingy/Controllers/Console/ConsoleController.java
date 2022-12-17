package com.thervieu.swingy.controllers.console;

import com.thervieu.swingy.models.Player;

public class ConsoleController {
    public static void playerCreation() {
        Player player;

        String choice = Create.CreateOrDB();
        String name = Create.Name();
        // String class = Create.ClassChoice();
        if (choice.equals("create")) {
            // player = Create.CreatePlayer(name, class);
        } else if (choice.equals("choose")) {
            // load db and choose character
        }
    }

    public static void Game() {
        System.out.println("GAME");
        // Player player = playerCreation();
        // player.Print();
    }
}
