package com.res.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.res.view.R;

public class Index extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.main);
    }

    private void hideTitle() {
        // TODO Auto-generated method stub
        requestWindowFeature(Window.FEATURE_NO_TITLE);
    }

    private void hideStatusBar() {
        // TODO Auto-generated method stub
        //隐藏标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //定义全屏参数
        int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
        //获得窗口对象
        Window myWindow = this.getWindow();
        //设置Flag标识
        myWindow.setFlags(flag, flag);
    }
}

