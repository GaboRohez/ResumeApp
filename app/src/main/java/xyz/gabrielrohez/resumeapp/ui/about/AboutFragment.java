package xyz.gabrielrohez.resumeapp.ui.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.databinding.ContentScrollBinding;
import xyz.gabrielrohez.resumeapp.databinding.FragmentAboutBinding;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;
import xyz.gabrielrohez.resumeapp.ui.about.adapter.ChipAdapter;
import xyz.gabrielrohez.resumeapp.ui.splash.viewmodel.SplashViewModel;

public class AboutFragment extends Fragment implements View.OnClickListener {

    private ChipAdapter adapter;
    private ResumeResponse resume;
    private FragmentAboutBinding binding;
    private ContentScrollBinding bindingScroll;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashViewModel viewModel = ViewModelProviders.of(requireActivity()).get(SplashViewModel.class);
        resume = viewModel.getResponse();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAboutBinding.inflate(inflater, container, false);
        bindingScroll = binding.scrollableContent;
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpData();
        setUpEvents();
    }

    /**
     * In this method, fill the textviews with info from viewModel
     */
    private void setUpData() {
        binding.tvName.setText(resume.getAbout().getName());
        binding.tvLocation.setText(resume.getAbout().getLocation());
        binding.tvJob.setText(resume.getAbout().getJob());
        bindingScroll.tvResume.setText(resume.getAbout().getResume());

        //  recyclerviews
        adapter = new ChipAdapter(resume.getSkills().getLanguages());
        bindingScroll.recyclerLanguages.setLayoutManager(new GridLayoutManager(requireActivity(), 3, GridLayoutManager.VERTICAL, false));
        bindingScroll.recyclerLanguages.setHasFixedSize(true);
        bindingScroll.recyclerLanguages.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    /**
     * Create onclick method in imagebuttons
     */
    private void setUpEvents() {
        binding.btnWeb.setOnClickListener(this);
        binding.btnGithub.setOnClickListener(this);
        binding.btnPlaystore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String url = "";
        switch (v.getId()){
            case R.id.btnWeb:
                url = resume.getSocial().getWeb();
                break;
            case R.id.btnGithub:
                url = resume.getSocial().getGithub();
                break;
            case R.id.btnPlaystore:
                url = resume.getSocial().getPlaystore();
                break;
        }
        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url)));
    }
}