package com.example.lawshop2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;


import androidx.appcompat.app.AppCompatActivity;


import com.example.lawshop2.adapter.RecetteAdapter;
import com.example.lawshop2.models.Recette;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView modif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        List<Recette> recetteList = new ArrayList<>();
        recetteList.add(new Recette("Pate Carbo",  "spaghetti", 6.5));
        recetteList.add(new Recette("Steak riz", "steak", 8));
        recetteList.add(new Recette("Wrap poulet", "burrito", 5.5));
        recetteList.add(new Recette("Hamburger", "hamburger", 10));
        recetteList.add(new Recette("Pate Carbo",  "spaghetti", 6.5));
        recetteList.add(new Recette("Steak riz", "steak", 8));
        recetteList.add(new Recette("Wrap poulet", "burrito", 5.5));
        recetteList.add(new Recette("Hamburger", "hamburger", 10));

        GridView recetteGridView = findViewById(R.id.liste_recette_view);
        recetteGridView.setAdapter(new RecetteAdapter(this, recetteList));

        this.modif = (ImageView) findViewById(R.id.plus);

        modif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent otherActivity = new Intent(getApplicationContext(), CreateRecetteActivity.class);
                startActivity(otherActivity);

            }
        });
    }


}
