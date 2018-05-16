package com.yess;

import com.huijiemanager.http.response.QuareOrderFiltrateResponse;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by yehun on 2018/4/17.
 */

public class OrderComparator implements Comparator<QuareOrderFiltrateResponse.OrdersBean> {

    @Override
    public int compare(QuareOrderFiltrateResponse.OrdersBean itemBean1, QuareOrderFiltrateResponse.OrdersBean itemBean2) {
        Long date1 = Long.parseLong(itemBean1.getCreateTime());
        Long date2 = Long.parseLong(itemBean2.getCreateTime());
        return date1 < date2 ? 0 : 1;
    }

}