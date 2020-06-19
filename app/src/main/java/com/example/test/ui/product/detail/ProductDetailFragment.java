package com.example.test.ui.product.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.test.R;

public class ProductDetailFragment extends Fragment {

    private ProductDetailViewModel productDetailViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productDetailViewModel =
                ViewModelProviders.of(this).get(ProductDetailViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product_detail, container, false);
//        final RecyclerView recyclerView = root.findViewById(R.id.product_categories);
//        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), COLUMN_COUNT));
//        adapter = new ProductCategoryRecyclerViewAdapter(getContext());
//        recyclerView.setAdapter(adapter);
        return root;
    }
}
