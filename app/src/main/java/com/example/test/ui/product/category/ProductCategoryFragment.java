package com.example.test.ui.product.category;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class ProductCategoryFragment extends Fragment {

    private static final int COLUMN_COUNT = 2;

    private ProductCategoryViewModel productViewModel;
    private ProductCategoryRecyclerViewAdapter adapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductCategoryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product_category, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.product_categories);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), COLUMN_COUNT));
        adapter = new ProductCategoryRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(adapter);

//        final TextView textView = root.findViewById(R.id.text_notifications);
//        productViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}
