package com.example.retrofit.test.entity.resulte;

/**
 * 回调信息统一封装类
 * Created by Jusenr on 2017/4/12.
 */
public class BaseResultEntity<T> {
    //判断标示
    private int code;
    //提示信息
    private String msg;
    //显示数据（我们需要关心的数据）
    private T data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
