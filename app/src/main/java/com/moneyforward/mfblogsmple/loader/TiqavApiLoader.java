package com.moneyforward.mfblogsmple.loader;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import com.google.gson.Gson;
import com.moneyforward.mfblogsmple.rest.TiqavApiService;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by maeda on 15/04/27.
 */
public class TiqavApiLoader extends AsyncTaskLoader<List<Tiqav>> {

    private List<Tiqav> mTiqavList;

    public TiqavApiLoader(Context context) {
        super(context);
    }

    @Override
    public List<Tiqav> loadInBackground() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://api.tiqav.com")
                .setConverter(new GsonConverter(new Gson()))
                .build();
        TiqavApiService api = restAdapter.create(TiqavApiService.class);
        return api.getRandom();
    }

    @Override
    protected void onStartLoading() {
        if (mTiqavList != null
                && !mTiqavList.isEmpty()) {
            deliverResult(mTiqavList);
            return;
        }
        forceLoad();
    }

    @Override
    public void deliverResult(List<Tiqav> data) {
        if (!isReset()) {
            if (mTiqavList != null) {
                mTiqavList = null;
            }
        }
        mTiqavList = data;
        if (isStarted()) {
            super.deliverResult(data);
        }
    }

    @Override
    protected void onReset() {
        super.onReset();
        onStopLoading();
        if (mTiqavList != null) {
            mTiqavList = null;
        }
    }
}
