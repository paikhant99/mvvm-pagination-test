package com.paikhantko.mvvm_pagination_test.data.remote;

import com.paikhantko.mvvm_pagination_test.data.model.api.CovidApiResponse;

import io.reactivex.Single;

public interface ApiHelper {
    Single<CovidApiResponse> getAllCovidApiResponse();
}
