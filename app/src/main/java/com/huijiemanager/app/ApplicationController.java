package com.huijiemanager.app;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Environment;
//import android.support.v4.app.ae.e;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.TextView;
//import com.android.volley.Request;
// com.android.volley.RequestQueue;
//import com.bugtags.library.Bugtags;
//import com.d.a.a.b.a.h;
//import com.d.a.b.e.a;
//import com.huijiemanager.http.NetworkHelper;
/*
import com.huijiemanager.http.SystemParams;
import com.huijiemanager.http.VolleyImpl;
import com.huijiemanager.http.request.CommonRequest;
import com.huijiemanager.http.request.NewAddressBookRequest;
import com.huijiemanager.http.request.PageRequest;
import com.huijiemanager.http.request.SensorsRequest;
import com.huijiemanager.model.Account;
import com.huijiemanager.ui.activity.ClientDetailActivity;
import com.huijiemanager.ui.activity.PublicDetailActivity;
import com.huijiemanager.ui.activity.SplashActivity;
import com.huijiemanager.ui.activity.WelcomeActivity;
import com.huijiemanager.ui.b.j;
import com.huijiemanager.utils.ag;
import com.huijiemanager.utils.an;
import com.huijiemanager.utils.ao;
import com.huijiemanager.utils.ap;
import com.huijiemanager.utils.k;
import com.huijiemanager.utils.y;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI.AutoTrackEventType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI.DebugMode;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UHandler;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;
import io.rong.imkit.RongIM;

import io.rong.imlib.model.Conversation.ConversationType;
*/
//import io.rong.push.RongPushClient;
import com.huijiemanager.base.b;
import com.huijiemanager.http.NetworkHelper;

