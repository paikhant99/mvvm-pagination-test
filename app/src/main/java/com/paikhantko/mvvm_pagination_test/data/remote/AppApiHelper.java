package com.paikhantko.mvvm_pagination_test.data.remote;

import com.paikhantko.mvvm_pagination_test.data.model.api.CovidApiResponse;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Single;

@Singleton
public class AppApiHelper implements ApiHelper{

    private ApiService apiService;

    @Inject
    public AppApiHelper(ApiService apiService) {
        this.apiService=apiService;
    }

    @Override
    public Single<CovidApiResponse> getAllCovidApiResponse() {
        return apiService.getAllCovidApiResponse();
    }
}
