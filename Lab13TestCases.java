package Abstract;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Lab13TestCases {

	// Appointment test cases

	@Test
	public void AppointmentIsAbstractClass() {
		assertEquals("Your Appointment class must be abstract.", true,
				Modifier.isAbstract(Appointment.class.getModifiers()));
	}

	@Test
	public void AppointmentInstanceVariablesTest() {
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			c.getDeclaredField("description");
			c.getDeclaredField("year");
			c.getDeclaredField("month");
			c.getDeclaredField("day");

			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					4, c.getDeclaredFields().length);

			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("description").getModifiers()));
			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("year").getModifiers()));
			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("month").getModifiers()));
			assertEquals("You must make your instance variables private.", true,
					Modifier.isPrivate(c.getDeclaredField("day").getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("description").getModifiers()));
			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("year").getModifiers()));
			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("month").getModifiers()));
			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(c.getDeclaredField("day").getModifiers()));

			assertEquals("You must make your description instance variable of type String.", (String.class),
					c.getDeclaredField("description").getType());
			assertEquals("You must make your year instance variable of type int.", (int.class),
					c.getDeclaredField("year").getType());
			assertEquals("You must make your month instance variable of type int.", (int.class),
					c.getDeclaredField("month").getType());
			assertEquals("You must make your day instance variable of type int.", (int.class),
					c.getDeclaredField("day").getType());

		} catch (NoSuchFieldException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " instance variable");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void AppointmentOccursOnDeclarationTest() {
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			@SuppressWarnings("unchecked")
			Method method = c.getMethod("occursOn", new Class[] { int.class, int.class, int.class });

			assertEquals("You must make your methods public.", false, Modifier.isPrivate(method.getModifiers()));

			assertEquals("Your instance variables must NOT be static.", false,
					Modifier.isStatic(method.getModifiers()));

			assertEquals("You must make your occursOn method return a Boolean value.", (boolean.class),
					method.getReturnType());

			assertEquals("Your occursOn method must be abstract.", true, Modifier.isAbstract(method.getModifiers()));

		} catch (NoSuchMethodException e) {
			fail("Could not find the " + e.getLocalizedMessage().toString() + " method");
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void AppointmentToStringTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		assertEquals(
				"After calling the toString method with a description of \"The Strokes\", a year of \"2001\", a month of \"7\", and a day of \"30\", we",
				"Appointment: The Strokes On Date 7/30/2001", myAppointment.toString());
	}

	@Test
	public void AppointmentEqualsTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		Appointment anotherAppointment = createAppointment("The Strokes", 2001, 7, 30);
		Appointment finalAppointment = createAppointment("The Cribs", 2004, 3, 8);

		assertEquals("After calling the equals method comparing the same object we", true,
				myAppointment.equals(myAppointment));
		assertEquals("After calling the equals method comparing identical objects we", true,
				myAppointment.equals(anotherAppointment));
		assertEquals("After calling the equals method comparing different objects we", false,
				myAppointment.equals(finalAppointment));
	}

	@Test
	public void AppointmentGetYearTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		assertEquals(
				"After calling the getYear method with a description of \"The Strokes\", a year of \"2001\", a month of \"7\", and a day of \"30\", we",
				2001, myAppointment.getYear());
	}

	@Test
	public void AppointmentGetMonthTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		assertEquals(
				"After calling the getMonth method with a description of \"The Strokes\", a year of \"2001\", a month of \"7\", and a day of \"30\", we",
				7, myAppointment.getMonth());
	}

	@Test
	public void AppointmentGetDayTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		assertEquals(
				"After calling the getDay method with a description of \"The Strokes\", a year of \"2001\", a month of \"7\", and a day of \"30\", we",
				30, myAppointment.getDay());
	}

	@Test
	public void AppointmentGetDescriptionTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		assertEquals(
				"After calling the getDay method with a description of \"The Strokes\", a year of \"2001\", a month of \"7\", and a day of \"30\", we",
				"The Strokes", myAppointment.getDescription());
	}

	@Test
	public void AppointmentSetYearTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		myAppointment.setYear(2004);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field year = c.getDeclaredField("year");
			year.setAccessible(true);
			int yearValue = (int) year.get(myAppointment);
			assertEquals("After calling the setYear method with a parameter of 2004 we", 2004, yearValue);
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void AppointmentSetMonthTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		myAppointment.setMonth(3);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field month = c.getDeclaredField("month");
			month.setAccessible(true);
			int monthValue = (int) month.get(myAppointment);
			assertEquals("After calling the setMonth method with a parameter of 3 we", 3, monthValue);
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void AppointmentSetDayTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		myAppointment.setDay(8);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field day = c.getDeclaredField("day");
			day.setAccessible(true);
			int dayValue = (int) day.get(myAppointment);
			assertEquals("After calling the setDay method with a parameter of 8 we", 8, dayValue);
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void AppointmentSetDescriptionTest() {
		Appointment myAppointment = createAppointment("The Strokes", 2001, 7, 30);
		myAppointment.setDescription("The Cribs");
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field description = c.getDeclaredField("description");
			description.setAccessible(true);
			String descriptionValue = (String) description.get(myAppointment);
			assertEquals("After calling the setDescription method with a parameter of \"The Cribs\" we", "The Cribs",
					descriptionValue);
		} catch (Exception e) {
			fail(e.toString());
		}
	}

	private class myAppointment extends Appointment {

		@Override
		public boolean occursOn(int aYear, int aMonth, int aDay) {
			// TODO Auto-generated method stub
			return false;
		}

	}

	private Appointment createAppointment(String aDescription, int aYear, int aMonth, int aDay) {
		Appointment myAppointment = new myAppointment();
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field description = c.getDeclaredField("description");
			description.setAccessible(true);
			description.set(myAppointment, aDescription);

			Field year = c.getDeclaredField("year");
			year.setAccessible(true);
			year.set(myAppointment, aYear);

			Field month = c.getDeclaredField("month");
			month.setAccessible(true);
			month.set(myAppointment, aMonth);

			Field day = c.getDeclaredField("day");
			day.setAccessible(true);
			day.set(myAppointment, aDay);

		} catch (Exception e) {
			fail(e.toString());
		}
		return myAppointment;
	}

	// Onetime test cases
	@Test
	public void OnetimeSuperClass() {
		Onetime myOnetime = new Onetime(0, 0, 0);
		assertEquals("When Testing if the Onetime Super Class is Appointment, we", true,
				(myOnetime instanceof Appointment));
	}

	@Test
	public void OnetimeInstanceVariablesTest() {
		Onetime testOnetime = new Onetime(0, 0, 0);
		@SuppressWarnings("rawtypes")
		Class c = testOnetime.getClass();
		try {
			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					0, c.getDeclaredFields().length);
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void OnetimeParameterizedConstructorTest() {
		Onetime testOnetime = new Onetime(1998, 9, 28);
		@SuppressWarnings("rawtypes")
		Class c = testOnetime.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field description = superC.getDeclaredField("description");
			description.setAccessible(true);
			String descriptionValue = (String) description.get(testOnetime);
			assertEquals("When checking the value of description we", "", descriptionValue);

			Field year = superC.getDeclaredField("year");
			year.setAccessible(true);
			int yearValue = (int) year.get(testOnetime);
			assertEquals("When checking the value of year we", 1998, yearValue);

			Field month = superC.getDeclaredField("month");
			month.setAccessible(true);
			int monthValue = (int) month.get(testOnetime);
			assertEquals("When checking the value of month we", 9, monthValue);

			Field day = superC.getDeclaredField("day");
			day.setAccessible(true);
			int dayValue = (int) day.get(testOnetime);
			assertEquals("When checking the value of day we", 28, dayValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void OnetimeOccursOnTest() {
		Onetime testOnetime = createOnetime("", 1998, 9, 28);
		assertEquals(
				"After calling the occursOn method with the parameters the same as those used in the constructor we",
				true, testOnetime.occursOn(1998, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(2000, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(2000, 1, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(2000, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(2000, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(1998, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(1998, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testOnetime.occursOn(1998, 1, 28));
	}

	@Test
	public void OnetimeToStringTest() {
		Onetime myAppointment = createOnetime("Pokemon Red and Blue", 1998, 9, 28);
		assertEquals(
				"After calling the toString method with a description of \"Pokemon Red and Blue\", a year of \"1998\", a month of \"9\", and a day of \"28\", we",
				"Appointment: Pokemon Red and Blue On Date 9/28/1998", myAppointment.toString());
	}

	private Onetime createOnetime(String aDescription, int aYear, int aMonth, int aDay) {
		Onetime myAppointment = new Onetime(0, 0, 0);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field description = c.getDeclaredField("description");
			description.setAccessible(true);
			description.set(myAppointment, aDescription);

			Field year = c.getDeclaredField("year");
			year.setAccessible(true);
			year.set(myAppointment, aYear);

			Field month = c.getDeclaredField("month");
			month.setAccessible(true);
			month.set(myAppointment, aMonth);

			Field day = c.getDeclaredField("day");
			day.setAccessible(true);
			day.set(myAppointment, aDay);

		} catch (Exception e) {
			fail(e.toString());
		}
		return myAppointment;
	}

	// Monthly test cases

	public void MonthlySuperClass() {
		Monthly myMonthly = new Monthly(0);
		assertEquals("When Testing if the Monthly Super Class is Appointment, we", true,
				(myMonthly instanceof Appointment));
	}

	@Test
	public void MonthlyInstanceVariablesTest() {
		Monthly testMonthly = new Monthly(0);
		@SuppressWarnings("rawtypes")
		Class c = testMonthly.getClass();
		try {
			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					0, c.getDeclaredFields().length);
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void MonthlyParameterizedConstructorTest() {
		Monthly testMonthly = new Monthly(28);
		@SuppressWarnings("rawtypes")
		Class c = testMonthly.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field description = superC.getDeclaredField("description");
			description.setAccessible(true);
			String descriptionValue = (String) description.get(testMonthly);
			assertEquals("When checking the value of description we", "", descriptionValue);

			Field day = superC.getDeclaredField("day");
			day.setAccessible(true);
			int dayValue = (int) day.get(testMonthly);
			assertEquals("When checking the value of day we", 28, dayValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void MonthlyOccursOnTest() {
		Monthly testMonthly = createtestMonthly("", 1998, 9, 28);
		assertEquals(
				"After calling the occursOn method with the parameters the same as those used in the constructor we",
				true, testMonthly.occursOn(1998, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testMonthly.occursOn(2000, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				true, testMonthly.occursOn(2000, 1, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testMonthly.occursOn(2000, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				true, testMonthly.occursOn(2000, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testMonthly.occursOn(1998, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testMonthly.occursOn(1998, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				true, testMonthly.occursOn(1998, 1, 28));
	}

	@Test
	public void MonthlyToStringTest() {
		Monthly myAppointment = createtestMonthly("Pokemon Red and Blue", 1998, 9, 28);
		assertEquals(
				"After calling the toString method with a description of \"Pokemon Red and Blue\", and a day of \"28\", we",
				"Appointment: Pokemon Red and Blue Every Month on 28", myAppointment.toString());
	}

	private Monthly createtestMonthly(String aDescription, int aYear, int aMonth, int aDay) {
		Monthly myAppointment = new Monthly(0);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field description = c.getDeclaredField("description");
			description.setAccessible(true);
			description.set(myAppointment, aDescription);

			Field year = c.getDeclaredField("year");
			year.setAccessible(true);
			year.set(myAppointment, aYear);

			Field month = c.getDeclaredField("month");
			month.setAccessible(true);
			month.set(myAppointment, aMonth);

			Field day = c.getDeclaredField("day");
			day.setAccessible(true);
			day.set(myAppointment, aDay);

		} catch (Exception e) {
			fail(e.toString());
		}
		return myAppointment;
	}

	// Yearly test cases

	public void YearlySuperClass() {
		Yearly myYearly = new Yearly(0, 0);
		assertEquals("When Testing if the Yearly Super Class is Appointment, we", true,
				(myYearly instanceof Appointment));
	}

	@Test
	public void YearlyInstanceVariablesTest() {
		Yearly testYearly = new Yearly(0, 0);
		@SuppressWarnings("rawtypes")
		Class c = testYearly.getClass();
		try {
			assertEquals(
					"You must only have the instance variables specified in the lab manual. When looking at the number of instance variables we",
					0, c.getDeclaredFields().length);
		} catch (Exception e) {
			fail("Something weird went wrong");
		}
	}

	@Test
	public void YearlyParameterizedConstructorTest() {
		Yearly testYearly = new Yearly(7, 4);
		@SuppressWarnings("rawtypes")
		Class c = testYearly.getClass();
		@SuppressWarnings("rawtypes")
		Class superC = c.getSuperclass();
		try {

			Field description = superC.getDeclaredField("description");
			description.setAccessible(true);
			String descriptionValue = (String) description.get(testYearly);
			assertEquals("When checking the value of description we", "", descriptionValue);

			Field month = superC.getDeclaredField("month");
			month.setAccessible(true);
			int monthValue = (int) month.get(testYearly);
			assertEquals("When checking the value of month we", 7, monthValue);

			Field day = superC.getDeclaredField("day");
			day.setAccessible(true);
			int dayValue = (int) day.get(testYearly);
			assertEquals("When checking the value of day we", 4, dayValue);

		} catch (Exception e) {
			fail(e.toString());
		}
	}

	@Test
	public void YearlyOccursOnTest() {
		Yearly testYearly = createTestYearly("", 1998, 9, 28);
		assertEquals(
				"After calling the occursOn method with the parameters the same as those used in the constructor we",
				true, testYearly.occursOn(1998, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(2000, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(2000, 1, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(2000, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				true, testYearly.occursOn(2000, 9, 28));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(1998, 1, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(1998, 9, 1));
		assertEquals(
				"After calling the occursOn method with the parameters different as those used in the constructor we",
				false, testYearly.occursOn(1998, 1, 28));
	}

	@Test
	public void YearlyToStringTest() {
		Yearly myAppointment = createTestYearly("Independence Day", 1776, 7, 4);
		assertEquals(
				"After calling the toString method with a description of \"Independence Day\", a month of \"7\" and a day of \"4\", we",
				"Appointment: Independence Day Every Year on 7/4", myAppointment.toString());
	}

	private Yearly createTestYearly(String aDescription, int aYear, int aMonth, int aDay) {
		Yearly myAppointment = new Yearly(0, 0);
		@SuppressWarnings("rawtypes")
		Class c = Appointment.class;
		try {
			Field description = c.getDeclaredField("description");
			description.setAccessible(true);
			description.set(myAppointment, aDescription);

			Field year = c.getDeclaredField("year");
			year.setAccessible(true);
			year.set(myAppointment, aYear);

			Field month = c.getDeclaredField("month");
			month.setAccessible(true);
			month.set(myAppointment, aMonth);

			Field day = c.getDeclaredField("day");
			day.setAccessible(true);
			day.set(myAppointment, aDay);

		} catch (Exception e) {
			fail(e.toString());
		}
		return myAppointment;
	}

}
