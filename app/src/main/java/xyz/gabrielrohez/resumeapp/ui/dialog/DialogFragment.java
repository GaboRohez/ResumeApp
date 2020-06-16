package xyz.gabrielrohez.resumeapp.ui.dialog;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.databinding.FragmentDialogBinding;

public class DialogFragment extends androidx.fragment.app.DialogFragment {

    private FragmentDialogBinding binding;

    public static DialogFragment newInstance(String message) {
        Bundle args = new Bundle();
        args.putString("message", message);
        DialogFragment fragment = new DialogFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentDialogBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.tvMessage.setText(getArguments().getString("message"));

        binding.btnAccept.setOnClickListener( v -> {
            dismiss();
        });
    }
}