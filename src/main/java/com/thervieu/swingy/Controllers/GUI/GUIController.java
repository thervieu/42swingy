package com.thervieu.swingy.Controllers.GUI;

import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Views.GUI.GUIView;

import com.thervieu.swingy.Utils.Reader;
import com.thervieu.swingy.Utils.Writer;

public class GUIController {
    private GUIView guiView;
    private Player player;

    public int levelEnemy = 0;

    public GUIController(Player player, GUIView guiView) {
        this.player = player;
        this.guiView = guiView;
    }

    public Boolean winMap(Player player) {
        int x = player.getX();
        int y = player.getY();
        int goal = player.getMapSize() / 2;

        if (x == goal || Math.abs(x) == goal
            || y == goal || Math.abs(y) == goal)
            return true;
        return false;
    }

    public String ChooseDirection() {
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
        sc.close();
        return choice;
    }


    public static Player CreatePlayer(String name, String name2) {
        if (name2.equals("warrior")) {
            return new Player(name, name2, 10, 5, 40);
        } else if (name2.equals("paladin")) {
            return new Player(name, name2, 7, 8, 40);
        }
        return null;
    }

    public void fight() {
        int power = (player.getAttack() + player.getDefense()) / 4;

        double randPower = Math.random();
        double randPlus = Math.random();

        int enemyAttack = (int)(randPower * power) + (int)(randPlus * (levelEnemy - player.getLevel()));
        int enemyDefense = (int)((1 - randPower) * power) + (int)((1 - randPlus) * (levelEnemy - player.getLevel()));
        int enemyHitPoints = player.getHitPoints() * 3 / 4;

        int playerAttack = player.getAttack();
        int playerDefense = player.getDefense();
        int playerHitPoints = player.getHitPoints();
        if (player.getArtifact().equals("WEAPON")) {
            playerAttack += 5;
        }
        if (player.getArtifact().equals("ARMOR")) {
            playerDefense += 8;
        }
        if (player.getArtifact().equals("HELM")) {
            playerHitPoints += 20;
        }

        int damagePlayer = 0;
        int damageEnemy = 0;
        System.out.printf("%d %d %d\n", playerAttack, playerDefense, playerHitPoints);
        System.out.printf("%d %d %d\n", enemyAttack, playerDefense, enemyHitPoints);
        while (true) {
            damagePlayer +=  enemyAttack - playerDefense;
            damageEnemy += playerAttack- enemyDefense;
            if (damagePlayer > playerHitPoints) {
                guiView.getGameOverLabel().setText("Game over!");
                guiView.getGameOverLabel().setVisible(true);
                return ;
            }
            if (damageEnemy > enemyHitPoints) {
                break ;
            }
        }

        player.setExp(player.getExp() + (player.getLevel() * (levelEnemy - player.getLevel()) * 300));

        double drop = Math.random();
        if (drop < 0.45 && player.getArtifact().equals("none")) {
            player.setArtifact("WEAPON");
        }
        if (drop < 0.25 && player.getArtifact().equals("WEAPON")) {
            player.setArtifact("ARMOR");
        }
        if (drop < 0.1 && player.getArtifact().equals("ARMOR")) {
            player.setArtifact("HELM");
        }
        
        int expForLevel = (player.getLevel() * 1000) + ((int)(Math.pow(player.getLevel() - 1, 2.0) * 450));
        if (player.getExp() > expForLevel) {
            player.setLevel(player.getLevel() + 1);
            if (player.getLevel() == 6) {
                guiView.getWinLabel().setVisible(true);
                return;
            }
            player.setExp(player.getExp() - expForLevel);
            player.setHitPoints(player.getHitPoints() + 5);
            if (player.getClass1().equals("warrior")) {
                player.setAttack(player.getAttack() + 3);
                player.setDefense(player.getDefense() + 2);
            } else if (player.getClass1().equals("paladin")) {
                player.setAttack(player.getAttack() + 2);
                player.setDefense(player.getDefense() + 3);
            }
        }

        guiView.getPositionLabel().setVisible(true);
        guiView.getMoveorSaveLabel().setVisible(true);
        guiView.getNorthButton().setVisible(true);
        guiView.getWestButton().setVisible(true);
        guiView.getEastButton().setVisible(true);
        guiView.getSouthButton().setVisible(true);
        guiView.getStatsButton().setVisible(true);
        guiView.getSaveButton().setVisible(true);
    }

