package com.res.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.res.beans.DishItem;
import com.res.beans.DishOrder;
import com.res.memory.DishMemory;
import com.res.ui.OrderFinishActivity;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-2-18
 * Time: 下午11:10
 * version: v1.0
 * since: v1.0
 */
public class OrderListAdapter extends ArrayAdapter<DishOrder> {

    private Context context;
    private DishMemory dishMemory;

    public OrderListAdapter(Context context) {
        super(context, 0);
        this.context = context;
        dishMemory = DishMemory.getInstance();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.order_list_item, null);
        }
        final TextView nameView = (TextView) convertView.findViewById(R.id.order_list_name);
        TextView countView = (TextView) convertView.findViewById(R.id.order_list_count);
        Button deleteBtn = (Button) convertView.findViewById(R.id.delete);
        nameView.setText(getItem(position).getName());
        countView.setText("×" + getItem(position).getCount());
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dishMemory.delete(nameView.getText().toString());
                ((OrderFinishActivity) context).loadDishOrderList();
            }
        });
        return convertView;
    }
}
