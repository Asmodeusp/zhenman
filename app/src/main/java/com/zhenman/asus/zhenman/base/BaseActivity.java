package com.zhenman.asus.zhenman.base;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.Toast;

import com.gyf.barlibrary.ImmersionBar;
import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.utils.NetUtils;
import com.zhy.autolayout.AutoLayoutActivity;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseActivity<T extends BasePresenter> extends AutoLayoutActivity {
    protected T presenter;
    private Fragment lastFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ImmersionBar.with(this).init();
        if (Build.VERSION.SDK_INT >= 23) {
            String[] mPermissionList = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CALL_PHONE, Manifest.permission.READ_LOGS, Manifest.permission.READ_PHONE_STATE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.SET_DEBUG_APP, Manifest.permission.SYSTEM_ALERT_WINDOW, Manifest.permission.GET_ACCOUNTS, Manifest.permission.WRITE_APN_SETTINGS};
            ActivityCompat.requestPermissions(this, mPermissionList, 123);
        }
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN); //隐藏状态栏
        //判断是否是手机网络
        if (!NetUtils.is3GNet(this) && !NetUtils.isMobileConnected(this)) {
            Toast.makeText(this, "手机无网络", Toast.LENGTH_SHORT).show();
        }
        //判断WIFI网络是否可用
        if (!NetUtils.isWifiConnected(this)) {
            Toast.makeText(this, "手机WIFI不可用", Toast.LENGTH_SHORT).show();
        }
        //全局context赋值
        App.context = this;
        presenter = getPresenter();
        if (presenter != null) {
            presenter.actualView(this);
        }
        init();
        loadDate();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
    }

    protected T getPresenter() {
        Type type = getClass().getGenericSuperclass();
        if (BaseActivity.class.equals(type)) {
            return null;
        }
        Type[] arguments = ((ParameterizedType) type).getActualTypeArguments();
        Class<T> tClass = (Class<T>) arguments[0];
        try {
            return tClass.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.context = this;
        presenter = getPresenter();
        if (presenter != null) {
            presenter.actualView(this);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.context = null;
        if (presenter != null) {
            presenter.unActualView();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy(); //必须调用该方法，防止内存泄漏
    }

    /**
     * 加载布局
     * @return 要加载的布局文件
     */
    protected abstract int getLayoutId();

    /**
     * 统一初始化数据
     */
    protected abstract void init();

    /**
     * 统一加载数据
     */
    protected abstract void loadDate();

    /**
     * 切换Fragment
     * @param layoutId      Fragment要显示的布局id
     * @param fragmentClass 要显示的Fragment
     */
    protected void setContentView(int layoutId, Class<? extends BaseFragment> fragmentClass) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        String simpleName = fragmentClass.getSimpleName();
        Fragment fragment = fragmentManager.findFragmentByTag(simpleName);
        if (fragment == null) {
            try {
                fragment = fragmentClass.newInstance();
                transaction.add(layoutId, fragment, simpleName);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (lastFragment != null) {
            transaction.hide(lastFragment);
        }
        transaction.show(fragment);
        lastFragment = fragment;
        transaction.commit();
    }
}