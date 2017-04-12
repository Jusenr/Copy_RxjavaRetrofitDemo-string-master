package com.example.retrofit.test;

import com.example.retrofit.api.TotalBaseApi;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by T5-Jusenr on 2017/4/5.
 */
public interface HttpGankService {

    @GET(TotalBaseApi.Url.URL_FULI_10_1)
    Observable<String> getGank();

    @GET(TotalBaseApi.Url.URL_FULI_10)
    Observable<String> getGank_1();
}
