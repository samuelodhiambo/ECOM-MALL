package com.moringaschool.ecommall.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Datum> products;
    GridView gridView;

    public ProductAdapter(Context mContext, List<Datum> products) {
        this.mContext = mContext;
        this.products = products;
    }

    public ProductAdapter(Context mContext, List<Datum> products, GridView gridView) {
        this.mContext = mContext;
        this.products = products;
        this.gridView = gridView;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null) {
            inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.product_item, null);

        }

        ImageView productImage = convertView.findViewById(R.id.productImage);
        TextView productName = convertView.findViewById(R.id.productName);

        Picasso.get().load(products.get(position).getImage().getUrl()).into(productImage);
        productName.setText(products.get(position).getName());
        return convertView;
    }

}
