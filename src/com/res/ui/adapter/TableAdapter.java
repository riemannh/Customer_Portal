package com.res.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import com.res.memory.DishMemory;
import com.res.ui.DishActivity;
import com.res.ui.TableActivity;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-2-18
 * Time: 下午10:29
 * version: v1.0
 * since: v1.0
 */
public class TableAdapter extends ArrayAdapter<String> {

    private Context context;
    private DishMemory dishMemory;

    public TableAdapter(Context context) {
        super(context, 0);
        this.context = context;
        this.dishMemory = DishMemory.getInstance();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.table_item, null);
        }
        final Button tableBtn = (Button) convertView.findViewById(R.id.table);
        tableBtn.setText(getItem(position));

        tableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dishMemory.selectTable(tableBtn.getText().toString());
                Intent intent = new Intent(context, DishActivity.class);
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
