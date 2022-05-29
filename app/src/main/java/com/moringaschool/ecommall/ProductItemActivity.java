package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductItemActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backArrow)
    ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);
        ButterKnife.bind(this);

        backArrow.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == backArrow) {
            this.finish();
        }
    }
}