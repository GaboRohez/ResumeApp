package xyz.gabrielrohez.resumeapp.ui.apps;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends BasicFragment {

    public static AppsFragment newInstance() {
        Bundle args = new Bundle();
        AppsFragment fragment = new AppsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apps, container, false);

        return view;
    }

}
