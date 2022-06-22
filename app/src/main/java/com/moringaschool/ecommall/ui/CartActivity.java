package com.moringaschool.ecommall.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.ecommall.Adapters.FirebaseCartAdapter;
import com.moringaschool.ecommall.Adapters.FirebaseCartViewHolder;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CartActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.backArrow)
    ImageView backArrow;
    @BindView(R.id.cartTable)
    TableLayout cartTable;
    @BindView(R.id.cartRecycler)
    RecyclerView cartRecycler;
    @BindView(R.id.cartConstraint)
    ConstraintLayout cartConstraint;
    private Datum cartProducts = new Datum();

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/cart/product/");
    private FirebaseCartAdapter<Datum, FirebaseCartViewHolder> firebaseAdapter;
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

        enableSwipeToDeleteAndUndo();

    }

    private void enableSwipeToDeleteAndUndo() {
        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(this) {
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


                final int position = viewHolder.getAdapterPosition();
                final Datum item = firebaseAdapter.getItem(position);

                firebaseAdapter.removeItem(position);


                Snackbar snackbar = Snackbar
                        .make(cartConstraint, "Item was removed from the list.", Snackbar.LENGTH_LONG);
                snackbar.setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        firebaseAdapter.restoreItem(item, position);
                        cartRecycler.setAdapter(firebaseAdapter);
                        cartRecycler.scrollToPosition(position);
                    }
                });

                snackbar.setActionTextColor(Color.YELLOW);
                snackbar.show();

            }
        };

        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
        itemTouchhelper.attachToRecyclerView(cartRecycler);
    }

    private void setUpFirebaseAdapter(){
        FirebaseRecyclerOptions<Datum> options =
                new FirebaseRecyclerOptions.Builder<Datum>()
                        .setQuery(ref, Datum.class)
                        .build();

        firebaseAdapter = new FirebaseCartAdapter<Datum, FirebaseCartViewHolder>(options) {
//            @Override
//            protected void onBindViewHolder(@NonNull FirebaseCartViewHolder firebaseCartViewHolder, int position, @NonNull Datum cartProduct) {
//                firebaseCartViewHolder.bindCartProduct(cartProduct);
//            }

//            @NonNull
//            @Override
//            public FirebaseCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
//                return new FirebaseCartViewHolder(view);
//            }

//            public void removeItem(int position) {
//                options.getSnapshots().remove(position);
//                notifyItemRemoved(position);
//            }
//
//            public void restoreItem(Datum product, int position) {
//                options.getSnapshots().add(position, product);
//                notifyItemInserted(position);
//            }
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