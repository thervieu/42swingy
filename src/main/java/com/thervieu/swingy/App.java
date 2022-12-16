package com.thervieu.swingy;


public class App 
{
    public static void main( String[] args )
    {
        // usage
        if (args.length != 1) {
            System.out.println( "usage: [console/gui]" );
            return ;
        }
        if (args[0] != "console" && args[0] == "gui") {
            System.out.println( "usage: [console/gui]" );
            return ;
        }

        // launch game
        if (args[0] == "console") {
            // do console
        } else if (args[0] == "gui") {
            // do gui
        }
        return ;
    }
}
