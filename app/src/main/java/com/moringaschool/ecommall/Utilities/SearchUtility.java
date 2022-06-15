package com.moringaschool.ecommall.Utilities;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.moringaschool.ecommall.Adapters.ProductAdapter;
import com.moringaschool.ecommall.Connections.CommerceApiClient;
import com.moringaschool.ecommall.Interfaces.ProductsInterface;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.Models.Products.Product;
import com.moringaschool.ecommall.R;
import com.moringaschool.ecommall.ui.HomeFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchUtility {
    private SearchView searchView;
    private GridView gridView;
    private Context mContext;
    private FragmentManager fragmentManager;

    public SearchUtility(SearchView searchView, GridView gridView, Context mContext, FragmentManager fragmentManager) {
        this.searchView = searchView;
        this.gridView = gridView;
        this.mContext = mContext;
        this.fragmentManager = fragmentManager;
    }

    public void search(){
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchTerm = searchView.getQuery().toString();
                if (searchTerm.length() <= 2){
                    Toast.makeText(mContext, "Search query is too short: " + searchTerm, Toast.LENGTH_SHORT).show();
                    return false;
                }
                Toast.makeText(mContext, "You searched for " + searchTerm, Toast.LENGTH_SHORT).show();
                ProductsInterface productsInterface = CommerceApiClient.getApiInstance().create(ProductsInterface.class);
                Call<Product> productCall = productsInterface.searchProducts(searchTerm);
                productCall.enqueue(new Callback<Product>() {
                    @Override
                    public void onResponse(Call<Product> call, Response<Product> response) {
                        List<Datum> searchProducts = response.body().getData();
                        ProductAdapter adapter = new ProductAdapter(mContext, searchProducts);
//                        replaceFragment(new HomeFragment());
                        gridView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<Product> call, Throwable t) {
                        Log.e("API ERROR: ", t.getMessage());
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
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    public void replaceFragment(Fragment fragment){
        FragmentManager fm = this.fragmentManager;
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();
    }
}
