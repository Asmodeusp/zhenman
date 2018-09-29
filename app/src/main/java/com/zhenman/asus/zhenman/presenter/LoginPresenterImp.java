package com.zhenman.asus.zhenman.presenter;

import android.util.Log;

import com.zhenman.asus.zhenman.App;
import com.zhenman.asus.zhenman.contract.LoginContract;
import com.zhenman.asus.zhenman.model.bean.ThirdPartyLoginBean;
import com.zhenman.asus.zhenman.model.bean.UserBean;
import com.zhenman.asus.zhenman.model.service.LoginService;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenterImp implements LoginContract.LoginPresenter {
    LoginContract.LoginView loginView;

    @Override
    public void actualView(LoginContract.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void unActualView() {
        this.loginView = null;
    }


    @Override
    public void getLogin(String phone, String password) {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("password", password);
        RetrofitUtils.getInstance().getLoginService().GetUserBean(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UserBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(UserBean userBean) {
                        if (userBean.getState() == 0) {
                            //利用SP储存用户信息
                            SPUtils.put(App.context, "token", userBean.getData().getToken());
                            SPUtils.put(App.context, "refreshToken", userBean.getData().getRefreshToken());
                            SPUtils.put(App.context, "isBindMobile", userBean.getData().getIsBindMobile());
                            SPUtils.put(App.context, "sex", userBean.getData().getSex()+"");
                            SPUtils.put(App.context, "name", userBean.getData().getName());
                            SPUtils.put(App.context, "id", userBean.getData().getId());
                            SPUtils.put(App.context, "introduction", userBean.getData().getIntroduction());
//                            保存登陆成功
                            SPUtils.put(App.context, SPKey.IS_LOGIN, true);

                            loginView.showError(userBean.getMsg());
                            loginView.gotoContent();
                        } else {
                            loginView.showError(userBean.getMsg());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public void sendUMengLoginData(String otherUserId, String name, String cityName, String headImg, String sex, String type, String openId) {
        Map<String, String> map = new HashMap<>();
        map.put("otherUserId", otherUserId);
        map.put("name", name);
        map.put("cityName", cityName);
        map.put("headImg", headImg);
        map.put("sex", sex);
        map.put("type", type);
        map.put("openId", openId);


        RetrofitUtils.getInstance().getService(LoginService.class).GetThirdPartyLoginBean(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ThirdPartyLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.e("onComple", d.toString());
                    }

                    @Override
                    public void onNext(ThirdPartyLoginBean uMengLoginBean) {
                        Log.e("onNext", uMengLoginBean.getMsg());
                        Log.e("onNext", uMengLoginBean.getState() + "");

                        loginView.showUMengLoginData(uMengLoginBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("onError", e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Log.e("onComple", "8956");

                    }
                });
                /*.subscribe(new Consumer<UMengLoginBean>() {
                    @Override
                    public void accept(UMengLoginBean uMengLoginBean) throws Exception {
                        loginView.showUMengLoginData(uMengLoginBean);
                    }
                });*/
    }
}
