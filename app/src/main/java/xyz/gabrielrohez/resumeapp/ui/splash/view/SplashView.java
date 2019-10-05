package xyz.gabrielrohez.resumeapp.ui.splash.view;

import xyz.gabrielrohez.resumeapp.data.network.response.MyResumeResponse;

public interface SplashView {
    void openProfile(MyResumeResponse body);
}
