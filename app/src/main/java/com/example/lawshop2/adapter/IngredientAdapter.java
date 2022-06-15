package com.example.lawshop2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lawshop2.R;
import com.example.lawshop2.models.Ingredient;
import com.example.lawshop2.models.Recette;

import java.util.List;

public class IngredientAdapter extends BaseAdapter {
    private Context context;
    private List<Ingredient> ingredientList;
    private LayoutInflater inflater;
    private int cmpt=1;

    public IngredientAdapter(Context context, List<Ingredient> ingredientList) {
        this.context = context;
        this.ingredientList = ingredientList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return ingredientList.size();
    }
    @Override
    public Ingredient getItem(int position) {
        return ingredientList.get(position);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_ingredient_item_course,  null);
        Ingredient currentIngredient = getItem(i);

        String ingredient_nom = currentIngredient.getNom();
        String mnenonic = currentIngredient.getCategorie();
        String ressource_name = "img_"+mnenonic;
        String nbr = "x "+String.valueOf(currentIngredient.getCompteur());

        ImageView recetteIconView = view.findViewById(R.id.img_categorie);
        int resId = context.getResources().getIdentifier(ressource_name, "drawable", context.getPackageName());
        recetteIconView.setImageResource(resId);

        TextView recetteNameView = view.findViewById(R.id.nom_ingredient);
        recetteNameView.setText(ingredient_nom);

        TextView ingredient_nbr = view.findViewById(R.id.nbr_ingredient);
        ingredient_nbr.setText(nbr);


        return view;
    }
}
