package com.res.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.res.beans.DishOrder;
import com.res.memory.DishMemory;
import com.res.ui.DishActivity;
import com.res.ui.DishListFragment;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @author h00187621
 * @version v1.0
 * @date 12-10-15,上午10:00
 * @since IOT-OMP 1.0
 */

public class MenuDetail extends Activity {

    private DishMemory memory;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail);
        memory = DishMemory.getInstance();

        final Intent intent = getIntent();
        final String dishName = intent.getStringExtra("dishName");
        final String price = intent.getStringExtra("price");
        String flashPath = intent.getStringExtra("flashPath");

        final WebView flashView = (WebView) findViewById(R.id.flash);
        TextView dishNameView = (TextView) findViewById(R.id.dishName);
        TextView dishPriceView = (TextView) findViewById(R.id.dishPrice);

        Button backButton = (Button) findViewById(R.id.detail_back);
        final Button submitButton = (Button) findViewById(R.id.detail_submit);

        flashView.getSettings().setJavaScriptEnabled(true);
        flashView.getSettings().setPluginState(WebSettings.PluginState.ON);
        flashView.loadUrl(flashPath);
        dishNameView.setText(dishName);
        dishPriceView.setText(price);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double priceNum = Double.parseDouble(price);
                memory.addDishOrder(new DishOrder(dishName, priceNum, 1));
                Intent intent = new Intent(MenuDetail.this, DishListFragment.class);
                intent.putExtra("dishName", dishName);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}