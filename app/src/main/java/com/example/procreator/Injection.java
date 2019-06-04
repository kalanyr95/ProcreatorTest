package com.example.procreator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Injection {
    static final String BASE_URL = "https://kalanyr95.github.io/";

    public static PersonnageRestApi getRestApiInstance(){
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        //FIN creation instance de l'interface
        return retrofit.create(PersonnageRestApi.class);
    }
}