package xyz.gabrielrohez.resumeapp.ui.about;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.adapters.AptitudesAdapter;
import xyz.gabrielrohez.resumeapp.adapters.InterestsAdapter;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.custom.barChart.MyBarChart;
import xyz.gabrielrohez.resumeapp.custom.scroll.ObservableScrollView;
import xyz.gabrielrohez.resumeapp.data.model.DataCharts;
import xyz.gabrielrohez.resumeapp.data.network.response.About;
import xyz.gabrielrohez.resumeapp.data.network.response.Inter_personal;
import xyz.gabrielrohez.resumeapp.data.network.response.Languages;
import xyz.gabrielrohez.resumeapp.data.network.response.Skills;
import xyz.gabrielrohez.resumeapp.data.network.response.Social;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BasicFragment implements ObservableScrollView.OnScrollChangedListener {

    @BindView(R.id.tvAboutName)
    TextView tvName;
    @BindView(R.id.tvAboutLocation)
    TextView tvLocation;
    @BindView(R.id.tvAboutJob)
    TextView tvJob;
    @BindView(R.id.tvAboutEmail)
    TextView tvEmail;
    @BindView(R.id.tvAboutPhone)
    TextView tvPhone;
    @BindView(R.id.tvAboutResume)
    TextView tvResume;
    @BindView(R.id.rvAboutAptitudes)
    RecyclerView rvAboutAptitudes;
    @BindView(R.id.rvAboutInterest)
    RecyclerView rvAboutInterest;
    @BindView(R.id.aboutScrollView)
    ObservableScrollView scrollView;
    @BindView(R.id.img_container)
    FrameLayout frameLayout;
    @BindView(R.id.barChart)
    BarChart chart;

    private About about;
    private Social social;
    private Skills skills;
    private Inter_personal interests;
    private InterestsAdapter adapter;
    private AptitudesAdapter adapterAptitudes;
    private RecyclerView.LayoutManager layoutManager;

    public static AboutFragment newInstance(Social social, About about, Skills skills, Inter_personal interests) {
        Bundle args = new Bundle();
        args.putParcelable("social", social);
        args.putParcelable("about", about);
        args.putParcelable("skills", skills);
        args.putParcelable("interests", interests);
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getParcelableData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, rootView);
        scrollView.setOnScrollChangedListener(this);   //   for parallax effect

        setAboutData();
        setSkillsDataInChart();
        setInterestsRecyclerView();
        setAptitudesRecyclerView();
        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        social = getArguments().getParcelable("social");
        about = getArguments().getParcelable("about");
        skills = getArguments().getParcelable("skills");
        interests = getArguments().getParcelable("interests");
        Log.i("ABOUT-social", social.toString());
        Log.i("ABOUT-about", about.toString());
        Log.i("ABOUT-skills", skills.toString());
        Log.i("ABOUT-interests", interests.toString());
    }

    /**
     * the information is shown in the about section
     */
    private void setAboutData() {
        tvName.setText(about.getName());
        tvLocation.setText(about.getLocation());
        tvJob.setText(about.getJob());
        tvEmail.setText(about.getEmail());
        tvPhone.setText(about.getPhone());
        tvResume.setText(about.getResume());
    }

    /**
     * the information is shown in the chart
     */
    private void setSkillsDataInChart() {
        List<DataCharts> listDataChart = new ArrayList<>();
        for (Languages languages : skills.getLanguages()){
            listDataChart.add(new DataCharts(languages.getName(), Float.valueOf(languages.getYoe())));
        }
        MyBarChart myBarChart = new MyBarChart(chart, getActivity(), listDataChart);
        myBarChart.showBarChart();
    }

    /**
     * the information is shown in the recyclers
     */
    private void setInterestsRecyclerView() {
        adapter = new InterestsAdapter(interests.getInterests());
        layoutManager = new LinearLayoutManager(getActivity());
        rvAboutInterest.setNestedScrollingEnabled(false);   //  block scroll in recycer
        rvAboutInterest.setLayoutManager(layoutManager);
        rvAboutInterest.setHasFixedSize(true);
        rvAboutInterest.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    /**
     * the information is shown in the recyclers
     */
    private void setAptitudesRecyclerView() {
        adapterAptitudes = new AptitudesAdapter(interests.getAptitudes());
        layoutManager = new LinearLayoutManager(getActivity());
        rvAboutAptitudes.setNestedScrollingEnabled(false);   //  block scroll in recycer
        rvAboutAptitudes.setLayoutManager(layoutManager);
        rvAboutAptitudes.setHasFixedSize(true);
        rvAboutAptitudes.setAdapter(adapterAptitudes);
        adapterAptitudes.notifyDataSetChanged();
    }

    /**
     * Parallax effect
     */
    @Override
    public void onScrollChanged(int deltaX, int deltaY) {
        int scrollY = scrollView.getScrollY();
        // Add parallax effect
        frameLayout.setTranslationY(scrollY * 0.5f);
    }

    @OnClick({R.id.layoutAboutWeb, R.id.layoutAboutPlay, R.id.layoutAboutGit})
    void onViewClicked(View view) {
        String url = null;
        switch (view.getId()) {
            case R.id.layoutAboutWeb:
                url = social.getWeb();
                break;
            case R.id.layoutAboutPlay:
                url = social.getPlaystore();
                break;
            case R.id.layoutAboutGit:
                url = social.getGithub();
                break;
        }
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);
    }
}
