package com.moringaschool.ecommall;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.moringaschool.ecommall.Connections.CommerceApiClient;
import com.moringaschool.ecommall.Interfaces.ProductsInterface;
import com.moringaschool.ecommall.Models.Products.Datum;
import com.moringaschool.ecommall.Models.Products.Product;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements AdapterView.OnItemClickListener, SearchView.OnQueryTextListener, View.OnClickListener {

    private String searchTerm;
    @BindView(R.id.shimmerLoading)
    ShimmerFrameLayout shimmerLoading;
    @BindView(R.id.cartButton)
    ConstraintLayout cartButton;
    @BindView(R.id.productsGrid)
    GridView productsGrid;
    @BindView(R.id.searchInput)
    SearchView searchInput;

    List<Datum> products;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        productsGrid.setVisibility(View.INVISIBLE);
        shimmerLoading.startShimmerAnimation();

//        ProductAdapter adapter = new ProductAdapter(getActivity(), products);
//        productsGrid.setAdapter(adapter);

        ProductsInterface productsInterface = CommerceApiClient.getApiInstance().create(ProductsInterface.class);
        Call<Product> productCall = productsInterface.getAllProducts();
        productCall.enqueue(new Callback<Product>() {
            @Override
            public void onResponse(Call<Product> call, Response<Product> response) {
                List<Datum> data = response.body().getData();
                products = data;
                for (Datum datum1: data){
                    Log.i("API DATA: ", datum1.getName());
                }

                ProductAdapter adapter = new ProductAdapter(getActivity(), response.body().getData());
                productsGrid.setAdapter(adapter);
                productsGrid.setVisibility(View.VISIBLE);
                shimmerLoading.stopShimmerAnimation();
                shimmerLoading.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onFailure(Call<Product> call, Throwable t) {
                Log.e("API ERROR: ", t.getMessage());
            }
        });

        productsGrid.setOnItemClickListener(this);

        searchInput.setOnQueryTextListener(this);

        cartButton.setOnClickListener(this);
        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "You clicked " + products.get(position).getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(getActivity(), ProductItemActivity.class);
        intent.putExtra("product", products.get(position));
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        searchTerm = searchInput.getQuery().toString();
        if (searchTerm.length() <= 2){
            Toast.makeText(getActivity(), "Search query is too short: " + searchTerm, Toast.LENGTH_SHORT).show();
            return false;
        }
        Toast.makeText(getActivity(), "You searched for " + searchTerm, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }

    @Override
    public void onClick(View v) {
        if (v == cartButton) {
            Intent intent = new Intent(getActivity(), CartActivity.class);
            startActivity(intent);
        }
    }
}