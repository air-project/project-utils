package com.yh.utils.basis.date;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;

import com.yh.utils.basic.date.DateUtil;


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
    	Assert.assertEquals(31,DateUtil.diff(date, newDate, 0));
    } 
	@Test
    public  void getSysDate() {  
    	System.out.println(DateUtil.getSysDateOfDate());
    } 
} 