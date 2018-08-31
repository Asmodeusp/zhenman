package com.zhenman.asus.zhenman.view.myself;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.utils.umeng.PhotoUtils;
import com.zhy.autolayout.AutoRelativeLayout;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PersonalInformationActivity extends BaseActivity implements View.OnClickListener {


    private TextView myInfo_skip;
    private ImageView myInfo_avatar;
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
    private static String selectSex="";

    @Override
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
        seventBug();
        initPopup();
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
                popupWindow.showAsDropDown(myInfo_finish, 0, 0);

                break;
            case R.id.myInfo_enterNikeName:
                break;
            case R.id.myInfo_selectBorn:
                bornPiker();
                break;
            case R.id.myInfo_boy:
                myInfo_boy.setAlpha(0.5f);
                myInfo_girl.setAlpha(1.0f);
                selectSex="男";
                break;
            case R.id.myInfo_girl:
                myInfo_boy.setAlpha(1.0f);
                myInfo_girl.setAlpha(0.5f);
                selectSex="女";
                break;
            case R.id.myInfo_finish:

                break;
            case R.id.selector_popup_imgLibily_line:
                showImgLibily();
                break;
            case R.id.selector_popup_photo_line:
                showPhoto();
                break;
            case R.id.selector_popup_dissmis_line:
                popupWindow.dismiss();
                break;
        }
    }

    // android 7.0系统解决拍照的问题
    @SuppressLint("NewApi")
    private void seventBug() {
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }

    //调用系统相机
    private void showPhoto() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        file = new File(Environment.getExternalStorageDirectory(), "image.jpg");
        tempUri = Uri.fromFile(file);
        // 指定照片保存路径（SD卡），image.jpg为一个临时文件，每次拍照后这个图片都会被替换
        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, tempUri);
        startActivityForResult(openCameraIntent, TAKE_PICTURE);
    }

    //从相册选择图片
    private void showImgLibily() {
        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        openAlbumIntent.setType("image/*");
        startActivityForResult(openAlbumIntent, CHOOSE_PICTURE);
        // 在点击之后设置popupwindow的销毁
        if (popupWindow.isShowing()) {
            popupWindow.dismiss();
            lighton();
        }
    }


    //对图片处理的回调
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
    }

    /**
     * 裁剪图片方法实现
     *
     * @param uri
     */
    protected void startPhotoZoom(Uri uri) {
        if (uri == null) {

        }
        tempUri = uri;
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        // 设置裁剪
        intent.putExtra("crop", "true");
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高
        intent.putExtra("outputX", 150);
        intent.putExtra("outputY", 150);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_SMALL_PICTURE);
    }

    /**
     * 保存裁剪之后的图片数据
     *
     * @param
     * @param
     */
    protected void setImageToView(Intent data) {
        Bundle extras = data.getExtras();
        if (extras != null) {
            Bitmap photo = extras.getParcelable("data");
            photo = PhotoUtils.toRoundBitmap(photo, tempUri); // 这个时候的图片已经被处理成圆形的了
//            toUploadFile();
            myInfo_avatar.setImageBitmap(photo);
        }
    }

    private void initPopup() {
        popupView1 = LayoutInflater.from(this).inflate(R.layout.img_selector_popup, null);
        selector_popup_dissmis_line = popupView1.findViewById(R.id.selector_popup_dissmis_line);
        selector_popup_imgLibily_line = popupView1.findViewById(R.id.selector_popup_imgLibily_line);
        selector_popup_photo_line = popupView1.findViewById(R.id.selector_popup_photo_line);
        selector_popup_dissmis_line.setOnClickListener(this);
        selector_popup_imgLibily_line.setOnClickListener(this);
        selector_popup_photo_line.setOnClickListener(this);
        popupWindow = new PopupWindow(popupView1, WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT);
        // 需要设置一下此参数，点击外边可消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        //设置点击窗口外边窗口消失
        popupWindow.setOutsideTouchable(true);
        // 设置此参数获得焦点，否则无法点击
        popupWindow.setFocusable(true);
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                lighton();
            }
        });
        // 平移动画相对于手机屏幕的底部开始，X轴不变，Y轴从1变0
        TranslateAnimation animation = new TranslateAnimation(Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0,
                Animation.RELATIVE_TO_PARENT, 0, Animation.RELATIVE_TO_PARENT, 0);
        animation.setInterpolator(new AccelerateInterpolator());
        animation.setDuration(200);

    }

    /**
     * 设置手机屏幕亮度显示正常
     */
    private void lighton() {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 1f;
        getWindow().setAttributes(lp);
    }

    /**
     * 上传图片到服务器
     */
    private void toUploadFile() {
//        String fileKey = "avatarFile";
//        UploadUtil uploadUtil = UploadUtil.getInstance();
//        uploadUtil.setOnUploadProcessListener(this); //设置监听器监听上传状态
//        Map<String, String> params = new HashMap<>();//上传map对象
//        params.put("picName", "UserIcon");
//        params.put("code", "1");
//        uploadUtil.uploadFile(file, fileKey, "http://154.8.215.210:8888/api/Public/uploadPic", params);
//        Toast.makeText(this, "上传成功", Toast.LENGTH_LONG).show();
//        uploadPicturePresenter.loadUploadPictureData("UserIcon",1);
    }

}
