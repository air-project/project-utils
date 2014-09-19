package com.yh.utils.date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/** 
 * @author yanghao 
 * @date 2014年9月17日 下午4:56:30
 */
public class DateUtil {  
	  
    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();  
      
    private static final Object object = new Object();  
      
    /** 
     * 获取SimpleDateFormat 
     * @param pattern 日期格式 
     * @return SimpleDateFormat对象 
     * @throws RuntimeException 异常：非法日期格式 
     */  
    private static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {  
        SimpleDateFormat dateFormat = threadLocal.get();  
        if (dateFormat == null) {  
            synchronized (object) {  
                if (dateFormat == null) {  
                    dateFormat = new SimpleDateFormat(pattern);  
                    dateFormat.setLenient(false);  
                    threadLocal.set(dateFormat);  
                }  
            }  
        }  
        dateFormat.applyPattern(pattern);  
        return dateFormat;  
    }  
  
    /** 
     * @category 获取日期中的某数值。如获取月份 
     * @param date 日期 
     * @param dateType 日期格式 .Calendar.month....
     * @return 数值 
     */  
    public static int getInteger(Date date, int dateType) {  
        int num = 0;  
        Calendar calendar = Calendar.getInstance();  
        if (date != null) {  
            calendar.setTime(date);  
            num = calendar.get(dateType);  
            if(Calendar.MONTH==dateType){
            	num++;
            }
        }  
        return num;  
    }  
  
    /** 
     * @category 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @param amount 数值 
     * @return 计算后日期 
     */  
    public static Date addInteger(Date date, int dateType, int amount) {  
        Date myDate = null;  
        if (date != null) {  
            Calendar calendar = Calendar.getInstance();  
            calendar.setTime(date);  
            calendar.add(dateType, amount);  
            myDate = calendar.getTime();  
        }  
        return myDate;  
    }  
    /** 
     * @category 增加日期中某类型的某数值。如增加日期 
     * @param date 日期 
     * @param dateType 类型 
     * @return 计算后日期 
     */  
    public static long diff(Date date,Date largeDate, int dateType, int amount) {  
        long large=largeDate.getTime();
    	long small=date.getTime();
    	long result=large-small;
    	long tmp=0;
    	switch (dateType) {
		case Calendar.DATE:
			tmp=1000*60*60*24;
			break;

		default:
			break;
		} 
    	//result/1000
    	return 0;  
    } 
    /** 
     * @category 将日期字符串转化为日期。失败返回null。 
     * @param date 日期字符串 
     * @param pattern 日期格式 
     * @return 日期 
     */  
    public static Date StringToDate(String date, String pattern) {  
        Date myDate = null;  
        if (date != null) {  
            try {  
                myDate = getDateFormat(pattern).parse(date);  
            } catch (Exception e) { 
            	e.printStackTrace();
            }  
        }  
        return myDate;  
    }  
  
  
    /** 
     * @category 将日期转化为日期字符串。失败返回null。 
     * @param date 日期 
     * @param pattern 日期格式 
     * @return 日期字符串 
     */  
    public static String DateToString(Date date, String pattern) {  
        String dateString = null;  
        if (date != null) {  
            try {  
                dateString = getDateFormat(pattern).format(date);  
            } catch (Exception e) {  
            }  
        }  
        return dateString;  
    }  
  
    /** 
     * @category 增加日期的年份。失败返回null。 
     * @param date 日期 
     * @param yearAmount 增加数量。可为负数 
     * @return 增加年份后的日期 
     */  
    public static Date addYear(Date date, int yearAmount) {  
        return addInteger(date, Calendar.YEAR, yearAmount);  
    }  
  
    /** 
     * @category 增加日期的月份。失败返回null。 
     * @param date 日期 
     * @param monthAmount 增加数量。可为负数 
     * @return 增加月份后的日期 
     */  
    public static Date addMonth(Date date, int monthAmount) {  
        return addInteger(date, Calendar.MONTH, monthAmount);  
    }  
  
  
    /** 
     * @category 增加日期的天数。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加天数后的日期 
     */  
    public static Date addDay(Date date, int dayAmount) {  
        return addInteger(date, Calendar.DATE, dayAmount);  
    }  
  
  
    /** 
     * @category 增加日期的小时。失败返回null。 
     * @param date 日期 
     * @param hourAmount 增加数量。可为负数 
     * @return 增加小时后的日期 
     */  
    public static Date addHour(Date date, int hourAmount) {  
        return addInteger(date, Calendar.HOUR_OF_DAY, hourAmount);  
    }  
  
    /** 
     * @category 增加日期的分钟。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加分钟后的日期 
     */  
    public static Date addMinute(Date date, int minuteAmount) {  
        return addInteger(date, Calendar.MINUTE, minuteAmount);  
    }  
  
  
    /** 
     * @category 增加日期的秒钟。失败返回null。 
     * @param date 日期 
     * @param dayAmount 增加数量。可为负数 
     * @return 增加秒钟后的日期 
     */  
    public static Date addSecond(Date date, int secondAmount) {  
        return addInteger(date, Calendar.SECOND, secondAmount);  
    }  
  
    /** 
     * @category 获取日期的年份。失败返回0。 
     * @param date 日期 
     * @return 年份 
     */  
    public static int getYear(Date date) {  
        return getInteger(date, Calendar.YEAR);  
    }  
  
    /** 
     * @category 获取日期的月份。失败返回0。 
     * @param date 日期 
     * @return 月份 
     */  
    public static int getMonth(Date date) {  
        return getInteger(date, Calendar.MONTH);  
    }  
  
  
    /** 
     * @category 获取日期的天数。失败返回0。 
     * @param date 日期 
     * @return 天 
     */  
    public static int getDay(Date date) {  
        return getInteger(date, Calendar.DATE);  
    }  
  
  
    /** 
     * @category 获取日期的小时。失败返回0。 
     * @param date 日期 
     * @return 小时 
     */  
    public static int getHour(Date date) {  
        return getInteger(date, Calendar.HOUR_OF_DAY);  
    }  
  
  
    /** 
     * @category 获取日期的分钟。失败返回0。 
     * @param date 日期 
     * @return 分钟 
     */  
    public static int getMinute(Date date) {  
        return getInteger(date, Calendar.MINUTE);  
    }  
  
  
    /** 
     * @category 获取日期的秒钟。失败返回0。 
     * @param date 日期 
     * @return 秒钟 
     */  
    public static int getSecond(Date date) {  
        return getInteger(date, Calendar.SECOND);  
    }  
} 