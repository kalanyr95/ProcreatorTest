package com.Procreator.controller;

import android.util.Log;

import java.util.List;

import com.Procreator.PersonnageRestApi;
import com.Procreator.model.Personnage;
import com.Procreator.view.MainActivity;
import com.Procreator.PersonnageRestApi;
import com.Procreator.model.RestPersonnageResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainController {

    private MainActivity view;

    private PersonnageRestApi personnageRestApi;

    public MainController(MainActivity view, PersonnageRestApi personnageRestApi) {
        this.view = view;
        this.personnageRestApi = personnageRestApi;
    }

    public void start() {
        Call<RestPersonnageResponse> call = personnageRestApi.getPersonnageList();
        call.enqueue(new Callback<RestPersonnageResponse>() {
            @Override
            public void onResponse(Call<RestPersonnageResponse> call, Response<RestPersonnageResponse> response) {
                if(response.isSuccessful()) {
                    RestPersonnageResponse restPokemonResponse = response.body();
                    List<Personnage> pokemonList = restPokemonResponse.getResults();
                    view.showList(pokemonList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestPersonnageResponse> call, Throwable t) {
                Log.d("API ERROR", "onFailure");
            }
        });
    }
}
