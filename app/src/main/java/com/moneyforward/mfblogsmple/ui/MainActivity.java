package com.moneyforward.mfblogsmple.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.moneyforward.mfblogsmple.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.recycler_button)
    void onRecyclerButtonClicked(View v) {
        startActivity(new Intent(this, TiqavActivity.class));
    }

    @OnClick(R.id.shadow_button)
    void onShadowButtonClicked(View v) {
        startActivity(new Intent(this, ShadowableActivity.class));
    }
}
