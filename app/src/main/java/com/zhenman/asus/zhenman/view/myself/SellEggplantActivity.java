package com.zhenman.asus.zhenman.view.myself;

import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.zhenman.asus.zhenman.R;
import com.zhenman.asus.zhenman.base.BaseActivity;
import com.zhenman.asus.zhenman.contract.SellEggplantContract;
import com.zhenman.asus.zhenman.model.bean.SellEggplantBean;
import com.zhenman.asus.zhenman.model.bean.WeiXinTiXianBean;
import com.zhenman.asus.zhenman.presenter.SellEggplantPresenter;
import com.zhy.autolayout.AutoLinearLayout;
import com.zhy.autolayout.AutoRelativeLayout;

import java.text.NumberFormat;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

public class SellEggplantActivity extends BaseActivity<SellEggplantPresenter> implements SellEggplantContract.SellEggplantInView {


    @BindView(R.id.app_back)
    AutoRelativeLayout appBack;
    @BindView(R.id.app_title)
    TextView appTitle;
    @BindView(R.id.app_otherID)
    TextView appOtherID;
    @BindView(R.id.sellEggplant_eggplantNum)
    TextView sellEggplantEggplantNum;
    @BindView(R.id.sellEggplant_money)
    TextView sellEggplantMoney;
    @BindView(R.id.sellEggplant_question)
    ImageView sellEggplantQuestion;
    @BindView(R.id.sellEggplant_sellBtn)
    Button sellEggplantSellBtn;
    @BindView(R.id.sellEggplant_footView)
    AutoRelativeLayout sellEggplantFootView;
    private static double eggplantMoney = 0;
    private static int eggplantCount;
    @BindView(R.id.sellEggplant_img01)
    CircleImageView sellEggplantImg01;
    @BindView(R.id.sellEggplant_num01)
    TextView sellEggplantNum01;
    @BindView(R.id.sellEggplant_kind01)
    TextView sellEggplantKind01;
    @BindView(R.id.sellEggplant_isSelect01)
    CheckBox sellEggplantIsSelect01;
    @BindView(R.id.sellEggplant_img02)
    CircleImageView sellEggplantImg02;
    @BindView(R.id.sellEggplant_num02)
    TextView sellEggplantNum02;
    @BindView(R.id.sellEggplant_kind02)
    TextView sellEggplantKind02;
    @BindView(R.id.sellEggplant_isSelect02)
    CheckBox sellEggplantIsSelect02;
    @BindView(R.id.sellEggplant_item02)
    AutoRelativeLayout sellEggplantItem02;
    @BindView(R.id.sellEggplant_img03)
    CircleImageView sellEggplantImg03;
    @BindView(R.id.sellEggplant_num03)
    TextView sellEggplantNum03;
    @BindView(R.id.sellEggplant_kind03)
    TextView sellEggplantKind03;
    @BindView(R.id.sellEggplant_isSelect03)
    CheckBox sellEggplantIsSelect03;
    @BindView(R.id.sellEggplant_none)
    TextView sellEggplantNone;
    @BindView(R.id.sellEggplant_item01)
    AutoRelativeLayout sellEggplantItem01;
    @BindView(R.id.sellEggplant_item03)
    AutoRelativeLayout sellEggplantItem03;
    //支付popuwindow
    private PopupWindow paypopupWindow;
    TextView ppwPayUserName;
    RecyclerView ppwPayProductList;
    CheckBox ppwPayZhifubaoBtn;
    CheckBox ppwPayWeixinBtn;
    Button ppwPayPayBtn;
    ImageView ppwQuestion;
    AutoLinearLayout ppwPayBottom;
    TextView ppwPayOther01;
    private String paymentMethod = "2";
    private boolean tag = false;
    private int eggplantAmount = 0;
    private int biteEggplantAmount;
    private int unripeEggplantAmount;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_sell_eggplant;
    }

    @Override
    protected void init() {
        appTitle.setText("卖茄子");
        appOtherID.setVisibility(View.VISIBLE);
        appOtherID.setText("茄子明细");
        //卖茄子
        presenter.sendSellEggplant();

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.app_back, R.id.app_otherID, R.id.sellEggplant_question, R.id.sellEggplant_sellBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.app_back:
                finish();
                break;
            case R.id.app_otherID:
                sellEggplantFootView.setVisibility(View.VISIBLE);
                break;
            case R.id.sellEggplant_question:
                break;
            case R.id.sellEggplant_sellBtn:
                if (tag == false) {
                    tag = true;
                    showPaypopupView();
                } else {
                    tag = false;
                    if (paymentMethod.equals("1")) {
//                        提现到微信
//                        presenter.sendWeixinTixian(eggplantAmount + "", biteEggplantAmount + "", unripeEggplantAmount + "", sellEggplantMoney.getText().toString());
                        presenter.sendWeixinTixian(0+ "", 5 + "", 0 + "",3+"");

                    } else {
//                        提现到支付宝
                    }
                }
                break;
        }

    }

    //支付popuwindow
    private void showPaypopupView() {


        View PaypopupView = LayoutInflater.from(this).inflate(R.layout.ppw_pay, null);
        ppwPayProductList = PaypopupView.findViewById(R.id.ppwPay_productList);
        ppwPayZhifubaoBtn = PaypopupView.findViewById(R.id.ppwPay_zhifubaoBtn);
        ppwPayWeixinBtn = PaypopupView.findViewById(R.id.ppwPay_weixinBtn);
        ppwQuestion = PaypopupView.findViewById(R.id.ppw_question);
        ppwPayBottom = PaypopupView.findViewById(R.id.ppwPay_bottom);
        ppwPayOther01 = PaypopupView.findViewById(R.id.ppwPay_other01);
        ppwPayBottom.setVisibility(View.GONE);
        ppwPayUserName = PaypopupView.findViewById(R.id.ppwPay_userName);
        ppwPayUserName.setText("卖出到：");
        ppwPayProductList.setVisibility(View.GONE);
        ppwPayOther01.setVisibility(View.GONE);
//        PopUpwindowLayout popUpwindowLayout = (PopUpwindowLayout) view.findViewById(R.id.llayout_popupwindow);
//        popUpwindowLayout.initViews(mContext, titles, false);
        final PopupWindow popupWindow = new PopupWindow(PaypopupView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        PaypopupView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);
        int popupWidth = PaypopupView.getMeasuredWidth();
        int popupHeight = PaypopupView.getMeasuredHeight();
        int[] location = new int[2];
// 允许点击外部消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
// 获得位置
        sellEggplantFootView.getLocationOnScreen(location);
//        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.showAtLocation(sellEggplantFootView, Gravity.NO_GRAVITY, (location[0] + sellEggplantFootView.getWidth() / 2) - popupWidth / 2, location[1] - popupHeight);
//        支付宝
        ppwPayZhifubaoBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ppwPayZhifubaoBtn.isChecked()) {
                    paymentMethod = "2";
                    ppwPayWeixinBtn.setChecked(false);
                } else {
                    ppwPayWeixinBtn.setChecked(true);
                }
            }
        });
