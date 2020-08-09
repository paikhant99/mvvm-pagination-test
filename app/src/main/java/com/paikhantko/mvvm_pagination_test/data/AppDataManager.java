package com.paikhantko.mvvm_pagination_test.data;

import com.paikhantko.mvvm_pagination_test.data.model.api.CovidApiResponse;
import com.paikhantko.mvvm_pagination_test.data.remote.ApiHelper;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppDataManager implements DataManager {

    private ApiHelper apiHelper;

    @Inject
    public AppDataManager(ApiHelper apiHelper) {
        this.apiHelper=apiHelper;
    }

    @Override
    public Single<CovidApiResponse> getAllCovidApiResponse() {
        return apiHelper.getAllCovidApiResponse();
    }
}
