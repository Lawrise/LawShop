package com.example.lawshop2.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "LawShop.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String strSql = "create table T_ingredient ("
                +"  idIngredient integer primary key autoincrement,"
                +"  name text not null,"
                +"  price real not null,"
                +"  categorie text not null"
                +"  )";
        sqLiteDatabase.execSQL(strSql);
        Log.i("DATABASE", "on create invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) { // i = oldversion i1 = new
        // mettre a jour la structure de la db si besoin
    }

    public void insertIngredient(String name, String categorie, double price) {
        name = name.replace("'", "''"); // pour supprimer les ' ajouter en gardant ce necessaire
        categorie = categorie.replace("'", "''");
        String strSql = "insert into T_ingredient (name, categorie, price) values ('"
                + name + "', '" + categorie + "', "  + price +  ")";
        this.getWritableDatabase().execSQL(strSql);
        Log.i("DATABASE", "insert ingredient");
    }

}
