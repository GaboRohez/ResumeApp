package xyz.gabrielrohez.resumeapp.base.fragment;

import android.content.Context;

import androidx.fragment.app.Fragment;

import xyz.gabrielrohez.resumeapp.base.activity.BasicUIView;
import xyz.gabrielrohez.resumeapp.base.activity.BasicView;


public class BasicFragment extends Fragment {

    public BasicView basicView;
    public BasicUIView basicUIView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        basicView = (BasicView)context;
        basicUIView = (BasicUIView)context;
    }
}
