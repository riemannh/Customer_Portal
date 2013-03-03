package com.res.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.res.beans.DishItem;
import com.res.beans.DishOrder;
import com.res.memory.DishMemory;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-15
 * Time: 下午9:21
 * version: v1.0
 * since: v1.0
 */
public class DishItemAdapter extends ArrayAdapter<DishItem> {

    private DishMemory dishMemory;

    private Context context;
    private Button orderDetailBtn;

    public DishItemAdapter(Context context, Button orderDetailBtn) {
        super(context, 0);
        this.context = context;
        this.orderDetailBtn = orderDetailBtn;
        dishMemory = DishMemory.getInstance();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
        }
        ImageView icon1 = (ImageView) convertView.findViewById(R.id.row_icon1);
        icon1.setImageBitmap(getItem(position).getIconRes());
        final TextView tag1 = (TextView) convertView.findViewById(R.id.row_title1);
        tag1.setText(getItem(position).getTag());
        final TextView priceText = (TextView) convertView.findViewById(R.id.price);
        priceText.setText(getItem((position)).getPrice());
        Button confirmBtn = (Button) convertView.findViewById(R.id.confirm);

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = tag1.getText().toString();
                double price = Double.parseDouble(priceText.getText().toString());
                dishMemory.addDishOrder(new DishOrder(title, price, 1));
                orderDetailBtn.setText("已点：" + dishMemory.size());
                orderDetailBtn.postInvalidate();
                Toast.makeText(context, "已点：\"" + tag1.getText() + "\"", Toast.LENGTH_SHORT).show();
            }
        });

        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO 展示详情
            }
        });
        return convertView;
    }
}
