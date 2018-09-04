package com.zhenman.asus.zhenman.view.myself;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.AlartDataContract;
import com.zhenman.asus.zhenman.model.bean.AlartDataBean;
import com.zhenman.asus.zhenman.presenter.AlartDataPresenter;
import com.zhenman.asus.zhenman.utils.UploadUtil;
import com.zhenman.asus.zhenman.utils.photo.PhotoHelp;
import com.zhenman.asus.zhenman.utils.photo.PhotoUtils;
import com.zhenman.asus.zhenman.utils.sp.SPKey;
import com.zhenman.asus.zhenman.utils.sp.SPUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import io.reactivex.annotations.NonNull;

public class PersonalInformationActivity extends BaseActivity<AlartDataPresenter> implements View.OnClickListener, AlartDataContract.AlartDataInView {


    private TextView myInfo_skip;
    private CircleImageView myInfo_avatar;
    private EditText myInfo_enterNikeName;
    private TextView myInfo_selectBorn;
    private ImageView myInfo_boy;
    private ImageView myInfo_girl;
    private AutoRelativeLayout myInfo_finish;

    protected static final int CHOOSE_PICTURE = 0;
    protected static final int TAKE_PICTURE = 1;
    private static final int CROP_SMALL_PICTURE = 2;
    protected static Uri tempUri;
    private PopupWindow popupWindow;
    private File file;
    private LinearLayout selector_popup_dissmis_line;
    private LinearLayout selector_popup_imgLibily_line;
    private LinearLayout selector_popup_photo_line;
    private View popupView;
    private View popupView1;
    private static String selectSex = "";
    private EditText myInfo_introduction;
    private static String bitmapString;
    private TranslateAnimation animation;
    //这是相册权限
    private final int STORAGE_PERMISSIONS_REQUEST_CODE = 100;
    //这是相册请求码
    private final int CODE_GALLERY_REQUEST = 200;
    //相机权限码
    private final int CAMERA_PERMISSIONS_REQUEST_CODE = 300;
    //相机请求码
    private final int CODE_CAMERA_REQUEST = 400;
    private String filePath;
    private Map<ImageView,String> mHashMap;
    private List<String> mList;
    protected int getLayoutId() {
        return R.layout.activity_personal_information;
    }

    @Override
    protected void init() {

        myInfo_skip = findViewById(R.id.myInfo_skip);
        myInfo_avatar = findViewById(R.id.myInfo_avatar);
        myInfo_enterNikeName = findViewById(R.id.myInfo_enterNikeName);
        myInfo_selectBorn = findViewById(R.id.myInfo_selectBorn);
        myInfo_boy = findViewById(R.id.myInfo_boy);
        myInfo_girl = findViewById(R.id.myInfo_girl);
        myInfo_finish = findViewById(R.id.myInfo_finish);
        myInfo_introduction = findViewById(R.id.myInfo_introduction);
        mHashMap = new HashMap<>();
        mList=new ArrayList<>();
//        seventBug();
//        initPopup();

        idListener();

    }

    private void bornPiker() {
        TimePickerView pvTime = new TimePickerBuilder(PersonalInformationActivity.this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                myInfo_selectBorn.setText(getTime(date));
            }
        }).build();
        pvTime.show();
    }

    //转换时间格式
    private String getTime(Date date) {//可根据需要自行截取数据显示

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }

    private void idListener() {
        myInfo_skip.setOnClickListener(this);
        myInfo_avatar.setOnClickListener(this);
        myInfo_enterNikeName.setOnClickListener(this);
        myInfo_selectBorn.setOnClickListener(this);
        myInfo_boy.setOnClickListener(this);
        myInfo_girl.setOnClickListener(this);
        myInfo_finish.setOnClickListener(this);

    }

    @Override
    protected void loadDate() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.myInfo_skip:
                break;
//                切换头像
            case R.id.myInfo_avatar:
                showPopueWindow();
