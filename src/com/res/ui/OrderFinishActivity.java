package com.res.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.res.memory.DishMemory;
import com.res.view.R;
import com.res.view.Success;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-2-16
 * Time: 下午4:38
 * version: v1.0
 * since: v1.0
 */
public class OrderFinishActivity extends Activity {

    private Button finishOrderOkBtn;
    private Button finishOrderBackBtn;
    private ListView finishOrderList;
    private TextView totalCost;
    private DishMemory dishMemory;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_finish);
        finishOrderList = (ListView) findViewById(R.id.finish_order_list);
        finishOrderOkBtn = (Button) findViewById(R.id.finish_order_ok);
        finishOrderBackBtn = (Button) findViewById(R.id.finish_order_back);
        totalCost = (TextView) findViewById(R.id.total_cost);
        dishMemory = DishMemory.getInstance();
        String action = this.getIntent().getAction();
        if ("detail".equals(action)) {
            finishOrderOkBtn.setVisibility(View.GONE);
        } else if ("over".equals(action)) {
            finishOrderOkBtn.setVisibility(View.VISIBLE);
        }
        setClickListener();
        loadDishOrderList();
    }

    private void loadDishOrderList() {
        SimpleAdapter adapter = new SimpleAdapter(this, dishMemory.listDishOrderMap(), R.layout.order_list_item,
                new String[]{"name", "count"}, new int[]{R.id.order_list_item1, R.id.order_list_item2});
        finishOrderList.setAdapter(adapter);
        totalCost.setText("共消费：" + dishMemory.totalCost() + "元");
    }

    private void setClickListener() {
        finishOrderOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderFinishActivity.this, Success.class);
                startActivity(intent);
                finish();
            }
        });

        finishOrderBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OrderFinishActivity.this, DishActivity.class);
                startActivity(intent);
            }
        });
    }
}