//        微信
        ppwPayWeixinBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (ppwPayWeixinBtn.isChecked()) {
                    paymentMethod = "1";
                    ppwPayZhifubaoBtn.setChecked(false);
                } else {
                    ppwPayZhifubaoBtn.setChecked(true);
                }
            }
        });
//        //popupWindow消失屏幕变为不透明
//        PaypopupView.setOnDismissListener(new PopupWindow.OnDismissListener() {
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = getWindow().getAttributes();
//                lp.alpha = 1.0f;
//                getWindow().setAttributes(lp);
//            }
//        });
    }


    @Override
    public void showError(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showSellEggplant(final SellEggplantBean eggplantDetailsBean) {
        if (eggplantDetailsBean.getData() == null) {
            sellEggplantNone.setVisibility(View.VISIBLE);
            sellEggplantItem01.setVisibility(View.INVISIBLE);
            sellEggplantItem02.setVisibility(View.INVISIBLE);
            sellEggplantItem03.setVisibility(View.INVISIBLE);
        } else {
            sellEggplantNone.setVisibility(View.GONE);
            sellEggplantItem01.setVisibility(View.VISIBLE);
            sellEggplantItem02.setVisibility(View.VISIBLE);
            sellEggplantItem03.setVisibility(View.VISIBLE);
            sellEggplantImg01.setImageResource(R.mipmap.my_qiezi_small);
            sellEggplantImg02.setImageResource(R.mipmap.my_qiezi_bite);
            sellEggplantImg03.setImageResource(R.mipmap.my_qiezi_green);
            sellEggplantKind01.setText("茄子"+eggplantDetailsBean.getData().getEggplantAmount());
            sellEggplantKind02.setText("被咬一口的茄子" + eggplantDetailsBean.getData().getBiteEggplantAmount());
            sellEggplantKind03.setText("未成熟的茄子" + eggplantDetailsBean.getData().getUnripeEggplantAmount());
            sellEggplantIsSelect01.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (sellEggplantIsSelect01.isChecked()) {
                        eggplantAmount = eggplantDetailsBean.getData().getEggplantAmount();
                        sellEggplantCallback(1, eggplantDetailsBean.getData().getEggplantAmount());

                    } else {
                        eggplantAmount = 0;
                        sellEggplantNoSelectCallback(1, eggplantDetailsBean.getData().getEggplantAmount());
                    }
                }
            });
            sellEggplantIsSelect02.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (sellEggplantIsSelect02.isChecked()) {
                        biteEggplantAmount = eggplantDetailsBean.getData().getBiteEggplantAmount();
                        sellEggplantCallback(2, eggplantDetailsBean.getData().getBiteEggplantAmount());

                    } else {
                        biteEggplantAmount = 0;
                        sellEggplantNoSelectCallback(2, eggplantDetailsBean.getData().getBiteEggplantAmount());
                    }
                }
            });
            sellEggplantIsSelect03.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (sellEggplantIsSelect03.isChecked()) {
                        unripeEggplantAmount = eggplantDetailsBean.getData().getUnripeEggplantAmount();
                        sellEggplantCallback(3, eggplantDetailsBean.getData().getUnripeEggplantAmount());

                    } else {
                        unripeEggplantAmount = 0;
                        sellEggplantNoSelectCallback(3, eggplantDetailsBean.getData().getUnripeEggplantAmount());
                    }
                }
            });
        }

    }

    //   微信提现
    @Override
    public void showWeiXinTixian(WeiXinTiXianBean weiXinTiXianBean) {
        if (weiXinTiXianBean.getData() == null) {
            Toast.makeText(this, weiXinTiXianBean.getMsg(), Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, weiXinTiXianBean.getData().getErr_code_des(), Toast.LENGTH_SHORT).show();
        }

    }

    //  回调
    public void sellEggplantCallback(int type, int amount) {
        sellEggplantFootView.setVisibility(View.VISIBLE);
        eggplantCount += amount;
        sellEggplantEggplantNum.setText(eggplantCount + "");
        double v;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        if (type == 1) {
            v = 0.9;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }
        if (type == 2) {
            v = 0.6;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }
        if (type == 3) {
            v = 0.05;
            double v1 = amount * v;
            eggplantMoney += v1;
            String format = nf.format(eggplantMoney);
            sellEggplantMoney.setText(format);
        }

    }

    //取消选中
    public void sellEggplantNoSelectCallback(int type, int amount) {
        eggplantCount -= amount;
        sellEggplantEggplantNum.setText(eggplantCount + "");
        double v;
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        if (eggplantCount >= 0) {
            if (type == 1) {
                v = 0.9;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
            if (type == 2) {
                v = 0.6;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
            if (type == 3) {
                v = 0.05;
                double v1 = amount * v;
                eggplantMoney -= v1;
                String format = nf.format(eggplantMoney);
                sellEggplantMoney.setText(format);
            }
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sellEggplantIsSelect01.setChecked(false);
        sellEggplantIsSelect02.setChecked(false);
        sellEggplantIsSelect03.setChecked(false);
    }
}
