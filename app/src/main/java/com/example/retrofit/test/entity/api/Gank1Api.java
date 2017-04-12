package com.example.retrofit.test.entity.api;

import com.example.retrofit.api.TotalBaseApi;
import com.example.retrofit.test.HttpGankService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by T5-Jusenr on 2017/4/4.
 */

public class Gank1Api extends BaseApi {

    public Gank1Api() {
        setBaseUrl(TotalBaseApi.GANK_IO_1_URL);
    }

    public void setting() {
        setShowProgress(true);
        setMethod(TotalBaseApi.Url.URL_FULI_10);
        setCache(true);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        setting();
        HttpGankService httpGankService = retrofit.create(HttpGankService.class);
        return httpGankService.getGank_1();
    }
}

