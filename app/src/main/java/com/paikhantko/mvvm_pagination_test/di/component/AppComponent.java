package com.paikhantko.mvvm_pagination_test.di.component;

import android.app.Application;

import com.paikhantko.mvvm_pagination_test.MvvmPaginationTestApp;
import com.paikhantko.mvvm_pagination_test.di.builder.ActivityBuilder;
import com.paikhantko.mvvm_pagination_test.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Singleton
@Component(modules = {AndroidInjectionModule.class, AppModule.class, ActivityBuilder.class})
public interface AppComponent {
    void inject(MvvmPaginationTestApp app);

    @Component.Builder
    interface Builder{

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }
}
