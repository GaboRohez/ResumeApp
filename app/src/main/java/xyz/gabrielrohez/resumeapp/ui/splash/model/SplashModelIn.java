package xyz.gabrielrohez.resumeapp.ui.splash.model;

import xyz.gabrielrohez.resumeapp.base.presenter.BasicUIListener;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashListener;

public interface SplashModelIn {
    void getPersonalInfo(SplashListener listener, BasicUIListener basicUIListener);
}
