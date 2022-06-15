package com.example.lawshop2;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lawshop2.Database.DatabaseManager;
import com.example.lawshop2.adapter.IngredientAdapter;
import com.example.lawshop2.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

public class CreateRecetteActivity extends AppCompatActivity {
    private TextView ajout_ing;
    private int cmpt = 0;
    private TextView nbr;
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recette);

        List<Ingredient> ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient("javel", "produit", 3.5));

        List<Ingredient> fakelist = new ArrayList<>();
        fakelist.add(new Ingredient("banane", "fruit", 1.5));
        fakelist.add(new Ingredient("Dinde", "viande", 5));
        fakelist.add(new Ingredient("carotte", "legume", 2));
        fakelist.add(new Ingredient("riz", "ble", 0.8));
        fakelist.add(new Ingredient("javel", "produit", 3.5));

        ListView ingredientListView = findViewById(R.id.list_ingredient_view);
        ingredientListView.setAdapter(new IngredientAdapter(this, ingredientList));

        databaseManager = new DatabaseManager(this);
        databaseManager.insertIngredient("Courgette", "legume", 2);
        databaseManager.close();

        this.ajout_ing = (TextView) findViewById(R.id.ajout_ingredient);
        this.nbr = (TextView) findViewById(R.id.nbr_ingredient);

        ajout_ing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int nombreAleatoire = (int) (Math.random()* fakelist.size() - 1) ;
                Ingredient newIngredient = fakelist.get(nombreAleatoire);
                if (!ingredientList.contains(newIngredient)){
                    ingredientList.add(newIngredient);
                }else {
                    ingredientList.get(ingredientList.indexOf(newIngredient)).setCompteur(ingredientList.get(ingredientList.indexOf(newIngredient)).getCompteur() + 1);

                }


                Toast.makeText(CreateRecetteActivity.this, "Ajoute de l'ingrédient"+newIngredient.getNom(), Toast.LENGTH_SHORT).show();
                ListView ingredientListView = findViewById(R.id.list_ingredient_view);
                ingredientListView.setAdapter(new IngredientAdapter(view.getContext(), ingredientList));
            }
        });

    }
}
