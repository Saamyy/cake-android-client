package com.waracle.androidtest.view.cakelist;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.waracle.androidtest.ImageLoader;
import com.waracle.androidtest.R;
import com.waracle.androidtest.model.Cake;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    // Can you think of a better way to represent these items???
    private List<Cake> cakesList;
    private ImageLoader mImageLoader;

    public MyAdapter() {
        this(new ArrayList<Cake>());
    }

    public MyAdapter(List<Cake> items) {
        cakesList = items;
        mImageLoader = new ImageLoader();
    }

    @Override
    public int getCount() {
        return cakesList.size();
    }

    @Override
    public Object getItem(int position) {
        return cakesList.get(position);

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(convertView.getContext());
        View root = inflater.inflate(R.layout.list_item_layout, parent, false);
        if (root != null) {
            TextView title = (TextView) root.findViewById(R.id.title);
            TextView desc = (TextView) root.findViewById(R.id.desc);
            ImageView image = (ImageView) root.findViewById(R.id.image);
            Cake object = cakesList.get(position);
            title.setText(object.getTitle());
            desc.setText(object.getDesc());
//                        mImageLoader.load(object.getString("image"), image);

        }

        return root;
    }

    public void setItems(ArrayList<Cake> items) {
        cakesList = items;
    }
}
