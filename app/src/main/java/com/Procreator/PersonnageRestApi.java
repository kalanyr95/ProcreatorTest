package com.Procreator;

import com.Procreator.model.RestPersonnageResponse;

import retrofit2.Call;
import retrofit2.http.POST;


public interface PersonnageRestApi {
    @POST("5cd3e006c07f283511e25bd6/")
    Call<RestPersonnageResponse> getPersonnageList();
}
