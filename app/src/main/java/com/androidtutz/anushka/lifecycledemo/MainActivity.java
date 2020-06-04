package com.androidtutz.anushka.lifecycledemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    MainActivityViewModel mainActivityViewModel;
    private TextView textView;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initial_views();

        mainActivityViewModel=ViewModelProviders.of(this).get(MainActivityViewModel.class);

        LiveData<Integer> count=mainActivityViewModel.getInitialCount();
        count.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer integer) {
                textView.setText("Count is: "+integer);
            }
        });


    }

    private void initial_views() {
        textView=findViewById(R.id.tvCount);
        fab = findViewById(R.id.fab);


    }


    public void fab_onclickListener(View view){
        mainActivityViewModel.getCurrentCount();
    }


}
