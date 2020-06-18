package xyz.gabrielrohez.resumeapp.ui.experience;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.databinding.FragmentExperienceBinding;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;
import xyz.gabrielrohez.resumeapp.ui.experience.adapter.ExperienceAdapter;
import xyz.gabrielrohez.resumeapp.ui.splash.viewmodel.SplashViewModel;

public class ExperienceFragment extends Fragment {

    private ResumeResponse resume;
    private FragmentExperienceBinding binding;

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
        binding = FragmentExperienceBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecycler();
    }

    private void setUpRecycler() {

        ExperienceAdapter adapterExperience = new ExperienceAdapter(resume.getApps(), requireActivity());
        binding.recyclerApps.setLayoutManager(new GridLayoutManager(requireActivity(), 4, GridLayoutManager.VERTICAL, false));
        binding.recyclerApps.setHasFixedSize(true);
        binding.recyclerApps.setAdapter(adapterExperience);
        adapterExperience.notifyDataSetChanged();

    }
}