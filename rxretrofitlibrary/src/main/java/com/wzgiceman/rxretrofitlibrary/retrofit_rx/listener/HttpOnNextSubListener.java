package com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener;

import rx.Observable;

/**
 * 回调obser对象
 * Created by WZG on 2016/12/12.
 */

public interface HttpOnNextSubListener {

    /**
     * obser成功回调
     * @param observable
     * @param method
     */
    void onNext(Observable observable,String method);
}
