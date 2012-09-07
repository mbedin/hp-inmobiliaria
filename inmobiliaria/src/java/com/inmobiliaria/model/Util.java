package com.inmobiliaria.model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

	public static final String DATE_FORMAT_DEFAULT = "dd/MM/yyyy";
	public static final String TIME_FORMAT_DEFAULT = "H:m";
	
	public static boolean isStringNullOrEmpty(String value) {
		
		if (value == null || "".equals(value) || "".equals(value.trim()))
			return true;
		
		return false;
	}
	

	/** isEmailValid: Validate email address using Java reg ex. 
	 * This method checks if the input string is a valid email address. 
	 * @param email String. Email address to validate 
	 * @return boolean: true if email address is valid, false otherwise. 
	 */  
	public static boolean isEmailValid(String email){  
		boolean isValid = false;  
		/* 
		   Email format: A valid email address will have following format: 
		           [\\w\\.-]+: Begins with word characters, (may include periods and hypens). 
		       @: It must have a '@' symbol after initial characters. 
		       ([\\w\\-]+\\.)+: '@' must follow by more alphanumeric characters (may include hypens.). 
		   This part must also have a "." to separate domain and subdomain names. 
		       [A-Z]{2,4}$ : Must end with two to four alaphabets. 
		   (This will allow domain names with 2, 3 and 4 characters e.g pa, com, net, wxyz) 
		    
		   Examples: Following email addresses will pass validation 
		   abc@xyz.net; ab.c@tx.gov 
		*/  
	     
		//Initialize reg ex for email.  
		String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";  
		CharSequence inputStr = email;  
		//Make the comparison case-insensitive.  
		Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);  
		Matcher matcher = pattern.matcher(inputStr);  
		if(matcher.matches()){  
			isValid = true;  
		}  
		return isValid;  
	}  
	
	
	public static boolean isNumeric(String value){
		try {
			Double.parseDouble(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static boolean isInteger(String value){
		try {
			Integer.parseInt(value);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public static String getStringParameter(String parameterValue) {
		String returnValue = "";
		if (parameterValue != null) {
			returnValue = parameterValue;
		}
		return returnValue ;
	}
	
	public static Integer getIntParameter(String parameterValue) {
		int returnValue = 0;
		if (parameterValue != null) {
			if (isNumeric(parameterValue))
				returnValue = Integer.parseInt(parameterValue);
		}
		return returnValue;
	}
	
	public static Boolean getBooleanParameter(String parameterValue) {
		Boolean returnValue = false;
		if (parameterValue != null) {
			returnValue = Boolean.parseBoolean(parameterValue);
		}
		return returnValue;
	}
	
	public static boolean isDate(int year, int month, int day){
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd");
		    sdf.setLenient(false);
		    return sdf.parse(year+"-"+month+"-"+day, new ParsePosition(0)) != null;
	
	}

	public static Timestamp getTimestamp(int year, int month, int day) {
		Calendar date = new GregorianCalendar();
		date.setLenient(false);
		date.set(year, month - 1, day);
		return new Timestamp(date.getTimeInMillis());
    }

	
	public static String encriptar(String s) {

		String r = null;
		try {
			if (s != null) {

				MessageDigest algorithm =MessageDigest.getInstance("MD5");
				algorithm.reset();
				algorithm.update(s.getBytes());
				byte bytes[] = algorithm.digest();
				StringBuffer sb = new StringBuffer();
				for (int i = 0; i < bytes.length; i++) {
					String hex = Integer.toHexString(0xff & bytes[i]);
					if (hex.length() == 1)
						sb.append('0');
					sb.append(hex);
				}
				
				r = sb.toString();
			}
		} catch (NoSuchAlgorithmException e) {
		}

		return r;

	}
	
	
	public static int compareOnlyDates(Date date1, Date date2) {
		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		d1.set(d1.get(Calendar.YEAR),
				d1.get(Calendar.MONTH),
				d1.get(Calendar.DAY_OF_MONTH),
				0,   // Hour
				0,   // Minute
				0);  // Second
		d1.set(Calendar.MILLISECOND, 0);
		
		Calendar d2 = Calendar.getInstance();
		d2.setTime(date2);
		d2.set(d2.get(Calendar.YEAR),
				d2.get(Calendar.MONTH),
				d2.get(Calendar.DAY_OF_MONTH),
				0,   // Hour
				0,   // Minute
				0);  // Second
		d2.set(Calendar.MILLISECOND, 0);

		return d1.getTime().compareTo(d2.getTime());
	}

	public static boolean isDate(String date) {
		return isDate(date, DATE_FORMAT_DEFAULT);
	}
	
	public static boolean isDate(String date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		boolean result = false;
		try {
			Date dateObject = df.parse(date);
			result = true;
		} catch (ParseException e) {

		}
		return result;
	}

    public static boolean isTime(String time) {
		int h,m;

		if(!time.isEmpty()){
			if(time.length()==5){
				if( String.valueOf(time.charAt(2)).equals(":")) {
					try {
						h = Integer.parseInt(time.charAt(0)+""+time.charAt(1));
						m = Integer.parseInt(time.charAt(3)+""+time.charAt(4));
						if(h < 24 && m < 60 && h >= 0 && m >= 0)
							return true;
					} catch (Exception e) {
					}
				}
			}
		}
		return false;

	}

	public static Date getDateFromString(String date) {
		return getDateFromString(date, DATE_FORMAT_DEFAULT);
	}

	public static Date getDateFromString(String date, String format) {
		DateFormat df = new SimpleDateFormat(format);
		df.setLenient(false);
		Date result = new Date();
		try {
			result = df.parse(date);
		} catch (ParseException e) {

		}
		return result;
	}
	
	public static Time getTimeFromString(String time){
		int h, m, s=0;
		Time hora = new Time(0, 0, 0);
		
		if(isTime(time)){
			try {
				h = Integer.parseInt(time.charAt(0)+""+time.charAt(1));
				m = Integer.parseInt(time.charAt(3)+""+time.charAt(4));
				if(h < 24 && m < 60 && h >= 0 && m >= 0)
					return new Time(h,m,s);
			} catch (Exception e) {
			}
		}
		return hora;
	}

	public static String getStringFromDate(Date date) {
		return getStringFromDate(date, DATE_FORMAT_DEFAULT);
	}
	
	public static String getStringFromDate(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}
	
	/**public static String getStringFromTime(Time time) {
		return getStringFromTime(time, TIME_FORMAT_DEFAULT);
	}
	
	public static String getStringFromTime(Time time, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(time);  
	}
	*/
	
}
