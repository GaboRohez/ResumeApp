package xyz.gabrielrohez.resumeapp.base.activity;

import androidx.fragment.app.Fragment;

public interface BasicView {
    void addFragment(Fragment fragment, final String TAG, int id);
    void replaceFragment(Fragment fragment, final String TAG, int id);
    void setTitleToolbar(String title);
}
