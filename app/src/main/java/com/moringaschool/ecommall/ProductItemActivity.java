package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductItemActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backArrow)
    ImageView backArrow;
    @BindView(R.id.itemName)
    TextView itemName;
    @BindView(R.id.addToCartButton)
    Button addToCartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        ButterKnife.bind(this);

        backArrow.setOnClickListener(this);
        addToCartButton.setOnClickListener(this);

        Intent intent = getIntent();
        String item = intent.getStringExtra("product");
        itemName.setText(item);
    }

    @Override
    public void onClick(View v) {
        if (v == backArrow) {
            this.finish();
        }
        if (v == addToCartButton) {
            Intent intent = new Intent(ProductItemActivity.this, CartActivity.class);
            startActivity(intent);
        }
    }
}