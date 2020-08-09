package com.paikhantko.mvvm_pagination_test.data.remote;

import com.paikhantko.mvvm_pagination_test.data.model.api.CovidApiResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface ApiService {

    @GET("countries-search")
    Single<CovidApiResponse> getAllCovidApiResponse();
}
