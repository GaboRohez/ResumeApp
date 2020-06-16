package xyz.gabrielrohez.resumeapp.ui.splash.view;

import xyz.gabrielrohez.resumeapp.model.ResumeResponse;

public interface SplashView {
    void errorInWS(String message);
    void openResume(ResumeResponse response);
}
