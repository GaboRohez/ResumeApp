package xyz.gabrielrohez.resumeapp.ui.splash.view;

import androidx.annotation.Nullable;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.activity.BasicActivity;
import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;
import xyz.gabrielrohez.resumeapp.ui.main.MenuActivity;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenter;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenterIn;

public class SplashActivity extends BasicActivity implements SplashView {

    private SplashPresenterIn presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        presenter = new SplashPresenter(this, this);

        presenter.getPersonalInfo();
    }

    @Override
    public void openProfile(ResponseAbout body) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MenuActivity.class).putExtra("body", body));
                finish();
            }
        }, 2000);
    }
}
