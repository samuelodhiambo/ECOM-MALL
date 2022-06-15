package com.moringaschool.ecommall.Adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.moringaschool.ecommall.Connections.CommerceApiClient;
import com.moringaschool.ecommall.Interfaces.ProductsInterface;
import com.moringaschool.ecommall.Models.Categories.Datum;
import com.moringaschool.ecommall.Models.Products.Product;
import com.moringaschool.ecommall.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<Datum> categories;
    LayoutInflater gridInflater;
    GridView categoryItemsGrid;

    public CategoryAdapter(Context mContext, List<Datum> categories, GridView categoryItemsGrid) {
        this.mContext = mContext;
        this.categories = categories;
        this.categoryItemsGrid = categoryItemsGrid;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        CategoryViewHolder viewHolder = new CategoryViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        holder.bindCategoriesToLayout(categories.get(position));
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.categoryImage)
        ImageView categoryImage;
        @BindView(R.id.categoryName)
        TextView categoryName;
        GridView categoryItemsGrid = CategoryAdapter.this.categoryItemsGrid;

        private Context mContext;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindCategoriesToLayout(Datum category) {

            try {
                Picasso.get().load(category.getAssets().get(0).getUrl()).into(categoryImage);
            } catch (Exception e) {
                Log.e(this.toString(), e.getLocalizedMessage());
            }
            categoryName.setText(category.getName());
            categoryImage.setOnClickListener(this);
            categoryName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v == categoryImage || v == categoryName){
                ProductsInterface productsInterface = CommerceApiClient.getApiInstance().create(ProductsInterface.class);
                String category_id = "";
                String category_name = "";
                for (Datum category: categories){
                    if (categoryName.getText().toString() == category.getName()){
                        category_id = category.getId();
                        category_name = category.getName();
                    }
                }
                Call<Product> productCall = productsInterface.getProductsByCategory(category_id);
                String finalCategory_name = category_name;
                productCall.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        if (response.body().getData() != null) {
                            ProductAdapter adapter = new ProductAdapter(mContext, response.body().getData(), categoryItemsGrid);
                            categoryItemsGrid.setAdapter(adapter);
                        } else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                            //Setting message manually and performing action on button click
                            builder.setMessage("There are currently no products in the " + finalCategory_name + " category")
                                    .setCancelable(false)
                                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            dialog.cancel();
                                        }
                                    });
                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Empty Category");
                            alert.show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                        //Setting message manually and performing action on button click
                        builder.setMessage("You have no internet connection!!!")
                                .setCancelable(false)
                                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                        //Creating dialog box
                        AlertDialog alert = builder.create();
                        //Setting the title manually
                        alert.setTitle("Connection Problem");
                        alert.show();
                    }
                });
            }
        }
    }

}
