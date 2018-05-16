package com.yess.cd;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.MenuItem;

import com.huijiemanager.base.b;
import com.huijiemanager.http.NetworkHelper;
import com.huijiemanager.http.response.MyInforCreditResponse;
import com.huijiemanager.http.response.PublicDetailResponse;
import com.huijiemanager.http.response.QuareOrderFiltrateResponse;
import com.huijiemanager.ui.activity.PublicDetailActivity;
import com.huijiemanager.ui.fragment.PageFragment;
import com.yess.OrderComparator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;

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

    private static String lastOrderTime;

    private static ArrayList<QuareOrderFiltrateResponse.OrdersBean> allOrder = new ArrayList<QuareOrderFiltrateResponse.OrdersBean>();
    private static HashMap<QuareOrderFiltrateResponse.OrdersBean,PageFragment> allPage = new HashMap<QuareOrderFiltrateResponse.OrdersBean,PageFragment>();
   // private static int queryCounter = 5;

    private static PageFragment lastFragment;

    private static  String[] tagArray = new String[]{"0","8","1","3"};
    private static int tagArrayCount = 0;

    public static void DetailClose(MenuItem close)
    {
        // startAgent = true;
        if(detailClose == null)
            detailClose = close;

        boolean autoRequest = false;

        if(allOrder.size() > 0 &&  allPage.size() > 0 /*&& queryCounter > 0*/)
        {
            int orderIndex = allOrder.size() -1;
            QuareOrderFiltrateResponse.OrdersBean bean = allOrder.get(orderIndex);
            lastFragment = allPage.get(bean);
            if(bean != null &&lastFragment != null )
            {
                StringBuilder parmeras = new StringBuilder();
                parmeras.append(bean.getId());
                parmeras.append("");

                String parmera = parmeras.toString();

                Intent intent = new Intent(lastFragment.getContext(),PublicDetailActivity.class);
                intent.putExtra("id",parmera);

                lastFragment.startActivityForResult(intent,0);

                allOrder.remove(orderIndex);
                allPage.remove(orderIndex);
               // queryCounter --;
                LogStr("自动检查下一个订单 ：" +bean.getUserDesc() +" size : " +allOrder.size());
            }else
                autoRequest = true;

        }else
            autoRequest = true;

        if(autoRequest)
        {
            LogStr("列表检查完毕，Helper ：" + (_networkHelper == null) +" requestMap : " +(requestMap == null));
            if(_networkHelper != null && requestMap != null)
            {
                lastFragment.a();
                allOrder.clear();
                allPage.clear();
                startAgent = true;
               // queryCounter = 5;
                LogStr("自动发送获取新订单消息" );
            }
        }
    }


    private static  boolean IsLock(){
        SimpleDateFormat formatter   =   new   SimpleDateFormat   ("yyyy年MM月dd日   HH:mm:ss");
        Date curDate =  new Date(System.currentTimeMillis());
        Date lockData =  new Date(2018,5,30);

        return  lockData.getTime() < curDate.getTime();
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
            allOrder.add(bean);
            allPage.put(bean,page);

            Comparator<QuareOrderFiltrateResponse.OrdersBean> comparator = new OrderComparator();
            Collections.sort(allOrder,comparator);

            LogStr("NickName : "+ bean.getUserDesc()+" Create time : " +bean.getCreateTime() +" Order Count :" + allOrder.size());
       }else
      {
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

    public  static void RecviceDetailBean(PublicDetailResponse detailData,PublicDetailActivity detailActivity)
    {
        currentData = detailData;

        currentDetail = detailActivity;

        boolean[] allCondition = new boolean[]{false,false,false,false};//[微粒贷，社保，住房公积金]
        //过滤不能买断的，没有社保和公积金的
        if (detailData.can_collect.equals("1") && detailData.can_monopoly )
        {
            for (MyInforCreditResponse response  :detailData.user_info_list) {

                for (MyInforCreditResponse.InforDetail info:response.getC_list()) {

                    if(info.getC_name().contains("微粒贷") && !info.getC_value().contains("无"))
                        allCondition[0] = true;

                    if(info.getC_name().equals("本地社保") && !info.getC_value().contains("无"))
                        allCondition[1] = true;

                    if(info.getC_name().equals("本地公积金") && !info.getC_value().contains("无"))
                        allCondition[2] = true;

                    if(info.getC_name().equals("收入形式") && info.getC_value().equals("银行代发"))
                        allCondition[3] = true;

                    LogStr(info.getC_name() +" : " +info.getC_value());
                }
            }

            if(allCondition[0]|| (allCondition[1]&&allCondition[3]) || (allCondition[2]&&allCondition[3]))
            {
                TimerTask task = new TimerTask() {

                    PublicDetailResponse tempData = currentData;
                    PublicDetailActivity tempActivity = currentDetail;
                    @Override
                    public void run() {
                        Looper.prepare();
                        Message message = new Message();
                        Bundle bundle = new Bundle();
                        Handler handler = new Handler(){
                            @Override
                            public void handleMessage(Message message) {
                                super.handleMessage(message);
                                Bundle bundle = message.getData();
                                int orderType = bundle.getInt("orderType");

                                LogStr("自动发送买断消息，order id : " +tempData.id + (tempActivity == null));

                                HashMap paramView = new HashMap();
                                paramView.put("order_id", String.valueOf(+tempData.id));
                                paramView.put("click", "选择买断抢单");
                                com.huijiemanager.utils.k.a("xdj_loan_order_detail", paramView);

                                paramView.put("order_id", String.valueOf(tempData.id));
                                paramView.put("click", "立即抢单");
                                com.huijiemanager.utils.k.a("xdj_loan_order_detail", paramView);
                                tempActivity.ac.sendBuyLoanOrderFirstRequest(tempActivity.getNetworkHelper(), tempActivity, tempData.id, orderType);
                            }
                        };

                        bundle.putInt("orderType", 1);
                        message.setData(bundle);
                        handler.sendMessage(message);
                        Looper.loop();
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
                //满足所有条件，自动买断


               // detailActivity.b(1);
               /* detailActivity.c(1);
                detailActivity.ac.sendBuyLoanOrderRequest(detailActivity.getNetworkHelper(), detailActivity, detailActivity.d.id.longValue(), 1,
                        detailActivity.d.operationActivityId, detailActivity.B);*/
            }  else
            {
                if(detailClose == null || currentDetail == null)
                    return;

                TimerTask task = new TimerTask()
                {
                    PublicDetailActivity tempActivity = currentDetail;
                    MenuItem tempClose = detailClose;
                    @Override
                    public void run() {
                        //自动关闭界面
                        tempActivity.onOptionsItemSelected(tempClose);
                    }
                };
                Timer timer = new Timer();
                timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
            }
        }
        else
        {
            if(detailClose == null || currentDetail == null)
                return;

            TimerTask task = new TimerTask()
            {
                PublicDetailActivity tempActivity = currentDetail;
                MenuItem tempClose = detailClose;
                @Override
                public void run() {
                    //自动关闭界面

                    LogStr((tempActivity == null) +" : "+(tempClose == null));
                    tempActivity.onOptionsItemSelected(tempClose);
                }
            };
            Timer timer = new Timer();
            timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
        }


    }

    private static NetworkHelper<b> _networkHelper = null;
    private static HashMap requestMap = null;

    public static  void SetNetworkHelper(NetworkHelper<b> paramNetworkHelper, HashMap localHashMap)
    {
        _networkHelper = paramNetworkHelper;
        requestMap= localHashMap;

        StringBuilder buffer = new StringBuilder();
        for (Object mapKey:requestMap.keySet()) {

            buffer.append("key : " +mapKey.toString() +" value : "+ requestMap.get(mapKey).toString()+" \r\n");
        }

        LogStr(buffer.toString());
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
    }

    public  static void SuccessClose(PublicDetailActivity detailActivitys)
    {
        //currentDetail = detailActivitys;

        if(detailClose == null || currentDetail == null)
            return;

        TimerTask task = new TimerTask()
        {
            PublicDetailActivity tempActivity = currentDetail;
            MenuItem tempClose = detailClose;
            @Override
            public void run() {
                //自动关闭界面
                tempActivity.onOptionsItemSelected(tempClose);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, 1000);//3秒后执行TimeTask的run方法
    }
}