//                popupWindow.showAsDropDown(myInfo_introduction, 0, 0);
//// 设置popupWindow的显示位置，此处是在手机屏幕底部且水平居中的位置
//                popupWindow.showAtLocation(PersonalInformationActivity.this.findViewById(R.id.myInfo_introduction), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
//                popupView.startAnimation(animation);

                break;
            case R.id.myInfo_enterNikeName:
                break;
            case R.id.myInfo_selectBorn:
                bornPiker();
                break;
            case R.id.myInfo_boy:
                myInfo_boy.setAlpha(0.5f);
                myInfo_girl.setAlpha(1.0f);
                selectSex = "2";
                break;
            case R.id.myInfo_girl:
                myInfo_boy.setAlpha(1.0f);
                myInfo_girl.setAlpha(0.5f);
                selectSex = "1";
                break;
            case R.id.myInfo_finish:
                String accessToken = (String) SPUtils.get(PersonalInformationActivity.this, SPKey.USER_REFRESHTOKEN, "");
                String oauthId = (String) SPUtils.get(this, SPKey.USER_OAUTHID, "");
                Log.e("Sushine",accessToken);
                Log.e("Sushine",oauthId);
                presenter.sendAlartData("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJqd3QiLCJpYXQiOjE1MzQ4MzYzOTAsInN1YiI6IntcInVzZXJJZFwiOjMwNixcInJvbGVUeXBlXCI6bnVsbCxcInNlc3Npb25JZFwiOlwiQjUyNzI3NkIyODlFRjcyRTM5NzAxRUJDQjMyNzdFRUVcIixcInVzZXJBZ2VudFwiOlwiUG9zdG1hblJ1bnRpbWUvNy4xLjVcIixcImluZGV4XCI6MCxcInJlZnJlc2hUb2tlblwiOmZhbHNlfSIsImV4cCI6MTU2NjM3MjM5MH0.0nQECGVov3ZMpdbblKfBKThM7ogDtP-qJrOwT7bYHDs","69",selectSex,myInfo_enterNikeName.getText().toString(),myInfo_introduction.getText().toString(),bitmapString,myInfo_selectBorn.getText().toString());
                break;
            case R.id.selector_popup_imgLibily_line:
                PhotoHelp.autoObtainStoragePermission(PersonalInformationActivity.this, STORAGE_PERMISSIONS_REQUEST_CODE, CODE_GALLERY_REQUEST);
                popupWindow.dismiss();
                break;
            case R.id.selector_popup_photo_line:
                filePath = PhotoHelp.getFilePath();
                PhotoHelp.applyForCameraPermission(PersonalInformationActivity.this, CAMERA_PERMISSIONS_REQUEST_CODE, filePath, CODE_CAMERA_REQUEST);
                popupWindow.dismiss();
                break;
            case R.id.selector_popup_dissmis_line:
                popupWindow.dismiss();
                break;
        }
    }
    //显示详情
    private void startIntent(ImageView view){
        Intent intent = new Intent(this, PersonalInformationActivity.class);
        intent.putExtra("name",mHashMap.get(view));
        startActivity(intent);
    }
    //删除图片
    private void delete(ImageView image, RelativeLayout relativeLayout, LinearLayout linearLayout){
        mHashMap.remove(image);
        relativeLayout.setVisibility(View.GONE);
        linearLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case CAMERA_PERMISSIONS_REQUEST_CODE:
                filePath = PhotoHelp.getFilePath();
                PhotoHelp.cameraPermissionResult(this, grantResults, CAMERA_PERMISSIONS_REQUEST_CODE, filePath, CODE_CAMERA_REQUEST);
                break;
            case STORAGE_PERMISSIONS_REQUEST_CODE://调用系统相册申请Sdcard权限回调
                PhotoHelp.xiangCePermissionResult(this, grantResults, CODE_GALLERY_REQUEST);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case CODE_CAMERA_REQUEST://拍照完成回调
                    Bitmap cameraBitmap = BitmapFactory.decodeFile(filePath);
                    Log.d("xaingji", filePath);

                    myInfo_avatar.setImageBitmap(cameraBitmap);
                    break;
                case CODE_GALLERY_REQUEST://访问相册完成回调
                    Bitmap xiangCeBitmap = PhotoHelp.xiangCeResult(this, data);
                    String path = PhotoUtils.getPath(PersonalInformationActivity.this, data.getData());
                    Log.d("xiangce", path);
//                    这个不行
                    myInfo_avatar.setImageBitmap(xiangCeBitmap);
                    break;
            }
        }
    }


    private void showPopueWindow() {
        popupView1 = LayoutInflater.from(this).inflate(R.layout.img_selector_popup, null);
        selector_popup_dissmis_line = popupView1.findViewById(R.id.selector_popup_dissmis_line);
        selector_popup_imgLibily_line = popupView1.findViewById(R.id.selector_popup_imgLibily_line);
        selector_popup_photo_line = popupView1.findViewById(R.id.selector_popup_photo_line);
        //获取屏幕宽高
        int weight = getResources().getDisplayMetrics().widthPixels;
        int height = getResources().getDisplayMetrics().heightPixels * 1 / 4;

        popupWindow = new PopupWindow(popupView1, weight, height);
        // popupWindow.setAnimationStyle(R.style.anim_popup_dir);
        popupWindow.setFocusable(true);
        //点击外部popueWindow消失
        popupWindow.setOutsideTouchable(true);
        selector_popup_imgLibily_line.setOnClickListener(this);
        selector_popup_photo_line.setOnClickListener(this);
        selector_popup_dissmis_line.setOnClickListener(this);
        //popupWindow消失屏幕变为不透明
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().setAttributes(lp);
            }
        });
        popupWindow.showAtLocation(popupView1, Gravity.BOTTOM, 0, 0);
    }








  /*  //对图片处理的回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) { // 如果返回码是可以用的
            switch (requestCode) {
                case TAKE_PICTURE:
                    startPhotoZoom(tempUri); // 开始对图片进行裁剪处理
                    break;
                case CHOOSE_PICTURE:
                    startPhotoZoom(data.getData()); // 开始对图片进行裁剪处理
                    break;
                case CROP_SMALL_PICTURE:
                    if (data != null) {
                        setImageToView(data); // 让刚才选择裁剪得到的图片显示在界面上
                    }
                    break;
            }
        }
    }*/
    /**
     * 上传图片到服务器
     */
    private void toUploadFile() {

        String fileKey = "avatarFile";
        UploadUtil uploadUtil = UploadUtil.getInstance();
//        uploadUtil.setOnUploadProcessListener(this); //设置监听器监听上传状态
        Map<String, String> params = new HashMap<>();//上传map对象
        params.put("picName", "UserIcon");
        params.put("code", "1");
        uploadUtil.uploadFile(file, fileKey, "http://154.8.215.210:8888/api/Public/uploadPic", params);
        Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
//        uploadPicturePresenter.loadUploadPictureData("UserIcon",1);
    }

    //修改个人资料
    @Override
    public void showAlartData(AlartDataBean alartDataBean) {
        Log.e("Sunshine",alartDataBean.getMsg());
        if (!alartDataBean.getMsg().isEmpty()&&alartDataBean.getMsg().equals("成功")) {
            Toast.makeText(this, "修改资料成功", Toast.LENGTH_SHORT).show();
            finish();
        }else {
            Toast.makeText(this, "请先完成登陆", Toast.LENGTH_SHORT).show();
        }
    }
}
