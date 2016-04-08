package com.smartgifter.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartgifter.controller.R;

/**
 * Created by Shweta Sachdeva on 4/6/2016.
 */
public class MyEvents extends Fragment {
    private View view;
    private static final String TAG = "My Events";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.i(TAG, "In onCreateView");
        view = inflater.inflate(R.layout.fragment_myevents, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        Log.i(TAG, "In onActivity");
        super.onActivityCreated(savedInstanceState);
        FloatingActionButton fab = (FloatingActionButton) getView().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create an event", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }


}
