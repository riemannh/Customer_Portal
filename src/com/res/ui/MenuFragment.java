package com.res.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-3
 * Time: 下午3:11
 * version: v1.0
 * since: v1.0
 */
public class MenuFragment extends Fragment {

    private Button famousBtn;
    private Button hotBtn;
    private Button coldBtn;
    private Button dessertBtn;
    private Button stapleBtn;
    private Button drinkBtn;

    private DishListFragment dishListFragment;

    public MenuFragment(DishListFragment dishListFragment) {
        this.dishListFragment = dishListFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu, null);
        famousBtn = (Button) view.findViewById(R.id.famous);
        hotBtn = (Button) view.findViewById(R.id.hot);
        coldBtn = (Button) view.findViewById(R.id.cold);
        dessertBtn = (Button) view.findViewById(R.id.dessert);
        stapleBtn = (Button) view.findViewById(R.id.staple);
        drinkBtn = (Button) view.findViewById(R.id.drink);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        famousBtn.setOnClickListener(new MenuClickListener(this, "0"));
        hotBtn.setOnClickListener(new MenuClickListener(this, "1"));
        coldBtn.setOnClickListener(new MenuClickListener(this, "2"));
        dessertBtn.setOnClickListener(new MenuClickListener(this, "3"));
        stapleBtn.setOnClickListener(new MenuClickListener(this, "4"));
        drinkBtn.setOnClickListener(new MenuClickListener(this, "5"));
    }

    /**
     * 加载菜品页面
     */
    public void loadDishView() {
        dishListFragment.loadDishItem();
    }

}

class MenuClickListener implements View.OnClickListener {

    private MenuFragment menuFragment;
    private String menuType;

    public MenuClickListener(MenuFragment menuFragment, String menuType) {
        this.menuFragment = menuFragment;
        this.menuType = menuType;
    }

    @Override
    public void onClick(View view) {
        //TODO查询加载列表
        menuFragment.loadDishView();
        ((DishActivity) menuFragment.getActivity()).showMenu();
    }
}
