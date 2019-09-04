package xyz.gabrielrohez.resumeapp.base.presenter;

public interface BasicUIListener {
    void showDialog(String message);
    void showLoader(boolean visible);
    void showDialogSplash(String message);
}
