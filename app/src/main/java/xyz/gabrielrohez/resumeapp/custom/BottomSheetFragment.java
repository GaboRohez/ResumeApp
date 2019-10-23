package xyz.gabrielrohez.resumeapp.custom;

import android.app.Dialog;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.data.network.response.Courses;
import xyz.gabrielrohez.resumeapp.utils.AppConstants;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private Courses data;
    private ActionsInterface listener;

    @BindView(R.id.bsTitle) TextView tvTitle;

    public interface ActionsInterface {
        void downloadFile(String fileName);
        void sharedFile(String fileName);
    }

    public BottomSheetFragment(Courses data, ActionsInterface listener) {
        this.data = data;
        this.listener = listener;
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
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bsDownload:
                listener.downloadFile(AppConstants.PDF_FILE.getNameFromId(data.getImage()));
                break;
            case R.id.bsShared:
                listener.sharedFile(AppConstants.PDF_FILE.getNameFromId(data.getImage()));
                break;
        }
        //  hide dialog
        getDialog().dismiss();
    }
}