import io.rong.imkit.manager.IUnReadMessageObserver;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class ApplicationController
  extends Application
  implements IUnReadMessageObserver
{
  public static String PIC_PATH;
  public static final String TAG = "VolleyPatterns";
  public static String TEMP_PATH;
  public static String access_key_id = "";
  public static String access_key_secret = "";
  public static String content;
  public static ApplicationController instance;
  public static String parentPath = "";
  public static String plat_id;
  public static long timestamp;
  public static String title;
  public static String token = "";
  public static String umengToken = "";
  public static String url;
  public static String version;
  private Dialog mLoadingDialog = null;
//  private PushAgent mPushAgent;
 // private RequestQueue mRequestQueue;
  private String sUid;
  private LayoutParams windowParams = new LayoutParams();
  
  static
  {
    TEMP_PATH = "";
    PIC_PATH = "";
    plat_id = "";
  }

  public void onCountChanged(int paramInt)
  {
  }

  public void sendOrderFitrateRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {}

  public void sendBuyLoanOrderFirstRequest(NetworkHelper<b> paramNetworkHelper, Context paramContext, long paramLong, int paramInt)
  {
   /* HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("order_id", Long.valueOf(paramLong));
    paramContext.put("type", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/pre_buy_order_check.json?ver=3.4.0", localHashMap);*/
  }

  public void sendBuyLoanOrderRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, long paramLong, int paramInt, Integer paramInteger, String paramString)
  {}
  private void addCommonInfo(Map<String, String> paramMap, Context paramContext)
  {
  /*  CommonRequest localCommonRequest = new CommonRequest();
    localCommonRequest.setLocation(com.huijiemanager.utils.g.Q);
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject;
    if (TextUtils.isEmpty(com.huijiemanager.utils.g.Q))
    {
      localObject = "";
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!TextUtils.isEmpty(com.huijiemanager.utils.g.R)) {
        break label504;
      }
      localObject = "";
      label58:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!TextUtils.isEmpty(com.huijiemanager.utils.g.S)) {
        break label511;
      }
      localObject = "";
      label78:
      localStringBuilder = localStringBuilder.append((String)localObject);
      if (!TextUtils.isEmpty(com.huijiemanager.utils.g.T)) {
        break label518;
      }
      localObject = "";
      label98:
      localCommonRequest.setSpecific_address((String)localObject);
      localCommonRequest.setC_id(getChannelId(paramContext));
      localCommonRequest.setD_id(getDeviceId(paramContext));
      localCommonRequest.setP("android");
      localCommonRequest.setTimestemp(System.currentTimeMillis() + "");
      localCommonRequest.setFrom(getPackageName());
      Log.e("from", getPackageName());
      if (!TextUtils.isEmpty(com.huijiemanager.utils.n.a())) {
        localCommonRequest.setD_bd(com.huijiemanager.utils.n.a());
      }
      if (!TextUtils.isEmpty(com.huijiemanager.utils.n.b())) {
        localCommonRequest.setD_ml(com.huijiemanager.utils.n.b());
      }
      if ((TextUtils.isEmpty(com.huijiemanager.utils.g.J + "")) || (com.huijiemanager.utils.g.J == 0.0D) || (com.huijiemanager.utils.g.J == Double.MIN_VALUE)) {
        break label525;
      }
      localCommonRequest.setLat(new BigDecimal(com.huijiemanager.utils.g.J).toString());
      label281:
      if ((TextUtils.isEmpty(com.huijiemanager.utils.g.K + "")) || (com.huijiemanager.utils.g.K == 0.0D) || (com.huijiemanager.utils.g.K == Double.MIN_VALUE)) {
        break label535;
      }
      localCommonRequest.setLng(new BigDecimal(com.huijiemanager.utils.g.K).toString());
    }
    for (;;)
    {
      if (ap.h(paramContext) != null)
      {
        localCommonRequest.setU_id(ap.h(paramContext).getUserId());
        localCommonRequest.setToken(ap.h(paramContext).getToken());
      }
      localObject = new SensorsRequest();
      if (SensorsDataAPI.sharedInstance() != null) {
        ((SensorsRequest)localObject).anonymous_id = SensorsDataAPI.sharedInstance().getAnonymousId();
      }
      ((SensorsRequest)localObject).product = "信贷家";
      ((SensorsRequest)localObject).os_version = Build.VERSION.RELEASE;
      ((SensorsRequest)localObject).screen_height = com.huijiemanager.utils.n.c(paramContext);
      ((SensorsRequest)localObject).screen_width = com.huijiemanager.utils.n.b(paramContext);
      ((SensorsRequest)localObject).wifi = "wifi".equals(com.huijiemanager.utils.n.f(paramContext));
      ((SensorsRequest)localObject).carrier = com.huijiemanager.utils.n.g(paramContext);
      ((SensorsRequest)localObject).network_type = com.huijiemanager.utils.n.f(paramContext);
      ((SensorsRequest)localObject).utm_source = getChannelId(paramContext);
      localCommonRequest.setSensors((SensorsRequest)localObject);
      localCommonRequest.setVer("3.4.0");
      paramMap.put("common_json", localCommonRequest.toString());
      return;
      localObject = com.huijiemanager.utils.g.Q;
      break;
      label504:
      localObject = com.huijiemanager.utils.g.R;
      break label58;
      label511:
      localObject = com.huijiemanager.utils.g.S;
      break label78;
      label518:
      localObject = com.huijiemanager.utils.g.T;
      break label98;
      label525:
      localCommonRequest.setLat("");
      break label281;
      label535:
      localCommonRequest.setLng("");*/
  //  }
  }
  
  public static String getAccess_key_id()
  {
    return access_key_id;
  }
  
  public static String getAccess_key_secret()
  {
    return access_key_secret;
  }
  
  public static long getTimestamp()
  {
    return timestamp;
  }
  
  public static String getToken()
  {
    return token;
  }
  
  private void initBugtags()
  {

    //Bugtags.start("fb89894698c10228161c24044f192f9a", this, 0);
  }
  
  private void initEventBus()
  {
   // org.greenrobot.eventbus.c.b().a(new org.greenrobot.a.a()).a();
  }
  
  private void initImageLoader()
  {
  //  com.d.a.b.e locale = new e.a(this).b(3).a().a(5).b(new com.d.a.a.a.b.c()).a(com.d.a.b.a.g.b).a(480, 800).a(new h()).c();
   // com.d.a.b.d.a().a(locale);
  }
  
  private void initSavePath()
  {
    if ("mounted".equals(Environment.getExternalStorageState())) {}
    for (parentPath = Environment.getExternalStorageDirectory().getPath() + File.separator + getPackageName();; parentPath = getApplicationContext().getFilesDir().getAbsolutePath())
    {
      TEMP_PATH = parentPath + "/tmp";
      PIC_PATH = parentPath + "/.pic";
      new File(TEMP_PATH).mkdirs();
      new File(PIC_PATH).mkdirs();
      return;
    }
  }
  
  private void initSensorsData()
  {
    /*SensorsDataAPI.sharedInstance(this, "https://sensordataprod.huijieapp.com:8016/sa?project=production", "https://sensordataprod.huijieapp.com:8016/config/?project=production", SensorsDataAPI.DebugMode.DEBUG_OFF);
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("app_name", "com.huijiemanager");
      ((JSONObject)localObject).put("product_name", "信贷家");
      ((JSONObject)localObject).put("platform_type", "android");
      ((JSONObject)localObject).put("channel", getChannelId(this));
      SensorsDataAPI.sharedInstance(this).registerSuperProperties((JSONObject)localObject);
      localObject = new ArrayList();
      ((List)localObject).add(SensorsDataAPI.AutoTrackEventType.APP_START);
      ((List)localObject).add(SensorsDataAPI.AutoTrackEventType.APP_END);
      ((List)localObject).add(SensorsDataAPI.AutoTrackEventType.APP_VIEW_SCREEN);
      ((List)localObject).add(SensorsDataAPI.AutoTrackEventType.APP_CLICK);
      SensorsDataAPI.sharedInstance(this).enableAutoTrack((List)localObject);
    }
    catch (JSONException localJSONException)
    {
      try
      {
        Object localObject = new Date();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("first_use_time", localObject);
        SensorsDataAPI.sharedInstance(this).trackInstallation("app_install", localJSONObject);
        k.a();
        return;
        localJSONException = localJSONException;
        com.google.a.a.a.a.a.a.b(localJSONException);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          com.google.a.a.a.a.a.a.b(localException);
        }
      }
    }*/
  }
  
  private void initUmengPush()
  {
   /* UMConfigure.init(this, 1, "1d7780c9922262b7bf9ab45073ba7982");
    this.mPushAgent = PushAgent.getInstance(this);
    this.mPushAgent.setNotificaitonOnForeground(true);
    this.mPushAgent.register(new IUmengRegisterCallback()
    {
      public void onFailure(String paramAnonymousString1, String paramAnonymousString2)
      {
        Log.e("Token", paramAnonymousString1 + paramAnonymousString2);
      }
      
      public void onSuccess(String paramAnonymousString)
      {
        ApplicationController.umengToken = paramAnonymousString;
        org.greenrobot.eventbus.c.a().d(new com.huijiemanager.ui.c.d());
        Log.e("Token", ApplicationController.umengToken);
      }
    });
    Object localObject = new UmengMessageHandler()
    {
      public Notification getNotification(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
      {
        Map localMap = paramAnonymousUMessage.extra;
        if ((localMap != null) && (!localMap.isEmpty()) && (!TextUtils.isEmpty((CharSequence)localMap.get("msg_type"))))
        {
          int i = Integer.parseInt((String)localMap.get("msg_type"));
          if ((i != 0) && (((4 == Integer.parseInt((String)localMap.get("msg_event"))) && (ap.h(ApplicationController.instance) != null)) || (!j.a.status.equals(ap.h(ApplicationController.instance).getCredit_manager_status())))) {
            k.a(ApplicationController.instance, "gcjl_tjt", "监听到信贷经理收到新的借条用户消息对应的推送通知");
          }
          if ((i == 0) && (a.a()))
          {
            Activity localActivity = b.a().b();
            if (((localActivity instanceof SplashActivity)) || ((localActivity instanceof WelcomeActivity))) {}
            for (;;)
            {
              return super.getNotification(paramAnonymousContext, paramAnonymousUMessage);
              localActivity.runOnUiThread(new ApplicationController.2.1(this, localActivity, localMap));
            }
          }
          return new ae.e(ApplicationController.this).a(2130838462).a(paramAnonymousUMessage.title).b(paramAnonymousUMessage.text).a(BitmapFactory.decodeResource(ApplicationController.this.getResources(), 2130838081)).f(true).c();
        }
        return super.getNotification(paramAnonymousContext, paramAnonymousUMessage);
      }
    };
    this.mPushAgent.setMessageHandler((UHandler)localObject);
    localObject = new UmengNotificationClickHandler()
    {
      public void launchApp(Context paramAnonymousContext, UMessage paramAnonymousUMessage)
      {
        ao.a(paramAnonymousContext, paramAnonymousUMessage, ApplicationController.this);
      }
    };
    this.mPushAgent.setNotificationClickHandler((UHandler)localObject);
    RongPushClient.registerMiPush(this, "2882303761517525740", "5901752565740");
    RongIM.init(this);
    RongIM.getInstance().addUnReadMessageCountChangedObserver(this, new Conversation.ConversationType[] { Conversation.ConversationType.PRIVATE });
    UMShareAPI.get(this);
    PlatformConfig.setWeixin("wx507b20069912aaa3", "53c17204ad1529e6cd83506151aaa279");
    PlatformConfig.setQQZone("1105748939", "QF5OD3LHbV42YCaQ");
    PlatformConfig.setSinaWeibo("757284912", "f8121ae646915214224cd1903f67fc46", "http://sns.whalecloud.com");*/
  }
  
  private boolean isExistDataCache(String paramString)
  {
    boolean bool = false;
    if (getFileStreamPath(paramString).exists()) {
      bool = true;
    }
    return bool;
  }
  
  public static void setAccess_key_id(String paramString)
  {
    access_key_id = paramString;
  }
  
  public static void setAccess_key_secret(String paramString)
  {
    access_key_secret = paramString;
  }
  
  public static void setTimestamp(long paramLong)
  {
    timestamp = paramLong;
  }
  
  public static void setToken(String paramString)
  {
    token = paramString;
  }
  
  private void showProgess(int paramInt, boolean paramBoolean, Context paramContext)
  {
   // this.mLoadingDialog = an.a(paramInt, paramContext, paramBoolean);
    this.mLoadingDialog.show();
  }
  
 /* public void OssToken(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    paramNetworkHelper.sendRequest("util/get_oss_token.json?ver=3.4.0", localHashMap);
  }*/
  
 /* public void addRemind(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramMap));
    paramNetworkHelper.sendRequest("crm/customer_remind.json?ver=3.4.0", localHashMap);
  }*/
  
 /* public <T> void addToRequestQueue(Request<T> paramRequest)
  {
    paramRequest.setTag("VolleyPatterns");
    getRequestQueue().add(paramRequest);
  }*/
  
 /* public void addTrack(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramMap));
    paramNetworkHelper.sendRequest("crm/add_track.json?ver=3.4.0", localHashMap);
  }*/
  
  protected void attachBaseContext(Context paramContext)
  {
    super.attachBaseContext(paramContext);
   // android.support.multidex.b.a(this);
  }
  
  public void cancelPendingRequests(Object paramObject)
  {
  /*  if (this.mRequestQueue != null) {
      this.mRequestQueue.cancelAll(paramObject);
    }*/
  }
  
 /* public void certificateSubmit(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramMap));
    paramNetworkHelper.sendRequest("loanManagerNew/certificate_submit.json?ver=3.4.0", localHashMap);
  }*/
  
 /* public void checkOrderBeforeBuy(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("action_type", paramString);
    paramContext.put("order_id", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManagerNew/check_order_before_buy.json?ver=3.4.0", localHashMap);
  }*/
  
  /*public void createFeedback(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString)
  {
   *//* HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.put("feedbackDesc", paramString);
    }
    paramContext.put("orderId", Integer.valueOf(paramInt1));
    paramContext.put("feedbackId", Integer.valueOf(paramInt2));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/createFeedbackApi.json?ver=3.4.0", localHashMap);*//*
  }*/
  
  public void dismissProgess()
  {
    if ((this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing()))
    {
      this.mLoadingDialog.dismiss();
      this.mLoadingDialog.cancel();
    }
  }
  
