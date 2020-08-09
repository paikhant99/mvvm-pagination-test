package com.paikhantko.mvvm_pagination_test.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class NetworkUtils {
    private NetworkUtils() {
    }

    public static boolean isNetworkConnected(Context context){
        ConnectivityManager manager=(ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (manager!=null){
            NetworkInfo activeNetwork=manager.getActiveNetworkInfo();
            return activeNetwork!=null && activeNetwork.isConnectedOrConnecting();
        }
        return false;
    }

    public enum ErrorCode{
        OFFLINE
    }
}
