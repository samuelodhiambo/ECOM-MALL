package com.moringaschool.ecommall.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Timer;
import java.util.TimerTask;

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
    private Datum product;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        ButterKnife.bind(this);

        backArrow.setOnClickListener(this);
        addToCartButton.setOnClickListener(this);

        Intent intent = getIntent();
        Serializable item = intent.getSerializableExtra("product");
        product = (Datum) item;
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
            ref.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    int id = (int) snapshot.child("cart").child("product").getChildrenCount();
                    for (int i=0; i<id; i++){
                        if (snapshot.child("cart").child("product").hasChild(i+product.getName())) {
                            Toast.makeText(getBaseContext(), "Product already in cart", Toast.LENGTH_SHORT).show();
                            id = i;
                        }
                    }
                    if (snapshot.child("cart").child("product").hasChild(id+product.getName())){
                        Toast.makeText(getBaseContext(), "Product already in cart", Toast.LENGTH_SHORT).show();
                    } else {
                        ref.child("cart").child("product").child(id+product.getName()).setValue(product);
                        ref.child("cart").child("product").child(id+product.getName()).child("id").setValue(""+(id+1));
                        ref.child("cart").child("product").child(id+product.getName()).child("quantity").setValue(1, new DatabaseReference.CompletionListener() {
                            @Override
                            public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                                Intent intent = new Intent(ProductItemActivity.this, CartActivity.class);
                                startActivity(intent);
                            }
                        });
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}