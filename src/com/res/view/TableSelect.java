package com.res.view;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.res.beans.TableInfoBean;
import com.res.sqlite.impl.TableInfoDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-10-15,上午10:58
 * @since IOT-OMP 1.0
 */

public class TableSelect extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_select);

        TableInfoDAO tableInfoDAO = new TableInfoDAO(this);

        List<TableInfoBean> tableInfoBeanList = new ArrayList<TableInfoBean>();
        int i = 1;
        for (TableInfoBean tableInfoBean : tableInfoBeanList) {
            tableInfoBean = new TableInfoBean();
            tableInfoBean.setName("第" + i++ + "桌");
            tableInfoBean.setAddress("第" + i + "房间");
            tableInfoBean.setStatus(TableInfoBean.AVAILABLE_STATUS);
            tableInfoBeanList.add(tableInfoBean);
        }

        tableInfoDAO.insert(tableInfoBeanList);

        List<TableInfoBean> gettedTables = tableInfoDAO.getAll();

        int id = 1;
        for (TableInfoBean tableInfoBean : gettedTables) {
            LinearLayout linearLayout = new LinearLayout(this);


            ImageButton tableImage = new ImageButton(this);
            tableImage.setBackgroundResource(R.drawable.table800);
            TextView textView = new TextView(this);
            textView.setId(Integer.parseInt(tableInfoBean.getId()));
            textView.setText(tableInfoBean.getName());

        }

    }
}
