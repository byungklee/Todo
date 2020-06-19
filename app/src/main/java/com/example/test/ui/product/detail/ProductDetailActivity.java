package com.example.test.ui.product.detail;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.example.test.BackButtonActivity;
import com.example.test.R;

public class ProductDetailActivity extends BackButtonActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        Fragment productDetailFragment = new ProductDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("productId", getIntent().getIntExtra("productId", 0));
        productDetailFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment, productDetailFragment).addToBackStack(null).commit();
    }
}
