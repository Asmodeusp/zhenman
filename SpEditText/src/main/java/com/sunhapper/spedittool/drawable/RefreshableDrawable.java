package com.sunhapper.spedittool.drawable;

import android.graphics.drawable.Drawable;


public interface RefreshableDrawable {

  boolean canRefresh();

  int getInterval();

  void addCallback(Drawable.Callback callback);

  void removeCallback(Drawable.Callback callback);

}
