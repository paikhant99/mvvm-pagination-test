package com.paikhantko.mvvm_pagination_test.ui.base;

import android.view.View;

public interface NavigatorHelper {
    void onError(int resId);
    void onError(String message);
    void showMessage(String message);
    void showMessage(int resId);
    boolean isNetworkConnected();
    View getLayoutView();
}
