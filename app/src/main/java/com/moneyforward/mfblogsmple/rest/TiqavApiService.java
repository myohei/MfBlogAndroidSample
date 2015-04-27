package com.moneyforward.mfblogsmple.rest;

import com.moneyforward.mfblogsmple.loader.Tiqav;

import java.util.List;

import retrofit.RetrofitError;
import retrofit.http.GET;

/**
 * Created by maeda on 15/04/27.
 */
public interface TiqavApiService {

    @GET("/search/random.json")
    public List<Tiqav> getRandom() throws RetrofitError;
}
