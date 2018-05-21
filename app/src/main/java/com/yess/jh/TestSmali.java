package com.yess.jh;

import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;

import com.huijiemanager.base.b;
import com.huijiemanager.http.NetworkHelper;
import com.huijiemanager.http.response.MyInforCreditResponse;
import com.huijiemanager.http.response.PublicDetailResponse;
import com.huijiemanager.http.response.QuareOrderFiltrateResponse;
import com.huijiemanager.ui.activity.PublicDetailActivity;
import com.huijiemanager.ui.fragment.PageFragment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by yehun on 2018/4/14.
 */
public class TestSmali {

    private static  String TAG = "yess : ";
    public  static  void LogStr(String parmeras)
    {
        Log.d(TAG,parmeras);
    }

    private static  boolean startAgent = false;

    private static MenuItem detailClose;

    private  static  ArrayList<Integer> rededOrders = new ArrayList<Integer>();
    private static ArrayList<QuareOrderFiltrateResponse.OrdersBean> allOrder = new ArrayList<QuareOrderFiltrateResponse.OrdersBean>();
    private static HashMap<QuareOrderFiltrateResponse.OrdersBean,PageFragment> allPage = new HashMap<QuareOrderFiltrateResponse.OrdersBean,PageFragment>();
    // private static int queryCounter = 5;

    private static PageFragment lastFragment;

    //  private static ScheduledThreadPoolExecutor pool;

    private static int delayInterval = 600;

