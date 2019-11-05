package xyz.gabrielrohez.resumeapp.ui.experience;


import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.adapters.ExperienceAdapter;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Experience;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends BasicFragment {

    @BindView(R.id.recyclerExperience)
    RecyclerView recycler;

    private List<Experience> experience;

    public static ExperienceFragment newInstance(List<Experience> experience) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("experience", (ArrayList<? extends Parcelable>) experience);

        ExperienceFragment fragment = new ExperienceFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_experience, container, false);
        ButterKnife.bind(this, rootView);
        getParcelableData();
        setExperienceRecyclerView();
        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        experience = getArguments().getParcelableArrayList("experience");
        Log.i("Experience", experience.toString());
    }

    /**
     * the information is shown in the recycler
     */
    private void setExperienceRecyclerView() {
        ExperienceAdapter adapter = new ExperienceAdapter(experience);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
