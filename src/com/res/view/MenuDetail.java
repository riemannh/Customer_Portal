package com.res.view;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        createFlashView(getString(R.string.test_flash));
        //       createWebViewDemo(flashView);
    }

    /**
     * 创建用于播放flash的WebView
     *
     * @param flashName
     */
    private void createFlashView(String flashName) {
        final WebView flashView = (WebView) findViewById(R.id.flash);
        WebViewClient webViewClient = new WebViewClient();
        webViewClient.onLoadResource(flashView, flashName);
        flashView.setWebViewClient(webViewClient);
        WebSettings webSettings = flashView.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }

    private void createWebViewDemo(final WebView flashView) {
        final Handler mHandler = new Handler();
        flashView.addJavascriptInterface(new Object() {
            public void clickOnAndroid() {
                mHandler.post(new Runnable() {
                    public void run() {
                        flashView.loadUrl("javascript:wave()");
                    }
                });
            }
        }, "flash");
    }
}