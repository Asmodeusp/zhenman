package com.zhenman.asus.zhenman.utils;

public class Urls {
    //基本路径
    public static final String BASE_URL = "http://api.dev.zhenmanapp.com/";
    //登陆
    public static final String LOGING = "login/passwordLogin";
    //  友盟第三方登录{QQ 微信，微博   的注册和登陆}
    public static final String THIRD_PARTY_LOGING = "userOauth/register";
    //请求图片验证码
    public static final String REQUES_PICTURE_VERIFICATION_CODE = "login/getImageCode";
    //请求手机验证码
    public static final String REQUEST_CELL_PHONE_VERIFICATION_CODE = "login/sendSms";
    //    账号绑定更换前的密码校验
    public static final String CHECK_CODE = "userOauth/checkCode";
    //忘记密码
    public static final String FORGET_PASSWORD = "";
    //更换手机号
    public static final String CHANGE_MOBILE = "userOauth/changeMobile";

    //注册手机号和验证码
    public static final String REGISTER_PHONE_CODE = "login/register";
    //  三方账号绑定手机号
    public static final String THIRD_BIND_PHONE = "userOauth/bindMobile";

    //  注册手机号和验证码
    public static final String SET_PASSWORD = "login/setPassword";

    //主页热门
    public static final String HOME_HOT = "userUgcInfo/getHotList";
    //连载主页热门
    public static final String SERIALIZATION_HOT = "userPgcInfo/getPgcInfo52";
    //连载主页更新
    public static final String SERIALIZATION_LATELY = "userPgcInfo/getPgcList";
    //连载详情页
    public static final String SERIALIZATION_DETAILS = "userPgcInfo/getPgcInfo";
    //连载目录页
    public static final String SERIALIZATION_CATALOG = "userPgcInfo/getPgcCatalogInfo";
    //连载页阅读
    public static final String SERIALIZATION_CATALOG_READ = "userPgcInfo/getCatalogInfoPayPage";
    //评论列表
    public static final String COMMENT_LIST = "ugcCommentInfo/getCommentList";
    //Pgc点赞
    public static final String PGCFABULOUS = "likesPgcCommentInfo/insertLikesPgcCommentInfo";
    //主页Ugc点赞
    public static final String UGCFABULOUS = "userLikesUgc/insertUserLikesUgc";
    //Pgc收藏
    public static final String PGC_COLLECTION = "userLikesPgc/insertUserLikesPgc";
    //  产品列表
    public static final String PRODUCT_LIST = "uProduct/productList";
    //  创建订单
    public static final String MAKE_ORDER = "userOrder/createOrder";
    //  获取支付宝支付数据
    public static final String GET_PAY_DATA = "userOrder/getPaySignByAli";
    //  得到微信支付数据
    public static final String GET_WX_PAY_DATA = "userOrder/getPaySignByWx";
    //分类标签
    public static final String SERIALIZATION_CLASSIFY_TAG = "pgcTag/getPgcTag";
    //分类数据
    public static final String SERIALIZATION_CLASSIFY = "userPgcInfo/getPgcListByTags";
    //  注销登陆
    public static final String CANCLE_LOGIN = "userOauth/unbindMobile";
    //  个人主页信息
    public static final String HEAD_DATA = "userUgcInfo/getPersonalHomepageHeader";
    //  获得个人资料信息
    public static final String GET_MYDATA = "userOauth/getPersonalData";
    //  修改个人资料
    public static final String ALART_MYDATA = "userOauth/updatePersonalData";
    //  手机号解绑
    public static final String UNBIND_MOBILE = "userOauth/unbindMobile";
    //  交易记录
    public static final String PURCHASE_HISTORY = "userCoinAccount/getCoinAccountOutList";

    //  个人主页 我的作品   短漫画
    public static final String UGS_SHORT_COMIC = "userUgcInfo/getUgcListByType";
    //  个人主页  我的作品  长漫画
    public static final String PGC_SHORT_COMIC = "userUgcInfo/getPgcListByType";
    //  消息页面 3个的主题及对应的4个ugc作品
    public static final String UGC_THEME_INFO = "ugcSubjectUser/getNewsSubjectListByUserId";
    //  关注主题
    public static final String ATTENTION_THEME = "ugcSubjectUser/saveUserSubjectFollow";
    //  我关注的主题
    public static final String MY_ATTENTION_THEME = "ugcSubjectUser/getUserSubjectList";
    //  书架中我的收藏
    public static final String SHELF_COLLECTION = "userLikesPgc/getLikesPgcList";
    //    书架中的历史列表
    public static final String SHELF_HISTORY = "readPgcHistory/getPgcReadHistoryList";
    //  批量删除收藏作品
    public static final String DELETE_COLLECTION = "userLikesPgc/deleteUserLikesPgc";
    //  手机号登录 手机号绑定三方账号
    public static final String MOBILE_BIND_THIRD = "userOauth/bindOauth";
    //  三方账号绑定另外的三方账号
    public static final String THIRD_BIND_THIRD = "userOauth/otherBindOther";
    //  主题详情头部信息
    public static final String THEME_DETAIL_HEAD = "ugcSubjectUser/getUgcListHeaderBySubjectId";
    //  主题详情下的精选
    public static final String THEME_FEATURED = "ugcSubjectUser/getUgcListBySubjectId";
    //  关注用户
    public static final String INSERT_USER_FOLLOW = "userFollow/insertUserFollow";
    //  关注用户下的作品列表
    public static final String USER_FOLLOW_WORKS_LIST = "userFollow/getUserFollowWorksList";
    //  用户的粉丝
    public static final String USER_FANS = "userFans/getUserFansList";
    //  用户的关注
    public static final String USER_ATTENTION = "userFollow/getUserFollowList";
    //  关注用户
    public static final String ATTENTION_USER = "userFollow/insertUserFollow";
    //  卖茄子
    public static final String SELL_EGGPLANT = "userCoinAccount/getUserCoinAccount";
    //  茄子明细
    public static final String EGGPLANT_DETAILS = "userCoinAccount/getCoinAccountIncomeList";
    //  微信提现
    public static final String WEIXIN_TIXIAN = "userOrder/withdraw";
    //  被打赏列表
    public static final String BY_REWARDED = "newsRewardInfo/getNewsRewardInfoList";
    //  消息页面被关注列表(也就是粉丝列表)
    public static final String BY_FANS = "newsFansInfo/getNewsFansInfoList";
    //    被点赞的列表
    public static final String BY_LIKE = "newsLikeInfo/getNewsLikeInfoList";
    //续购开关
    public static final String RENEW = "userSetting/autoContinuedPurchase";
}
