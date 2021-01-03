package limuiju.todolist.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MyParam {
	public static LocalDate toDate(String str) {
		DateTimeFormatter dateFormat 
		= DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		
		return LocalDate.parse(str, dateFormat);
	}
}
