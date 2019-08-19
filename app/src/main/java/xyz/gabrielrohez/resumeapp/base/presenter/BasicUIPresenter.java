package xyz.gabrielrohez.resumeapp.base.presenter;

import xyz.gabrielrohez.resumeapp.base.activity.BasicUIView;

public class BasicUIPresenter implements BasicUIListener {

    private BasicUIView basicUIView;

    public BasicUIPresenter(BasicUIView basicUIView) {
        this.basicUIView = basicUIView;
    }

    @Override
    public void showDialog(String message) {
        if (basicUIView != null){
            basicUIView.showDialog(message);
        }
    }

    @Override
    public void showLoader(boolean visible) {
        if (basicUIView != null){
            basicUIView.showLoader(visible);
        }
    }

    @Override
    public void showDialogSplash(String message) {
        if (basicUIView != null){
            basicUIView.showDialogSplash(message);
        }
    }
}
