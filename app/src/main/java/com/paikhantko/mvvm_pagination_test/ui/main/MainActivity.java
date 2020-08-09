package com.paikhantko.mvvm_pagination_test.ui.main;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.paikhantko.mvvm_pagination_test.R;
import com.paikhantko.mvvm_pagination_test.ViewModelProviderFactory;
import com.paikhantko.mvvm_pagination_test.databinding.ActivityMainBinding;
import com.paikhantko.mvvm_pagination_test.ui.base.BaseActivity;

import javax.inject.Inject;

public class MainActivity extends BaseActivity<ActivityMainBinding,MainViewModel> implements MainNavigatorHelper {

    @Inject
    ViewModelProviderFactory factory;

    private MainViewModel mMainViewModel;
    private ActivityMainBinding binding;

    @Override
    protected int getBindingVariable() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected MainViewModel getViewModel() {
        mMainViewModel=new ViewModelProvider(this,factory).get(MainViewModel.class);
        return mMainViewModel;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=getViewDataBinding();
        mMainViewModel.setNavigator(this);
    }
}