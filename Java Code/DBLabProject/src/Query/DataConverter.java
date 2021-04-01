package Query;
import java.time.LocalDateTime;

public class DataConverter {
	public static String createDateTimeString(int year, int month, int day, int hour, int min, int sec)
	{
		return 
				addZeroToTheLeft(Integer.toString(year)) + "/" + 
				addZeroToTheLeft(Integer.toString(month)) + "/" + 
				addZeroToTheLeft(Integer.toString(day)) + " " + 
				addZeroToTheLeft(Integer.toString(hour)) + ":" + 
				addZeroToTheLeft(Integer.toString(min)) + ":" + 
				addZeroToTheLeft(Integer.toString(sec));
	}
	public static String createDateTimeString(int year, int month, int day)
	{
		return 
				addZeroToTheLeft(Integer.toString(year)) + "/" + 
				addZeroToTheLeft(Integer.toString(month)) + "/" + 
				addZeroToTheLeft(Integer.toString(day)) + " 00:00:00" ;
	}
	public static String addZeroToTheLeft(String a)
	{
		if (a.length() == 1)
		{
			a = "0" + a;
		}
		return a;
	}
	public static String convertDateTimeToString(LocalDateTime a)
	{
		String res = Integer.toString(a.getYear())
				+"-"+	addZeroToTheLeft(Integer.toString(a.getMonthValue()))
				+"-"+	addZeroToTheLeft(Integer.toString(a.getDayOfMonth()))
				+" "
				+		addZeroToTheLeft(Integer.toString(a.getHour()))
				+":"+	addZeroToTheLeft(Integer.toString(a.getMinute()))
				+":"+	addZeroToTheLeft(Integer.toString(a.getSecond()));
		return res;
	}
	public static String getDateTimeFormat()
	{
		return "yyyy-MM-dd HH:mm:ss";
	}
	public static String getNormalTimeFormat(LocalDateTime a)
	{
		String res = 	DataConverter.addZeroToTheLeft(Integer.toString(a.getDayOfMonth()))
				+ "/" + DataConverter.addZeroToTheLeft(Integer.toString(a.getMonthValue()))
				+ "/" + DataConverter.addZeroToTheLeft(Integer.toString(a.getYear()))
				+ " " + DataConverter.addZeroToTheLeft(Integer.toString(a.getHour()))
				+":"+	addZeroToTheLeft(Integer.toString(a.getMinute()))
				+":"+	addZeroToTheLeft(Integer.toString(a.getSecond()));
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(DataConverter.getNormalTimeFormat(LocalDateTime.now()));
		System.out.println(DataConverter.createDateTimeString(0, 0, 0));
	}

}
