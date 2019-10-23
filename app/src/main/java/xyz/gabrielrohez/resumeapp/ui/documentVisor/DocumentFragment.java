package xyz.gabrielrohez.resumeapp.ui.documentVisor;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.github.barteksc.pdfviewer.PDFView;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.fragment.BasicFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DocumentFragment extends BasicFragment {

    @BindView(R.id.documentPDFViewer) PDFView pdfViewer;

    private String assetName;

    public static DocumentFragment newInstance(String idPDF) {
        Bundle args = new Bundle();
        args.putString("idPDF", idPDF);
        DocumentFragment fragment = new DocumentFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_document, container, false);
        ButterKnife.bind(this, rootView);
        getParcelableData();

        pdfViewer.fromAsset(assetName).load();
        return rootView;
    }

    /**
     * get data from bundle
     */
    private void getParcelableData() {
        assetName = getArguments().getString("idPDF");
        Log.i("DOCUMENT-ID", ""+assetName);
    }

}
