package com.paikhantko.mvvm_pagination_test;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.paikhantko.mvvm_pagination_test.data.DataManager;
import com.paikhantko.mvvm_pagination_test.ui.main.MainViewModel;
import com.paikhantko.mvvm_pagination_test.utils.rx.SchedulerProvider;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ViewModelProviderFactory extends ViewModelProvider.NewInstanceFactory {

    private DataManager dataManager;
    private SchedulerProvider schedulerProvider;

    @Inject
    public ViewModelProviderFactory(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.dataManager=dataManager;
        this.schedulerProvider=schedulerProvider;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)){
            //noinspection unchecked
            return (T) new MainViewModel(dataManager,schedulerProvider);
        }
        throw new IllegalArgumentException("Unknown ViewModel Class"+modelClass.getName());
    }
}
