package com.moneyforward.mfblogsmple.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.moneyforward.mfblogsmple.R;
import com.moneyforward.mfblogsmple.loader.Tiqav;
import com.moneyforward.mfblogsmple.loader.TiqavApiLoader;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by maeda on 15/04/27.
 */
public class TiqavRecyclerView extends RecyclerView implements LoaderManager.LoaderCallbacks<List<Tiqav>> {

    public TiqavRecyclerView(Context context) {
        this(context, null);
    }

    public TiqavRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TiqavRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    // View 初期化
    private void init(Context context) {
        // RecylerViewをGridで表示
        final GridLayoutManager glm = new GridLayoutManager(context, 4, VERTICAL, false);
        this.setLayoutManager(glm);
    }

    @Override
    public Loader<List<Tiqav>> onCreateLoader(int id, Bundle args) {
        return new TiqavApiLoader(getContext());
    }

    @Override
    public void onLoadFinished(Loader<List<Tiqav>> loader, List<Tiqav> data) {
        if (data == null) {
            // TODO: EmptyView.
            return;
        }
        this.setAdapter(new TiqavRecyclerViewAdapter(data));
    }

    @Override
    public void onLoaderReset(Loader<List<Tiqav>> loader) {
    }

    private static class TiqavRecyclerViewAdapter extends Adapter<TiqavViewHolder> {

        @NonNull
        private final List<Tiqav> tiqavList;

        private TiqavRecyclerViewAdapter(@NonNull List<Tiqav> tiqavList) {
            this.tiqavList = tiqavList;
        }

        @Override
        public TiqavViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            final View view = inflater.inflate(R.layout.view_tiqav_image, parent, false);
            return new TiqavViewHolder(view);
        }

        @Override
        public void onBindViewHolder(TiqavViewHolder holder, int position) {
            final String imgUrl = tiqavList.get(position).getSourceUrl();
            holder.bind(imgUrl);
        }

        @Override
        public int getItemCount() {
            return tiqavList.size();
        }
    }


    private static class TiqavViewHolder extends ViewHolder {

        private ImageView imgView;
        private TextView errorText;

        public TiqavViewHolder(View itemView) {
            super(itemView);
            imgView = (ImageView) itemView.findViewById(R.id.img);
            errorText = (TextView) itemView.findViewById(R.id.text);
        }

        void bind(String imgUrl) {
            // 画像取得.
            Picasso.with(imgView.getContext())
                    .load(imgUrl)
                    .fit()
                    .into(imgView, new Callback() {
                        @Override
                        public void onSuccess() {
                            errorText.setVisibility(GONE);
                        }

                        @Override
                        public void onError() {
                            imgView.setVisibility(GONE);
                            errorText.setVisibility(VISIBLE);
                        }
                    });
        }
    }
}
