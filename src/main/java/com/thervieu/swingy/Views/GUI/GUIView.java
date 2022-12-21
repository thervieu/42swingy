package com.thervieu.swingy.Views.GUI;

import com.thervieu.swingy.Models.Player;
import com.thervieu.swingy.Controllers.GUI.GUIController;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayer;
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


    private JLabel moveOrSaveLabel = new JLabel("Move player or save progress");
    private JLabel positionLabel = new JLabel("Position");
    private JButton northButton = new JButton("North");
    private JButton westButton = new JButton("West");
    private JButton eastButton = new JButton("East");
    private JButton southButton = new JButton("South");
    private JButton saveButton = new JButton("Save and quit");

    private JLabel encounterLabel = new JLabel("Encounter");
    private JButton fightButton = new JButton("Fight");
    private JButton flightButton = new JButton("Flight");


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

    // map or save methods
    public void setMoveorSaveLabel(JLabel moveOrSaveLabel) {
        this.moveOrSaveLabel = moveOrSaveLabel;
    }
    public JLabel getMoveorSaveLabel() {
        return this.moveOrSaveLabel;
    }
    public void setPositionLabel(JLabel positionLabel) {
        this.positionLabel = positionLabel;
    }
    public JLabel getPositionLabel() {
        return this.positionLabel;
    }

    public void setNorthButton(JButton northButton) {
        this.northButton = northButton;
    }
    public JButton getNorthButton() {
        return this.northButton;
    }
    public void setWestButton(JButton westButton) {
        this.westButton = westButton;
    }
    public JButton getWestButton() {
        return this.westButton;
    }
    public void setEastButton(JButton eastButton) {
        this.eastButton = eastButton;
    }
    public JButton getEastButton() {
        return this.eastButton;
    }
    public void setSouthButton(JButton southButton) {
        this.southButton = southButton;
    }
    public JButton getSouthButton() {
        return this.southButton;
    }
    public void setSaveButton(JButton saveButton) {
        this.saveButton = saveButton;
    }
    public JButton getSaveButton() {
        return this.saveButton;
    }


    // fight or flight methods
    public JLabel getEncounterLabel() {
        return this.encounterLabel;
    }
    public JButton getFightButton() {
        return this.fightButton;
    }
    public JButton getFlightButton() {
        return this.flightButton;
    }



    private JLabel selectPlayerLabel = new JLabel("Select player");
    private JButton validateSelectButton = new JButton("Validate");


    public GUIView() {
        // first fiew
        createPlayerButton.setBounds(225, 100, 150, 25);
        createPlayerButton.setOpaque(true);

        selectPlayerButton.setBounds(225, 200, 150, 25);
        selectPlayerButton.setOpaque(true);

        frame.add(createPlayerButton);
        frame.add(selectPlayerButton);

        // create view
        createPlayerLabel.setBounds(250, 50, 100, 25);
        createPlayerLabel.setOpaque(true);

        enterNameLabel.setBounds(235, 150, 150, 25);
        enterNameLabel.setOpaque(true);

        nameField.setBounds(235, 180, 120, 25);
        nameField.setOpaque(true);
        nameField.setText("blabla");

        classLabel.setBounds(235, 240, 300, 25);
        classLabel.setOpaque(true);

        ButtonGroup buttonGroup = new ButtonGroup();

        warriorButton.setBounds(210, 270, 90, 30);
        warriorButton.setOpaque(true);
        warriorButton.setSelected(true);

        paladinButton.setBounds(310, 270, 100, 30);
        paladinButton.setOpaque(true);


        buttonGroup.add(warriorButton);
        buttonGroup.add(paladinButton);

        validateCreateButton.setBounds(230, 400, 130, 25);
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
        
        // select player
    
        // choose map
        moveOrSaveLabel.setBounds(190, 100, 240, 30);
        moveOrSaveLabel.setOpaque(true);
        northButton.setBounds(250, 200, 100, 30);
        northButton.setOpaque(true);
        westButton.setBounds(110, 300, 100, 30);
        westButton.setOpaque(true);
        positionLabel.setBounds(283, 300, 100, 30);
        positionLabel.setOpaque(true);
        eastButton.setBounds(390, 300, 100, 30);
        eastButton.setOpaque(true);
        southButton.setBounds(250, 400, 100, 30);
        southButton.setOpaque(true);
        saveButton.setBounds(420, 500, 140, 30);
        saveButton.setOpaque(true);

        moveOrSaveLabel.setVisible(false);
        positionLabel.setVisible(false);
        northButton.setVisible(false);
        westButton.setVisible(false);
        eastButton.setVisible(false);
        southButton.setVisible(false);
        saveButton.setVisible(false);

        frame.add(moveOrSaveLabel);
        frame.add(positionLabel);
        frame.add(northButton);
        frame.add(westButton);
        frame.add(eastButton);
        frame.add(southButton);
        frame.add(saveButton);

        // fight or flight
        encounterLabel.setBounds(180, 150, 250, 30);
        encounterLabel.setOpaque(true);
        fightButton.setBounds(150, 300, 100, 30);
        fightButton.setOpaque(true);
        flightButton.setBounds(350, 300, 100, 30);
        flightButton.setOpaque(true);

        encounterLabel.setVisible(false);
        fightButton.setVisible(false);
        flightButton.setVisible(false);

        frame.add(encounterLabel);
        frame.add(fightButton);
        frame.add(flightButton);

        // player stats

        // game over

        // game won

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }
}
