package com.zhenman.asus.zhenman.presenter;

import com.zhenman.asus.zhenman.contract.AlartDataContract;
import com.zhenman.asus.zhenman.model.bean.AlartDataBean;
import com.zhenman.asus.zhenman.model.service.AlertDataService;
import com.zhenman.asus.zhenman.utils.GetData;
import com.zhenman.asus.zhenman.utils.RetrofitUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MediaType;
import okhttp3.RequestBody;


public class AlartDataPresenter implements AlartDataContract.AlartDataInPresenter {
    AlartDataContract.AlartDataInView alartDataInView;

    private RequestBody toRequestBody(String value) {
        RequestBody requestBody = RequestBody.create(MediaType.parse("multipart/form-data"), value);
        return requestBody;
    }
    @Override
    public void sendAlartData(String oauthId, String sex, String name, String introduction, String headImg, String birthdate, File file) {

        Map<String, RequestBody> images = new HashMap<String, RequestBody>();
        RequestBody oauthIdRequestBody = toRequestBody(oauthId);
        RequestBody sexRequestBody = toRequestBody(sex);
        RequestBody nameRequestBody = toRequestBody(name);
        RequestBody introductionRequestBody = toRequestBody(introduction);
        RequestBody headImgRequestBody = toRequestBody(headImg);
        RequestBody birthdateRequestBody = toRequestBody(birthdate);
        images.put("oauthId", oauthIdRequestBody);
        images.put("sex", sexRequestBody);
        images.put("name", nameRequestBody);
        images.put("introduction", introductionRequestBody);
        images.put("headImg", headImgRequestBody);
        images.put("birthdate", birthdateRequestBody);
        images.put("file\";filename=\"" + "photo", RequestBody.create(MediaType.parse("image/png"), file));
        RetrofitUtils.getInstance().getService(AlertDataService.class)
                .upLoadPhoto(images)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AlartDataBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AlartDataBean alartDataBean) {
                        if (alartDataBean.getMsg().equals(GetData.MSG_SUCCESS)) {
                            alartDataInView.showAlartData(alartDataBean);
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
    public void actualView(AlartDataContract.AlartDataInView alartDataInView) {
        this.alartDataInView = alartDataInView;
    }

    @Override
    public void unActualView() {
        this.alartDataInView = null;
    }

}
