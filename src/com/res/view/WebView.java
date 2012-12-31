package com.res.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import java.io.File;
import java.io.FileFilter;

/**
 * Class Descriptions.
 * User: Riemannh
 * Date: 12-12-26
 * Time: 上午6:32
 * version:[]
 */
public class WebView extends Activity {
    /*File name[];
    WebView wv;
    ListView listview;
    String filename;
    ImageView iv;
    Bitmap flashtobitmap;
    byte ImageByte[];

    *//**
     * Called when the activity is first created.
     *//*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        wv = (WebView) findViewById(R.id.webView1);
        wv.getSettings().setPluginsEnabled(true);
        wv.loadUrl("http://www.baidu.com");

        listview = (ListView) findViewById(R.id.listView1);
        listview.setAdapter(new MyListAdapter(WebView.this, getSD()));
        listview.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                // TODO Auto-generated method stub
                filename = name[arg2].getName();
                wv.loadUrl("file:///mnt/sdcard/X_flash/" + filename);

            }
        });
    }

    File[] getSD() {
        File file = new File("/sdcard/X_flash/");
        File name[] = file.listFiles(new FileFilter() {

            public boolean accept(File pathname) {
                // TODO Auto-generated method stub
                if (pathname.getName().lastIndexOf(".swf") > 0) {
                    return true;
                }
                return false;
            }
        });

        return name;
    }

    public class MyListAdapter extends BaseAdapter {
        *//* 声明变量 *//*
        private Context mContext;
        int car[] = {R.drawable.car1, R.drawable.car2, R.drawable.car3};
        int i;

        MyListAdapter(Context c, File[] file) {
            mContext = c;
            name = file;

        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            if (name != null) {
                return name.length;
            } else return 0;
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // TODO Auto-generated method stub
            *//*
            * TextView temp=new TextView(mContext);
            * temp.setText(name[position].getName()); temp.setSingleLine(true);
            * temp.setEllipsize(TruncateAt.MARQUEE);//设置为跑马灯
            * temp.setTextSize(20); return temp;
            *//*

            LayoutInflater inflater = LayoutInflater.from(mContext);
            View vw = (View) inflater.inflate(R.layout.listadapter, null);
            iv = (ImageView) vw.findViewById(R.id.imageViewCar);
            iv.setImageResource(car[position % 3]);


            TextView temp = (TextView) vw.findViewById(R.id.textViewName);
            temp.setSingleLine(true);
            temp.setText(name[position].getName());
            temp.setEllipsize(TruncateAt.MARQUEE);// 设置为跑马灯
            temp.setTextSize(20);

            return vw;

        }

    }*/
}

