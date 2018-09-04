package com.szl.oa.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: songzl
 * @Date: 2018/8/14 9:56
 * @Description:
 */
public class calculateDay {

    public  static SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");

    public static double calDays(String beginDate, String endDate, String beginTime, String endTime) throws ParseException {
        int hour = 60 * 60 * 1000;
        String bTimeStr[] = beginTime.split(":");
        String eTimeStr[] = endTime.split(":");
        Date bDate =sdf.parse(beginDate);
        Date eDate =sdf.parse(endDate);
        double bTime = Integer.parseInt(bTimeStr[0]) * hour + Integer.parseInt(bTimeStr[1]) * 60 * 1000 + Integer.parseInt(bTimeStr[2]) * 1000;
        double eTime = Integer.parseInt(eTimeStr[0]) * hour + Integer.parseInt(eTimeStr[1]) * 60 * 1000 + Integer.parseInt(eTimeStr[2]) * 1000;
        double days = 0.0;
        double half = 0.5;
        double allDay = 1.0;
        double AM_UpHour = 8 * hour;
        double AM_DownHour = 12 * hour;
        double PM_UpHour = 13.5 * hour;
        double PM_DownHour = 17.5 * hour;
        //相隔天数
        long n = (eDate.getTime() - bDate.getTime()) / (hour * 24);
        if (n > 1) {
            days = n - 1;
        }
        //如果是同一天
        if (beginDate.equals(endDate)) {
            if (bTime < AM_DownHour) {
                if (eTime <= PM_UpHour) {
                    days += half;
                } else {
                    days += allDay;
                }
            } else {
//                if (eTime <= PM_UpHour) {
                    days += half;
//                } else {
//                    days += allDay;
//                }
            }
        } else {//不是同一天
            //计算开始的那一天的
            //如果开始时间<早上下班时间+1.0
            if (bTime < AM_DownHour) {
                days += allDay;
            }else {//如果是下午开始
                days += half;
            }
            //计算结束的那一天
            //如果是早上结束+0.5
            if (eTime <= PM_UpHour) {
                days += half;
            } else { //如果是下午结束+1.0
                days += allDay;
            }
        }
        return days;
    }

    public static void main(String[] args) throws ParseException {
        String beginDate ="2018-08-14";
        String endDate ="2018-08-14";
        String beginTime ="13:00:00";
        String endTime ="17:30:00";

        double days = calDays(beginDate,endDate,beginTime,endTime);
        System.out.println(days);

        String day = getDays("2018-08-14 08:30:00","2018-08-14 11:30:00");
        System.out.println(day);
    }

    public static String getDays(String beginDate,String endDate)  {
        SimpleDateFormat dateSdf=new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat timeSdf=new SimpleDateFormat("HH:mm:ss");
        String bDate = null;
        String eDate = null;
        String bTime = null;
        String eTime = null;
        double d =0.0;
        try {
            bDate = dateSdf.format(getDate(beginDate));
            eDate = dateSdf.format(getDate(endDate));
            bTime = timeSdf.format(getTime(beginDate));
            eTime = timeSdf.format(getTime(endDate));
            d = calDays(bDate,eDate,bTime,eTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }

       return String.valueOf(d);

    }

    public static Date getDate(String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        return d;
    }

    public static Date getTime(String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(date);
        return d;
    }
}
