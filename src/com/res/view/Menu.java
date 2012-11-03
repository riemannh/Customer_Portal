package com.res.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-10-15,上午9:57
 * @since IOT-OMP 1.0
 */

public class Menu extends Activity {

    private boolean isMenuShown;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.menu);
        final MenuViewGroup menuViewGroup = (MenuViewGroup) findViewById(R.id.menu_view_group);
        ImageButton navShowBtn = (ImageButton) findViewById(R.id.nav_show);
        navShowBtn.setOnClickListener(new ImageButton.OnClickListener() {
            public void onClick(View view) {
                menuViewGroup.slideMenu(isMenuShown);
                isMenuShown = !isMenuShown;
            }
        });

    }


}
