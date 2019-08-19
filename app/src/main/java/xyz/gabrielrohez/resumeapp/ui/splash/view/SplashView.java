package xyz.gabrielrohez.resumeapp.ui.splash.view;

import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;

public interface SplashView {
    void openProfile(ResponseAbout body);
}
