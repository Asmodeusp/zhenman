package com.zhenman.asus.zhenman.view.home;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseFragment;

import butterknife.BindView;

import me.panpf.sketch.SketchImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowPhotoFragment extends BaseFragment {


    @BindView(R.id.show_photo_ImageView)
    SketchImageView showPhotoImageView;

    public ShowPhotoFragment() {
        // Required empty public constructor
    }


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_show_photo;
    }

    @Override
    protected void init() {
        Bundle arguments = getArguments();
        String finalImg = arguments.getString("finalImg");
        showPhotoImageView.displayImage(finalImg);
        showPhotoImageView .setZoomEnabled(true);
        showPhotoImageView.getZoomer().setReadMode(true);
        showPhotoImageView.setShowDownloadProgressEnabled(true);
        showPhotoImageView.getZoomer().zoom(3f, 100f, 200f, true);
        showPhotoImageView.getZoomer().setZoomInterpolator(new AccelerateDecelerateInterpolator());
        showPhotoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    protected void loadDate() {

    }


}
