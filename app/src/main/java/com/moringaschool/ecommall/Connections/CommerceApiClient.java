package com.moringaschool.ecommall.Connections;

import com.moringaschool.ecommall.Constants;
import com.moringaschool.ecommall.Interfaces.ProductsInterface;
import com.moringaschool.ecommall.Models.Products.Product;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CommerceApiClient {
    public static Retrofit retrofit = null;

    public static Retrofit getApiInstance(){
        OkHttpClient client = new OkHttpClient().newBuilder()
                .authenticator(new Authenticator() {
                    @Override
                    public Request authenticate(Route route, Response response) throws IOException {
                        return response.request().newBuilder().header("X-Authorization", Constants.API_KEY).build();
                    }
                })
                .build();

        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .client(client)
                    .baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    };
}
