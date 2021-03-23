import java.time.LocalDateTime;

public class DataConverter {
	public static String addZeroToTheLeft(String a)
	{
		if (a.length() == 1)
		{
			a = "0" + a;
		}
		return a;
	}
	public static String TimeToString(LocalDateTime a)
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
