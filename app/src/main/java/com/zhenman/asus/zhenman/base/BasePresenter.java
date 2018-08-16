package com.zhenman.asus.zhenman.base;

public interface BasePresenter<View> {
    void actualView(View view);

    void unActualView();
}