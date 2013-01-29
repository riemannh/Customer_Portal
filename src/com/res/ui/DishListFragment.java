package com.res.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.res.beans.DishItem;
import com.res.beans.DishOrder;
import com.res.memory.DishMemory;
import com.res.ui.adapter.DishItemAdapter;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-3
 * Time: 下午3:15
 * version: v1.0
 * since: v1.0
 */
public class DishListFragment extends Fragment {

    DishMemory dishMemory;

    private ImageButton showMenuBtn;
    private GridView gridView;
    private Button orderFinishBtn;
    private Button orderDetailBtn;
    private DishItemAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dish, null);
        dishMemory = DishMemory.getInstance();
        showMenuBtn = (ImageButton) view.findViewById(R.id.show_menu);
        orderDetailBtn = (Button) view.findViewById(R.id.order_detail);
        orderFinishBtn = (Button) view.findViewById(R.id.order_finish);
        gridView = (GridView) view.findViewById(R.id.dish_list);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new DishItemAdapter(getActivity(), orderDetailBtn);
        //todo 加载菜单数据
        loadDishItem();

        showMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DishActivity) getActivity()).showMenu();
            }
        });
    }

    /**
     * 加载菜单信息
     */
    public void loadDishItem() {
        adapter.clear();
        for (int i = 0; i < 20; i++) {
            adapter.add(new DishItem(android.R.drawable.btn_star, "鱼香肉丝", "22"));
        }
        gridView.setAdapter(adapter);
    }

}
