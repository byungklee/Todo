package com.example.test.ui.product.category;

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
import com.example.test.ui.product.ProductListActivity;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryRecyclerViewAdapter
        extends RecyclerView.Adapter<ProductCategoryRecyclerViewAdapter.ViewHolder> {
    private LayoutInflater mInflater;
    private List<ProductCategory> productCategories;
    private Context context;

    // data is passed into the constructor
    ProductCategoryRecyclerViewAdapter(final Context context) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        productCategories = new ArrayList<>();
        productCategories.add(new ProductCategory(1,
                "Title1",
                "https://www.elegantthemes.com/blog/wp-content/uploads/2015/02/custom-trackable-short-url-feature.png"));
        productCategories.add(new ProductCategory(2,
                "Title2",
                "https://www.elegantthemes.com/blog/wp-content/uploads/2015/02/custom-trackable-short-url-feature.png"));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.product_category_recycler, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.productCategoryName.setText(productCategories.get(position).getProductCategoryName());
//        holder.productCategoryImage.setImage(productCategories.get(position).getProductCategoryTitle());
        Glide.with(context).load(productCategories.get(position).getImageUrl()).into(holder.productCategoryImage);

    }

    @Override
    public int getItemCount() {
        return productCategories.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView productCategoryName;
        ImageView productCategoryImage;

        ViewHolder(View itemView) {
            super(itemView);
            // myTextView = itemView.findViewById(R.id.info_text);
            itemView.setOnClickListener(this);
            productCategoryName = itemView.findViewById(R.id.product_category_name);
            productCategoryImage = itemView.findViewById(R.id.product_category_image);
        }

        @Override
        public void onClick(View view) {
            // if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
            Log.d("ByungL", "Item clicked " + getItemId() + " " + getAdapterPosition());
            onItemClick(view, getAdapterPosition());
        }
    }

    // Convenience method for getting data at click position
    public ProductCategory getItem(int id) {
        return productCategories.get(id);
    }

    // Method that executes your code for the action received
    public void onItemClick(View view, int position) {
        Log.i("TAG", "You clicked number " + getItem(position).toString() + ", which is at cell position " + position);
        Intent intent = new Intent(context, ProductListActivity.class);
        intent.putExtra("productCategoryId", getItem(position).getProductId());
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
