package com.res.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.res.memory.DishMemory;
import com.res.ui.WelcomeActivity;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-10-15,上午11:04
 * @since IOT-OMP 1.0
 */

public class Success extends Activity {

    private Button finishBackBtn;
    private DishMemory dishMemory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.success);
        new Thread() {
            public void run() {
                //todo 存储订单信息
                dishMemory.clearDishOrder();
            }
        }.start();
        dishMemory = DishMemory.getInstance();
        finishBackBtn = (Button) findViewById(R.id.finish_back);
        finishBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Success.this, WelcomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
