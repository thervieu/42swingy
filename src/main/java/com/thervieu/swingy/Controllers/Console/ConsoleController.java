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

    public static void Game() {
        Player player = playerCreation();
        player.Print();
        return ;
    }
}
