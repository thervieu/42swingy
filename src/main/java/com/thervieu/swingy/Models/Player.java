package com.thervieu.swingy.Models;

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
    private int mapSize;
    private int x;
    private int y;

    public Player(String n, String c, int l, int e, int a,
        int d, int h, String art, int m, int x, int y) {
        this.name = n;
        this.class1 = c;
        this.level = l;
        this.exp = e;
        this.attack = a;
        this.defense = d;
        this.hitPoints = h;
        this.artifact = art;
        this.mapSize = m;
        this.x = x;
        this.y = y;
    }

    public Player(String name, String class1, int attack, int defense, int hitPoints) {
        this.name = name;
        this.class1 = class1;
        this.level = 1;
        this.exp = 0;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.artifact = "none";
        this.mapSize = (this.level - 1) * 5 + 9;
        this.x = 0;
        this.y = 0;
    }

    public void Print() {
        System.out.printf("[Stats] name: %s\n", this.name);
        System.out.printf("[Stats] class: %s\n", this.class1);
        System.out.printf("[Stats] level: %d\n", this.level);
        System.out.printf("[Stats] exp: %d\n", this.exp);
        System.out.printf("[Stats] attack: %d\n", this.attack);
        System.out.printf("[Stats] defense: %d\n", this.defense);
        System.out.printf("[Stats] hitPoints: %d\n", this.hitPoints);
        System.out.printf("[Stats] artifact: %s\n", this.artifact);
        System.out.printf("[Stats] x: %d\n", this.x);
        System.out.printf("[Stats] y: %d\n", this.y);
    }

    public void Move(String direction) {
        if (direction.equals("north")) {
            this.setY(this.getY() + 1);
        }
        if (direction.equals("south")) {
            this.setY(this.getY() - 1);
        }
        if (direction.equals("west")) {
            this.setX(this.getX() - 1);
        }
        if (direction.equals("east")) {
            this.setX(this.getX() + 1);
        }
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
    public void setExp(int exp) {
        this.exp = exp;
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
    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return this.name;
    }
    public String getClass1() {
        return this.class1;
    }
    public int getLevel() {
        return this.level;
    }
    public int getExp() {
        return this.exp;
    }
    public int getAttack() {
        return this.attack;
    }
    public int getDefense() {
        return this.defense;
    }
    public int getHitPoints() {
        return this.hitPoints;
    }
    public String getArtifact() {
        return this.artifact;
    }
    public int getMapSize() {
        return this.mapSize;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
}
