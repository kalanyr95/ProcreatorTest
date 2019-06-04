package com.example.procreator.controller;

import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import com.example.procreator.PersonnageRestApi;
import com.example.procreator.model.Personnage;
import com.example.procreator.model.RestPersonnageResponse;
import com.example.procreator.view.MainActivity;
import com.google.gson.reflect.TypeToken;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class MainController {

    private MainActivity view;

    private PersonnageRestApi personnageRestApi;

    private SharedPreferences sharedPreferences;

    public MainController(MainActivity view, PersonnageRestApi personnageRestApi, SharedPreferences sharedPreferences) {
        this.view = view;
        this.personnageRestApi = personnageRestApi;
        this.sharedPreferences = sharedPreferences;
    }

    public void start() {
        Call<RestPersonnageResponse> call = personnageRestApi.getPersonnageList();
        call.enqueue(new Callback<RestPersonnageResponse>() {
            @Override
            public void onResponse(Call<RestPersonnageResponse> call, Response<RestPersonnageResponse> response) {
                if (response.isSuccessful()) {
                    RestPersonnageResponse restPersonnageResponse = response.body();
                    List<Personnage> personnageList = restPersonnageResponse.getResults();
                    storeData(personnageList);
                    view.showList(personnageList);
                } else {
                    System.out.println(response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<RestPersonnageResponse> call, Throwable t) {
                Log.d("API ERROR", "onFailure");
                List<Personnage> personnageList = getDataFromCache();
                view.showList(personnageList);
            }
        });
    }

    private void storeData(List<Personnage> personnageList) {
        Gson gson = new Gson();
        String listPersonnageString = gson.toJson(personnageList);
        sharedPreferences
                .edit()
                .putString("cle_string", listPersonnageString)
                .apply();
    }

    private List<Personnage> getDataFromCache() {
        String listPersonnageString = sharedPreferences.getString("cle_string", "");
        if (listPersonnageString != null && !TextUtils.isEmpty(listPersonnageString)) {
            Type listType = new TypeToken<List<Personnage>>() {
            }.getType();
            List<Personnage> personnageList = new Gson().fromJson(listPersonnageString, listType);
            return personnageList;
        }
        return new ArrayList<>();
    }
}
