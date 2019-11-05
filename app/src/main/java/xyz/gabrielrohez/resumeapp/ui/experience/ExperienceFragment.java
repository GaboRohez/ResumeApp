package xyz.gabrielrohez.resumeapp.ui.experience;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Experience;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExperienceFragment extends BasicFragment {

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
        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        experience = getArguments().getParcelableArrayList("experience");
        Log.i("Experience", experience.toString());
    }
}
