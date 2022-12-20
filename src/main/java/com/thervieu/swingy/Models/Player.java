package com.thervieu.swingy.models;

public class Player {

    public Player() {

    }

    private String name;
    private String class1;
    private int level;
    private int exp;
    private int attack;
    private int defense;
    private int hitPoints;
    private String artifact;

    public Player(String name, String class1, int attack, int defense, int hitPoints) {
        this.name = name;
        this.class1 = class1;
        this.level = 0;
        this.exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.artifact = "";
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setClass1(String class1) {
        this.class1 = class1;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    public void setArtifact(String artifact) {
        this.artifact = artifact;
    }

    public String getName() {
        return this.artifact;
    }
    public String getClass1() {
        return this.class1;
    }
    public int getLevel() {
        return this.level;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public int getHitPOints() {
        return this.hitPoints;
    }
    public String getArtifact() {
        return this.artifact;
    }
}
