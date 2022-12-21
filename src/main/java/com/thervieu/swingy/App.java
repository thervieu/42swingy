package com.thervieu.swingy;

import com.thervieu.swingy.Controllers.Console.ConsoleController;
import com.thervieu.swingy.Controllers.GUI.GUIController;

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
            GUIController c = new GUIController();
            c.Game();
        }
        return ;
    }
}
