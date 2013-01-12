package com.res.ui;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.res.view.R;

/**
 * <p>
 * </p>
 * User: LICHEN
 * Date: 13-1-3
 * Time: 下午3:15
 * version: v1.0
 * since: v1.0
 */
public class DishListFragment extends Fragment {

    private ImageButton showMenuBtn;
    private GridView gridView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dish, null);
        showMenuBtn = (ImageButton) view.findViewById(R.id.show_menu);
        gridView = (GridView) view.findViewById(R.id.dish_list);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        SampleAdapter adapter = new SampleAdapter(getActivity());
        for (int i = 0; i < 20; i++) {
            adapter.add(new SampleItem(android.R.drawable.btn_star, "鱼香肉丝", "22"));
        }
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String title = ((TextView) view.findViewById(R.id.row_title1)).getText().toString();
                Toast.makeText(getActivity(), title, Toast.LENGTH_SHORT).show();
            }
        });
        showMenuBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((DishActivity) getActivity()).showMenu();
            }
        });
    }

    private class SampleItem {
        private int iconRes;
        private String tag;
        private String price;

        public SampleItem(int iconRes, String tag, String price) {
            this.iconRes = iconRes;
            this.tag = tag;
            this.price = price;
        }

        public int getIconRes() {
            return iconRes;
        }

        public void setIconRes(int iconRes) {
            this.iconRes = iconRes;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public class SampleAdapter extends ArrayAdapter<SampleItem> {

        public SampleAdapter(Context context) {
            super(context, 0);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.item, null);
            }
            ImageView icon1 = (ImageView) convertView.findViewById(R.id.row_icon1);
            icon1.setImageResource(getItem(position).getIconRes());
            TextView tag1 = (TextView) convertView.findViewById(R.id.row_title1);
            tag1.setText(getItem(position).getTag());
            TextView price = (TextView) convertView.findViewById(R.id.price);
            price.setText(getItem((position)).getPrice());
            return convertView;
        }
    }
}
