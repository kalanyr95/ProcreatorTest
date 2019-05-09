package com.Procreator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Injection {

    static final String BASE_URL = "https://api.jsonbin.io/b/";

    //TODO Faire un singleton.
    public static PersonnageRestApi getRestApiInstance(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(PersonnageRestApi.class);
    }
}
