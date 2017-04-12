package com.example.retrofit;

import android.app.Application;
import android.content.Context;

import com.example.retrofit.api.TotalBaseApi;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.RxRetrofitApp;

/**
 * Created by WZG on 2016/10/25.
 */

public class MyApplication extends Application {
    public static Context app;
    private boolean isDebug;

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Service Api
        TotalBaseApi.init(TotalBaseApi.HOST_TEST);
        isDebug = isDebug();

        RxRetrofitApp.init(this, isDebug);
    }

    private boolean isDebug() {
        return TotalBaseApi.isInnerEnvironment();
    }
}
