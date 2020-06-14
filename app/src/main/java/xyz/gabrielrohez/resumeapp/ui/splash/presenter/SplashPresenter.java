package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.ui.splash.interactor.SplashInteractor;
import xyz.gabrielrohez.resumeapp.ui.splash.interactor.SplashInteractorIn;
import xyz.gabrielrohez.resumeapp.ui.splash.view.SplashView;

public class SplashPresenter implements SplashPresenterIn.Listener, SplashPresenterIn.Presenter {

    private SplashView view;
    private SplashInteractorIn interactor;

    public SplashPresenter(SplashView view) {
        this.view = view;
        interactor = new SplashInteractor();
    }
}
