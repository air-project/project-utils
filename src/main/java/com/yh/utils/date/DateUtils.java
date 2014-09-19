package com.yh.utils.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 日期时间与字符串互相转换
 * Create at 2011-11-24
 *
 * @author ketqi
 */
public abstract class DateUtils {
    /** 日期格式器--年 */
    public static final String DATE_FORMAT_YEAR = "yyyy";
    /** 日期格式器 */
    public static final String DATE_FORMAT_MONTH = "yyyy-MM";
    /** 日期格式器 */
    public static final String DATE_FORMAT = "yyyy-MM-dd";
    /** 日期格式器 */
    public static final String DATE_FORMAT_HH = DATE_FORMAT + " HH";
    /** 时间格式器 */
    public static final String TIME_FORMAT = "HH:mm:ss";
    /** 日期时间格式器 */
    public static final String DATETIME_FORMAT = DATE_FORMAT + " " +TIME_FORMAT;
    /** 日期时间格式器 */
    public static final String DATETIME_FORMAT_1 = DATE_FORMAT + " 00:00:00";
    /** 日期戳 */
    public static final String DATE_STAMP = "yyyyMMdd";
    /** 时间戳 */
    public static final String TIME_STAMP = "HHmmssSSS";
    /** 日期时间戳 */
    public static final String DATETIME_STAMP = DATE_STAMP + TIME_STAMP;
    /** 天 */
    public static final int DATE_TYPE_DAY = 0;
    /** 月 */
    public static final int DATE_TYPE_MONTH = 1;
    /** 年 */
    public static final int DATE_TYPE_YEAR = 2;
    /**
     * @category 一天的分钟数据
     */
    public static final long ONE_DAY_MINUTE = 1440;
    /**
     * @category 一小时的分钟数据
     */
    public static final long ONE_HOUR_MINUTE = 60;
    /**
     * @category 天
     */
    public static final String DAY_STR = "天";
    /**
     * @category 小时
     */
    public static final String HOUR_STR = "小时";
    /**
     * @category 分钟
     */
    public static final String MINUTE_STR = "分钟";

    /** 将字符串解析成yyyy-MM-dd 的日期 */
    public static Date parseDate(String value) {
        try {
            return new SimpleDateFormat(DATE_FORMAT, Locale.CHINA).parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    /** 将字符串解析成HH:mm:ss的时间 */
    public static Date parseTime(String value) {
        try {
            return new SimpleDateFormat(TIME_FORMAT, Locale.CHINA).parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    /** 将字符串解析成yyyy-MM-dd HH:mm:ss的日期时间 */
    public static Date parseDateTime(String value) {
        try {
            return new SimpleDateFormat(DATETIME_FORMAT, Locale.CHINA).parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    /** 将字符串解析成yyyyMMddHHmmssSSS的日期时间 */
    public static Date parseDateTimeStamp(String value) {
        try {
            return new SimpleDateFormat(DATETIME_STAMP, Locale.CHINA).parse(value);
        } catch (ParseException e) {
            return null;
        }
    }

    /** 将时间解析成yyyy-MM-dd的字符串 */
    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_FORMAT, Locale.CHINA).format(date);
    }

    /** 将时间解析成yyyy的字符串 */
    public static String formatDateToYear(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_FORMAT_YEAR, Locale.CHINA).format(date);
    }

    /** 将日期解析成HH:mm:ss的字符串 */
    public static String formatTime(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(TIME_FORMAT, Locale.CHINA).format(date);
    }

    /** 将日期时间解析成yyyy-MM-dd HH:mm:ss的字符串 */
    public static String formatDateTime(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATETIME_FORMAT, Locale.CHINA).format(date);
    }

    /** 将日期解析成yyyyMMddHHmmssSSS的字符串 */
    public static String formatDateTimestamp(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATETIME_STAMP, Locale.CHINA).format(date);
    }

    /** 将日期解析成yyyyMMdd的字符串 */
    public static String formatDatestamp(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_STAMP, Locale.CHINA).format(date);
    }

