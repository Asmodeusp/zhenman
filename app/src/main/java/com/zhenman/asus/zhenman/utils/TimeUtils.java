package com.zhenman.asus.zhenman.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeUtils {


    public  static String getChatTime(long timesamp) {
        String result = "";
        Date today = new Date(System.currentTimeMillis());
        Date otherDay = new Date(timesamp);

        long time=today.getTime() - otherDay.getTime();

        long mill = time /1000;//秒前

        long minute = time/60/1000;// 分钟前

        long hour = time/60/60/1000;// 小时

        long day = time/24/60/60/1000;// 天前

        if (day - 1 >= 0) {
            if(day<=7){
                result=(day +"天");
            }else {
                return  getTimeStr(timesamp);
            }

        } else if (hour - 1 >= 0) {
            if (hour >= 24) {
                result=("1天");
            } else {
                result=(hour + "小时");
            }
        } else if (minute - 1 >= 0) {
            if (minute == 60) {
                result=("1小时");
            } else {
                result=(minute + "分钟");
            }
        } else if (mill - 1 >= 0) {
            if (mill == 60) {
                result=("1分钟");
            } else {
                result="刚刚";
            }
        } else {
            result="刚刚";
        }
        if (!"刚刚".equals(result.toString())) {
            result=result+"前";
        }
        return result;
    }


    //聊天时间
    public  static String getChatHintTime(long timesamp) {
        String result = "";
        Date today = new Date(System.currentTimeMillis());
        Date otherDay = new Date(timesamp);

        long time = today.getTime() - otherDay.getTime();

        long mill = time / 1000;//秒前

        long minute = time / 60 / 1000;// 分钟前

        long hour = time / 60 / 60 / 1000;// 小时

        long day = time / 24 / 60 / 60 / 1000;// 天前


        if(diffTime(getTimesmorning(),timesamp)>2) {

            return getTime(timesamp) + " " + getHourAndMin(timesamp);

        }else if (diffTime(getTimesmorning(),timesamp)==2) {

            return "前天 " + getHourAndMin(timesamp);

        }else if(diffTime(getTimesmorning(),timesamp)==1){

            return "昨天 " + getHourAndMin(timesamp);

        }else if (diffTime(getTimesmorning(),timesamp)==0) {

            if (hour - 1 >= 0) {
                return getHourAndMin(timesamp);
            } else if (minute - 1 >= 0) {
                if (minute == 60) {
                    return getHourAndMin(timesamp);
                } else {
                    result=(minute + "分钟");
                }
            } else if (mill - 1 >= 0) {
                if (mill == 60) {
                    result=("1分钟");
                } else {
                    result="刚刚";
                }
            } else {
                result="刚刚";
            }
            if (!"刚刚".equals(result.toString())) {
                result=result+"前";
            }

        }
        return result;
    }

    private static String sqlitAM(long time) {
        String am = "";
        SimpleDateFormat format = new SimpleDateFormat("HH");
        String timeStr = format.format(new Date(time));

        am = Integer.parseInt(timeStr) + "小时前";

        return am;
    }

    private static String getTime(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM月dd日");
        return format.format(new Date(time));
    }


    public static String getTimeStr(long time) {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd");
        return format.format(new Date(time));
    }

    public static String getTimeData(long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(new Date(time));
    }

    public static String getBirthdatyData(long time){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(new Date(time));
    }


    private  static String getHourAndMin(long time) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        return format.format(new Date(time));
    }


    public  static int castTime(String date) {
        int time = 0;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd HH");

            Date parse = dateFormat.parse(date);

            time = parse.getDate();
        } catch (Exception e) {
            return time;
        }
        return time;
    }

    public  static String getAudioTime(long time) {

        SimpleDateFormat formatter = new SimpleDateFormat("mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        String hms = formatter.format(time);
//        SimpleDateFormat format = new SimpleDateFormat("mm:ss");
//        return format.format(new Date(time));
        return hms;
    }

    public static String shiftTime(int time) {

        return getChatTime(IntToLong(time));
    }


    public static String chatShiftTime(int time) {

        return getChatHintTime(IntToLong(time));
    }




    public static long IntToLong(int i){
        long result = (long)i;
        result*=1000;
        return result;
    }


    /**
     * 计算两个时间的时间差time1-time2
     *
     * @param time1
     * @param time2
     * @return 差多少天
     */
    public static int diffTime(long time1, long time2) {
//        if (TextUtils.isEmpty(time2)){
//            time2 = "1970-10-10 10:10:10";
//        }

        int days = 0;
//        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
//            Date d1 = df.parse(time1);
//            Date d2 = df.parse(time2);
            long diff = time1 - time2;// 这样得到的差值是微秒级别

            if(diff<=0){
                days=0;
            }else if(diff>0&&diff<=1000*60*60*24) {
                days = 1;
            } else if(diff>1000*60*60*24&&diff<=1000*60*60*24*2){
                days=2;
            }else {
                days =3;
            }


        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
        }
        return days;
    }

    public static long getTimesmorning(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.MILLISECOND, 001);
        return cal.getTimeInMillis();
    }


    public static String currentTime() {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sDateFormat.format(new Date());
    }


    public static String parssLongTime(long time) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return sDateFormat.format(new Date(time));
    }

    /*
       * 将秒数转为时分秒
       * */
    public static String change(long second) {
        long h = 0;
        long d = 0;
        long s = 0;
        long temp = second % 3600;
        if (second > 3600) {
            h = second / 3600;
            if (temp != 0) {
                if (temp > 60) {
                    d = temp / 60;
                    if (temp % 60 != 0) {
                        s = temp % 60;
                    }
                } else {
                    s = temp;
                }
            }
        } else {
            d = second / 60;
            if (second % 60 != 0) {
                s = second % 60;
            }
        }

        return h + ":" + d + ":" + s + "";
    }

}