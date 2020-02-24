package LibraryManageUtil;
/**
 * 整数工具类
 * @author dell
 *
 */
public class IntUtil {
	/**
	 * 判断年份数据为整数
	 */
	public static boolean IsInt(String str) {
		boolean isNum = str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
		if(isNum) {
			return true;
		}else {
			return false;
		}
		
	}
	
	/**
	 * 判断输入年份是否满足是否现实
	 * @param args
	 */
	public static boolean isYear(int year) {
		if(year>1900&&year<2020) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * 判断数据月份是否符合现实
	 * @param args
	 */
	
	public static boolean isMonth(int month) {
		if(month>=1&&month<=12) {
			return true;
		}else {
			return false;	
		}
	}
	
	/**
	 * 判断数据天数是否符合现实
	 * @param args
	 */
	
	public static boolean isDay(int year ,int month ,int day) {
		int monthDay[] = {31,28,31,30,31,30,31,31,30,31,30,31};
		if((year%4==0 && year%100 != 0)|| year%400==0 ) 
			monthDay[1]++;
		if(day>=1&&day<=monthDay[month-1]) {
			return true;
		}else {
			return false;	
		}
	}
	
}

