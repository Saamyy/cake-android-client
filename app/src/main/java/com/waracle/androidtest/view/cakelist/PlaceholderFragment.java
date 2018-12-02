package com.waracle.androidtest.view.cakelist;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.waracle.androidtest.R;
import com.waracle.androidtest.model.Cake;
import com.waracle.androidtest.netowrk.CakesRequest;

import java.util.List;

/**
 * Fragment is responsible for loading in some JSON and
 * then displaying a list of cakes with images.
 * Fix any crashes
 * Improve any performance issues
 * Use good coding practices to make code more secure
 */
public class PlaceholderFragment extends ListFragment implements PlaceHolderViewContract {

    private static final String TAG = PlaceholderFragment.class.getSimpleName();
    private final String errorMessageStrin = "something went wrong please try again later";
    private CakesRequest requestContract;
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
        requestContract = new CakesRequest(this);
        // Create and set the list adapter
        mAdapter = new MyAdapter(getContext());
        mListView.setAdapter(mAdapter);
        requestContract.execute();
    }

    @Override
    public void displayList(List<Cake> cakes) {
        mAdapter.setItems(cakes);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), errorMessageStrin, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        requestContract=null;
    }
}