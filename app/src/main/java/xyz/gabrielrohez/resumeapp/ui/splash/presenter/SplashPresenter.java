package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.ui.splash.model.SplashModel;
import xyz.gabrielrohez.resumeapp.ui.splash.view.SplashView;

public class SplashPresenter implements SplashPresenterIn, SplashListener {

    private SplashView view;
    private SplashModel model;

    public SplashPresenter(SplashView view) {
        this.view = view;
        model = new SplashModel();
    }
}
