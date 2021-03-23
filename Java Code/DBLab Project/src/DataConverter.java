import java.time.LocalDateTime;

public class DataConverter {
	public static String add0(String a)
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
				+"-"+	add0(Integer.toString(a.getMonthValue()))
				+"-"+	add0(Integer.toString(a.getDayOfMonth()))
				+" "
				+		add0(Integer.toString(a.getHour()))
				+":"+	add0(Integer.toString(a.getMinute()))
				+":"+	add0(Integer.toString(a.getSecond()));
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
