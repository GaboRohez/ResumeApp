package xyz.gabrielrohez.resumeapp.ui.main;

import android.os.Bundle;
import android.util.Log;
import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.base.activity.BasicActivity;
import xyz.gabrielrohez.resumeapp.data.network.model.about.ResponseAbout;

public class MainActivity extends BasicActivity {

    private ResponseAbout body;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getParcelableData();
    }

    private void getParcelableData() {
        if (getIntent().getExtras()!=null){
            body = (ResponseAbout) getIntent().getParcelableExtra("body");
            Log.d("APP_LOG", body.toString());
        }
    }
}
