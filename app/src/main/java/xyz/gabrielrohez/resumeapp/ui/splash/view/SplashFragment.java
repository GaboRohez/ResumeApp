package xyz.gabrielrohez.resumeapp.ui.splash.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.constants.AppConstants;
import xyz.gabrielrohez.resumeapp.databinding.FragmentSplashBinding;
import xyz.gabrielrohez.resumeapp.model.ResumeResponse;
import xyz.gabrielrohez.resumeapp.ui.dialog.DialogFragment;
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
        setUpEvents();
    }

    //  event click
    private void setUpEvents() {
        binding.btnRetry.setOnClickListener(v -> {
            binding.btnRetry.setVisibility(View.GONE);
            binding.progressBar.setVisibility(View.VISIBLE);
            presenter.getResumeInfo();
        });
    }

    /**
     * This method shown an error message
     * @param message a message that will be shown to the user to inform them of what happened
     */
    @Override
    public void errorInWS(String message) {
        binding.btnRetry.setVisibility(View.VISIBLE);
        binding.progressBar.setVisibility(View.GONE);

        DialogFragment alertDialog = DialogFragment.newInstance(message);
        alertDialog.show(getChildFragmentManager(), AppConstants.TAG_DIALOG);
    }

    @Override
    public void openResume(ResumeResponse response) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Bundle bundle = new Bundle();
                //bundle.putParcelable("resume", response);
                Navigation.findNavController(getView()).navigate(R.id.action_splash_to_action_about);
            }
        }, 3000);
    }

}