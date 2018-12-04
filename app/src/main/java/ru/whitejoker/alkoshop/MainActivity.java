package ru.whitejoker.alkoshop;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.io.InputStreamReader;

import ru.whitejoker.alkoshop.databinding.MainActivityBinding;
import ru.whitejoker.alkoshop.ui.main.MainFragment;
import ru.whitejoker.alkoshop.ui.main.MainViewModel;

public class MainActivity extends AppCompatActivity {

    InputStreamReader reader;

    private Toolbar toolbar;

    private MainViewModel model;
    private MainActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }

        model = ViewModelProviders.of(this).get(MainViewModel.class);
        binding = DataBindingUtil.setContentView(this, R.layout.main_activity);
        toolbar = (Toolbar)binding.toolbarOrders;
        setSupportActionBar(toolbar);

        reader = new InputStreamReader(getResources().openRawResource(R.raw.data));
        UserOrdersResponse response = UserOrdersResponse.fromJson(reader);
        setFragment(new MainFragment());
    }

    public void setFragment(Fragment fragment){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
