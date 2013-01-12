package com.res.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class Index extends Activity {

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideStatusBar();
        setContentView(R.layout.main);
        Button button2Menu = (Button) findViewById(R.id._2menu);
        Button button2TableSelect = (Button) findViewById(R.id._2tableSelect);

        button2Menu.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2Menu = new Intent();
                intent2Menu.setClass(Index.this, Menu.class);
                startActivity(intent2Menu);
            }
        });

        button2TableSelect.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2TableSelect = new Intent();
                intent2TableSelect.setClass(Index.this, Menu.class);
                startActivity(intent2TableSelect);
            }
        });
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

