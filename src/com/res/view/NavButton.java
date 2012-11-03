package com.res.view;

import android.R;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author lichen
 * @version [版本号, 2012-11-03]
 * @since [IOT-OMP/version 1.0]
 */
public class NavButton extends LinearLayout {

    private ImageView navImage;

    private TextView navName;

    public NavButton(Context context, int imageResource, int textResource) {
        super(context);
        navImage = new ImageView(context);
        navName = new TextView(context);
        navImage.setImageResource(imageResource);
        navName.setText(textResource);
        navImage.setLayoutParams(
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        navName.setLayoutParams(
            new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));

        setOrientation(LinearLayout.VERTICAL);
        setClickable(true);
        setFocusable(true);
        setBackgroundResource(R.drawable.btn_default);
        addView(navImage);
        addView(navName);
    }

}
