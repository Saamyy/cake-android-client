package com.waracle.androidtest.view.cakelist;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.waracle.androidtest.R;
import com.waracle.androidtest.StreamUtils;
import com.waracle.androidtest.netowrk.CakesRequest;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.CacheRequest;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Fragment is responsible for loading in some JSON and
 * then displaying a list of cakes with images.
 * Fix any crashes
 * Improve any performance issues
 * Use good coding practices to make code more secure
 */
public class PlaceholderFragment extends ListFragment {

    private static final String TAG = PlaceholderFragment.class.getSimpleName();

    private ListView mListView;
    private MyAdapter mAdapter;

    public PlaceholderFragment() { /**/ }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        mListView = rootView.findViewById(android.R.id.list);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Create and set the list adapter.
        mAdapter = new MyAdapter();
        mListView.setAdapter(mAdapter);

        // Load data from net.
//        try {
//            JSONArray array = loadData();
//            mAdapter.setItems(array);
//        } catch (IOException | JSONException e) {
//            Log.e(TAG, e.getMessage());
//        }
    }


}