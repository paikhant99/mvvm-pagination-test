package com.paikhantko.mvvm_pagination_test.di.builder;

import com.paikhantko.mvvm_pagination_test.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector
    abstract MainActivity bindMainActivity();
}
