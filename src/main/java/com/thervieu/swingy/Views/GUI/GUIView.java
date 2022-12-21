package com.thervieu.swingy.Views.GUI;

import com.thervieu.swingy.Models.Player;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thervieu.swingy.Utils.Reader;

public class GUIView {
    private String[] playersStrings = Reader.getLines();
    private final JList listOfPlayers = new JList<>(playersStrings);

    private final JFrame swingyFrame = new JFrame("Swingy");
    private final JFrame createPlayerFrame = new JFrame("Create player");
    private final JFrame selectPlayerFrame = new JFrame("Select player");
    private final JFrame playerStatsFrame = new JFrame("Stats player");
    private final JFrame playerCreationFrame = new JFrame("Player creation");
    private final JFrame gameFrame = new JFrame("Game");
    private final JFrame gameOverFrame = new JFrame("Game Over");

    private JLabel createPlayerLabel = new JLabel("Create player");
    private JLabel enterNameLabel = new JLabel("Name your player");
    private JTextField playerNameField = new JTextField();
    private JTextArea playerNameArea = new JTextArea();

    private JLabel selectPlayerLabel = new JLabel("Select player");
    private final JRadioButton warriorButton = new JRadioButton("Warrior");
    private final JRadioButton paladinButton = new JRadioButton("Paladin");

    private JButton createPlayerButton = new JButton("Create player");
    private JButton selectPlayerButton = new JButton("Select player");
    private JButton validatePlayerButton = new JButton("Validate");

    private String playerClass;
    private String hero;
    private Player player;

    public void startGUI() {
        createPlayerButton.setBounds(225, 100, 150, 25);
        createPlayerButton.setOpaque(true);

        selectPlayerButton.setBounds(225, 200, 150, 25);
        selectPlayerButton.setOpaque(true);

        swingyFrame.add(createPlayerButton);
        swingyFrame.add(selectPlayerButton);
        swingyFrame.setSize(600, 600);
        swingyFrame.setLayout(null);
        swingyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        swingyFrame.setVisible(true);
        swingyFrame.setResizable(false);


        createPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createHeroGUI();
                swingyFrame.dispose();
            }
        });

        selectPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // selectHeroGUI();
                swingyFrame.dispose();
            }
        });
    }

    public void createHeroGUI() {
        createPlayerLabel.setBounds(250, 50, 100, 25);
        createPlayerLabel.setOpaque(true);

        enterNameLabel.setBounds(100, 150, 150, 25);
        enterNameLabel.setOpaque(true);

        playerNameField.setBounds(300, 150, 150, 25);
        playerNameField.setOpaque(true);
        playerNameField.setText("Enter name here");


        JLabel classLabel = new JLabel("Choose your class");
        classLabel.setBounds(230, 240, 300, 25);
        classLabel.setOpaque(true);

        ButtonGroup buttonGroup = new ButtonGroup();

        warriorButton.setBounds(200, 270, 100, 30);
        warriorButton.setOpaque(true);
        warriorButton.setSelected(true);

        paladinButton.setBounds(300, 270, 100, 30);
        paladinButton.setOpaque(true);


        buttonGroup.add(warriorButton);
        buttonGroup.add(paladinButton);


        validatePlayerButton.setBounds(200, 400, 130, 25);
        validatePlayerButton.setOpaque(true);

        createPlayerFrame.add(createPlayerLabel);
        createPlayerFrame.add(enterNameLabel);
        createPlayerFrame.add(playerNameField);
        createPlayerFrame.add(classLabel);
        createPlayerFrame.add(warriorButton);
        createPlayerFrame.add(paladinButton);
        createPlayerFrame.add(validatePlayerButton);
        
        createPlayerFrame.setSize(600, 600);
        createPlayerFrame.setLayout(null);
        createPlayerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createPlayerFrame.setVisible(true);
        createPlayerFrame.setResizable(false);


        validatePlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (warriorButton.isSelected()) {
                    playerClass = "warrior";
                } else if (paladinButton.isSelected()) {
                    playerClass = "paladin";
                }

                hero = playerNameField.getText();
                hero = hero.trim();

                if (hero.length() ==  0) {
                    JOptionPane.showMessageDialog(null, "Blanks are not allowed.");
                    return ;
                }
                String[] strList = hero.split("\\s");

                if (strList != null) {
                    hero = String.join("_", strList);
                }

                System.out.printf("Create %s %s\n", hero, playerClass);
                createPlayerFrame.setVisible(false);
                createPlayerFrame.dispose();
            }
        });

        selectPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // selectHeroGUI();
                createPlayerFrame.dispose();
            }
        });
    }
}