    /** 将日期解析成HHmmssSSS的字符串 */
    public static String formatTimestamp(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(TIME_STAMP, Locale.CHINA).format(date);
    }

    /** 将日期解析成yyyy-MM-dd HH的字符串 */
    public static String formatDateHH(Date date) {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat(DATE_FORMAT_HH, Locale.CHINA).format(date);
    }

    /** 获取当天的开始时间, 如:2014-02-24 00:00:00 */
    public static Date getBeginOfDate() {
        return getBeginOfDate(null);
    }

    /** 获取当天的结束时间, 如:2014-02-24 23:59:59 */
    public static Date getEndOfDate() {
        return getEndOfDate(null);
    }

    /** 获取指定日期的开始时间, 如:2014-02-24 00:00:00 */
    public static Date getBeginOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return setDayToBegin(calendar).getTime();
    }

    /** 获取指定日期的结束时间, 如:2014-02-24 23:59:59 */
    public static Date getEndOfDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }
        return setDayToEnd(calendar).getTime();
    }

    /**
     * @return 获取当年天数
     */
    public static int getDaysInYear() {
        GregorianCalendar calendar = new GregorianCalendar();
        return calendar.isLeapYear(calendar.get(Calendar.YEAR)) ? 366 : 365;
    }

    /**
     * 格式化当前日期
     *
     * @return date型时间
     */
    public static Date getSysDateOfDate() {
        return parseDateTime(formatDateTime(new Date()));
    }

    /**
     * @param calendarType Calendar.DATE、Calendar.MONTH、Calendar.YEAR等
     * @param num          对应日期类型对应的数量
     * @return 指定date型时间
     * 获取指定日期并格式化日期。比如：离现在30天前的日期、获取上个月日期
     */
    public static Date getDefineDate(int calendarType, int num) {
        Calendar cal = Calendar.getInstance();
        cal.add(calendarType, num);
        SimpleDateFormat formatter = new SimpleDateFormat(DATETIME_FORMAT_1);
        try {
            return formatter.parse(formatter.format(cal.getTime()));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * @param specifiedDate 指定的时间，即需要比较的时间
     * @param largeDate     到期的时间，即比较大的时间
     * @return 天数差
     * 计算指定时间与当前时间的天数差
     */
    public static int getDaysDifference(Date specifiedDate, Date largeDate) {
        Calendar cNow = Calendar.getInstance();
        Calendar cReturnDate = Calendar.getInstance();
        cNow.setTime(largeDate);
        cReturnDate.setTime(specifiedDate);
        setDayToBegin(cNow);
        setDayToBegin(cReturnDate);
        long todayMs = cNow.getTimeInMillis();
        long returnMs = cReturnDate.getTimeInMillis();
        long intervalMs = todayMs - returnMs;
        return (int) (intervalMs / (1000 * 86400));
    }
    /**
     * @param referenceDate 需要比较的时间 不能为空(null),需要正确的日期格式
     * @param date          被比较的时间  为空(null)则为当前时间
     * @param stype         返回值类型   0为多少天，1为多少个月，2为多少年
     * @throws ParseException
     */
    public static int compareDate(String referenceDate, String date, int stype) throws ParseException {
        int n = 0;
        String formatStyle = stype == 1 ? DATE_FORMAT_MONTH : DATE_FORMAT;

        if (date == null) {
            date = formatDate(new Date());
        }

        DateFormat df = new SimpleDateFormat(formatStyle);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(df.parse(referenceDate));
        c2.setTime(df.parse(date));

        // 循环对比，直到相等，n 就是所要的结果
        while (!c1.after(c2)) {
            n++;
            if (stype == 1) {
                // 比较月份，月份+1
                c1.add(Calendar.MONTH, 1);
            } else {
                // 比较天数，日期+1
                c1.add(Calendar.DATE, 1);
            }
        }

        n = n - 1;

        if (stype == 2) {
            n = n / 365;
        }

        return n;
    }

    /**
     * @param format   日期格式
     * @param variable 正数代表时间之后，负数代表时间之前
     * @param field    单位，年，月，日
     * @return 获取当前时间之前/之后多少年/月/日的时间
     */
    public static String getDiffDate(String format, int variable, int field) {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat(format, Locale.CHINA);
        c.set(field, c.get(field) + variable);
        return formatter.format(c.getTime());
    }

    /**
     * 时间范围
     */
    public static class DateRange {
        /** 开始时间 */
        public Date begin;
        /** 结束时间 */
        public Date end;

        public DateRange() {
        }

        public DateRange(Date begin, Date end) {
            this.begin = begin;
            this.end = end;
        }
    }

    /**
     * 获取指定日期的当天时间范围如(2014-06-09 00:00:00 2014-06-09 23:59:59)
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getDayRange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        range.begin = setDayToBegin(calendar).getTime();
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    /**
     * 获取指定日期本周的时间范围如
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getWeekReange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        range.begin = setDayToBegin(calendar).getTime();

        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + 6);
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    /**
     * 获取指定日期本月的时间范围如
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getMonthReange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        range.begin = setDayToBegin(calendar).getTime();

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 1);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    /**
     * 获取指定日期本季度的时间范围如
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getSeasonReange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        int month = calendar.get(Calendar.MONTH);
        calendar.set(Calendar.MONTH, month - (month % 3));
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        range.begin = setDayToBegin(calendar).getTime();

        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) + 3);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    /**
     * 获取指定日期本半年的时间范围如
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getHalfYearReange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
        range.begin = calendar.getTime();

        calendar.set(Calendar.MONTH, 6);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    /**
     * 获取指定日期本半年的时间范围如
     *
     * @param date 时间,为空表示当前时间
     * @return 时间范围
     */
    public static DateRange getYearReange(Date date) {
        DateRange range = new DateRange();
        Calendar calendar = Calendar.getInstance();
        if (date != null) {
            calendar.setTime(date);
        }

        calendar.set(calendar.get(Calendar.YEAR), Calendar.JANUARY, 1, 0, 0, 0);
        range.begin = calendar.getTime();

        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - 1);
        range.end = setDayToEnd(calendar).getTime();

        return range;
    }

    private static Calendar setDayToEnd(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        return calendar;
    }

    private static Calendar setDayToBegin(Calendar calendar) {
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar;
    }
    
    /**
	 * @category 根据分钟得到X天X小时X分钟信息
	 * @param minutes
	 * @return
	 */
	public static String getTimeInfoByMinute(long minutes) {
		StringBuilder info = new StringBuilder();
		if (minutes >= ONE_DAY_MINUTE) {
			info.append(handDayByMinute(minutes));
		} else if (minutes > ONE_HOUR_MINUTE) {
			info.append(handHourByMinute(minutes));
		} else {
			info.append(minutes).append(MINUTE_STR);
		}
		
		return info.toString();
	}

	/**
	 * @category 通过分钟处理得到多少天
	 * @param minutes
	 * @return
	 */
	private static String handDayByMinute(long minutes) {
		StringBuilder info = new StringBuilder();
		long day = minutes / ONE_DAY_MINUTE;
		info.append(day).append(DAY_STR);
		long dayOther = minutes % ONE_DAY_MINUTE;
		if (dayOther > 0) {
			if (dayOther > ONE_HOUR_MINUTE) {
				info.append(handHourByMinute(dayOther));
			} else {
				info.append(dayOther).append(MINUTE_STR);
			}
		}
		
		return info.toString();
	}
	
	/**
	 * @category 通过分钟处理得到多少小时
	 * @param minutes
	 */
	private static String handHourByMinute(long minutes) {
		StringBuilder info = new StringBuilder();
		long hour = minutes / ONE_HOUR_MINUTE;
		info.append(hour).append(HOUR_STR);
		long hourOther = minutes % ONE_HOUR_MINUTE;
		if (hourOther > 0) {
			info.append(hourOther).append(MINUTE_STR);
		}
		
		return info.toString();
	}

}