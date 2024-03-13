package com.example.gsb_visites;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://friendly-rotary-phone-567xr46xxvx27759-3000.app.github.dev/";
    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)

                    .addConverterFactory(GsonConverterFactory.create())

                    .build();
        }
        return retrofit;
    }
}
