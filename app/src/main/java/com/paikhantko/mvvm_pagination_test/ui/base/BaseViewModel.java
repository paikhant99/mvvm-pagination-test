package com.paikhantko.mvvm_pagination_test.ui.base;

import androidx.databinding.ObservableBoolean;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;

import com.google.gson.Gson;
import com.paikhantko.mvvm_pagination_test.data.DataManager;
import com.paikhantko.mvvm_pagination_test.data.model.api.ErrorApiResponse;
import com.paikhantko.mvvm_pagination_test.utils.NetworkUtils;
import com.paikhantko.mvvm_pagination_test.utils.rx.SchedulerProvider;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

import io.reactivex.disposables.CompositeDisposable;
import retrofit2.HttpException;

public class BaseViewModel<N extends NavigatorHelper> extends ViewModel {
    private DataManager mDataManager;
    private SchedulerProvider mSchedulerProvider;
    private ObservableBoolean mIsLoading=new ObservableBoolean();
    private CompositeDisposable mCompositeDisposable;
    private WeakReference<N> mNavigator;

    public BaseViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        this.mDataManager=dataManager;
        this.mSchedulerProvider=schedulerProvider;
        this.mCompositeDisposable=new CompositeDisposable();
    }

    @Override
    protected void onCleared() {
        mCompositeDisposable.dispose();
        super.onCleared();
    }

    protected CompositeDisposable getCompositeDisposable(){
        return mCompositeDisposable;
    }

    public DataManager getDataManager(){
        return mDataManager;
    }

    public ObservableBoolean getmIsLoading(){
        return mIsLoading;
    }

    protected void setIsLoading(boolean isLoading){
        mIsLoading.set(isLoading);
    }

    protected N getNavigator(){
        return mNavigator.get();
    }

    public void setNavigator(N navigator){
        this.mNavigator=new WeakReference<>(navigator);
    }

    public SchedulerProvider getSchedulerProvider(){
        return mSchedulerProvider;
    }

    protected void handleApiError(Throwable error) {
        Gson gson = new Gson();
        if (error instanceof HttpException) {
            switch (((HttpException) error).code()) {
                case HttpsURLConnection.HTTP_UNAUTHORIZED:
                    getNavigator().onError("Unauthorised User ");
                    break;
                case HttpsURLConnection.HTTP_FORBIDDEN:
                    getNavigator().onError("Forbidden");
                    break;
                case HttpsURLConnection.HTTP_INTERNAL_ERROR:
                    try {
                        ErrorApiResponse errorResponse = gson.fromJson(Objects.requireNonNull(((HttpException) error).response().errorBody()).string(), ErrorApiResponse.class);
                        getNavigator().onError(errorResponse.getDetail());
                    } catch (IOException e) {
                        e.printStackTrace();
                        getNavigator().onError("Internal Server Error");
                    }
                    break;
                case HttpsURLConnection.HTTP_BAD_REQUEST:
                    getNavigator().onError("Bad Request");
                    break;
                default:
                    try {
                        ErrorApiResponse errorResponse = gson.fromJson(Objects.requireNonNull(((HttpException) error).response().errorBody()).string(), ErrorApiResponse.class);
                        getNavigator().onError(errorResponse.getDetail());
                    } catch (IOException e) {
                        e.printStackTrace();
                        getNavigator().onError(error.getLocalizedMessage());
                    }
            }
        }
    }

    protected void handleApiError(NetworkUtils.ErrorCode errorCode) {
        if (errorCode == NetworkUtils.ErrorCode.OFFLINE) {
            getNavigator().onError("No Internet Connection");
        }
    }

    protected void handleApiError(String message) {
        getNavigator().onError(message);
    }


}
