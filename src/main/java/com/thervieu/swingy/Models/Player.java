package com.thervieu.swingy.models;

public class Player {

    public Player() {}

    private String name;
    private String class1;
    private int level;
    private int exp;
    private int attack;
    private int defense;
    private int hitPoints;
    private String artifact;
    private int x;
    private int y;

    public Player(String name, String class1, int attack, int defense, int hitPoints) {
        this.name = name;
        this.class1 = class1;
        this.level = 0;
        this.exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.artifact = "";
        this.x = 0;
        this.y = 0;
    }

    public void Print() {
        System.out.printf("name: %s\n", this.name);
        System.out.printf("class: %s\n", this.class1);
        System.out.printf("level: %d\n", this.level);
        System.out.printf("exp: %d\n", this.exp);
        System.out.printf("attack: %d\n", this.attack);
        System.out.printf("defense: %d\n", this.defense);
        System.out.printf("hitPoints: %d\n", this.hitPoints);
        System.out.printf("artifact: %s\n", this.artifact);
        System.out.printf("x: %d\n", this.x);
        System.out.printf("y: %d\n", this.y);
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
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
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
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
