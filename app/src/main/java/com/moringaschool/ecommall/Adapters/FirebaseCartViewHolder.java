package com.moringaschool.ecommall.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.Models.Products.Datum_2;
import com.moringaschool.ecommall.R;
import com.squareup.picasso.Picasso;

import org.jsoup.Jsoup;

public class FirebaseCartViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View view;
    Context mContext;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference ref = database.getReferenceFromUrl("https://ecom-mall-default-rtdb.firebaseio.com/");


    public FirebaseCartViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        mContext = itemView.getContext();
        itemView.setOnClickListener(this);
    }

    public void bindCartProduct(Datum cartProduct){
        ImageView cartImage = view.findViewById(R.id.cartImage);
        TextView cartName, cartDesc, cartPrice;
        cartName = view.findViewById(R.id.cartName);
        cartDesc = view.findViewById(R.id.cartDesc);
        cartPrice = view.findViewById(R.id.cartPrice);

        Log.e("cartProd", cartProduct.toString());

        Picasso.get().load(cartProduct.getImage().getUrl()).into(cartImage);
        cartName.setText(cartProduct.getName());
        cartDesc.setText(Jsoup.parse(cartProduct.getDescription()).text());
        cartPrice.setText(cartProduct.getPrice().getFormattedWithSymbol());
    }

    @Override
    public void onClick(View v) {

    }
}
