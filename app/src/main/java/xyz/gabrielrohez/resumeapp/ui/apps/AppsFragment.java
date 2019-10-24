package xyz.gabrielrohez.resumeapp.ui.apps;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Apps;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends BasicFragment {

    @BindView(R.id.appRecycler) RecyclerView appRecycler;

    private List<Apps> apps;

    public static AppsFragment newInstance(List<Apps> apps) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("apps", (ArrayList<? extends Parcelable>) apps);
        AppsFragment fragment = new AppsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_apps, container, false);
        ButterKnife.bind(this, rootView);
        getParcelableData();

        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        apps = getArguments().getParcelableArrayList("apps");
        Log.i("GooglePlay-apps", apps.toString());
    }

}
