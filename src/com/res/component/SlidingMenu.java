package com.res.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-3
 * Time: 下午3:03
 * version: v1.0
 * since: v1.0
 */
public class SlidingMenu extends RelativeLayout {

    private SlidingView slidingView;
    private View menuView;

    public SlidingMenu(Context context) {
        super(context);
    }

    public SlidingMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SlidingMenu(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setMenuView(View view) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.MATCH_PARENT);
        addView(view, layoutParams);
        menuView = view;
    }

    public void setDishView(View view) {
        LayoutParams layoutParams = new LayoutParams(LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        slidingView = new SlidingView(getContext());
        addView(slidingView, layoutParams);
        slidingView.setView(view);
        slidingView.invalidate();
        slidingView.setMenuView(menuView);
    }

    public void showMenuView() {
        slidingView.showMenuView();
    }
}
