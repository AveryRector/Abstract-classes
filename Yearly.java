package Abstract;

public class Yearly extends Appointment {

	public Yearly(int aMonth, int aDay) {
		setMonth(aMonth);
		setDay(aDay);
		setDescription("");
	}
	
	public boolean occursOn(int aYear, int aMonth, int aDay) {
		if(aMonth == getMonth() && aDay == getDay()) { // if month and day match object values
			return true;
		}
		else {
			return false;
		}
	}
	
	// override of Appointment's toString method
	@Override
	public String toString() {
		return "Appointment: " + getDescription() + " Every Year On " + getMonth() + "/" + getDay();
	}
}
