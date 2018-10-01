package Abstract;

public abstract class Appointment {

	private int year;
	private int month;
	private int day;
	private String description;
	
	public void setYear(int year) {
		this.year = year;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public void setDay(int day) {
		this.day = day;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public int getMonth() {
		return this.month;
	}
	
	public int getDay() {
		return this.day;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public abstract boolean occursOn(int aYear, int aMonth, int aDay);
	
	// overriding of superclass toString method
	@Override
	public String toString() {
		return "Appointment: " + this.description +  " On Date: " + this.month + "/" + this.day + "/" + this.year;
	}
	
	// overriding of superclass equal method
	// test if object is same type and same instance variable values
	@Override
	public boolean equals(Object obj) {
		if(this == obj) { //checks if object refers to itself
			return true;
		}
		else if(obj == null) { //checks if object is null
			return false;
		}
		else if(!(obj instanceof Appointment)) { //checks if the object is a subclass of appointment
			return false;
		}
		Appointment otherAppointment = (Appointment) obj; // cast to object
		// test for values to be equal
		if(this.day == otherAppointment.getDay() && this.month == otherAppointment.getMonth() && this.year == otherAppointment.getYear()) {
			return true;
		}
		else {
			return false;
		}
	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
