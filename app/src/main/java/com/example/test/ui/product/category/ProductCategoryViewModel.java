package com.example.test.ui.product.category;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProductCategoryViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProductCategoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is product fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
