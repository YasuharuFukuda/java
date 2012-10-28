package ch24.ex24_03;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

public class MyDateFormat {
	public static void main(String[] args) throws ParseException{
		Date  date = DateFormat.getDateInstance().parse(args[0]);
		int[] array = {DateFormat.SHORT, DateFormat.MEDIUM, DateFormat.LONG, DateFormat.FULL};
		for(int i = 0 ; i < array.length ; i++){
			DateFormat df = DateFormat.getDateTimeInstance(array[i],
					array[i]);
			System.out.println(df.format(date));
		}
	}
}
