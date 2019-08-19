package xyz.gabrielrohez.resumeapp.ui.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;

public class DialogSplash extends DialogFragment {

    @BindView(R.id.splashDialogMessage) TextView message;

    public static DialogSplash newInstance(String message) {
        Bundle args = new Bundle();
        args.putString("message", message);
        DialogSplash fragment = new DialogSplash();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash_dialog, container, false);
        ButterKnife.bind(this, view);
        message.setText(getArguments().getString("message"));
        return view;
    }

    @OnClick(R.id.splashButtonAccept)
    public void OnClick(){
        getDialog().dismiss();
        getActivity().finish();
    }

    @Override
    public void onStart() {
        super.onStart();
        getDialog().setCancelable(false);
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
    }
}
