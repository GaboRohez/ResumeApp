package xyz.gabrielrohez.resumeapp.ui.splash.interactor;

import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenterIn;

public interface SplashInteractorIn {
    void getResumeInfo(SplashPresenterIn.Listener listener);
}