    public void fightOrFlight() {
        levelEnemy = player.getLevel() + (int)Math.floor(Math.random() * 3) + 1;

        guiView.getPositionLabel().setText("(" + Integer.toString(player.getX()) + "," + Integer.toString(player.getY()) + ")");
        if (Math.random() < 0.6) {
            guiView.getPositionLabel().setVisible(false);
            guiView.getMoveorSaveLabel().setVisible(false);
            guiView.getNorthButton().setVisible(false);
            guiView.getWestButton().setVisible(false);
            guiView.getEastButton().setVisible(false);
            guiView.getSouthButton().setVisible(false);
            guiView.getStatsButton().setVisible(false);
            guiView.getSaveButton().setVisible(false);

            guiView.getEncounterLabel().setText("You encounter a zombie of level " + Integer.toString(levelEnemy));
            guiView.getEncounterLabel().setVisible(true);
            guiView.getFightButton().setVisible(true);
            guiView.getFlightButton().setVisible(true);
            
        }
        return ;
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
            }
        });

        this.guiView.getSelectPlayerButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getCreatePlayerButton().setVisible(false);
                guiView.getSelectPlayerButton().setVisible(false);

                
                player = Reader.CreateFromArray(Reader.getLine().split(" "));

                guiView.getPositionLabel().setText("(" + Integer.toString(player.getX()) + "," + Integer.toString(player.getY()) + ")");
                guiView.getPositionLabel().setVisible(true);
                guiView.getMoveorSaveLabel().setVisible(true);
                guiView.getNorthButton().setVisible(true);
                guiView.getWestButton().setVisible(true);
                guiView.getEastButton().setVisible(true);
                guiView.getSouthButton().setVisible(true);
                guiView.getStatsButton().setVisible(true);
                guiView.getSaveButton().setVisible(true);
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

                guiView.getCreatePlayerLabel().setVisible(false);
                guiView.getEnterNameLabel().setVisible(false);
                guiView.getNameField().setVisible(false);
                guiView.getClassLabel().setVisible(false);
                guiView.getWarriorButton().setVisible(false);
                guiView.getPaladinButton().setVisible(false);
                guiView.getValidateCreateButton().setVisible(false);

                guiView.getPositionLabel().setText("(" + Integer.toString(player.getX()) + "," + Integer.toString(player.getY()) + ")");
                guiView.getPositionLabel().setVisible(true);
                guiView.getMoveorSaveLabel().setVisible(true);
                guiView.getNorthButton().setVisible(true);
                guiView.getWestButton().setVisible(true);
                guiView.getEastButton().setVisible(true);
                guiView.getSouthButton().setVisible(true);
                guiView.getStatsButton().setVisible(true);
                guiView.getSaveButton().setVisible(true);
            }
        });

        guiView.getNorthButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setY(player.getY() + 1);
                fightOrFlight();
            }
        });
        guiView.getSouthButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setY(player.getY() - 1);
                fightOrFlight();
            }
        });
        guiView.getWestButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setX(player.getX() - 1);
                fightOrFlight();
            }
        });
        guiView.getEastButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                player.setX(player.getX() + 1);
                fightOrFlight();
            }
        });
        guiView.getSaveButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {guiView.getPositionLabel().setVisible(true);
                guiView.getPositionLabel().setVisible(false);
                guiView.getMoveorSaveLabel().setVisible(false);
                guiView.getNorthButton().setVisible(false);
                guiView.getWestButton().setVisible(false);
                guiView.getEastButton().setVisible(false);
                guiView.getSouthButton().setVisible(false);
                guiView.getStatsButton().setVisible(false);
                guiView.getSaveButton().setVisible(false);

                Writer.write(String.format("%s %s %d %d %d %d %d %s %d %d %d",
                player.getName(), player.getClass1(), player.getLevel(),
                player.getExp(), player.getAttack(), player.getDefense(),
                player.getHitPoints(), player.getArtifact(), player.getMapSize(),
                player.getX(), player.getY()));
                guiView.getGameOverLabel().setText("Player saved!");
                guiView.getGameOverLabel().setVisible(true);
            }
        });


        guiView.getStatsButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getPositionLabel().setVisible(false);
                guiView.getMoveorSaveLabel().setVisible(false);
                guiView.getNorthButton().setVisible(false);
                guiView.getWestButton().setVisible(false);
                guiView.getEastButton().setVisible(false);
                guiView.getSouthButton().setVisible(false);
                guiView.getStatsButton().setVisible(false);
                guiView.getSaveButton().setVisible(false);

                guiView.getStatsLabel().setText("<html>name: " + player.getName()
                    + "<br>class: " + player.getClass1()
                    + "<br>level: " + player.getLevel()
                    + "<br>exp: " + player.getExp()
                    + "<br>attack: " + player.getAttack()
                    + "<br>defense: " + player.getDefense()
                    + "<br>hit points: " + player.getHitPoints()
                    + "<br>artifact: " + player.getArtifact()
                    + "<br>coords: (" + player.getX() + "," + player.getY() + ")"
                    + "</html>");
                guiView.getStatsLabel().setVisible(true);
                guiView.getBackToMapButton().setVisible(true);
            }
        });
        guiView.getBackToMapButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getStatsLabel().setVisible(false);
                guiView.getBackToMapButton().setVisible(false);

                guiView.getPositionLabel().setVisible(true);
                guiView.getMoveorSaveLabel().setVisible(true);
                guiView.getNorthButton().setVisible(true);
                guiView.getWestButton().setVisible(true);
                guiView.getEastButton().setVisible(true);
                guiView.getSouthButton().setVisible(true);
                guiView.getStatsButton().setVisible(true);
                guiView.getSaveButton().setVisible(true);

            }
        });


        guiView.getFightButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getEncounterLabel().setVisible(false);
                guiView.getFightButton().setVisible(false);
                guiView.getFlightButton().setVisible(false);
                fight();
            }
        });

        guiView.getFlightButton().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiView.getEncounterLabel().setVisible(false);
                guiView.getFightButton().setVisible(false);
                guiView.getFlightButton().setVisible(false);
                if (Math.random() < 0.5) {
                    fight();
                    return;
                }

                guiView.getPositionLabel().setVisible(true);
                guiView.getMoveorSaveLabel().setVisible(true);
                guiView.getNorthButton().setVisible(true);
                guiView.getWestButton().setVisible(true);
                guiView.getEastButton().setVisible(true);
                guiView.getSouthButton().setVisible(true);
                guiView.getStatsButton().setVisible(true);
                guiView.getSaveButton().setVisible(true);

            }
        });

        return ;
    }
}
