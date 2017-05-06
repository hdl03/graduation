package com.san.graduation.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.san.graduation.common.constants.DateConstant;


/**
 * 日期工具类
 * 
 * ClassName: DateUtil <br/> 
 * Function: ADD FUNCTION. <br/> 
 * Reason: ADD REASON(可选). <br/> 
 * date: 2016年11月30日 下午10:03:53 <br/> 
 * 
 * @author huangdongliang
 * @version  
 * @since JDK 1.8
 */
public class DateUtil {

	
	public static Date getDate() {
		Calendar canlendar = Calendar.getInstance();
		return canlendar.getTime();
	}

	public static Date getDate(int iYear, int iMonth, int iDate, int iHour,
			int iMinute, int iSecond) {
		iMonth--;
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.set(iYear, iMonth, iDate, iHour, iMinute, iSecond);
		return canlendar.getTime();
	}

	public static Date getDate(int iYear, int iMonth, int iDate, int iHour,
			int iMinute) {
		return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute, 0);
	}

	public static Date getDate(int iYear, int iMonth, int iDate, int iHour) {
		return DateUtil.getDate(iYear, iMonth, iDate, iHour, 0, 0);
	}

	public static Date getDate(int iYear, int iMonth, int iDate) {
		return DateUtil.getDate(iYear, iMonth, iDate, 0, 0, 0);
	}

	public static Date getDate(int iYear, int iMonth) {
		return DateUtil.getDate(iYear, iMonth, 1, 0, 0, 0);
	}

	public static Date getDate(int iYear) {
		return DateUtil.getDate(iYear, 1, 1, 0, 0, 0);
	}

	public static Date getDate(String sYear) {
		int iYear = DateUtil.getRightNumber(sYear);
		return DateUtil.getDate(iYear);
	}

	public static Date getDate(String sYear, String sMonth) {
		int iYear = DateUtil.getRightNumber(sYear);
		int iMonth = DateUtil.getRightNumber(sMonth);
		return DateUtil.getDate(iYear, iMonth);
	}

	public static Date getDate(String sYear, String sMonth, String sDate) {
		int iYear = DateUtil.getRightNumber(sYear);
		int iMonth = DateUtil.getRightNumber(sMonth);
		int iDate = DateUtil.getRightNumber(sDate);
		return DateUtil.getDate(iYear, iMonth, iDate);
	}

	public static Date getDate(String sYear, String sMonth, String sDate,
			String sHour) {
		int iYear = DateUtil.getRightNumber(sYear);
		int iMonth = DateUtil.getRightNumber(sMonth);
		int iDate = DateUtil.getRightNumber(sDate);
		int iHour = DateUtil.getRightNumber(sHour);
		return DateUtil.getDate(iYear, iMonth, iDate, iHour);
	}

	public static Date getDate(String sYear, String sMonth, String sDate,
			String sHour, String sMinute) {
		int iYear = DateUtil.getRightNumber(sYear);
		int iMonth = DateUtil.getRightNumber(sMonth);
		int iDate = DateUtil.getRightNumber(sDate);
		int iHour = DateUtil.getRightNumber(sHour);
		int iMinute = DateUtil.getRightNumber(sMinute);
		return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute);
	}

	public static Date getDate(String sYear, String sMonth, String sDate,
			String sHour, String sMinute, String sSecond) {
		int iYear = DateUtil.getRightNumber(sYear);
		int iMonth = DateUtil.getRightNumber(sMonth);
		int iDate = DateUtil.getRightNumber(sDate);
		int iHour = DateUtil.getRightNumber(sHour);
		int iMinute = DateUtil.getRightNumber(sMinute);
		int iSecond = DateUtil.getRightNumber(sSecond);
		return DateUtil.getDate(iYear, iMonth, iDate, iHour, iMinute, iSecond);
	}

	private static int getRightNumber(String sNumber) {
		try {
			return Integer.parseInt(sNumber);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

	public static boolean isMax(Date date0, Date date1) {
		if (date0 == null || date1 == null) {
			return false;
		}
		if (date0.getTime() > date1.getTime()) {
			return true;
		}
		return false;

	}

	public static Date Max(Date date0, Date date1) {
		if (date0 != null && date1 != null) {
			if (date0.getTime() > date1.getTime()) {
				return date0;
			}
			return date1;
		} else if (date0 != null && date1 == null) {
			return date0;
		} else if (date0 == null && date1 != null) {
			return date1;
		} else {
			return null;
		}
	}

	public static Date Min(Date date0, Date date1) {
		if (date0 != null && date1 != null) {
			if (date0.getTime() < date1.getTime()) {
				return date0;
			}
			return date1;
		} else {
			return null;
		}
	}

	public static long getMMDif(Date date0, Date date1) {
		if (date0 == null || date1 == null) {
			return 0;
		}
		return date0.getTime() - date1.getTime();
	}

	public static long getSeDif(Date date0, Date date1) {
		return DateUtil.getMMDif(date0, date1) / 1000;
	}

	public static long getMiDif(Date date0, Date date1) {
		return DateUtil.getSeDif(date0, date1) / 60;
	}

	public static int getHoDif(Date date0, Date date1) {
		return (int) DateUtil.getMiDif(date0, date1) / 60;
	}

	public static int getDaDif(Date date0, Date date1) {
		return DateUtil.getHoDif(date0, date1) / 24;
	}

	private static Date addDate(Date date, int iArg0, int iDate) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.setTime(date);
		canlendar.add(iArg0, iDate);
		return canlendar.getTime();
	}

	public static Date addSe(Date date, int iSecond) {
		return addDate(date, Calendar.SECOND, iSecond);
	}

	public static Date addMi(Date date, int iMinute) {
		return addDate(date, Calendar.MINUTE, iMinute);
	}

	public static Date addHo(Date date, int iHour) {
		return addDate(date, Calendar.HOUR, iHour);
	}

	public static Date addDa(Date date, int iDate) {
		return addDate(date, Calendar.DAY_OF_MONTH, iDate);
	}

	public static Date addMo(Date date, int iMonth) {
		return addDate(date, Calendar.MONTH, iMonth);
	}

	public static Date addYe(Date date, int iYear) {
		return addDate(date, Calendar.YEAR, iYear);
	}

	public static Date addWe(Date date, int iWeek) {
		return addDate(date, Calendar.WEEK_OF_YEAR, iWeek);
	}

	public static Date addSe(Date date, String sSecond) {
		return addSe(date, getRightNumber(sSecond));
	}

	public static Date addMi(Date date, String sMinute) {
		return addMi(date, getRightNumber(sMinute));
	}

	public static Date addHo(Date date, String sHour) {
		return addHo(date, getRightNumber(sHour));
	}

	public static Date addDa(Date date, String sDate) {
		return addDa(date, getRightNumber(sDate));
	}

	public static Date addMo(Date date, String sMonth) {
		return addMo(date, getRightNumber(sMonth));
	}

	public static Date addYe(Date date, String sYear) {
		return addYe(date, getRightNumber(sYear));
	}

	public static Date addWe(Date date, String sWeek) {
		return addWe(date, getRightNumber(sWeek));
	}


	
	public static Date parseDate(String sDate, String formate) {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(formate);
		try {
			return simpleDateFormate.parse(sDate);
		} catch (ParseException e) {
			return null;
		}
	}
	
	public static Date parseDateFullYear(String sDate) {
		SimpleDateFormat simpleDateFormate = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			return simpleDateFormate.parse(sDate);
		} catch (ParseException e) {
			return null;
		}
	}
	
	//============通过传入date按一定格式转为日期字符串===========开始====//
	
	public static String dateToStr(Date date,String pattern) {
		if (StringUtils.isEmpty(date))
			return null;
	    try{
	       SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	       return formatter.format(date);
	    }catch(Exception e){
	    	   //------
	    }
	    return null;
	} 

	public static String get4yMdHmsS(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_YMDhmsS);
	}

	public static String get4yMdHms(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN);
	}

	public static String get4yMdH(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_YMDh);
	}

	public static String get4yMdHm(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_YMDhm);
	}

	public static String get4yMd(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_YMD);
	}

	public static String get4yM(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_YM);
	}

	public static String get4y(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_Y);
	}

	public static String getMd(Date date) {
		return dateToStr(date, DateConstant.DATE_PATTERN_MD);
	}

	public static String getLine4Ymd(Date date) {
	   return dateToStr(date, DateConstant.DATE_PATTERN_YMD_LINE);
	}
	
	public static String dateToStr(Date date, int type) {
        switch (type) {
        case DateConstant.DEFAULT:
            return getLine4Ymd(date);
        case DateConstant.YM:
            return dateToStr(date, "yyyy/MM");
        case DateConstant.NO_SLASH:
            return dateToStr(date, "yyyyMMdd");
        case DateConstant.YMR_SLASH:
        	return dateToStr(date, "yyyy-MM-dd");
        case DateConstant.YM_NO_SLASH:
            return dateToStr(date, "yyyyMM");
        case DateConstant.DATE_TIME:
            return dateToStr(date, DateConstant.DATE_PATTERN_LINE);
        case DateConstant.DATE_TIME_NO_SLASH:
            return dateToStr(date, "yyyyMMddHHmmss");
        case DateConstant.DATE_HM:
            return dateToStr(date, "yyyy/MM/dd HH:mm");
        case DateConstant.TIME:
            return dateToStr(date, "HH:mm:ss");
        case DateConstant.HM:
            return dateToStr(date, "HH:mm");
        case DateConstant.LONG_TIME:
            return dateToStr(date, "HHmmss");
        case DateConstant.SHORT_TIME:
            return dateToStr(date, "HHmm");
        case DateConstant.DATE_TIME_LINE:
            return dateToStr(date, "yyyy-MM-dd HH:mm:ss");
        default:
            throw new IllegalArgumentException("Type undefined : " + type);
        }
    }

