package com.example.retrofit.api;

/**
 * Description: API管理
 * Copyright  : Copyright (c) 2017
 * Email      : jusenr@163.com
 * Author     : Jusenr
 * Date       : 2017/04/04 15:12.
 */

public abstract class TotalBaseApi {

    public static final int HOST_FORMAL = 1;//正式环境
    public static final int HOST_DEV = 2;//开发环境
    public static final int HOST_TEST = 3;//测试环境

    public static int HOST_NOW;//当前环境

    //e.g.
    public static String GANK_IO_URL = "";
    public static String GANK_IO_1_URL = "";
    public static String IZAODAO_BASE_URL = "";


    /**
     * environment: 1，外网 2，开发内网，3，测试内网
     */
    public static void init(int environment) {
        HOST_NOW = environment;
        switch (environment) {
            case 1:
                GANK_IO_URL = "http://gank.io/api/data/";
                GANK_IO_1_URL = "http://gank.io/api/random/data/";
                IZAODAO_BASE_URL = "https://www.izaodao.com/Api/";
                break;
            case 2:
                GANK_IO_URL = "http://gank.io/api/data/";
                GANK_IO_1_URL = "http://gank.io/api/random/data/";
                IZAODAO_BASE_URL = "https://www.izaodao.com/Api/";
                break;
            case 3:
                GANK_IO_URL = "http://gank.io/api/data/";
                GANK_IO_1_URL = "http://gank.io/api/random/data/";
                IZAODAO_BASE_URL = "https://www.izaodao.com/Api/";
                break;
        }
    }


    public static boolean isInnerEnvironment() {
        return HOST_NOW == HOST_DEV || HOST_NOW == HOST_TEST;
    }


    /*所有的相对URL*/
    public static class Url {

        /**
         * Gank.io
         */
        public static final String URL_FULI_10_1 = "福利/20/1";

        public static final String URL_FULI_10 = "福利/20";
    }

}
