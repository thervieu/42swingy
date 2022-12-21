package com.thervieu.swingy.Views.GUI;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Controllers.GUI.GUIController;

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
import java.io.FileReader;

import com.thervieu.swingy.Utils.Reader;

public class GUIView {
    private String[] playersStrings = Reader.getLines();
    private JList listOfPlayers = new JList<>(playersStrings);

    private JFrame frame = new JFrame("Swingy");
    private JFrame createPlayerFrame = new JFrame("Create player");

    private JButton createPlayerButton = new JButton("Create player");
    private JButton selectPlayerButton = new JButton("Select player");

    private JLabel createPlayerLabel = new JLabel("Create player");
    private JLabel enterNameLabel = new JLabel("Name your player");
    private JTextField nameField = new JTextField();
    private JLabel classLabel = new JLabel("Choose your class");
    private JRadioButton warriorButton = new JRadioButton("Warrior");
    private JRadioButton paladinButton = new JRadioButton("Paladin");
    private JButton validateCreateButton = new JButton("Validate");


    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JFrame getFrame() {
        return this.frame;
    }

    public void setCreatePlayerButton(JButton createPlayerButton) {
        this.createPlayerButton = createPlayerButton;
    }
    public JButton getCreatePlayerButton() {
        return this.createPlayerButton;
    }
    public void setSelectPlayerButton(JButton selectPlayerButton) {
        this.selectPlayerButton = selectPlayerButton;
    }
    public JButton getSelectPlayerButton() {
        return this.selectPlayerButton;
    }

    public void setCreatePlayerLabel(JLabel createPlayerLabel) {
        this.createPlayerLabel = createPlayerLabel;
    }
    public JLabel getCreatePlayerLabel() {
        return this.createPlayerLabel;
    }
    public void setEnterNameLabel(JLabel enterNameLabel) {
        this.enterNameLabel = enterNameLabel;
    }
    public JLabel getEnterNameLabel() {
        return this.enterNameLabel;
    }

    public void setNameField(JTextField nameField) {
        this.nameField = nameField;
    }
    public JTextField getNameField() {
        return this.nameField;
    }


    public void setClassLabel(JLabel classLabel) {
        this.classLabel = classLabel;
    }
    public JLabel getClassLabel() {
        return this.classLabel;
    }

    public void setWarriorButton(JRadioButton warriorButton) {
        this.warriorButton = warriorButton;
    }
    public JRadioButton getWarriorButton() {
        return this.warriorButton;
    }
    public void setPaladinButton(JRadioButton paladinButton) {
        this.paladinButton = paladinButton;
    }
    public JRadioButton getPaladinButton() {
        return this.paladinButton;
    }

    public void setValidateCreateButton(JButton validateCreateButton) {
        this.validateCreateButton = validateCreateButton;
    }
    public JButton getValidateCreateButton() {
        return this.validateCreateButton;
    }

    private JLabel selectPlayerLabel = new JLabel("Select player");
    private JButton validateSelectButton = new JButton("Validate");


    public GUIView() {
        createPlayerButton.setBounds(225, 100, 150, 25);
        createPlayerButton.setOpaque(true);

        selectPlayerButton.setBounds(225, 200, 150, 25);
        selectPlayerButton.setOpaque(true);

        frame.add(createPlayerButton);
        frame.add(selectPlayerButton);


        createPlayerLabel.setBounds(250, 50, 100, 25);
        createPlayerLabel.setOpaque(true);

        enterNameLabel.setBounds(100, 150, 150, 25);
        enterNameLabel.setOpaque(true);

        nameField.setBounds(300, 150, 150, 25);
        nameField.setOpaque(true);
        nameField.setText("Enter name here");


        
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


        validateCreateButton.setBounds(200, 400, 130, 25);
        validateCreateButton.setOpaque(true);

        createPlayerLabel.setVisible(false);
        enterNameLabel.setVisible(false);
        nameField.setVisible(false);
        classLabel.setVisible(false);
        warriorButton.setVisible(false);
        paladinButton.setVisible(false);
        validateCreateButton.setVisible(false);
        frame.add(createPlayerLabel);
        frame.add(enterNameLabel);
        frame.add(nameField);
        frame.add(classLabel);
        frame.add(warriorButton);
        frame.add(paladinButton);
        frame.add(validateCreateButton);
        
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

        validateCreateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String hero = "";
                String playerClass = "";
                if (warriorButton.isSelected()) {
                    playerClass = "warrior";
                } else if (paladinButton.isSelected()) {
                    playerClass = "paladin";
                }

                hero = nameField.getText();
                hero = hero.trim();

                if (hero.length() ==  0) {
                    JOptionPane.showMessageDialog(null, "Blanks are not allowed.");
                    return ;
                }
                String[] strList = hero.split("\\s");

                if (strList != null) {
                    hero = String.join("_", strList);
                }
                // player = GUIController.CreatePlayer(hero, playerClass);
            }
        });

        selectPlayerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
    }
}
