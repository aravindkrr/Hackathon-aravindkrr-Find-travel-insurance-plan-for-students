package Utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Datepickers {
	public static String startdate() {
		
		DateTimeFormatter Date = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
    	String tripstartdate = LocalDate.now().plusDays(2).format(Date);
    	return tripstartdate;
	}
	public static String enddate() {
		
		DateTimeFormatter Date1 = DateTimeFormatter.ofPattern("dd MMMM, yyyy");
    	String tripenddate = LocalDate.now().plusDays(32).format(Date1);
    	return tripenddate;
	}

}
