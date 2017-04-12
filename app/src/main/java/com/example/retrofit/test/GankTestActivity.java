package com.example.retrofit.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.example.retrofit.R;
import com.example.retrofit.test.entity.api.Gank1Api;
import com.example.retrofit.test.entity.api.GankApi;
import com.example.retrofit.test.entity.resulte.BaseGankResultEntity;
import com.example.retrofit.test.entity.resulte.GankResulte;
import com.trello.rxlifecycle.components.support.RxAppCompatActivity;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.exception.ApiException;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.http.HttpManager;
import com.wzgiceman.rxretrofitlibrary.retrofit_rx.listener.HttpOnNextListener;

import java.util.List;

/**
 * Created by T5-Jusenr on 2017/4/6.
 */

public class GankTestActivity extends RxAppCompatActivity implements View.OnClickListener, HttpOnNextListener {


    private RecyclerView mRvTest;

    private HttpManager manager;
    private GankApi gankEntity;
    private Gank1Api gankEntity1;

    private int i = 0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gank_test);

        findViewById(R.id.tv_left_title).setOnClickListener(this);
        findViewById(R.id.tv_right_title).setOnClickListener(this);
        mRvTest = (RecyclerView) findViewById(R.id.rv_test);

        manager = new HttpManager(this, this);

        gankEntity = new GankApi();

        gankEntity1 = new Gank1Api();

        mRvTest.setLayoutManager(new GridLayoutManager(this, 2));
        mRvTest.setHasFixedSize(true);

        manager.doHttpDeal(gankEntity);
    }

    private void setadapter(List<GankResulte> list) {
        Log.i("####", "setadapter: " + list);
        GankAdapter gankAdapter = new GankAdapter(this, list);
        mRvTest.setAdapter(gankAdapter);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_left_title:
                finish();
                break;
            case R.id.tv_right_title:
                i++;
                if (i % 2 == 1) {
                    manager.doHttpDeal(gankEntity1);
                } else {
                    manager.doHttpDeal(gankEntity);
                }
                break;
        }
    }

    @Override
    public void onNext(String resulte, String method) {
        if (method.equals(gankEntity.getMethod())) {
            BaseGankResultEntity<List<GankResulte>> subjectResulte = JSONObject.parseObject(resulte, new TypeReference<BaseGankResultEntity<List<GankResulte>>>() {

            });
            setadapter(subjectResulte.getResults());
        }

        if (method.equals(gankEntity1.getMethod())) {
            BaseGankResultEntity<List<GankResulte>> subjectResulte = JSONObject.parseObject(resulte, new TypeReference<BaseGankResultEntity<List<GankResulte>>>() {

            });
            setadapter(subjectResulte.getResults());
        }
    }

    @Override
    public void onError(ApiException e) {
        Toast.makeText(GankTestActivity.this, e.getDisplayMessage().toString(), Toast.LENGTH_SHORT).show();
    }
}