    public static void DetailClose(MenuItem close)
    {
        // startAgent = true;
        if(detailClose == null && close != null)
            detailClose = close;

        // LogStr((detailClose == null)+"xcsd");

        boolean autoRequest = false;

        //查找当前public bean里面没有查询过的订单

        QuareOrderFiltrateResponse.OrdersBean beanUnRed = null;
        for (QuareOrderFiltrateResponse.OrdersBean bean :allOrder) {
            if (!rededOrders.contains(bean.getId()))
            {
                beanUnRed = bean;
                break;
            }
        }

        if(beanUnRed != null)
        {
            // int orderIndex = allOrder.size() -1;
            // beanUnRed = allOrder.get(orderIndex);
            lastFragment = allPage.get(beanUnRed);
            if(lastFragment != null )
            {
                rededOrders.add(beanUnRed.getId());
                StringBuilder parmeras = new StringBuilder();
                parmeras.append(beanUnRed.getId());
                parmeras.append("");

                String parmera = parmeras.toString();

                Intent intent = new Intent(lastFragment.getContext(),PublicDetailActivity.class);
                intent.putExtra("id",parmera);

                lastFragment.startActivityForResult(intent,0);

                allOrder.remove(beanUnRed);
                allPage.remove(beanUnRed);
                // queryCounter --;
                LogStr("自动检查下一个订单 ：" +beanUnRed.getUserDesc() +" size : " +allOrder.size());
            }else
                autoRequest = true;

        }else
            autoRequest = true;

        if(autoRequest)
        {
            // LogStr("列表检查完毕，Helper ：" + (_networkHelper == null) +" requestMap : " +(requestMap == null));
            if(_networkHelper != null && requestMap != null)
            {
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        lastFragment.a();
                        allOrder.clear();
                        allPage.clear();
                        startAgent = true;
                        LogStr("自动发送获取新订单消息" );
                    }
                }, delayInterval);
            }
        }
    }


    private static  boolean IsLock(){
        try {
            SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy-MM-dd HH:mm:ss");
            Date curDate =  new Date(System.currentTimeMillis());
            Date lockData =  formatter.parse("2018-6-20 00:00:00");

            // LogStr( lockData.getTime() + " => " +curDate.getTime());
            return  lockData.getTime() < curDate.getTime();
        }
        catch (Exception e){

        }
        return  true;
    }

    //com/huijiemanager/ui/fragment/PageFragment$f
    public static  void RecvicePublicBean(PageFragment page, QuareOrderFiltrateResponse.OrdersBean bean)
    {
        if(IsLock())
        {
            LogStr("Locking");
            return;
        }

        if(!startAgent)
        {
            if(!allOrder.contains(bean))
                allOrder.add(bean);

            if(!allPage.containsKey(bean))
                allPage.put(bean,page);

         /*   Comparator<QuareOrderFiltrateResponse.OrdersBean> comparator = new OrderComparator();
            Collections.sort(allOrder,comparator);*/

            //  LogStr("NickName : "+ bean.getUserDesc()+" Create time : " +bean.getCreateTime() +" Order Count :" + allOrder.size());
        }else
        {
            lastFragment = page;
            if(!rededOrders.contains(bean.getId()))
                rededOrders.add(bean.getId());

            startAgent = false;
            StringBuilder parmeras = new StringBuilder();
            parmeras.append(bean.getId());
            parmeras.append("");

            String parmera = parmeras.toString();

            Intent intent = new Intent(page.getContext(),PublicDetailActivity.class);
            intent.putExtra("id",parmera);

            page.startActivityForResult(intent,0);

            LogStr("开始检查第一个订单 ：" +bean.getUserDesc());
        }
    }


    private static void AutoCloseDetail()
    {
        new Handler().postDelayed(new Runnable(){
            public void run() {
                currentDetail.onOptionsItemSelected(detailClose);

                Runtime.getRuntime().gc();
                System.runFinalization();
            }
        }, delayInterval);
    }

    public  static void RecviceDetailBean(PublicDetailResponse detailData,PublicDetailActivity detailActivity)
    {
        currentData = detailData;

        currentDetail = detailActivity;

        boolean[] allCondition = new boolean[]{false, false,false,false,false, false};
        //[微粒贷，社保，住房公积金，公务员,打卡工资3000以上,信用良好]

        boolean forward =detailData.city.contains("金华");   //地区过滤
        /*if(forward)  //贷款金额过滤
        {
            if(detailData.loan_amount.contains("万"))
                forward= Integer.parseInt(detailData.loan_amount.replace("万","")) >= 3;
            else
                forward= Integer.parseInt(detailData.loan_amount) >= 30000;
        }*/  //贷款金额筛选条件主动过滤

        //年龄过滤
        if(forward)
        {
            int ageVal = Integer.parseInt(detailData.age);
            forward =  ageVal < 60 && ageVal > 23 ;
        }


        if (detailData.can_collect.equals("1") && detailData.can_monopoly && forward)
        {
            for (MyInforCreditResponse response  :detailData.user_info_list) {

                // LogStr(response.getP_name()) ;
           /*     if(!response.getP_name().isEmpty()&& response.getP_name().equals("社保信息"))   //职业判定 ,事业单位公务员
                    allCondition[3] = true;*/

                for (MyInforCreditResponse.InforDetail info:response.getC_list()) {

                    if(info.getC_name().contains("微粒贷") && !info.getC_value().contains("无"))
                    {
                        String saylaStr = info.getC_value();
                        if(saylaStr.contains("元"))
                            saylaStr= saylaStr.replace("元","");
                        int sayla = Integer.valueOf(saylaStr);
                        // LogStr("微粒贷额度 : " + sayla + " => " +(sayla >= 3000));
                        if(sayla >=10000)
                            allCondition[0] = true;
                    }

                /*    if(info.getC_name().equals("本地社保") && info.getC_value().contains("连续6个月"))
                        allCondition[1] = true;

                    if(info.getC_name().equals("本地公积金") && info.getC_value().contains("连续6个月"))
                        allCondition[2] = true;

                    if(info.getC_name().equals("公积金基数"))
                    {
                        String numVal = info.getC_value().replace("元","");
                        int baseNum = Integer.parseInt(numVal);
                        if(baseNum >= 3500)
                            allCondition[3] = true;
                    }*/

//                    if(info.getC_name().equals("收入形式") && info.getC_value().equals("银行代发"))
//                        allCondition[4] = true;

                    //信用记录 : 信用良好，无逾期
                    if(info.getC_name().equals("信用记录") && !info.getC_value().equals("1年内逾期超过3次或者90天")/*||info.getC_value().equals("信用良好，无逾期"))*/)
                        allCondition[5] = true;

              /*      LogStr(info.getC_name() +" : " +info.getC_value());

                    if(info.c_option != null)
                    {
                        for (MyInforCreditResponse.InforDetail.Option op:info.c_option) {
                            LogStr(op.getOp_code() +" : " +op.getOp_desc());
                        }
                    }

                    if(info.heidInfo != null)
                    {
                        for (MyInforCreditResponse.InforDetail.Hide hd:info.heidInfo) {
                            LogStr(hd.getKey() +" : " +hd.getValue());
                        }
                    }*/
                }
            }

            if(allCondition[5] &&allCondition[0])
            {                //满足所有条件，自动买断
                new Handler().postDelayed(new Runnable(){
                    public void run() {
                        HashMap paramView = new HashMap();
                        paramView.put("order_id", String.valueOf(+currentData.id));
                        paramView.put("click", "选择买断抢单");
                        com.huijiemanager.utils.k.a("xdj_loan_order_detail", paramView);

                        paramView.put("order_id", String.valueOf(currentData.id));
                        paramView.put("click", "立即抢单");
                        com.huijiemanager.utils.k.a("xdj_loan_order_detail", paramView);
                        currentDetail.ac.sendBuyLoanOrderFirstRequest(currentDetail.getNetworkHelper(), currentDetail, currentData.id, 1);
                    }
                }, delayInterval);
            }  else
            {
                if(detailClose == null || currentDetail == null)
                    return;

                AutoCloseDetail();
            }
        }
        else
        {
            if(detailClose == null || currentDetail == null)
                return;

            AutoCloseDetail();
        }

    }

    private static NetworkHelper<b> _networkHelper = null;
    private static HashMap requestMap = null;

    public static  void SetNetworkHelper(NetworkHelper<b> paramNetworkHelper, HashMap localHashMap)
    {
        _networkHelper = paramNetworkHelper;
        requestMap= localHashMap;
    }

    private static PublicDetailActivity currentDetail;
    private static  int currentInt;
    private  static  PublicDetailResponse currentData;

    public  static void SetDetail20(int parmera)
    {
        LogStr((currentDetail == null)+"");
        //  private void a(int paramInt)
        HashMap localHashMap = new HashMap();
        localHashMap.put("default", Boolean.valueOf(currentDetail.aX));
        localHashMap.put("order_price", currentDetail.aY);
        com.huijiemanager.utils.k.a("xdj_discount_coupon", localHashMap);
        currentDetail.I = Integer.valueOf(parmera);

        //  private void b(int paramInt) ->  private void c(int paramInt)
        HashMap parmeraHashMap = new HashMap();
        parmeraHashMap.put("coupon_id", currentDetail.B);
        parmeraHashMap.put("method", "独享");
        parmeraHashMap.put("coupon_usable", Boolean.valueOf(false));
        com.huijiemanager.utils.k.a("xdj_yhq_use", parmeraHashMap);


        currentDetail.ac.sendBuyLoanOrderRequest(_networkHelper, currentDetail, currentDetail.d.id.longValue(), 1,
                currentDetail.d.operationActivityId, currentDetail.B);

        LogStr("发送确认抢单消息");

        if(detailClose != null || currentDetail != null)
            AutoCloseDetail();
    }

    public  static void SuccessClose(PublicDetailActivity detailActivitys)
    {
        if(detailClose == null || currentDetail == null)
            return;

        AutoCloseDetail();
    }
}
