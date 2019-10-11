package xyz.gabrielrohez.resumeapp.custom;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private Courses data;
    @BindView(R.id.bsTitle) TextView tvTitle;

    public BottomSheetFragment(Courses courses) {
        data = courses;
    }

    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        View contentView = View.inflate(getActivity(), R.layout.bottom_sheet, null);
        ButterKnife.bind(this, contentView);

        dialog.setContentView(contentView);
        dialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(R.drawable.rounded_dialog);

        //  title of document
        tvTitle.setText(data.getInstitute());
    }


    @OnClick({R.id.bsDownload, R.id.bsShared})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bsDownload:
                Log.i("BottomSheetFragment", "Download");
                break;
            case R.id.bsShared:
                Log.i("BottomSheetFragment", "Shared");
                break;
        }
    }
}
