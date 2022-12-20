package com.thervieu.swingy.controllers.console;

import com.thervieu.swingy.models.Player;

public class ConsoleController {
    public static String playerCreation() {
        Player player;

        String choice = Create.CreateOrDB();
        if (choice.equals("create")) {
            String name = Create.Name();
            player = Create.CreatePlayer(name, Create.Class());
        } else if (choice.equals("choose")) {
            // load db and choose character
        }
        return "player";
    }

    public static void Game() {
        String player = playerCreation();
        // player.Print();
        return ;
    }
}
