package com.omarcomputer.javafragments.Model;

import com.squareup.moshi.Json;

public class Monster {
    @Json(name = "imageFile")
    private String imageFile;

    @Json(name = "monsterName")
    private String monsterName;

    @Json(name = "caption")
    private String caption;

    @Json(name = "description")
    private String description;

    @Json(name = "price")
    private double price;

    @Json(name = "scariness")
    private int scariness;


    public Monster() {
    }

    public Monster(String imageFile, String monsterName, String caption, String description, double price, int scariness) {
        this.imageFile = imageFile;
        this.monsterName = monsterName;
        this.caption = caption;
        this.description = description;
        this.price = price;
        this.scariness = scariness;
    }

    // Getters et Setters

    public String getImageFile() {
        return imageFile;
    }

    public void setImageFile(String imageFile) {
        this.imageFile = imageFile;
    }

    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getScariness() {
        return scariness;
    }

    public void setScariness(int scariness) {
        this.scariness = scariness;
    }

    @Override
    public String toString() {
        return "Monster{" +
                "imageFile='" + imageFile + '\'' +
                ", monsterName='" + monsterName + '\'' +
                ", caption='" + caption + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", scariness=" + scariness +
                '}';
    }

}
