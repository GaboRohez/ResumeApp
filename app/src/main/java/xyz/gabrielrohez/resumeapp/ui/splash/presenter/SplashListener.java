package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.data.network.response.MyResumeResponse;

public interface SplashListener {
    void openProfile(MyResumeResponse body);
}
