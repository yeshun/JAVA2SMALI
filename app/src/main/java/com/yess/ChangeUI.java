package com.yess;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.huijiemanager.ui.fragment.PageFragment;

/**
 * Created by yehun on 2018/5/20.
 */

public class UIChange {
    private static  TestSmali instance;
    public  void Test(PageFragment page){
        if(instance == null)
        {
            instance = new TestSmali();
            try{
                View view = page.getView().getRootView();
                RelativeLayout relative = new RelativeLayout(view.getContext());
                relative.setBackgroundColor(Color.YELLOW);

                // 将Button2 加入到RelativeLayout 中
                instance.button = new Button(view.getContext());
                instance.button.setText("开启");//设置显示的字符
                instance.button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if( instance.button.getText().equals("开启"))
                            instance.button.setText("关闭");
                        else
                            instance.button.setText("开启");
                    }
                });
                relative.addView( instance.button);
                // 设置RelativeLayout布局的宽高
                RelativeLayout.LayoutParams lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                lp.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
                lp.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
                lp=new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                instance.button.setLayoutParams(lp);   ////设置按钮的布局属性
                page.getActivity().addContentView(relative,lp);
            }catch (Exception e){
            }
            // page.getActivity().addContentView(button, layout);
        }
    }
}