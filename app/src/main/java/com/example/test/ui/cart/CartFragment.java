package com.example.test.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.test.R;
import com.example.test.ui.product.category.ProductCategoryRecyclerViewAdapter;
import com.example.test.ui.product.category.ProductCategoryViewModel;

public class CartFragment extends Fragment {

    private static final int COLUMN_COUNT = 2;

    private ProductCategoryViewModel productViewModel;
    private ProductCategoryRecyclerViewAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductCategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        return root;
    }
}