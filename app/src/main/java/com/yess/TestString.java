package com.yess;

import android.util.Log;

/**
 * Created by yehun on 2018/4/17.
 */

public class TestString {

    public static void main(String[] args){

        String content = "\"c_id\":\"yingyongbao\",\"d_bd\":\"samsung\",\"d_id\":\"787399588897007\",\"d_ml\":\"SAMSUNG-SM-N900A\",\"from\":\"com.huijiemanager\",\n" + "               \"lat\":\"\",\"lng\":\"\",\"p\":\"android\",\"sensors\":{\"anonymous_id\":\"de33a42af362df75\",\"carrier\":\"CMCC\",\"module\":\"\",\n" + "               \"network_type\":\"wifi\",\"os\":\"android\",\"os_version\":\"4.4.2\",\"product\":\"信贷家\",\"screen_height\":1600,\"screen_width\":900,\n" + "               \"utm_source\":\"yingyongbao\",\"wifi\":true},\"specific_address\":\"\",\"timestemp\":\"1523952012663\",\"token\":\"94e6062772a0213f4fdcde3915e7f641\",\n" + "               \"u_id\":\"0adadb94823f166c8b5cda6a4f6b126d\",\"ver\":\"3.4.0\"}";

        StringBuffer buffer = new StringBuffer(content);

        int index = buffer.indexOf("bao\",");

        System.out.print(":" +index);
    }
}
