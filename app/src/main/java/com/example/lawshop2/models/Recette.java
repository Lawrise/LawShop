package com.example.lawshop2.models;

public class Recette {
    private String name;
    private String mnemonic;
    private double price;

    public Recette(String name, String mnemonic, double price){
        this.name = name;
        this.mnemonic = mnemonic;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getMnenonic() {
        return mnemonic;
    }
}
