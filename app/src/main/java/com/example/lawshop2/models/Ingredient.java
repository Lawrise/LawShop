package com.example.lawshop2.models;

public class Ingredient {
    private String nom;
    private double price;
    private String categorie;
    private int compteur;

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCompteur() {
        return compteur;
    }

    public void setCompteur(int compteur) {
        this.compteur = compteur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String mnenonic) {
        this.categorie = mnenonic;
    }

    public Ingredient(String nom, String categorie, double price) {
        this.nom = nom;
        this.price = price;
        this.categorie = categorie;
        this.compteur = 1;
    }
}
