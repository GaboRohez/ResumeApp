package xyz.gabrielrohez.resumeapp.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import xyz.gabrielrohez.resumeapp.R;
import xyz.gabrielrohez.resumeapp.databinding.ActivityMainBinding;
import xyz.gabrielrohez.resumeapp.ui.splash.viewmodel.SplashViewModel;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        navController.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() {
            @Override
            public void onDestinationChanged(@NonNull NavController controller, @NonNull NavDestination destination, @Nullable Bundle arguments) {
                if(destination.getId() == R.id.action_about) {
                   binding.bottomNavigationView.setVisibility(View.VISIBLE);
                }
            }
        });

        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController);


        /*SplashViewModel mFlightPlanViewModel = ViewModelProviders.of(this).get(SplashViewModel.class);
        mFlightPlanViewModel.getResume().observe(this, (flightPlans) -> {
            Log.d(TAG, "ON_CHANGED");
            Log.d(TAG, flightPlans.toString());

        });*/
    }
}