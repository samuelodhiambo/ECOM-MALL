package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener {
    private String searchTerm;
    @BindView(R.id.productsGrid)
    GridView productsGrid;
    @BindView(R.id.searchInput)
    SearchView searchInput;

    String[] products = new String[]{"product1", "product2", "product3", "product4", "product5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ProductAdapter adapter = new ProductAdapter(MainActivity.this, products);
        productsGrid.setAdapter(adapter);

        searchInput.setOnQueryTextListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked " + products[position], Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ProductItemActivity.class);
        intent.putExtra("product", products[position]);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchTerm = searchInput.getQuery().toString();
        if (searchTerm.length() <= 2){
            Toast.makeText(this, "Search query is too short: " + searchTerm, Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(this, "You searched for " + searchTerm, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
//        searchTerm = searchInput.getQuery().toString();
//        if (searchTerm.length() == 0){
//            return false;
//        }
//        Toast.makeText(this, "You searched for " + searchTerm, Toast.LENGTH_SHORT).show();
        return false;
    }
}