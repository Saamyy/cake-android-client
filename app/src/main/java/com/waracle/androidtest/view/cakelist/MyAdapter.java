package com.waracle.androidtest.view.cakelist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.waracle.androidtest.R;
import com.waracle.androidtest.model.Cake;
import com.waracle.androidtest.netowrk.DownloadImage;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    // Can you think of a better way to represent these items???
    private List<Cake> cakesList;
    private Context context;

    public MyAdapter(Context context) {
        this(new ArrayList<Cake>());
        this.context = context;
    }

    public MyAdapter(List<Cake> items) {
        cakesList = items;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View root = inflater.inflate(R.layout.list_item_layout, parent, false);
        TextView title = (TextView) root.findViewById(R.id.title);
        TextView desc = (TextView) root.findViewById(R.id.desc);
        ImageView image = (ImageView) root.findViewById(R.id.image);
        Cake object = cakesList.get(position);
        title.setText(object.getTitle());
        desc.setText(object.getDesc());
//        mImageLoader.load(object.getImage(), image);
        new DownloadImage(image).execute(object.getImage());
        return root;
    }

    public void setItems(List<Cake> items) {
        cakesList.clear();
        cakesList.addAll(items);
        notifyDataSetChanged();
    }
}
