package com.moringaschool.ecommall.ui;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ScrollView;
import android.widget.SearchView;

import com.moringaschool.ecommall.Adapters.CategoryAdapter;
import com.moringaschool.ecommall.Adapters.ProductAdapter;
import com.moringaschool.ecommall.Connections.CommerceApiClient;
import com.moringaschool.ecommall.Interfaces.ProductsInterface;
import com.moringaschool.ecommall.Models.Categories.Category;
import com.moringaschool.ecommall.Models.Categories.Datum;
import com.moringaschool.ecommall.Models.Products.Product;
import com.moringaschool.ecommall.R;
import com.moringaschool.ecommall.Utilities.SearchUtility;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CategoriesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CategoriesFragment extends Fragment {
    @BindView(R.id.categories)
    RecyclerView categoryItems;
    @BindView(R.id.categoryItemsGrid)
    GridView categoryItemsGrid;
    @BindView(R.id.searchInput)
    SearchView searchInput;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CategoriesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CategoriesFragment newInstance(String param1, String param2) {
        CategoriesFragment fragment = new CategoriesFragment();
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
        final View view = inflater.inflate(R.layout.fragment_categories, container, false);
        ButterKnife.bind(this, view);

        ProductsInterface productsInterface = CommerceApiClient.getApiInstance().create(ProductsInterface.class);
        Call<Category> categoryCall = productsInterface.getAllCategories();

        categoryCall.enqueue(new Callback<Category>() {
            @Override
            public void onResponse(Call<Category> call, Response<Category> response) {
                List<Datum> categories = response.body().getData();
                for (Datum category: categories){
                    Log.e(String.valueOf(getActivity()), category.getName());
                }
                CategoryAdapter adapter = new CategoryAdapter(getActivity(), categories, categoryItemsGrid);
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                categoryItems.setLayoutManager(layoutManager);
                categoryItems.setAdapter(adapter);

                for (Datum category: categories){
                    if (category.getProducts() > 0){
                        Call<Product> productCall = productsInterface.getProductsByCategory(category.getId());
                        productCall.enqueue(new Callback<Product>() {
                            @Override
                            public void onResponse(Call<Product> call, Response<Product> response) {
                                Log.e("TEST", response.body().toString());
                                ProductAdapter adapter = new ProductAdapter(getActivity(), response.body().getData(), categoryItemsGrid);
                                categoryItemsGrid.setAdapter(adapter);
                            }

                            @Override
                            public void onFailure(Call<Product> call, Throwable t) {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
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

            @Override
            public void onFailure(Call<Category> call, Throwable t) {
                Log.e(String.valueOf(getActivity()), t.getMessage());
            }
        });

        // Inflate the layout for this fragment
        return view;
    }
}