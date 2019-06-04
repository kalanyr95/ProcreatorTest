package com.example.procreator.view;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import com.example.procreator.Injection;
import com.example.procreator.controller.MainController;
import com.example.procreator.R;
import com.example.procreator.model.Personnage;

public class MainActivity extends Activity {
    //Déclaration des variables.
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_personnages);
        SharedPreferences sharedPreferences = this.getSharedPreferences("user_prefs", Context.MODE_PRIVATE);
        MainController controller = new MainController(
                this,
                Injection.getRestApiInstance(),
                sharedPreferences);
        controller.start();
    }

    public void showList(List<Personnage> personnageList) {
        //Initialisation de la variable recyclerView
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        //Optimisation des performances Merci la documentation.
        recyclerView.setHasFixedSize(true);
        // Layout Manager = Manage l'affichage. Ici en liste Verticale
        //Initialisation de la variable layoutManager
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        // define an adapter

        //Initialisation de la variable mAdapter
        mAdapter = new MyAdapter(personnageList);
        recyclerView.setAdapter(mAdapter);
    }
}