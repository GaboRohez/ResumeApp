package xyz.gabrielrohez.resumeapp.ui.splash.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import xyz.gabrielrohez.resumeapp.databinding.FragmentSplashBinding;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenter;

public class SplashFragment extends Fragment implements SplashView {

    private SplashPresenter presenter;
    private  FragmentSplashBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SplashPresenter(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(LayoutInflater.from(requireActivity()));
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter.getResumeInfo();
    }
}