package com.res.ui;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.res.component.SlidingMenu;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-3
 * Time: 下午1:53
 * version: v1.0
 * since: v1.0
 */
public class DishActivity extends Activity {

    private SlidingMenu slidingMenu;
    private DishListFragment dishListFragment;
    private MenuFragment menuFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dish_main);
        slidingMenu = (SlidingMenu) findViewById(R.id.sliding_menu);
        slidingMenu.setMenuView(getLayoutInflater().inflate(R.layout.menu_frame, null));
        slidingMenu.setDishView(getLayoutInflater().inflate(R.layout.dish_frame, null));

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        menuFragment = new MenuFragment();
        transaction.replace(R.id.menu_frame, menuFragment);
        dishListFragment = new DishListFragment();
        transaction.replace(R.id.dish_frame, dishListFragment);
        transaction.commit();
    }

    public void showMenu() {
        slidingMenu.showMenuView();
    }
}
