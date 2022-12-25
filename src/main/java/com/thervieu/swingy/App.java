package com.thervieu.swingy;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Controllers.Console.ConsoleController;
import com.thervieu.swingy.Controllers.GUI.GUIController;
import com.thervieu.swingy.Views.Console.ConsoleView;
import com.thervieu.swingy.Views.GUI.GUIView;

public class App 
{
    public static void main( String[] args )
    {
        // usage
        if (args.length != 1) {
            System.out.println( "usage: [console/gui]" );
            return ;
        }
        if (args[0].equals("console") == false && args[0].equals("gui") == false) {
            System.out.println( "usage: [console/gui]" );
            return ;
        }

        // launch game
        if (args[0].equals("console") == true) {
            Player player = new Player();
            ConsoleView view = new ConsoleView();
            ConsoleController c = new ConsoleController(player, view);
            c.Game();
        } else if (args[0].equals("gui") == true ) {
            Player player = new Player();
            GUIView view = new GUIView();
            GUIController c = new GUIController(player, view);
            c.Init();
        }
        return ;
    }
}
