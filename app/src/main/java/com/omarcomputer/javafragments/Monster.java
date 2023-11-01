package com.omarcomputer.javafragments;

import java.io.Serializable;

public class Monster implements Serializable {
    private static final long serialVersionUID = 1L;
    public String imageFile;
    public String monsterName;
    public String caption;
    public String description;
    public double price;
    public int scariness;
    Monster(String imageFile, String monsterName, String caption,String description, double price, int scariness){
        this.imageFile = imageFile;
        this.monsterName = monsterName;
        this.caption = caption;
        this.description = description;
        this.price = price;
        this.scariness = scariness;

    }
}
