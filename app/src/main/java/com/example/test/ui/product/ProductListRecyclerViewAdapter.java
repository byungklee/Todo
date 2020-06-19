package com.example.test.ui.product;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.test.R;
import com.example.test.ui.product.category.ProductCategory;
import com.example.test.ui.product.detail.ProductDetailActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductListRecyclerViewAdapter
        extends RecyclerView.Adapter<ProductListRecyclerViewAdapter.ViewHolder>{
    private LayoutInflater mInflater;
    private List<Product> products;
    private Context context;

    public ProductListRecyclerViewAdapter(final Context context) {
        this.context = context;
        mInflater = LayoutInflater.from(context);
        products = new ArrayList<>();
        products.add(new Product(1,
                "Title1",
                "https://www.elegantthemes.com/blog/wp-content/uploads/2015/02/custom-trackable-short-url-feature.png",
                "Product Desrcipt1"));
        products.add(new Product(2,
                "Title2",
                "https://www.elegantthemes.com/blog/wp-content/uploads/2015/02/custom-trackable-short-url-feature.png",
                "Product Descript2"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_recycler, parent, false);
        return new ProductListRecyclerViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productName.setText(products.get(position).getProductName());
//        holder.productCategoryImage.setImage(productCategories.get(position).getProductCategoryTitle());
        Glide.with(context).load(products.get(position).getProductImage()).into(holder.productImage);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productName;
        ImageView productImage;

        ViewHolder(View itemView) {
            super(itemView);
            // myTextView = itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
            productName = itemView.findViewById(R.id.product_name);
            productImage = itemView.findViewById(R.id.product_image);
        }

        @Override
        public void onClick(View view) {
            // if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            Log.d("ByungL", "Item clicked " + getItemId() + " " + getAdapterPosition());
//            onItemClick(view, getAdapterPosition());
            onItemClick(view, getAdapterPosition());

        }
    }

    public Product getItem(int id) {
        return products.get(id);
    }

    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
        Intent intent = new Intent(context, ProductDetailActivity.class);
        intent.putExtra("Z", getItem(position).getProductId());
        context.startActivity(intent);
//        Fragment productFragment = new ProductFragment();
//        Bundle bundle = new Bundle();
//        bundle.putInt("productCategoryId", getItem(position).getProductId());
//        productFragment.setArguments(bundle);
//        AppCompatActivity activity = (AppCompatActivity) view.getContext();
//        activity.getSupportFragmentManager().beginTransaction()
//                .replace(R.id.nav_host_fragment, productFragment).addToBackStack(null).commit();
    }
}
