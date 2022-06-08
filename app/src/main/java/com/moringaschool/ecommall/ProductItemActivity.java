package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.moringaschool.ecommall.Models.Products.Datum;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;

import java.io.Serializable;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductItemActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backArrow)
    ImageView backArrow;
    @BindView(R.id.itemName)
    TextView itemName;
    @BindView(R.id.addToCartButton)
    Button addToCartButton;
    @BindView(R.id.productItemImage)
    ImageView productItemImage;
    @BindView(R.id.productItemPrice)
    TextView productItemPrice;
    @BindView(R.id.productItemDescription)
    TextView productItemDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        ButterKnife.bind(this);

        backArrow.setOnClickListener(this);
        addToCartButton.setOnClickListener(this);

        Intent intent = getIntent();
        Serializable item = intent.getSerializableExtra("product");
        Datum product = (Datum) item;
        itemName.setText(product.getName());
        Picasso.get().load(product.getImage().getUrl()).into(productItemImage);
        productItemPrice.setText(product.getPrice().getFormattedWithSymbol());
        productItemDescription.setText(Jsoup.parse(product.getDescription()).text());
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