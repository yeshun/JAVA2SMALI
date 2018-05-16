package com.huijiemanager.base;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
//
import com.huijiemanager.app.ApplicationController;
//import com.huijiemanager.base.b.a;
import com.huijiemanager.http.NetworkHelper;
/*
import com.huijiemanager.http.ReverseRegisterNetworkHelper;
import com.huijiemanager.model.Account;
import com.huijiemanager.utils.ag;
import com.huijiemanager.utils.ap;
import com.huijiemanager.utils.aq;
import com.huijiemanager.utils.k;
import com.huijiemanager.utils.w;
import com.mic.etoast2.c;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import org.a.b.c.b;
import org.a.c.b.e;
*/

public abstract class BaseActivity
  extends FragmentActivity
  //implements OnClickListener, a, b.b<b>
{

  
  private boolean isHideInput(View paramView, MotionEvent paramMotionEvent)
  {

    return false;
  }
  

  
  /* Error */
  public boolean onOptionsItemSelected(android.view.MenuItem paramMenuItem)
  {
    return false;
  }
    // Byte code:
    //   0: getstatic 64	com/huijiemanager/base/BaseActivity:ajc$tjp_0	Lorg/a/b/c$b;
    //   3: aload_0
    //   4: aload_0
    //   5: aload_1
    //   6: invokestatic 219	org/a/c/b/e:a	(Lorg/a/b/c$b;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Lorg/a/b/c;
    //   9: astore_3
    //   10: aload_1
    //   11: invokeinterface 224 1 0
    //   16: ldc -31
    //   18: if_icmpne +18 -> 36
    //   21: aload_0
    //   22: invokevirtual 228	com/huijiemanager/base/BaseActivity:finish	()V
    //   25: iconst_1
    //   26: istore_2
    //   27: invokestatic 234	com/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj:aspectOf	()Lcom/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj;
    //   30: aload_3
    //   31: invokevirtual 238	com/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj:onOptionsItemSelectedAOP	(Lorg/a/b/c;)V
    //   34: iload_2
    //   35: ireturn
    //   36: aload_0
    //   37: aload_1
    //   38: invokespecial 240	android/support/v4/app/FragmentActivity:onOptionsItemSelected	(Landroid/view/MenuItem;)Z
    //   41: istore_2
    //   42: goto -15 -> 27
    //   45: astore_1
    //   46: invokestatic 234	com/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj:aspectOf	()Lcom/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj;
    //   49: aload_3
    //   50: invokevirtual 238	com/sensorsdata/analytics/android/runtime/MenuItemSelectedAspectj:onOptionsItemSelectedAOP	(Lorg/a/b/c;)V
    //   53: aload_1
    //   54: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	this	BaseActivity
    //   0	55	1	paramMenuItem	android.view.MenuItem
    //   26	16	2	bool	boolean
    //   9	41	3	localc	org.a.b.c
    // Exception table:
    //   from	to	target	type
    //   10	25	45	java/lang/Throwable
    //   36	42	45	java/lang/Throwable

}


/* Location:              E:\apktool\dex2jar-2.0\xindaijia\classes_xindai-dex2jar.jar!\com\huijiemanager\base\BaseActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */