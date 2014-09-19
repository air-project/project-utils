package com.yh.utils.date;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;


/** 
 * @author yanghao 
 * @date 2014年9月17日 下午4:56:30
 */
public class DateUtilTest {

	@Test
	public  void getInteger() {
		Date date=new Date();
        Assert.assertEquals(date.getMonth()+1, DateUtil.getInteger(date,Calendar.MONTH));
    }
	@Test
    public  void addInteger() {  
    	Date date=new Date();
    	Date newDate=DateUtil.addInteger(date, Calendar.MONTH, 1);
    }  
//  
//    /** 
//     * @category 将日期字符串转化为日期。失败返回null。 
//     * @param date 日期字符串 
//     * @param pattern 日期格式 
//     * @return 日期 
//     */  
//    public  Date StringToDate(String date, String pattern) {  
//        Date myDate = null;  
//        if (date != null) {  
//            try {  
//                myDate = getDateFormat(pattern).parse(date);  
//            } catch (Exception e) { 
//            	e.printStackTrace();
//            }  
//        }  
//        return myDate;  
//    }  
//  
//  
//    /** 
//     * @category 将日期转化为日期字符串。失败返回null。 
//     * @param date 日期 
//     * @param pattern 日期格式 
//     * @return 日期字符串 
//     */  
//    public  String DateToString(Date date, String pattern) {  
//        String dateString = null;  
//        if (date != null) {  
//            try {  
//                dateString = getDateFormat(pattern).format(date);  
//            } catch (Exception e) {  
//            }  
//        }  
//        return dateString;  
//    }  
//  
//    /** 
//     * @category 增加日期的年份。失败返回null。 
//     * @param date 日期 
//     * @param yearAmount 增加数量。可为负数 
//     * @return 增加年份后的日期 
//     */  
//    public  Date addYear(Date date, int yearAmount) {  
//        return addInteger(date, Calendar.YEAR, yearAmount);  
//    }  
//  
//    /** 
//     * @category 增加日期的月份。失败返回null。 
//     * @param date 日期 
//     * @param monthAmount 增加数量。可为负数 
//     * @return 增加月份后的日期 
//     */  
//    public  Date addMonth(Date date, int monthAmount) {  
//        return addInteger(date, Calendar.MONTH, monthAmount);  
//    }  
//  
//  
//    /** 
//     * @category 增加日期的天数。失败返回null。 
//     * @param date 日期 
//     * @param dayAmount 增加数量。可为负数 
//     * @return 增加天数后的日期 
//     */  
//    public  Date addDay(Date date, int dayAmount) {  
//        return addInteger(date, Calendar.DATE, dayAmount);  
//    }  
//  
//  
//    /** 
//     * @category 增加日期的小时。失败返回null。 
//     * @param date 日期 
//     * @param hourAmount 增加数量。可为负数 
//     * @return 增加小时后的日期 
//     */  
//    public  Date addHour(Date date, int hourAmount) {  
//        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
//    }  
//  
//    /** 
//     * @category 增加日期的分钟。失败返回null。 
//     * @param date 日期 
//     * @param dayAmount 增加数量。可为负数 
//     * @return 增加分钟后的日期 
//     */  
//    public  Date addMinute(Date date, int minuteAmount) {  
//        return addInteger(date, Calendar.MINUTE, minuteAmount);  
//    }  
//  
//  
//    /** 
//     * @category 增加日期的秒钟。失败返回null。 
//     * @param date 日期 
//     * @param dayAmount 增加数量。可为负数 
//     * @return 增加秒钟后的日期 
//     */  
//    public  Date addSecond(Date date, int secondAmount) {  
//        return addInteger(date, Calendar.SECOND, secondAmount);  
//    }  
//  
//    /** 
//     * @category 获取日期的年份。失败返回0。 
//     * @param date 日期 
//     * @return 年份 
//     */  
//    public  int getYear(Date date) {  
//        return getInteger(date, Calendar.YEAR);  
//    }  
//  
//    /** 
//     * @category 获取日期的月份。失败返回0。 
//     * @param date 日期 
//     * @return 月份 
//     */  
//    public  int getMonth(Date date) {  
//        return getInteger(date, Calendar.MONTH);  
//    }  
//  
//  
//    /** 
//     * @category 获取日期的天数。失败返回0。 
//     * @param date 日期 
//     * @return 天 
//     */  
//    public  int getDay(Date date) {  
//        return getInteger(date, Calendar.DATE);  
//    }  
//  
//  
//    /** 
//     * @category 获取日期的小时。失败返回0。 
//     * @param date 日期 
//     * @return 小时 
//     */  
//    public  int getHour(Date date) {  
//        return getInteger(date, Calendar.HOUR_OF_DAY);  
//    }  
//  
//  
//    /** 
//     * @category 获取日期的分钟。失败返回0。 
//     * @param date 日期 
//     * @return 分钟 
//     */  
//    public  int getMinute(Date date) {  
//        return getInteger(date, Calendar.MINUTE);  
//    }  
//  
//  
//    /** 
//     * @category 获取日期的秒钟。失败返回0。 
//     * @param date 日期 
//     * @return 秒钟 
//     */  
//    public  int getSecond(Date date) {  
//        return getInteger(date, Calendar.SECOND);  
//    } 
} 