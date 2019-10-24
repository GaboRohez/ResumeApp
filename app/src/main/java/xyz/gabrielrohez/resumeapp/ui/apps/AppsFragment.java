package xyz.gabrielrohez.resumeapp.ui.apps;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.adapters.AppsAdapter;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Apps;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class AppsFragment extends BasicFragment implements AppsAdapter.AppsInterface {

    @BindView(R.id.appRecycler)
    RecyclerView recyclerView;

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
        setAppsRecyclerView();
        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        apps = getArguments().getParcelableArrayList("apps");
        Log.i("GooglePlay-apps", apps.toString());
    }

    /**
     * the information is shown in the recycler
     */
    private void setAppsRecyclerView() {
        AppsAdapter adapter = new AppsAdapter(apps, this);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnClick(R.id.appsGooglePlay)
    public void onViewClicked() {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(AppConstants.URL_PLAY_STORE));
        startActivity(i);
    }

    @Override
    public void ItemViewClick(Apps apps) {
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(apps.getUrl()));
        startActivity(i);
    }
}
