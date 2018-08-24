package com.zhenman.asus.zhenman.utils;

public class Urls {
    //基本路径
    public static final String BASE_URL = "http://api.dev.zhenmanapp.com/";
    //登陆
    public static final String LOGING = "login/passwordLogin";
    //第三方登录
    public static final String THIRD_PARTY_LOGING = "userOauth/register";
    //请求图片验证码
    public static final String REQUES_PICTURE_VERIFICATION_CODE = "login/getImageCode";
    //请求手机验证码
    public static final String REQUEST_CELL_PHONE_VERIFICATION_CODE = "login/sendSms";
    //忘记密码
    public static final String FORGET_PASSWORD = "";
    //注册手机号和验证码
    public static final String REGISTER_PHONE_CODE = "/ogin/register";
    //注册手机号和验证码
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
    public static final String SERIALIZATION_CATALOG_READ = "pgcCatalogPage/getPgcImageShowByCatalog";
    //作品下的评论列表
    public static final String WORKS_COMMENT = "pgcChapterCommentInfo/getPgcCommentListByPgcId";
    //Pgc点赞
    public static final String PGCFABULOUS = "likesPgcCommentInfo/insertLikesPgcCommentInfo";
    //主页Ugc点赞
    public static final String UGCFABULOUS ="userLikesUgc/insertUserLikesUgc";
    //Pgc收藏
    public static final String PGC_COLLECTION ="userLikesPgc/insertUserLikesPgc";
//    友盟第三方登录{QQ 微信，微博   的注册和登陆}
    public static final String UMENG_LOGIN="userOauth/register";
}
