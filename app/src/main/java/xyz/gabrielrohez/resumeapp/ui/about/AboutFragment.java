package xyz.gabrielrohez.resumeapp.ui.about;


import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.model.GradientColor;
import com.github.mikephil.charting.utils.MPPointF;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;
import xyz.gabrielrohez.resumeapp.custom.barChart.DayAxisValueFormatter;
import xyz.gabrielrohez.resumeapp.custom.barChart.MyBarChart;
import xyz.gabrielrohez.resumeapp.custom.barChart.MyValueFormatter;
import xyz.gabrielrohez.resumeapp.custom.scroll.ObservableScrollView;
import xyz.gabrielrohez.resumeapp.data.network.charts.DataCharts;

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

    public static AboutFragment newInstance() {
        Bundle args = new Bundle();
        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, rootView);
        scrollView.setOnScrollChangedListener(this);   //   for parallax effect

        List<DataCharts> listDataChart = new ArrayList<>();
        listDataChart.add(new DataCharts("C++", 2f));
        listDataChart.add(new DataCharts("Java", 3f));
        listDataChart.add(new DataCharts("Objective C", 0.5f));
        listDataChart.add(new DataCharts("Git", 1.5f));
        listDataChart.add(new DataCharts("Kotlin", 0.5f));

        MyBarChart myBarChart = new MyBarChart(chart, getActivity(), listDataChart);
        myBarChart.showBarChart();
        return rootView;
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
        switch (view.getId()) {
            case R.id.layoutAboutWeb:

                break;
            case R.id.layoutAboutPlay:

                break;
            case R.id.layoutAboutGit:

                break;
        }
    }
}
