package com.res.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import com.res.data.DataInsert;
import com.res.sqlite.IDishInfoDAO;
import com.res.sqlite.impl.DishInfoDAO;
import com.res.ui.adapter.TableAdapter;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-5
 * Time: 下午11:09
 * version: v1.0
 * since: v1.0
 */
public class WelcomeActivity extends Activity {

    private Button enterBtn;

    private IDishInfoDAO dishInfoDAO;

    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);

        enterBtn = (Button) findViewById(R.id.enter);
        enterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, TableActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
            }
        });

        dishInfoDAO = new DishInfoDAO(this);
        loadDishInfoOnStart();
    }

    /**
     * 加载菜单信息
     */
    private void loadDishInfoOnStart() {
        if (dishInfoDAO.getDishInfoCount() == 0) {
            DataInsert dataInsert = new DataInsert();
            dataInsert.insertTestData(this);
        }
    }
}