//--------------------结束-------------------------//
	

	public static int getPartOfTime(Date date, String part) {
		Calendar canlendar = Calendar.getInstance();
		canlendar.clear();
		canlendar.setTime(date);
		if (part.equals("year")) {
			return canlendar.get(Calendar.YEAR);
		}
		if (part.equals("month")) {
			return canlendar.get(Calendar.MONTH) + 1;
		}
		if (part.equals("date")) {
			return canlendar.get(Calendar.DAY_OF_MONTH);
		}
		if (part.equals("hour")) {
			return canlendar.get(Calendar.HOUR_OF_DAY);
		}
		if (part.equals("minute")) {
			return canlendar.get(Calendar.MINUTE);
		}
		if (part.equals("second")) {
			return canlendar.get(Calendar.SECOND);
		}
		if (part.equals("milliSecond")) {
			return canlendar.get(Calendar.MILLISECOND);
		}
		return -1;
	}

	/**
	 * 计算当前日期是星期几(星期日为0)
	 * 
	 * @param strDate
	 * @return
	 */
	public static int getWeekDay(Date strDate) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(strDate);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 日期增加天数
	 * 
	 * @param date0
	 * @param date1
	 * @return
	 */
	public static Date addDay(Date date, int iDate) {
		return addDate(date, Calendar.DAY_OF_MONTH, iDate);
	}

	public static Date getEndDate(Date date) {
		Calendar cal = Calendar.getInstance();

		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static Date getStartDate(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}
	
	// public static String getWeek(Date date)
	// {
	// Calendar canlendar = Calendar.getInstance();
	// canlendar.clear();
	// canlendar.setTime(date);
	// int i = canlendar.get(Calendar.DAY_OF_WEEK);
	// switch (i)
	// {
	// case 1:
	// return "星期日";
	// case 2:
	// return "星期一";
	// case 3:
	// return "星期二";
	// case 4:
	// return "星期三";
	// case 5:
	// return "星期四";
	// case 6:
	// return "星期五";
	// case 7:
	// return "星期六";
	// }
	// return "";
	//
	// }
	

	
 

	//public static void main(String a[]){
		//System.out.println(getPartOfTime(getDate(), "hour"));
		
		//String str=DateUtil.get4yMdHms(DateUtil.addDay(DateUtil.getDate(), -30));
		
		//System.out.println(TimeToolUtil.compareTwoDate("2016-11-14 11:45:40", str));
	//}
	
}
