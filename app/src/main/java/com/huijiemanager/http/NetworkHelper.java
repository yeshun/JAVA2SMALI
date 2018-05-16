package com.huijiemanager.http;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
/*import com.alibaba.a.e;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;*/
import com.huijiemanager.app.ApplicationController;
/*import com.huijiemanager.base.b.a;
import com.huijiemanager.base.b.b;*/
import java.util.Map;

public abstract class NetworkHelper<T>
  //implements Response.ErrorListener, Response.Listener<e>
{
  private ApplicationController ac;
  private Activity context;
/*  protected a requestErrorListener;
  private b<T> uiDataListener;
  
  public NetworkHelper(Activity paramActivity)
  {
    this.context = paramActivity;
    this.ac = ((ApplicationController)paramActivity.getApplication());
  }
  
  private boolean isNetworkError(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.contains("ConnectException")) || (paramString.contains("UnknownHostException")));
  }
  
  protected abstract void disposeResponse(e parame);
  
  protected abstract void disposeVolleyError(VolleyError paramVolleyError);
  
  protected Context getContext()
  {
    return this.context;
  }
  
  protected NetworkRequest getRequestForPost(String paramString, Map<String, String> paramMap)
  {
    return new NetworkRequest(paramString, this, this, paramMap);
  }
  
  protected void notifyDataChanged(T paramT, String paramString)
  {
    if (this.uiDataListener != null) {
      this.uiDataListener.onDataChanged(paramT, paramString);
    }
  }
  
  protected void notifyErrorHappened(String paramString)
  {
    if ((this.requestErrorListener != null) && (isNetworkError(paramString))) {
      this.requestErrorListener.networkError();
    }
    while (this.requestErrorListener == null) {
      return;
    }
    this.ac.dismissProgess();
    a locala = this.requestErrorListener;
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = "加载失败";
    }
    locala.businessError(str, "");
  }
  
  protected void notifyErrorHappened(String paramString1, String paramString2)
  {
    if (this.requestErrorListener != null)
    {
      if (!TextUtils.isEmpty(paramString1))
      {
        this.requestErrorListener.businessError(paramString1, paramString2);
        return;
      }
      this.requestErrorListener.businessError("加载失败", paramString2);
      return;
    }
    notifyErrorHappened(paramString1);
  }
  
  public void onErrorResponse(VolleyError paramVolleyError)
  {
    this.ac.dismissProgess();
    disposeVolleyError(paramVolleyError);
  }
  
  public void onResponse(e parame)
  {
    this.ac.dismissProgess();
    disposeResponse(parame);
  }
  
  public void sendBlockRequest(String paramString, Map<String, String> paramMap)
  {
    this.ac.showProgess(-1, this.context);
    sendRequest(paramString, paramMap);
  }*/
  
  public void sendRequest(String paramString, Map<String, String> paramMap)
  {
    //this.ac.addToRequestQueue(getRequestForPost(paramString, paramMap));
  }
  
/*  public void setRequestErrorListener(a parama)
  {
    this.requestErrorListener = parama;
  }
  
  public void setUiDataListener(b<T> paramb)
  {
    this.uiDataListener = paramb;
  }*/
}


/* Location:              E:\apktool\dex2jar-2.0\xindaijia\classes_xindai-dex2jar.jar!\com\huijiemanager\http\NetworkHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */