package com.yh.utils.lunar;

import org.junit.Test;

/** 
 * @author yanghao 
 * @date 2014年9月17日 下午1:43:10
 */
public class TestLunarCalender {
	    @Test  
	    public void test () {  
//	      String dateStr = "2015-2-4";  
//	      LunarCalendar calendar = new LunarCalendar(DateUtil.stringToDate(dateStr, DateStyle.YYYY_MM_DD));  
//	        LunarCalendar calendar = new LunarCalendar();  
//	        System.out.println("getAnimalString=" + calendar.getAnimalString());  
//	        System.out.println("getDateString=" + calendar.getDateString());  
//	        System.out.println("getDay=" + calendar.getDay());  
//	        System.out.println("getDayString=" + calendar.getDayString());  
//	        System.out.println("getGanZhiDateString=" + calendar.getGanZhiDateString());  
//	        System.out.println("getMaxDayInMonth=" + calendar.getMaxDayInMonth());  
//	        System.out.println("getMonth=" + calendar.getMonth());  
//	        System.out.println("getMonthString=" + calendar.getMonthString());  
//	        System.out.println("getYear=" + calendar.getYear());  
//	        System.out.println("getYearString=" + calendar.getYearString());  
//	  
//	        String[] strs = calendar.getAllSolarTerm();  
//	        for (String str : strs) {  
//	            System.out.println(str);  
//	        }  
	        
	        LunarDate d= new LunarDate();
	        d.setYear(2014);
	        d.setMonth(9);
	        LunarDate d2= new LunarDate();
	        d2.setYear(2015);
	        d2.setMonth(3);
	        LunarConstant.Oba.getDayName(d, d2);
	        System.out.println(d2.getImpName());
	    }  
	}  
