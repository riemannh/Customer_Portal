package com.res.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Scroller;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author lichen
 * @version [版本号, 2012-11-03]
 * @since [IOT-OMP/version 1.0]
 */
public class MenuViewGroup extends ViewGroup {

    private Scroller scroller;

    public MenuViewGroup(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MenuViewGroup(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        scroller = new Scroller(getContext());
        postDelayed(new Runnable() {
            public void run() {
                slideMenu(true);
            }
        }, 50);
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View navView = findViewById(R.id.nav_view);
        View mainView = findViewById(R.id.main_view);
        navView.measure(navView.getLayoutParams().width + mainView.getLeft() + navView.getRight(), heightMeasureSpec);
        mainView.measure(widthMeasureSpec, heightMeasureSpec);
    }

    protected void onLayout(boolean b, int left, int top, int right, int bottom) {
        int childCount = getChildCount();
        int childLeft = 0;
        for (int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            int childWidth = child.getMeasuredWidth();
            child.layout(childLeft, 0, childWidth, child.getMeasuredHeight());
            childLeft += childWidth;
        }
    }

    @Override
    public void computeScroll() {
        if (scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        int scrollX = getScrollX();
        super.dispatchDraw(canvas);
        canvas.translate(scrollX, 0);
    }

    public void scrollTo(int x, int y) {
        super.scrollTo(x, y);
        postInvalidate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        View view;
        for (int i = 0; i < getChildCount(); i++) {
            view = getChildAt(i);
            view.setFocusable(true);
            view.setClickable(true);
        }
    }

    public void slideMenu(boolean isMenuShown) {
        int moveWidth = findViewById(R.id.nav_view).getMeasuredWidth();
        if (isMenuShown) {
            scroller.startScroll(scroller.getCurrX(), 0, moveWidth, 0, 1000);
        } else {
            scroller.startScroll(scroller.getCurrX(), 0, -moveWidth, 0, 1000);
        }
    }

}
