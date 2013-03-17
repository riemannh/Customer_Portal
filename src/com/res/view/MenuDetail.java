package com.res.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_detail);
        final Intent intent = getIntent();
        final String dishName = intent.getStringExtra("dishName");
        String price = intent.getStringExtra("price");
        String flashPath = intent.getStringExtra("flashPath");

        final WebView flashView = (WebView) findViewById(R.id.flash);
        TextView dishNameView = (TextView) findViewById(R.id.dishName);
        TextView dishPriceView = (TextView) findViewById(R.id.dishPrice);

        Button backButton = (Button) findViewById(R.id.detail_back);
        final Button submitButton = (Button) findViewById(R.id.detail_submit);

        flashView.getSettings().setJavaScriptEnabled(true);
        flashView.getSettings().setPluginsEnabled(true);
        flashView.loadUrl(flashPath);
        dishNameView.setText(dishName);
        dishPriceView.setText(price);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submitIntent = new Intent();
                //todo     submitIntent.setClass(this,null);

                submitIntent.putExtra("dishName", dishName);
                startActivity(submitIntent);
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