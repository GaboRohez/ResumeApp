package xyz.gabrielrohez.resumeapp.ui.splash.interactor;

import android.util.Log;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import xyz.gabrielrohez.resumeapp.api.ResumeAPIService;
import xyz.gabrielrohez.resumeapp.api.RetrofitClient;
import xyz.gabrielrohez.resumeapp.ui.splash.presenter.SplashPresenterIn;

public class SplashInteractor implements SplashInteractorIn {

    @Override
    public void getResumeInfo(SplashPresenterIn.Listener listener) {

        CompositeDisposable disposable = new CompositeDisposable();
        disposable.add(RetrofitClient.retrofit.create(ResumeAPIService.class).getResume()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(resumeResponses -> {
                    Log.d("Salida", resumeResponses.getAbout().getName());
                }, throwable -> {
                    Log.d("Error", throwable.getMessage());
                }));
    }
}