/*  public void getBusinessCard(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("loanManager/get_name_card_info_for_client.json?ver=3.4.0", localHashMap);
  }*/
  
/*  public void getCertificateInfo(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
  //  paramNetworkHelper.sendRequest("loanManagerNew/get_apply_record.json?ver=3.4.0", localHashMap);
  }
  */
  public String getChannelId(Context paramContext)
  {
    return "";
  /*  try
    {
    //  paramContext = paramContext.getPackageManager().getApplicationInfo(paramContext.getPackageName(), 128);
      if (paramContext == null) {
        return "normal";
      }
    }
    catch (Exception paramContext)
    {
      for (;;)
      {
        com.google.a.a.a.a.a.a.b(paramContext);
        paramContext = null;
      }
    }
    return paramContext.metaData.getString("UMENG_CHANNEL");*/
  }
  
 /* public void getClientDetails(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("date_sort", paramString1);
    paramContext.put("query_message", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("crm/get_customer_list.json?ver=3.4.0", localHashMap);
  }*/
  
 /* public void getClientScreen(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("crm/get_screening_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void getCompanyCode(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_company_code.json?ver=3.4.0", localHashMap);
  }
  
  public void getCouponList(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("status", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("coupon/get_coupon_list.json?ver=3.4.0", localHashMap);
  }
  
  public void getCreditListRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("type", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("credit/get_credit_info.json?ver=3.4.0", localHashMap);
  }
  
  public void getCreditZhiMaDetailRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("userId", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/get_zhima_score.json?ver=3.4.0", localHashMap);
  }
  
  public void getCustomerDetail(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("crm/customer_detailed_info.json?ver=3.4.0", localHashMap);
  }
  
  public String getDeviceId(Context paramContext)
  {
    if (!TextUtils.isEmpty(this.sUid)) {
      paramContext = this.sUid;
    }
    for (;;)
    {
      return paramContext;
      this.sUid = ag.c();
      if (!TextUtils.isEmpty(this.sUid)) {
        return this.sUid;
      }
      try
      {
        paramContext = (TelephonyManager)paramContext.getSystemService("phone");
        if (paramContext != null)
        {
          this.sUid = paramContext.getDeviceId();
          if (!TextUtils.isEmpty(this.sUid))
          {
            ag.a(this.sUid);
            String str = this.sUid;
            paramContext = str;
            return str;
          }
        }
      }
      catch (Exception paramContext)
      {
        for (;;)
        {
          y.a("getDeviceId", paramContext.getMessage());
          if (TextUtils.isEmpty(this.sUid))
          {
            this.sUid = UUID.randomUUID().toString();
            ag.a(this.sUid);
          }
        }
      }
      finally
      {
        if (!TextUtils.isEmpty(this.sUid)) {
          break label216;
        }
        this.sUid = UUID.randomUUID().toString();
        ag.a(this.sUid);
      }
    }
    return this.sUid;
  }
  
  public void getDiscountRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("coupon/get_can_use_count.json?ver=3.4.0", localHashMap);
  }
  
  public void getDiscountTitleRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("coupon/get_coupon_stat.json?ver=3.4.0", localHashMap);
  }
  
  public void getFaceRecognitionRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id_card_name", paramString1);
    paramContext.put("id_card_no", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit_new/get_face_credit_param.json?ver=3.4.0", localHashMap);
  }
  
  public void getFaceRecognitionStatus(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("credit_new/need_face.json?ver=3.4.0", localHashMap);
  }
  
  public void getFeedbackEntry(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManager/createFeedbackEntryApi.json?ver=3.4.0", localHashMap);
  }
  
  public void getFollowRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/find_order_track_list.json?ver=3.4.0", localHashMap);
  }
  
  public void getIsChat(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("msg/if_can_chat.json?ver=3.4.0", localHashMap);
  }
  
  public void getListFilter(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("loanPlatform/find_filters.json?ver=3.4.0", localHashMap);
  }
  
  public String getMD5(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        localObject = MessageDigest.getInstance("MD5");
        ((MessageDigest)localObject).update(paramString.getBytes("UTF-8"));
        paramString = ((MessageDigest)localObject).digest();
        localObject = new StringBuffer();
        i = 0;
        if (i < paramString.length) {
          if (Integer.toHexString(paramString[i] & 0xFF).length() == 1) {
            ((StringBuffer)localObject).append("0").append(Integer.toHexString(paramString[i] & 0xFF));
          } else {
            ((StringBuffer)localObject).append(Integer.toHexString(paramString[i] & 0xFF));
          }
        }
      }
      catch (NoSuchAlgorithmException paramString)
      {
        Object localObject;
        return "";
        paramString = ((StringBuffer)localObject).toString();
        return paramString;
      }
      catch (UnsupportedEncodingException paramString)
      {
        return "";
      }
      i += 1;
    }
  }
  
  public void getManagerDetailRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("type", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/get_apply_detail.json?ver=3.4.0", localHashMap);
  }
  
  public void getManagerSubmitRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("type", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/submit_apply.json?ver=3.4.0", localHashMap);
  }
  
  public void getPartList(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("loanPlatform/find_identities.json?ver=3.4.0", localHashMap);
  }
  
  public void getPayOrderInfo(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("goods_id", paramString1);
    paramContext.put("coupon_id", paramString3);
    paramContext.put("order_type", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("pay/get_pay_order_info_new.json?ver=3.4.0", localHashMap);
  }
  
  public void getPhotoIsShowStatus(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id_card_name", paramString1);
    paramContext.put("id_card_no", paramString2);
    paramContext.put("mobile", paramString3);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit_new/need_attach_photo.json?ver=3.4.0", localHashMap);
  }
  
  public void getQRCode(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("invitation/get_qr_code_param.json?ver=3.4.0", localHashMap);
  }
  
  public void getRepaymentDetails(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/find_repay_schedule_list.json?ver=3.4.0", localHashMap);
  }
  
  public void getRepaymentIn(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("loanPlatform/create_repay_schedule_entry.json?ver=3.4.0", localHashMap);
  }
  
  public RequestQueue getRequestQueue()
  {
    if (this.mRequestQueue == null) {
      this.mRequestQueue = VolleyImpl.newRequestQueue(getApplicationContext(), null, false, -1);
    }
    return this.mRequestQueue;
  }
  
  public void getScreenPic(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("screen/getLoadingScreenAdvertisingApi.json?ver=3.4.0", localHashMap);
  }
  
  public void getTags(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("crm/get_tags.json?ver=3.4.0", localHashMap);
  }
  
  public LayoutParams getWindowParams()
  {
    return this.windowParams;
  }
  
  public void getZhiMaAuthorize(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    if (!paramString.equals(""))
    {
      paramContext.put("payTxId", paramString);
      localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    }
    for (;;)
    {
      paramNetworkHelper.sendBlockRequest("credit/get_zhima_auth_params.json?ver=3.4.0", localHashMap);
      return;
      localHashMap.put("data_json", new JSONObject().toString());
    }
  }
  
  public void getZhiMaParams(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id_card_name", paramString1);
    paramContext.put("id_card", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("credit/get_zhima_auth_params.json?ver=3.4.0", localHashMap);
  }
  
  public void getZhiMaScore(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("params", paramString1);
    paramContext.put("sign", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/auth_callback_zhima.json?ver=3.4.0", localHashMap);
  }
  

  
  public void onCreate()
  {
    super.onCreate();
    instance = this;
    initEventBus();
    initSensorsData();
    initBugtags();
    Object localObject = new com.huijiemanager.model.dao.e(this);
    try
    {
      ((com.huijiemanager.model.dao.e)localObject).a();
      initSavePath();
      localObject = new Intent();
      ((Intent)localObject).setAction("com.huijiemanager.GaodeLocationService");
      ((Intent)localObject).setPackage(getPackageName());
      startService((Intent)localObject);
      initImageLoader();
      initUmengPush();
      registerActivityLifecycleCallbacks(new a());
      if (ag.v(this) == 0L) {
        ag.a(this, Long.valueOf(System.currentTimeMillis()));
      }
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        com.google.a.a.a.a.a.a.b(localIOException);
      }
    }
  }
  
  public void privateCallBind(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap1 = new HashMap();
    addCommonInfo(localHashMap1, paramContext);
    HashMap localHashMap2 = new HashMap();
    if ((paramContext instanceof ClientDetailActivity)) {
      localHashMap2.put("customer_id", paramString);
    }
    if ((paramContext instanceof PublicDetailActivity)) {
      localHashMap2.put("loan_order_id", paramString);
    }
    localHashMap1.put("data_json", com.alibaba.a.a.a(localHashMap2));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/private_call_bind.json?ver=3.4.0", localHashMap1);
  }
  
  public void searchOrganization(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("city", paramString1);
    paramContext.put("type", paramString2);
    paramContext.put("words", paramString3);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManagerNew/search_by_organization.json?ver=3.4.0", localHashMap);
  }
  
  public void sendAddBlackList(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("friend/add_blacklist.json?ver=3.4.0", localHashMap);
  }
  
  public void sendAddressBookRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, List<NewAddressBookRequest> paramList)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramList));
    paramNetworkHelper.sendRequest("friend/create_addr_book.json?ver=3.4.0", localHashMap);
  }
  
  public void sendApplyPlatDetailRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/get_loan_apply_record_detail.json?ver=3.4.0", localHashMap);
  }
  
  public void sendBindDeviceTokenRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("device_token", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("sysMsg/bind_device_token.json?ver=3.4.0", localHashMap);
  }
  
  public void sendBindMobileRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      HashMap localHashMap1 = new HashMap();
      HashMap localHashMap2 = new HashMap();
      addCommonInfo(localHashMap1, paramContext);
      localHashMap2.put("mobile", paramString1);
      localHashMap2.put("param0", ap.b(paramString2));
      localHashMap2.put("login_type", "2");
      localHashMap2.put("account", paramString3);
      localHashMap2.put("access_token", paramString4);
      localHashMap2.put("open_id", paramString5);
      localHashMap1.put("data_json", ap.a(localHashMap2, SystemParams.REGISTER_KEY));
      paramNetworkHelper.sendBlockRequest("register.json?ver=3.4.0", localHashMap1);
      return;
    }
    catch (Exception paramNetworkHelper)
    {
      an.a(this, 1, paramNetworkHelper.toString());
    }
  }
  
  public void sendBuriedPointRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("url", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("data/create_buried_point.json?ver=3.4.0", localHashMap);
  }
  
  public void sendBuyLoanOrderFirstRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, long paramLong, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("order_id", Long.valueOf(paramLong));
    paramContext.put("type", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/pre_buy_order_check.json?ver=3.4.0", localHashMap);
  }
  
  public void sendBuyLoanOrderRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, long paramLong, int paramInt, Integer paramInteger, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramLong + "");
    if (paramInteger != null) {
      paramContext.put("operationActivityId", paramInteger);
    }
    paramContext.put("coupon_id", paramString);
    paramContext.put("type", paramInt + "");
    localHashMap.put("data_json", ap.a(paramContext, SystemParams.HOME_ORDER_BUY));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/buyLoanOrderDecryptApi.json?ver=3.4.0", localHashMap);
  }
  
  public void sendChannalList(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("goods_id", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("coupon/get_coupon_list_can_use.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCityRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("orderCity", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/submit_loan_manager_order_filter_city_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void sendConsumptionRecordRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("page_json", new PageRequest(paramInt1, paramInt2).toString());
    paramNetworkHelper.sendRequest("pay/find_loan_coin_history.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreateApplyRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("lp_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/create_loan_apply_record.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreatePublicIourRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("reason", paramString1);
    paramContext.put("desc", paramString7);
    paramContext.put("money", paramString2);
    paramContext.put("time_limit", paramString3);
    paramContext.put("province", paramString4);
    paramContext.put("city", paramString5);
    paramContext.put("district", paramString6);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanOrder/create_public_loan_order.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreditImageRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("value", paramString2);
    paramContext.put("type", paramString1);
    paramContext.put("pics", paramList.toArray(new String[0]));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/submit_user_credit_data.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreditManager(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("type", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManager/get_apply_data.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreditManagerRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("friend/find_blacklist.json?ver=3.4.0", localHashMap);
  }
  
  public void sendCreditManagersRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, List<String> paramList)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("value", paramString2);
    paramContext.put("type", paramString1);
    paramContext.put("pics", paramList.toArray(new String[0]));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/modify_apply_detail.json?ver=3.4.0", localHashMap);
  }
  
  public void sendDetailShow(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString1);
    paramContext.put("order_id", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("msg/get_chat_detail.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindBillsPagerequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    try
    {
      paramContext = new JSONObject();
      paramContext.put("start_date", "");
      paramContext.put("end_date", "");
      paramContext.put("bill_status", paramInt1);
      localHashMap.put("data_json", paramContext.toString());
      paramContext = new JSONObject();
      paramContext.put("start_row", paramInt2);
      paramContext.put("page_size", paramInt3);
      localHashMap.put("page_json", paramContext.toString());
      if (paramBoolean)
      {
        paramNetworkHelper.sendBlockRequest("bill/find_bills.json?ver=3.4.0", localHashMap);
        return;
      }
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        com.google.a.a.a.a.a.a.b(paramContext);
      }
      paramNetworkHelper.sendRequest("bill/find_bills.json?ver=3.4.0", localHashMap);
    }
  }
  
  public void sendFindNearbyRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("lng", paramString1);
    paramContext.put("lat", paramString2);
    paramContext.put("type", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/find_nearby.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindOtherRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("user/get_other_user_info.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindPaidGoodsHistoryRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("type", Integer.valueOf(paramInt3));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    if (paramBoolean)
    {
      paramNetworkHelper.sendBlockRequest("pay/find_goods_history.json?ver=3.4.0", localHashMap);
      return;
    }
    paramNetworkHelper.sendRequest("pay/find_goods_history.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindPaidGoodsListRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("type", Integer.valueOf(paramInt3));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    if (paramBoolean)
    {
      paramNetworkHelper.sendBlockRequest("pay/find_goods.json?ver=3.4.0", localHashMap);
      return;
    }
    paramNetworkHelper.sendRequest("pay/find_goods.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindPaidOrderFilteredRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("tab", paramString1);
    if (!TextUtils.isEmpty(paramString2)) {
      paramContext.put("id", paramString2);
    }
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/find_paid_order_filtered.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFindTrackFiltersRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    paramNetworkHelper.sendRequest("loanManager/find_track_filters.json?ver=3.4.0", localHashMap);
  }
  
  public void sendForgetPasswordRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("param4", ap.b(paramString1));
    paramContext.put("param2", ap.b(paramString2).substring(1, 31));
    paramContext.put("param3", ap.b(paramString3).substring(1, 31));
    paramContext.put("mobile", paramString4);
    localHashMap.put("data_json", ap.a(paramContext, SystemParams.FORGET_KEY));
    paramNetworkHelper.sendRequest("user/modify_pwd_reset.json?ver=3.4.0", localHashMap);
  }
  
  public void sendFriendOptRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new JSONObject();
    try
    {
      paramContext.put("friend_user_id", paramString1);
      paramContext.put("opt_type", paramString2);
      paramContext.put("source", paramString3);
      paramContext.put("record_id", paramString4);
      localHashMap.put("data_json", paramContext.toString());
      paramNetworkHelper.sendBlockRequest("friend/modify_opt.json?ver=3.4.0", localHashMap);
      return;
    }
    catch (JSONException paramContext)
    {
      for (;;)
      {
        com.google.a.a.a.a.a.a.b(paramContext);
      }
    }
  }
  
  public void sendGetLoanOrderDetailNewRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", "{\"id\":" + paramString + "}");
    paramNetworkHelper.sendBlockRequest("loanOrder/get_loan_order_detail_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetManageCollectRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", "{\"id\":" + paramString + "}");
    paramNetworkHelper.sendBlockRequest("loanOrder/manager_collect.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetManagerLoanOrderDetailNewRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", ap.a(paramContext, SystemParams.HOME_ORDER_DETAIL));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/getLoanOrderDetailDecryptApi.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetPayOrderRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("orderType", paramString1);
    paramContext.put("objectId", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("pay/get_pay_order.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetPresentConfig(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("overtIou/get_present_config.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetServiceStatusRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    if (paramBoolean)
    {
      paramNetworkHelper.sendBlockRequest("loanManager/get_service_status.json?ver=3.4.0", localHashMap);
      return;
    }
    paramNetworkHelper.sendRequest("loanManager/get_service_status.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetStaticContentBRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    paramNetworkHelper.sendRequest("sys/find_daily_activities_b.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetSysMsgRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("page_json", new PageRequest(paramInt1, paramInt2).toString());
    localHashMap.put("data_json", "{\"type\":" + paramString + "}");
    paramNetworkHelper.sendBlockRequest("sysMsg/find_sys_msgs.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetTimeStampRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("current_timestamp.json?ver=3.4.0", localHashMap);
  }
  
  public void sendGetVerificationRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("mobile", paramString);
    paramContext.put("login_type", "2");
    paramContext.put("type", "3");
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("get_verification_code.json?ver=3.4.0", localHashMap);
  }
  
  public void sendHomeFiltrate(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_loan_manager_order_filter_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void sendHuiJieMoneyRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("pay/find_goods_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendJudgeAuthPay(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    paramNetworkHelper.sendBlockRequest("credit/judge_auth_way.json?ver=3.4.0", localHashMap);
  }
  
  public void sendLoanManagePublicIousRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, int paramInt1, int paramInt2, int paramInt3, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt2));
    paramContext.put("page_size", Integer.valueOf(paramInt1));
    if (!paramString1.equals("")) {
      paramContext.put("last_record_id", paramString1);
    }
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = paramString2;
    if (!TextUtils.isEmpty(paramString2))
    {
      paramContext = paramString2;
      if (!paramString2.contains("全国"))
      {
        paramContext = paramString2;
        if (!paramString2.contains("自治州"))
        {
          paramContext = paramString2;
          if (!paramString2.contains("地区"))
          {
            paramContext = paramString2;
            if (!paramString2.contains("盟"))
            {
              paramContext = paramString2;
              if (!paramString2.contains("市")) {
                paramContext = paramString2 + "市";
              }
            }
          }
        }
      }
    }
    localHashMap.put("data_json", "{\"type\":" + paramInt3 + ",\"city\":\"" + paramContext + "\"}");
    paramNetworkHelper.sendRequest("loanManager/find_square_loan_order_list.json?ver=3.4.0", localHashMap);
  }
  
  public void sendLoginInRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("account", paramString1);
    paramContext.put("login_type", paramString2);
    paramContext.put("param2", ap.b(paramString3).substring(1, 31));
    paramContext.put("code", ap.b(paramString4));
    localHashMap.put("data_json", ap.a(paramContext, SystemParams.LOGIN_KEY));
    paramNetworkHelper.sendBlockRequest("login_in.json?ver=3.4.0", localHashMap);
  }
  
  public void sendLoginOutRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("login_out.json?ver=3.4.0", localHashMap);
  }
  
  public void sendManagerStatusRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("need_ext", Boolean.valueOf(true));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManagerNew/get_manager_service.json?ver=3.4.0", localHashMap);
  }
  
  public void sendMarkOrder(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    paramContext.put("marked", Boolean.valueOf(paramBoolean));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/mark_order.json?ver=3.4.0", localHashMap);
  }
  
  public void sendMarqueeRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_action_tip.json?ver=3.4.0", localHashMap);
  }
  
  public void sendMineRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_statistic_info.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModificationNewPhone(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("mobile", paramString1);
    paramContext.put("ticket", paramString2);
    paramContext.put("veri_code", ap.b(paramString3));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("confirm_change_bind_mobile.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModificationPhone(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("veri_code", ap.b(paramString));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("apply_change_bind_mobile.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyApplyStatusRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString2);
    paramContext.put("apply_status", paramString1);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/modify_loan_apply_record_status.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyMsgReadRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", "{\"id\":" + paramString1 + ",\"type\":" + paramString2 + "}");
    paramNetworkHelper.sendRequest("sysMsg/modify_msg_flag.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyMsgRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", "{\"type\":" + paramString + "}");
    paramNetworkHelper.sendRequest("sysMsg/modify_all_msg_finished.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyPushRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Boolean paramBoolean, String paramString1, String paramString2, String paramString3, List<com.alibaba.a.e> paramList)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("if_push", paramBoolean);
    paramContext.put("cities", paramString3);
    paramContext.put("push_end_hour", paramString1);
    paramContext.put("push_start_hour", paramString2);
    paramContext.put("tags", paramList);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/modify_push_config.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyPushSettingsRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("if_push", paramString1);
    paramContext.put("city", paramString2);
    paramContext.put("type", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    if (paramBoolean)
    {
      paramNetworkHelper.sendBlockRequest("loanManager/modify_push_settings.json?ver=3.4.0", localHashMap);
      return;
    }
    paramNetworkHelper.sendRequest("loanManager/modify_push_settings.json?ver=3.4.0", localHashMap);
  }
  
  public void sendModifyRepaySchedule(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/modify_repay_schedule.json?ver=3.4.0", localHashMap);
  }
  
  public void sendMsgCountRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("sysMsg/get_unfinish_msg_count.json?ver=3.4.0", localHashMap);
  }
  
  public void sendNewCreatePublicIourRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("reason", paramString1);
    paramContext.put("desc", paramString7);
    paramContext.put("money", paramString2);
    paramContext.put("time_limit", paramString3);
    paramContext.put("province", paramString4);
    paramContext.put("city", paramString5);
    paramContext.put("district", paramString6);
    paramContext.put("id_card_name", paramString8);
    paramContext.put("id_card", paramString9);
    paramContext.put("user_info", paramMap);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanOrder/create_public_loan_order_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendNewGetZhiMaAuth(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    if (!TextUtils.isEmpty(paramString1)) {
      paramContext.put("payTxId", paramString1);
    }
    paramContext.put("id_card", paramString3);
    paramContext.put("id_card_name", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("credit/get_zhima_auth_params_by_idcard.json?ver=3.4.0", localHashMap);
  }
  
  public void sendNewShiming(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id_card_name", paramString1);
    paramContext.put("id_card", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/verify_udcredit.json?ver=3.4.0", localHashMap);
  }
  
  public void sendNewTrackRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManager/create_track_entry.json?ver=3.4.0", localHashMap);
  }
  
  public void sendOrderFitrateRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, int paramInt1, int paramInt2, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("tags", paramString1);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt2));
    paramContext.put("page_size", Integer.valueOf(paramInt1));
    if (!paramString2.equals("")) {
      paramContext.put("last_record_id", paramString2);
    }
    if (!"".equals(paramString3)) {
      paramContext.put("last_record_time", paramString3);
    }
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManagerNew/submit_loan_manager_order_filter_request.json?ver=3.4.0", localHashMap);
  }
  
  public void sendOrderTagsRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_loan_manager_order_type_list.json?ver=3.4.0", localHashMap);
  }
  
  public void sendOtherInforDetail(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("userId", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/get_credit_info_loan.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPayForGoodsAlipay(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("pay_tx_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("pay/pay_for_goods_alipay_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPayForGoodsWeiXin(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("pay_tx_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("pay/pay_for_goods_weixin_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPlanFromApplyRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("last_record_id", paramString);
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("type", Integer.valueOf(paramInt3));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanPlatform/find_loan_apply_records.json?ver=3.4.0", localHashMap);
  }
  
  public void sendProfile(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("user/get_simple_info.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPublicConfigRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendBlockRequest("loanOrder/create_public_loan_order_entry.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPublicIouModifyUpDownRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, int paramInt1, int paramInt2, Context paramContext)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString1);
    paramContext.put("create_user_id", paramString2);
    if (paramInt2 == 1) {
      paramContext.put("pres_code", Integer.valueOf(paramInt1));
    }
    paramContext.put("operate_type", Integer.valueOf(paramInt2));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("overtIou/modify_up_down.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPushCity(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_loan_manager_order_filter_city_condition_and_condition_number.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPushConfigRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/get_loan_manager_order_push_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void sendPushDetailRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("pushConditionKey", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/get_loan_manager_order_push_condition_detail.json?ver=3.4.0", localHashMap);
  }
  
  public void sendQuanRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("coupon_id", paramString1);
    paramContext.put("goods_id", paramString2);
    paramContext.put("order_id", paramString3);
    paramContext.put("action_type", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("coupon/check_can_use_goods_user.json?ver=3.4.0", localHashMap);
  }
  
  public void sendReVerificationBeforeRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("mobile", paramString3);
    paramContext.put("login_type", paramString1);
    paramContext.put("object_id", paramString2);
    paramContext.put("data", paramString5);
    paramContext.put("type", paramString4);
    paramContext.put("ext_data", paramString6);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("get_verification_code.json?ver=3.4.0", localHashMap);
  }
  
  public void sendReVerificationVRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    try
    {
      paramContext = com.alibaba.a.a.b((String)localHashMap.get("common_json"));
      paramContext.a("timestamp", paramString7);
      localHashMap.put("common_json", com.alibaba.a.a.a(paramContext));
      paramContext = new SecretKeySpec(getMD5(com.alibaba.a.a.a(paramContext)).getBytes(), "HmacSHA256");
      paramString7 = Mac.getInstance("HmacSHA256");
      paramString7.init(paramContext);
      paramContext = new BigInteger(1, paramString7.doFinal(paramString3.getBytes())).toString(16);
      paramString7 = new HashMap();
      paramString7.put("mobile", paramString3);
      paramString7.put("login_type", paramString1);
      paramString7.put("object_id", paramString2);
      paramString7.put("data", paramString5);
      paramString7.put("type", paramString4);
      paramString7.put("sign", paramContext);
      paramString7.put("ext_data", paramString6);
      localHashMap.put("data_json", com.alibaba.a.a.a(paramString7));
      paramNetworkHelper.sendBlockRequest("get_verification_code_v2.json?ver=3.4.0", localHashMap);
      return;
    }
    catch (Exception paramNetworkHelper)
    {
      com.google.a.a.a.a.a.a.b(paramNetworkHelper);
    }
  }
  
  public void sendRechargeRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramNetworkHelper.sendRequest("loanManagerNew/query_recharge_status.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRecommandLoanPlatform(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("amount", paramString1);
    paramContext.put("identity", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanPlatform/find_platforms_new.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRemarkName(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString1);
    paramContext.put("note_name", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("friend/modify_note_name.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRemoveBlackList(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("u_id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("friend/remove_blacklist.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRepayment(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString1);
    paramContext.put("amount", paramString2);
    paramContext.put("period", paramString3);
    paramContext.put("pay_day", paramString4);
    paramContext.put("period_amount", paramString5);
    paramContext.put("period_code", Integer.valueOf(paramInt));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanPlatform/create_repay_schedule.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRepaymentDetailsClear(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanPlatform/clear_repay_schedule.json?ver=3.4.0", localHashMap);
  }
  
  public void sendRepaymentPush(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("if_push_schedule", Boolean.valueOf(paramBoolean));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanPlatform/modify_repay_schedule_push_setting.json?ver=3.4.0", localHashMap);
  }
  
  public void sendReviceHeadNick(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("new_head_pic", paramString);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendBlockRequest("loanManagerNew/update_head_pic.json?ver=3.4.0", localHashMap);
  }
  
  public void sendSingleRequest(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("conditionDetailKey", paramString1);
    paramContext.put("conditionDetailValue", paramString2);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManagerNew/submit_single_loan_manager_order_push_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void sendTrackDetails(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString, int paramInt, List<com.alibaba.a.e> paramList)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("id", paramString);
    paramContext.put("type", Integer.valueOf(paramInt));
    paramContext.put("args", paramList);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanManager/create_track.json?ver=3.4.0", localHashMap);
  }
  
  public void sendUpFiltrate(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramMap));
    paramNetworkHelper.sendRequest("loanManagerNew/submit_loan_manager_order_filter_condition.json?ver=3.4.0", localHashMap);
  }
  
  public void sendUserInfor(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", new JSONObject().toString());
    paramNetworkHelper.sendRequest("user/get_user_info.json?ver=3.4.0", localHashMap);
  }
  
  public void sendVerfity(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("clientType", paramString1);
    paramContext.put("captchaType", paramString2);
    paramContext.put("disturbLevel", paramString3);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("web/get_qcloud_captcha.json?ver=3.4.0", localHashMap);
  }
  
  public void sendWashOrderRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, int paramInt1, int paramInt2, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    if (!TextUtils.isEmpty(paramString)) {
      paramContext.put("packsId", paramString);
    }
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramContext = new HashMap();
    paramContext.put("start_row", Integer.valueOf(paramInt1));
    paramContext.put("page_size", Integer.valueOf(paramInt2));
    localHashMap.put("page_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("loanPacksOrderApi/getMyPacksOrderListApi.json?ver=3.4.0", localHashMap);
  }
  
  public void sendWeChatToken(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("appid", SystemParams.WECHAT_APPID);
    localHashMap.put("secret", SystemParams.WECHAT_APP_SECRET);
    localHashMap.put("code", paramString);
    localHashMap.put("grant_type", "authorization_code");
    paramNetworkHelper.sendRequest("https://api.weixin.qq.com/sns/oauth2/access_token", localHashMap);
  }
  
  public void sendWeChatUserInfo(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("access_token", paramString1);
    localHashMap.put("openid", paramString2);
    paramNetworkHelper.sendRequest("https://api.weixin.qq.com/sns/userinfo", localHashMap);
  }
  
  public void sendZhiMaAuthentication(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, boolean paramBoolean, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("bizNo", paramString1);
    paramContext.put("merchantID", paramString2);
    paramContext.put("zhimaCertifiType", paramString3);
    paramContext.put("isPassed", Boolean.valueOf(paramBoolean));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/postZhimaCertificationResultApi.json?ver=3.4.0", localHashMap);
  }
  
  public void sendbindIden(NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    addCommonInfo(localHashMap1, paramContext);
    localHashMap2.put("account", paramString1);
    localHashMap2.put("login_type", "2");
    localHashMap2.put("open_id", paramString2);
    localHashMap2.put("access_token", paramString3);
    localHashMap1.put("data_json", ap.a(localHashMap2, SystemParams.LOGIN_KEY));
    paramNetworkHelper.sendBlockRequest("login_in.json?ver=3.4.0", localHashMap1);
  }
  
  public void sendmodifyPasswordRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("param0", ap.b(paramString1).substring(1, 31));
    paramContext.put("param2", ap.b(paramString2).substring(1, 31));
    paramContext.put("param3", ap.b(paramString3).substring(1, 31));
    localHashMap.put("data_json", ap.a(paramContext, SystemParams.MODIFY_KEY));
    paramNetworkHelper.sendRequest("user/modify_pwd.json?ver=3.4.0", localHashMap);
  }
  
  public void sendzhiMaCreditImageRequest(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, List<String> paramList, String paramString)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    paramContext = new HashMap();
    paramContext.put("score", paramString);
    paramContext.put("pics", paramList.toArray(new String[0]));
    localHashMap.put("data_json", com.alibaba.a.a.a(paramContext));
    paramNetworkHelper.sendRequest("credit/modify_upload_zhima.json?ver=3.4.0", localHashMap);
  }
  
  public void showProgess(int paramInt, Context paramContext)
  {
    showProgess(paramInt, true, paramContext);
  }
  
  public void tempSubmit(Context paramContext, NetworkHelper<com.huijiemanager.base.b> paramNetworkHelper, Map<String, Object> paramMap)
  {
    HashMap localHashMap = new HashMap();
    addCommonInfo(localHashMap, paramContext);
    localHashMap.put("data_json", com.alibaba.a.a.a(paramMap));
    paramNetworkHelper.sendRequest("loanManagerNew/temporary_submit.json?ver=3.4.0", localHashMap);
  }*/
  
  protected void updateProgess(String paramString)
  {
    /*if ((this.mLoadingDialog != null) && (this.mLoadingDialog.isShowing()))
    {
      TextView localTextView = (TextView)this.mLoadingDialog.findViewById(2131690958);
      localTextView.setText(paramString);
      localTextView.invalidate();
    }*/
  }
}


/* Location:              E:\apktool\dex2jar-2.0\xindaijia\classes_xindai-dex2jar.jar!\com\huijiemanager\app\ApplicationController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */