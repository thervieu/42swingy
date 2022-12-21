package com.thervieu.swingy;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Controllers.Console.ConsoleController;
import com.thervieu.swingy.Controllers.GUI.GUIController;
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
            ConsoleController c = new ConsoleController();
            c.Game();
        } else if (args[0].equals("gui") == true ) {
            Player player = new Player();
            GUIView v = new GUIView();
            GUIController c = new GUIController(player, v);
            c.Init();
        }
        return ;
    }
}
