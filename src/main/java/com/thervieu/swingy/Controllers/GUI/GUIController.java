package com.thervieu.swingy.Controllers.GUI;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Views.GUI.GUIView;
import javax.swing.JOptionPane;

public class GUIController {
    private GUIView guiView;
    private Player player;

    public GUIController(Player player, GUIView guiView) {
        this.player = player;
        this.guiView = guiView;
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
        
        if (rand < 0.6) {
        
            int levelEnemy = level + (int)Math.floor(Math.random() * 3) + 1;

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

    public static Player CreatePlayer(String name, String name2) {
        if (name2.equals("warrior")) {
            return new Player(name, name2, 10, 5, 30);
        } else if (name2.equals("paladin")) {
            return new Player(name, name2, 7, 8, 40);
        }
        return null;
    }

    public static Boolean fight(Player player, int enemylvl) {
        int power = (player.getAttack() + player.getDefense()) / 2;

        double randPower = Math.random();
        double randPlus = Math.random();

        int enemyAttack = (int)(randPower * power) + (int)(randPlus * (enemylvl - player.getLevel()));
        int enemyDefense = (int)((1 - randPower) * power) + (int)((1 - randPlus) * (enemylvl - player.getLevel()));
        System.out.printf("enemy %d %d %d\n", enemyAttack, enemyDefense, player.getHitPoints() * 3 / 4);

        int playerAttack = player.getAttack();
        int playerDefense = player.getDefense();
        int playerHitPoints = player.getHitPoints();
        if (player.getArtifact().equals("WEAPON")) {
            playerAttack += 5;
        }
        if (player.getArtifact().equals("ARMOR")) {
            playerDefense += 8;
        }
        if (player.getArtifact().equals("WEAPON")) {
            playerHitPoints += 15;
        }

        int damagePlayer = 0;
        int damageEnemy = 0;
        while (true) {
            damageEnemy += playerAttack- enemyDefense;
            damagePlayer +=  enemyAttack - playerDefense;
            if (damagePlayer > playerHitPoints) {
                return false;
            }
            if (damageEnemy > (player.getHitPoints() * 3) / 4) {
                return true;
            }
        }
    }
    
    public void Init() {

        this.guiView.getCreatePlayerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getCreatePlayerButton().setVisible(false);
                guiView.getSelectPlayerButton().setVisible(false);

                guiView.getCreatePlayerLabel().setVisible(true);
                guiView.getEnterNameLabel().setVisible(true);
                guiView.getNameField().setVisible(true);
                guiView.getClassLabel().setVisible(true);
                guiView.getWarriorButton().setVisible(true);
                guiView.getPaladinButton().setVisible(true);
                guiView.getValidateCreateButton().setVisible(true);
                // 
                // createHeroGUI();
                // frame.dispose();
            }
        });

        this.guiView.getSelectPlayerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 
                guiView.getCreatePlayerButton().setVisible(false);
                guiView.getSelectPlayerButton().setVisible(false);
                // selectHeroGUI();
                // frame.dispose();
            }
        });


        guiView.getValidateCreateButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = "";
                String playerClass = "";
                if (guiView.getWarriorButton().isSelected()) {
                    playerClass = "warrior";
                } else if (guiView.getPaladinButton().isSelected()) {
                    playerClass = "paladin";
                }

                name = guiView.getNameField().getText();
                name = name.trim();

                if (name.length() ==  0) {
                    JOptionPane.showMessageDialog(null, "Blanks are not allowed.");
                    return ;
                }
                String[] strList = name.split("\\s");

                if (strList != null) {
                    name = String.join("_", strList);
                }
                System.out.println("creating " + name + " " + playerClass);
                player = GUIController.CreatePlayer(name, playerClass);
            }
        });

        // Player player = playerCreation();
        // player.Print();
        
        // while (true) {
        //     if (winMap(player) == true) {
        //         if (player.getLevel() == 6) {
        //             break;
        //         }
        //         System.out.println("HERE");
        //         player.setMapSize(((player.getLevel() - 1) * 5) + 9);
        //         player.setX(0);
        //         player.setY(0);
        //         continue;
        //     }
        //     System.out.printf("[Direction] You are currently on (%d,%d)\n", player.getX(), player.getY());
        //     String choice = ChooseDirection();

        //     if (choice.equals("save")) {
        //         saveAndQuit(player);
        //         break;
        //     }

        //     player.Move(choice);
            
        //     int enemy = FightOrFlight(player.getLevel());
        //     if (enemy > 0) {
        //         if (fight(player, enemy)) {
        //             player.setExp(player.getExp() + (player.getLevel() * (enemy - player.getLevel()) * 300));

        //             double drop = Math.random();
        //             if (drop < 0.45 && player.getArtifact().equals("")) {
        //                 player.setArtifact("WEAPON");
        //             }
        //             if (drop < 0.25 && player.getArtifact().equals("WEAPON")) {
        //                 player.setArtifact("ARMOR");
        //             }
        //             if (drop < 0.1 && player.getArtifact().equals("ARMOR")) {
        //                 player.setArtifact("HELM");
        //             }
        //             if (player.getExp() > (player.getLevel() * 1450) - 450) {
        //                 player.setLevel(player.getLevel() + 1);
        //                 player.setExp(0);
        //                 if (player.getClass1().equals("warrior")) {
        //                     player.setAttack(player.getAttack() + 3);
        //                     player.setDefense(player.getDefense() + 2);
        //                 } else if (player.getClass1().equals("paladin")) {
        //                     player.setAttack(player.getAttack() + 1);
        //                     player.setDefense(player.getDefense() + 3);
        //                 }
        //             }
        //             player.Print();
        //         } else {
        //             System.out.printf("[Death] Hero %s was slain.\n", player.getName());
        //             return ;
        //         }
        //     }
        // }
        // System.out.printf("[Victory] Hero %s has slayed all the enemies.\n", player.getName());
        // System.out.println("Here are the hero's stats:");
        // player.Print();
        return ;
    }
}
