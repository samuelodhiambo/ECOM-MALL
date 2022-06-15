package com.moringaschool.ecommall.Interfaces;

import com.moringaschool.ecommall.Models.Categories.Category;
import com.moringaschool.ecommall.Models.Products.Product;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ProductsInterface {
    @GET("products")
    Call<Product> getAllProducts();

    @GET("products")
    Call<Product> searchProducts(@Query("query") String query);

    @GET("products")
    Call<Product> getProductsByCategory(@Query("category_id") String category_id);

    @GET("categories")
    Call<Category> getAllCategories();
}
