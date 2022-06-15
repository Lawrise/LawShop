package com.example.lawshop2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lawshop2.R;
import com.example.lawshop2.models.Recette;

import java.util.List;

public class RecetteAdapter extends BaseAdapter {

    private Context context;
    private List<Recette> recetteList;
    private LayoutInflater inflater;

    public RecetteAdapter(Context context, List<Recette> recetteList) {
        this.context = context;
        this.recetteList = recetteList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return recetteList.size();
    }
    @Override
    public Recette getItem(int position) {
        return recetteList.get(position);
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.adapter_recette_itel,  null);
        Recette currentRecette = getItem(i);
        String recette_name = currentRecette.getName();
        String mnenonic = currentRecette.getMnenonic();
        String ressource_name = "img_"+mnenonic;

        ImageView recetteIconView = view.findViewById(R.id.recette_img);
        int resId = context.getResources().getIdentifier(ressource_name, "drawable", context.getPackageName());
        recetteIconView.setImageResource(resId);

        TextView recetteNameView = view.findViewById(R.id.nom_recette);
        recetteNameView.setText(recette_name);

        return view;
    }
}
