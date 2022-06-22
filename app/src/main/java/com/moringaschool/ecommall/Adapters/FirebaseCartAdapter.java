package com.moringaschool.ecommall.Adapters;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.R;
import com.moringaschool.ecommall.ui.CartActivity;

import java.util.ArrayList;

public class FirebaseCartAdapter<D, F extends FirebaseCartViewHolder> extends FirebaseRecyclerAdapter<Datum, FirebaseCartViewHolder> {

    FirebaseRecyclerOptions<Datum> options;
    FirebaseCartViewHolder firebaseCartViewHolder;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/cart/product/");

    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public FirebaseCartAdapter(@NonNull FirebaseRecyclerOptions<Datum> options) {
        super(options);
        this.options = options;
    }


    @Override
    protected void onBindViewHolder(@NonNull FirebaseCartViewHolder holder, int position, @NonNull Datum model) throws NullPointerException {
        try {
            Log.e("Model", model.toString());
            holder.bindCartProduct(model);
        } catch (Exception e){
            try {
                holder.bindCartProduct(options.getSnapshots().get(position));
            } catch (Exception ex){
                holder.bindCartProduct(new Datum());
            }
        }
    }

    @NonNull
    @Override
    public FirebaseCartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item, parent, false);
        return new FirebaseCartViewHolder(view);
    }

    public void removeItem(int position) {
        Log.e("position", options.getSnapshots().get(position).toString());
        options.getSnapshots().getSnapshot(position).getRef().removeValue();
//        options.getSnapshots().remove(position);
        notifyItemRemoved(position);
    }

    public void restoreItem(Datum product, int position) {
        ref.child(""+(Integer.parseInt(product.getId())-1)+product.getName()).setValue(product);
//        options.getSnapshots().add(position, product);
//        notifyItemInserted(position);
    }
}
