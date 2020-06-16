package xyz.gabrielrohez.resumeapp.ui.splash.viewmodel;

import androidx.lifecycle.ViewModel;

import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public class SplashViewModel  extends ViewModel {

    private ResumeResponse response;

    public ResumeResponse getResponse() {
        return response;
    }

    public void setResponse(ResumeResponse response) {
        this.response = response;
    }
}

