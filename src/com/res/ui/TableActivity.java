package com.res.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import com.res.ui.adapter.TableAdapter;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-2-18
 * Time: 下午10:43
 * version: v1.0
 * since: v1.0
 */
public class TableActivity extends Activity {

    private GridView tableView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.table);
        tableView = (GridView) findViewById(R.id.table_list);
        Toast.makeText(this, "请选择桌号", Toast.LENGTH_LONG).show();

        TableAdapter adapter = new TableAdapter(this);
        //todo 加载桌号
        for (int i = 1; i <= 16; i++) {
            adapter.add(String.valueOf(i));
        }
        tableView.setAdapter(adapter);
    }
}