package com.example.gsb_visites;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface GsbVisitesServices {
    @POST("api/auth/login")
    Call<Visiteur> login(@Body Visiteur visiteur);
}
