package com.paikhantko.mvvm_pagination_test.ui.main;

import com.paikhantko.mvvm_pagination_test.data.DataManager;
import com.paikhantko.mvvm_pagination_test.ui.base.BaseViewModel;
import com.paikhantko.mvvm_pagination_test.utils.rx.SchedulerProvider;

public class MainViewModel extends BaseViewModel<MainNavigatorHelper> {

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
    }
}
