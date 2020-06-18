package xyz.gabrielrohez.resumeapp.ui.education;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;
import xyz.gabrielrohez.resumeapp.databinding.FragmentEducationBinding;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;
import xyz.gabrielrohez.resumeapp.ui.education.adapter.EducationAdapter;
import xyz.gabrielrohez.resumeapp.ui.splash.viewmodel.SplashViewModel;

public class EducationFragment extends Fragment {

    private ResumeResponse resume;
    private FragmentEducationBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SplashViewModel viewModel = ViewModelProviders.of(requireActivity()).get(SplashViewModel.class);
        resume = viewModel.getResponse();
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentEducationBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setUpRecycler();
    }

    private void setUpRecycler() {
        EducationAdapter adapter = new EducationAdapter(resume.getCourses(), requireActivity());
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.recyclerView.setHasFixedSize(true);
        binding.recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}