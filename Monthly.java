package Abstract;

public class Monthly extends Appointment{
	
	public Monthly(int aDay) {
		setDay(aDay);
		setDescription("");
	}
	
	public boolean occursOn(int aYear, int aMonth, int aDay) {
		if(aDay == getDay()) { // if day match objects day
			return true;
		}
		else {
			return false;
		}
	}
	
	// override of Appointment toString method
	@Override
	public String toString() {
		return "Appointment: " + getDescription() + " Every Month On " + getDay();
	}
	
}
