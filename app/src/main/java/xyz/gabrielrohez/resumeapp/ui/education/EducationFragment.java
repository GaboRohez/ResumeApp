package xyz.gabrielrohez.resumeapp.ui.education;


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
public class EducationFragment extends BasicFragment {

    public static EducationFragment newInstance() {
        Bundle args = new Bundle();
        EducationFragment fragment = new EducationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_education, container, false);

        return rootView;
    }

}
