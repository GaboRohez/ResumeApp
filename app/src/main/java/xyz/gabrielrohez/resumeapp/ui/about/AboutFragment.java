package xyz.gabrielrohez.resumeapp.ui.about;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class AboutFragment extends BasicFragment {

    @BindView(R.id.tvAboutName)
    TextView tvName;
    @BindView(R.id.tvAboutLocation)
    TextView tvLocation;
    @BindView(R.id.tvAboutJob)
    TextView tvJob;
    @BindView(R.id.layoutAboutWeb)
    LinearLayout layoutAboutWeb;
    @BindView(R.id.layoutAboutPlay)
    LinearLayout layoutAboutPlay;
    @BindView(R.id.layoutAboutGit)
    LinearLayout layoutAboutGit;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick({R.id.layoutAboutWeb, R.id.layoutAboutPlay, R.id.layoutAboutGit})
    public void onViewClicked(View view) {
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
