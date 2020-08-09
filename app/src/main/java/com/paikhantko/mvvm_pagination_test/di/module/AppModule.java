package com.paikhantko.mvvm_pagination_test.di.module;

import android.app.Application;
import android.content.Context;

import com.paikhantko.mvvm_pagination_test.data.AppDataManager;
import com.paikhantko.mvvm_pagination_test.data.DataManager;
import com.paikhantko.mvvm_pagination_test.data.remote.ApiHelper;
import com.paikhantko.mvvm_pagination_test.data.remote.ApiService;
import com.paikhantko.mvvm_pagination_test.data.remote.AppApiHelper;
import com.paikhantko.mvvm_pagination_test.utils.rx.AppSchedulerProvider;
import com.paikhantko.mvvm_pagination_test.utils.rx.SchedulerProvider;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class AppModule {

    @Provides
    @Singleton
    Context provideContext(Application application){
        return application;
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(){
        return new OkHttpClient.Builder()
                .readTimeout(150,TimeUnit.SECONDS)
                .connectTimeout(150, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient){
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }

    @Provides
    @Singleton
    AppApiHelper networkManager(ApiService apiService){
        return new AppApiHelper(apiService);
    }

    @Provides
    @Singleton
    ApiHelper provideAppApiHelper(AppApiHelper appApiHelper){
        return appApiHelper;
    }

    @Provides
    @Singleton
    DataManager provideAppDataManager(AppDataManager appDataManager){
        return appDataManager;
    }

    @Provides
    @Singleton
    SchedulerProvider provideSchedulerProvider(){
        return new AppSchedulerProvider();
    }
}
