package com.moringaschool.ecommall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater inflater;
    private String[] products;

    public ProductAdapter(Context mContext, String[] products) {
        this.mContext = mContext;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.length;
    }

    @Override
    public Object getItem(int position) {
        return products[position];
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
//        ImageView productImage = convertView.findViewById(R.id.productImage);
        TextView productName = convertView.findViewById(R.id.productName);

//        productImage.setImageResource();
        productName.setText(products[position]);
        return convertView;
    }
}
