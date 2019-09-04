package xyz.gabrielrohez.resumeapp.ui.splash.presenter;

import xyz.gabrielrohez.resumeapp.base.activity.BasicUIView;
import xyz.gabrielrohez.resumeapp.base.presenter.BasicUIPresenter;
import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;
import xyz.gabrielrohez.resumeapp.ui.splash.model.SplashModel;
import xyz.gabrielrohez.resumeapp.ui.splash.view.SplashView;

public class SplashPresenter extends BasicUIPresenter implements SplashPresenterIn, SplashListener {

    private SplashView view;
    private SplashModel model;

    public SplashPresenter(BasicUIView basicUIView, SplashView view) {
        super(basicUIView);
        this.view = view;
        model = new SplashModel();
    }

    @Override
    public void getPersonalInfo() {
        model.getPersonalInfo(this, this);
    }

    @Override
    public void openProfile(ResponseAbout body) {
        if (view != null)
            view.openProfile(body);
    }
}
