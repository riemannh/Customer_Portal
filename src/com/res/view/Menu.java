package com.res.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-10-15,上午9:57
 * @since IOT-OMP 1.0
 */

public class Menu extends Activity {

    private LinearLayout navArea;

    float x = 0f;

    int moveSize = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu);
        navArea = (LinearLayout) findViewById(R.id.nav);
        ScrollView scrollView = (ScrollView) findViewById(R.id.dish_view);

        scrollView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    x = motionEvent.getX();
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    float newX = motionEvent.getX();
                    moveSize = (int) (newX - x);
                    if (navArea.getWidth() <= 195 && navArea.getWidth() >= 0) {
                        Toast.makeText(Menu.this, "moveSize===============" + moveSize, Toast.LENGTH_SHORT).show();
                        //new AlertDialog.Builder(Menu.this).setMessage(moveSize).show();
                        //                        navArea.setLayoutParams(
                        //                            new LinearLayout.LayoutParams(navArea.getWidth() + moveSize, navArea.getHeight()));
                    }
                }
                if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    if (moveSize > 90) {
                        navArea.setLayoutParams(
                            new AbsoluteLayout.LayoutParams(195, navArea.getHeight(), 195 + moveSize, 0));
                    } else {
                        navArea
                            .setLayoutParams(new AbsoluteLayout.LayoutParams(0, navArea.getHeight(), 0 + moveSize, 0));
                    }
                }
                //new AlertDialog.Builder(Menu.this).setMessage(moveSize).show();
                return true;
            }

        });
    }

}
