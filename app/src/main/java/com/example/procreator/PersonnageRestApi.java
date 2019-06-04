package com.example.procreator;

import com.example.procreator.model.RestPersonnageResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PersonnageRestApi {
    @GET("data.json")
    Call<RestPersonnageResponse> getPersonnageList();
}
