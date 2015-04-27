package com.moneyforward.mfblogsmple.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.moneyforward.mfblogsmple.ui.widget.TiqavRecyclerView;

public class TiqavActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TiqavRecyclerView tiqavRecyclerView = new TiqavRecyclerView(this);
        setContentView(tiqavRecyclerView);
        getSupportLoaderManager().initLoader(tiqavRecyclerView.hashCode(), null, tiqavRecyclerView);
    }
}
