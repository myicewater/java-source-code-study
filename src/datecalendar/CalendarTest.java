package datecalendar;

import java.util.Calendar;
/**
 * 
 * Calendar.getInstance() 返回的时间默认的是当前时间 
 * 
 * @author 朱素海
 *
 */
public class CalendarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
	}

}
