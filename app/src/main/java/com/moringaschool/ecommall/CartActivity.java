package com.moringaschool.ecommall;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity {
    @BindView(R.id.cartTable)
    TableLayout cartTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        // dummy data
        TableRow row = new TableRow(this);
        TableRow row2 = new TableRow(this);
        TableRow.LayoutParams rowparams = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(rowparams);
        row.setGravity(Gravity.CENTER);
        row2.setLayoutParams(rowparams);
        row2.setGravity(Gravity.CENTER);

        if (getCart().size() == 0){
            for (int i=1; i<=4; i++) {
                TextView textView = new TextView(this);
                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                params.setMargins(5,5,5,5);
                textView.setLayoutParams(params);
                textView.setText("one"+i);
                row.addView(textView);
            }
            cartTable.addView(row);
            for (int i=1; i<=4; i++) {
                TextView textView = new TextView(this);
                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                params.setMargins(5,5,5,5);
                textView.setLayoutParams(params);
                textView.setText("two"+i);
                row2.addView(textView);
            }
            cartTable.addView(row2);
        }
    }

    public ArrayList getCart() {
        return new ArrayList();
    }
}