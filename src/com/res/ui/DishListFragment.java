package com.res.ui;

import android.app.AlertDialog;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import com.res.beans.DishItem;
import com.res.memory.DishMemory;
import com.res.memory.DishPicCache;
import com.res.pojo.DishInfoBean;
import com.res.sqlite.IDishInfoDAO;
import com.res.sqlite.impl.DishInfoDAO;
import com.res.ui.adapter.DishItemAdapter;
import com.res.view.R;

import java.util.List;

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
    private Handler handler;
    private ProgressDialog progressDialog;
    private IDishInfoDAO dishInfoDAO;
    private DishPicCache picCache;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dish, null);
        dishMemory = DishMemory.getInstance();
        showMenuBtn = (ImageButton) view.findViewById(R.id.show_menu);
        orderDetailBtn = (Button) view.findViewById(R.id.order_detail);
        orderFinishBtn = (Button) view.findViewById(R.id.order_finish);
        gridView = (GridView) view.findViewById(R.id.dish_list);
        handler = new Handler();
        dishInfoDAO = new DishInfoDAO(getActivity());
        picCache = DishPicCache.getInstance(getActivity());
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new DishItemAdapter(getActivity(), orderDetailBtn);

        loadDishItem(1);

        showMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DishActivity) getActivity()).showMenu();
            }
        });

        //已点按钮
        orderDetailBtn.setText("已点：" + dishMemory.size());
        orderDetailBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), OrderFinishActivity.class);
                intent.setAction("detail");
                startActivity(intent);
            }
        });

        //完成点餐按钮
        orderFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dishMemory.isEmpty()) {
                    new AlertDialog.Builder(getActivity()).setMessage("您尚未点餐！").setPositiveButton("确定", null).show();
                } else {
                    Intent intent = new Intent(getActivity(), OrderFinishActivity.class);
                    intent.setAction("over");
                    startActivity(intent);
                }
            }
        });
    }

    /**
     * 加载菜单信息
     */
    public void loadDishItem(final int type) {
        progressDialog = ProgressDialog.show(getActivity(), "请稍等...", "菜单获取中...", true);
        handler.post(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                List<DishInfoBean> dishInfoList = dishInfoDAO.queryDishInfoList(type);
                for (DishInfoBean dishInfoBean : dishInfoList) {
                    Bitmap bitmap = picCache.get(dishInfoBean.getSmallPictureAddress());
                    adapter.add(new DishItem(bitmap,
                            dishInfoBean.getName(), dishInfoBean.getPrice()));
                }
                gridView.setAdapter(adapter);
                progressDialog.dismiss();
                gridView.setAdapter(adapter);
            }
        });
    }

}
