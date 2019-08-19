package xyz.gabrielrohez.resumeapp.ui.splash.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;
import xyz.gabrielrohez.resumeapp.ui.main.MainActivity;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenter;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenterIn;

public class SplashActivity extends AppCompatActivity implements SplashView {

    private SplashPresenterIn presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new SplashPresenter(this);

        presenter.getPersonalInfo();
    }

    @Override
    public void openProfile(ResponseAbout body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("body", body);
        startActivity(intent);
        finish();
    }
}
