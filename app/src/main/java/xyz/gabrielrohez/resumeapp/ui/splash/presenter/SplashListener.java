package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;

public interface SplashListener {
    void openProfile(ResponseAbout body);
}
