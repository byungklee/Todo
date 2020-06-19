package com.example.test.ui.product;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test.R;

public class ProductListFragment extends Fragment {
    private ProductListViewModel productViewModel;
    private ProductListRecyclerViewAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        productViewModel =
                ViewModelProviders.of(this).get(ProductListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_product_list, container, false);
        final RecyclerView recyclerView = root.findViewById(R.id.products);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProductListRecyclerViewAdapter(getContext());
        recyclerView.setAdapter(adapter);
        Bundle bundle = getArguments();
        Log.i("ByungL", "haha " + bundle.getInt("productCategoryId"));

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
