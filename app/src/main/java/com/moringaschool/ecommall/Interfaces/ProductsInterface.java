package com.moringaschool.ecommall.Interfaces;

import com.moringaschool.ecommall.Models.Products.Product;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ProductsInterface {
    @GET("products")
    Call<Product> getAllProducts();
}
