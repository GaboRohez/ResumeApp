package xyz.gabrielrohez.resumeapp.ui.education;


import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.adapters.EducationAdapter;
import xyz.gabrielrohez.resumeapp.adapters.InterestsAdapter;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.custom.BottomSheetFragment;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.ui.documentVisor.DocumentFragment;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

/**
 * A simple {@link Fragment} subclass.
 */
public class EducationFragment extends BasicFragment implements EducationAdapter.EducationInterface {

    @BindView(R.id.educationRecycler) RecyclerView recycler;

    private List<Courses> courses;
    private EducationAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    public static EducationFragment newInstance(List<Courses> courses) {
        Bundle args = new Bundle();
        args.putParcelableArrayList("courses", (ArrayList<? extends Parcelable>) courses);
        EducationFragment fragment = new EducationFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_education, container, false);
        ButterKnife.bind(this, rootView);
        getParcelableData();
        setEducationRecyclerView();

        return rootView;
    }

    /**
     * get data from intent
     */
    private void getParcelableData() {
        courses = getArguments().getParcelableArrayList("courses");
        Log.i("EDUCATION-courses", courses.toString());
    }

    /**
     * the information is shown in the recyclers
     */
    private void setEducationRecyclerView() {
        adapter = new EducationAdapter(courses, this, this);
        layoutManager = new LinearLayoutManager(getActivity());
        recycler.setLayoutManager(layoutManager);
        recycler.setHasFixedSize(true);
        recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * show pdf
     */
    @Override
    public void ItemViewClick(Courses courses) {
        basicView.addFragment(DocumentFragment.newInstance(AppConstants.PDF_FILE.getNameFromId(courses.getImage())), AppConstants.TAG_DOCUMENT_FRAGMENT, R.id.contentFragment);
    }

    /**
     * open bottom sheet
     */
    @Override
    public void MenuOnClick(Courses courses) {
        BottomSheetFragment bottomSheetFragment = new BottomSheetFragment(courses);
        bottomSheetFragment.show(getFragmentManager(), bottomSheetFragment.getTag());
    }
}
