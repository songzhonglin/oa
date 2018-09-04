package com.szl.oa.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author: songzl
 * @Date: 2018/8/14 14:18
 * @Description:
 */
public class MyDate {
    public static void main(String[] args) throws ParseException {
        String starttime="2018-08-14 13:00:00";
        String endtime="2018-08-14 17:30:00";
        System.out.println(1.50/8.00);
        double b =new MyDate().jisuan(starttime, endtime);
        System.out.println(b);
    }


    public double jisuan(String s1 ,String s2) throws ParseException{
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1 = s.parse(s1);
        Date d2 = s.parse(s2);
        SimpleDateFormat ss = new SimpleDateFormat("yyyy-MM-dd");
        Date dd1 = ss.parse(s1);
        Date dd11 = ss.parse(s1);
        Date dd2 = ss.parse(s2);
        System.out.println(dd1);
        Calendar ca = Calendar.getInstance();
        if(dd1.getTime()==dd2.getTime()){//同一天
            if(this.getweekdayloc(dd1,ca)==0){//星期天
                return 0;
            }else{
                return this.getshijian(d2,ca)-(1-this.getshijian(d1,ca));
            }
        }else{
            double bb=0.000;
            while(dd2.getTime()>=dd1.getTime()){
                if(this.getweekdayloc(dd1,ca)==1){
                    if(dd1.getTime()==dd11.getTime()){
                        bb+=this.getshijian(d1,ca);
                    }else if(dd1.getTime()==dd2.getTime()){
                        bb+=(1-this.getshijian(d2,ca));
                    }else{
                        bb+=1;
                    }
                }

                ca.setTime(d1);
                ca.add(Calendar.DATE, 1);
                d1=ca.getTime();
                ca.clear();
                ca.setTime(dd1);
                ca.add(Calendar.DATE, 1);
                dd1=ca.getTime();
                System.out.println(bb);
            }

            return bb;
        }

    }

    //传进一个日期判断是否是周六、日    。六日返回0，其他返回1
    private int getweekdayloc(Date date,Calendar ca){
        ca.setTime(date);
        if(ca.get(Calendar.DAY_OF_WEEK)==1 || ca.get(Calendar.DAY_OF_WEEK)==7){
            return 0;
        }else{
            return 1;
        }

    }

    //判断
    private double getshijian(Date date,Calendar ca){
        ca.setTime(date);
        int shi = ca.get(Calendar.HOUR_OF_DAY);
        int fen = ca.get(Calendar.MINUTE);
        double d = shi+fen/60.000;
        if(shi<8.500){
            return 1.000;
        }else if(d<=12.500 && d>=8.500){
            return (12.500-d+(17.500-13.500))/8;
        }else if(d>12.500 && d<13.000){
            return (17.500-13.500)/8;
        }else if(d>=13.500&& d<=17.500){
            return (17.500-d)/8;
        }else{
            return 0.000;
        }
    }
}
