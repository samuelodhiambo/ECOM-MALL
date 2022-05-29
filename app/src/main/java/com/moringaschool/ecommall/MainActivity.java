package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    @BindView(R.id.productsGrid)
    GridView productsGrid;

    String[] products = new String[]{"product1", "product2", "product3", "product4", "product5"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        ProductAdapter adapter = new ProductAdapter(MainActivity.this, products);
        productsGrid.setAdapter(adapter);

        productsGrid.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, "You clicked " + products[position], Toast.LENGTH_SHORT).show();
    }
}