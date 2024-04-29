package com.example.gsb_visites;

import retrofit2.Call;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GsbVisitesServices {
    @POST("api/auth/login")
    Call<Visiteur> login(@Body Visiteur visiteur);

    @GET("api/praticien/{praticienId}")
    Call<Praticiens> getPraticiens(@Header("Authorization") String token, @Path("praticienId") String praticienId);

    @GET("api/visiteur/{visiteurId}")
    Call<Visiteur> getVisiteur(@Header("Authorization") String token, @Path("visiteurId") String visiteurId);


}
