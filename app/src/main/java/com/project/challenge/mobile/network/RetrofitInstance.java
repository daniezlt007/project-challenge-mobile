package com.project.challenge.mobile.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {

    public static String BASE_URl = "https://challenge-mobile-api.liveonsolutions.com/api/v1/";

    private static Retrofit retrofit;

    private static Retrofit getRetrofitClient(){
        if(retrofit == null){
            retrofit = new Retrofit.
                    Builder().
                    baseUrl(BASE_URl).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public static APIClient getUserService(){
        APIClient apiClient = getRetrofitClient().create(APIClient.class);
        return apiClient;
    }

}
