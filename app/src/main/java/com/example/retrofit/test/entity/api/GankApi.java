package com.example.retrofit.test.entity.api;

import com.example.retrofit.api.TotalBaseApi;
import com.example.retrofit.test.HttpGankService;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.Api.BaseApi;

import retrofit2.Retrofit;
import rx.Observable;

/**
 * Created by T5-Jusenr on 2017/4/4.
 */

public class GankApi extends BaseApi {

    public GankApi() {
        setBaseUrl(TotalBaseApi.GANK_IO_URL);
        setShowProgress(true);
        setMethod(TotalBaseApi.Url.URL_FULI_10_1);
        setCache(true);
    }

    @Override
    public Observable getObservable(Retrofit retrofit) {
        HttpGankService httpGankService = retrofit.create(HttpGankService.class);
        return httpGankService.getGank();
    }
}

