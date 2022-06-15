package com.moringaschool.ecommall.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backArrow)
    ImageView backArrow;
    @BindView(R.id.cartTable)
    TableLayout cartTable;
    private Datum cartProducts = new Datum();

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/");


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        ref.child("cart").child("product").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String[] keys = new String[] {"id", "name", "quantity", "price"};
                TableRow row = new TableRow(getBaseContext());
                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                    row = new TableRow(getBaseContext());
                    for (String key: keys){
                        TextView textView = new TextView(getBaseContext());
                        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
                        params.setMargins(5, 5, 5, 5);
                        textView.setLayoutParams(params);
                        String val="";
                        try {
                            val = dataSnapshot.child(key).getValue().toString();
                        } catch (Exception e){
                            val = "";
                        }
                        textView.setText(val);
                        if (key == "price"){
                            textView.setText(dataSnapshot.child(key).child("formattedWithSymbol").getValue().toString());
                        }
                        row.addView(textView);
                    }
                    cartTable.addView(row);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        backArrow.setOnClickListener(this);

        // dummy data
//        TableRow row = new TableRow(this);
//        TableRow row2 = new TableRow(this);
//        TableRow.LayoutParams rowparams = new TableRow.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT);
//        row.setLayoutParams(rowparams);
//        row.setGravity(Gravity.CENTER);
//        row2.setLayoutParams(rowparams);
//        row2.setGravity(Gravity.CENTER);
//
//        if (getCart().size() == 0){
//            for (int i=1; i<=4; i++) {
//                TextView textView = new TextView(this);
//                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
//                params.setMargins(5,5,5,5);
//                textView.setLayoutParams(params);
//                textView.setText("one"+i);
//                row.addView(textView);
//            }
//            cartTable.addView(row);
//            for (int i=1; i<=4; i++) {
//                TextView textView = new TextView(this);
//                TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
//                params.setMargins(5,5,5,5);
//                textView.setLayoutParams(params);
//                textView.setText("two"+i);
//                row2.addView(textView);
//            }
//            cartTable.addView(row2);
//        }
    }

    public List<Datum> getCart() {
        List<Datum> cartProducts;
        return new ArrayList();
    }

    @Override
    public void onClick(View v) {
        if (v == backArrow){
            this.finish();
        }
    }
}