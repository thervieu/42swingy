package com.thervieu.swingy.models;

public class Player {

    public Player() {

    }

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
