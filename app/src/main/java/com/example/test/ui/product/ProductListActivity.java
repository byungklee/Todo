package com.example.test.ui.product;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.test.BackButtonActivity;
import com.example.test.R;

public class ProductListActivity extends BackButtonActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Fragment productFragment = new ProductListFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("productCategoryId", getIntent().getIntExtra("productCategoryId", 0));
        productFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, productFragment).addToBackStack(null).commit();
    }
}
