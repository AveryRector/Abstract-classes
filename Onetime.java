package Abstract;

public class Onetime extends Appointment {
	
	public Onetime(int aYear, int aMonth, int aDay) {
		setDescription("");
		setYear(aYear);
		setMonth(aMonth);
		setDay(aDay);
	}
	
	public boolean occursOn(int year, int month, int day) {
		if(year == getYear() && month == getMonth() && day == getDay()) { // if year month and day match objects 
			return true;
		}
		else {
			return false;
		}
	}
}
