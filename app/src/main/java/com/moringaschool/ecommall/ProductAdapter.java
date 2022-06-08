package com.moringaschool.ecommall;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.moringaschool.ecommall.Models.Products.Datum;
import com.squareup.picasso.Picasso;

import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Datum> products;

    public ProductAdapter(Context mContext, List<Datum> products) {
        this.mContext = mContext;
        this.products = products;
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
        ConstraintLayout constraintLayout = convertView.findViewById(R.id.constraintLayout3);
        int width = Resources.getSystem().getDisplayMetrics().widthPixels;
        int height = Resources.getSystem().getDisplayMetrics().heightPixels;
        constraintLayout.getLayoutParams().width = (width/2)-16;
        constraintLayout.getLayoutParams().height = height/3;
        ImageView productImage = convertView.findViewById(R.id.productImage);
        TextView productName = convertView.findViewById(R.id.productName);

        Picasso.get().load(products.get(position).getImage().getUrl()).into(productImage);
        productName.setText(products.get(position).getName());
        return convertView;
    }
}
