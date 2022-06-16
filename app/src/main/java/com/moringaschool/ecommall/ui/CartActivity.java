package com.moringaschool.ecommall.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.ecommall.Adapters.FirebaseCartViewHolder;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.Models.Products.Datum_2;
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
    @BindView(R.id.cartRecycler)
    RecyclerView cartRecycler;
    private Datum cartProducts = new Datum();

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/cart/product/");
    private FirebaseRecyclerAdapter<Datum, FirebaseCartViewHolder> firebaseAdapter;
    private DatabaseReference ref2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

//        ref.child("cart").child("product").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                ref2 = snapshot.getRef().getRef();
//                String[] keys = new String[] {"id", "name", "quantity", "price"};
//                TableRow row = new TableRow(getBaseContext());
//                for (DataSnapshot dataSnapshot: snapshot.getChildren()){
//                    row = new TableRow(getBaseContext());
//                    for (String key: keys){
//                        TextView textView = new TextView(getBaseContext());
//                        TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT);
//                        params.setMargins(5, 5, 5, 5);
//                        textView.setLayoutParams(params);
//                        String val="";
//                        try {
//                            val = dataSnapshot.child(key).getValue().toString();
//                        } catch (Exception e){
//                            val = "";
//                        }
//                        textView.setText(val);
//                        if (key == "price"){
//                            textView.setText(dataSnapshot.child(key).child("formattedWithSymbol").getValue().toString());
//                        }
//                        row.addView(textView);
//                    }
//                    cartTable.addView(row);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        ButterKnife.bind(this);

        cartTable.setVisibility(View.INVISIBLE);
        backArrow.setOnClickListener(this);
        setUpFirebaseAdapter();
        cartRecycler.setVisibility(View.VISIBLE);

    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Datum> options =
                new FirebaseRecyclerOptions.Builder<Datum>()
                        .setQuery(ref, Datum.class)
                        .build();

        firebaseAdapter = new FirebaseRecyclerAdapter<Datum, FirebaseCartViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull FirebaseCartViewHolder firebaseCartViewHolder, int position, @NonNull Datum cartProduct) {
                firebaseCartViewHolder.bindCartProduct(cartProduct);
            }

            @NonNull
            @Override
            public FirebaseCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
                return new FirebaseCartViewHolder(view);
            }
        };

        cartRecycler.setLayoutManager(new LinearLayoutManager(this));
        cartRecycler.setAdapter(firebaseAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        firebaseAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(firebaseAdapter!= null) {
            firebaseAdapter.stopListening();
        }
    }

    @Override
    public void onClick(View v) {
        if (v == backArrow){
            this.finish();
        }
    }
}