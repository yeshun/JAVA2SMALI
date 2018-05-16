package com.huijiemanager.utils;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;


import com.huijiemanager.app.ApplicationController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class k {
    public static final String A = "xdj_check_in";
    public static final String B = "xdj_alarm";
    public static final String C = "xdj_add_tags";
    public static final String D = "xdj_add_new_client";
    public static final String E = "xdj_screen_client";
    public static final String F = "xdj_time_client";
    public static final String G = "xdj_time_client_detail";
    public static final String H = "xdj_client_info_click";
    public static final String I = "xdj_home_orders_browse";
    public static final String J = "xdj_order_detail_push_click";
    public static final String K = "xdj_order_detail_unfold";
    public static final String L = "xdj_certification_process";
    public static final String M = "xdj_invite_saveqrcode";
    public static final String N = "xdj_discount_coupon";
    public static final String O = "xdj_grab_type";
    public static final String P = "xdj_open_operation";
    private static final String Q = "eventlog";
    // private static final b R = new b("cn-hangzhou.log.aliyuncs.com", "LTAIzyWGy86c7jwt", "foOn5ZrZtn0sWxPXAKArMfTNB2GrkE", "huijiewebtrack");
    private static final ExecutorService S = Executors.newFixedThreadPool(3);
    public static final String a = "method";
    public static final String b = "coupon_usable";
    public static final String c = "coupon_id";
    public static final String d = "click";
    public static final String e = "xdj_yhq_use";
    public static final String f = "xdj_quick_login";
    public static final String g = "xdj_password_login";
    public static final String h = "xdj_forget_password";
    public static final String i = "xdj_index";
    public static final String j = "xdj_banner_click";
    public static final String k = "xdj_loan_order_detail";
    public static final String l = "xdj_huijie_money";
    public static final String m = "xdj_huijie_money_buy_click";
    public static final String n = "xdj_invite_share";
    public static final String o = "xdj_message_click";
    public static final String p = "xdj_public_message";
    public static final String q = "xdj_user_message";
    public static final String r = "xdj_coupon_common_click";
    public static final String s = "xdj_coupon_type_click";
    public static final String t = "xdj_coupon_detail_click";
    public static final String u = "xdj_mine";
    public static final String v = "xdj_settings";
    public static final String w = "xdj_password_manage";
    public static final String x = "xdj_change_phone_number";
    public static final String y = "xdj_manager_info";
    public static final String z = "xdj_manager_certificate";

    public static void a() {

    }

    public static void a(Context paramContext, String paramString1, String paramString2) {
        a(paramContext, paramString1, null, paramString2);
    }

    public static void a(Context paramContext, String paramString1, HashMap<String, String> paramHashMap, String paramString2) {
    }

    public static void a(String paramString, Map<String, String> paramMap) {
    }
}