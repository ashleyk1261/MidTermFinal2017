package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.cisc181.eNums.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class Staff_Test {

	@BeforeClass
	public static void setup() {
	}

	@Test
	public void test1() throws PersonException {
		double TotalSalaries = 0.0;
		double AverageSalary = 0.0;
		ArrayList<Staff> staffList = new ArrayList<Staff>();

		// Provide details for Staff member 1 and add to the arraylist; increase the
		// total salaries field by the staff's salary
		Calendar DOB1 = Calendar.getInstance();
		Calendar HireDate1 = Calendar.getInstance();
		DOB1.set(1996, 8, 12);
		HireDate1.set(2015, 8,3);
		staffList.add(new Staff("Jim", "Alexander", "Kleinhomer", DOB1.getTime(),
				"15 Forestal Circle, Newark, DE  19711", "(302)-740-2299", "jak@udel.edu", "8:00 a.m. - 10:00 a.m. MWF",
				3, 50000.00, HireDate1.getTime(), eTitle.MR));

		// Provide details for Staff member 2 and add to the arraylist; increase the
		// total salaries field by the staff's salary
		Calendar DOB2 = Calendar.getInstance();
		Calendar HireDate2 = Calendar.getInstance();
		DOB2.set(1995, 7, 29);
		HireDate2.set(2015, 2,2);
		staffList.add(new Staff("Bill", "James", "Kleinhomer", DOB2.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"(302)-740-3399", "bill@kleinhomer.com", "8:00 a.m. - 9:00 a.m. TR", 3, 40000.00, HireDate2.getTime(), eTitle.MR));

		// Provide details for Staff member 3 and add to the arraylist; increase the
		// total salaries field by the staff's salary
		Calendar DOB3 = Calendar.getInstance();
		Calendar HireDate3 = Calendar.getInstance();
		DOB3.set(1997, 12, 6);
		HireDate3.set(2016, 1,3);
		staffList.add(new Staff("Ashley", "Renae", "Kleinhomer", DOB3.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"(302)-234-2392", "ashleyk@udel.edu", "9:00 a.m. - 11:00 a.m. MWF", 2, 55000.00, HireDate3.getTime(), eTitle.MS));

		// Provide details for Staff member 4 and add to the arraylist; increase the
		// total salaries field by the staff's salary
		Calendar DOB4 = Calendar.getInstance();
		Calendar HireDate4 = Calendar.getInstance();
		DOB4.set(1965, 10, 25);
		HireDate4.set(1990, 2,2);		
		staffList.add(new Staff("Kevin", "Peter", "Kleinhomer", DOB4.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"(302)-757-5877", "kevin@kleinhomer.com", "2:00 p.m. - 3:00 a.m. MWF", 8, 35000.00, HireDate4.getTime(),
				eTitle.MR));

		// Provide details for Staff member 5 and add to the arraylist; increase the
		// total salaries field by the staff's salary
		Calendar DOB5 = Calendar.getInstance();
		Calendar HireDate5 = Calendar.getInstance();
		DOB5.set(1967, 12, 28);
		HireDate5.set(2012, 3,18);
		staffList.add(new Staff("Michele", "Frances", "Kleinhomer", DOB5.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"(302)-562-3952", "kleinhom@udel.edu", "8:00 a.m. - 10:00 a.m. TR", 6, 45000.00, HireDate5.getTime(), eTitle.MRS));

		// Calculate the staff's average salary		
		for (Staff staff : staffList) {
			TotalSalaries += staff.getSalary();
		}
		AverageSalary = TotalSalaries / staffList.size();
		System.out.println("Average Salary is:  " + AverageSalary);
		
		// Check to see that we are getting the expected result
		assertEquals(45000.00, AverageSalary, 1);
	}

	// Test an invalid birthdate - one that is more than 100 years old
	@Test
	public void test2()  {
		try {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		// Provide details for Staff member with invalid birthdate
		Calendar DOB6 = Calendar.getInstance();
		Calendar HireDate6 = Calendar.getInstance();
		DOB6.set(1852, 8, 12);
		HireDate6.set(2015, 8,3);
		staffList.add(new Staff("Jim", "Alexander", "Kleinhomer", DOB6.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"(302)-740-2299", "jak@udel.edu", "8:00 a.m. - 10:00 a.m. MWF", 3, 50000.00, HireDate6.getTime(), eTitle.MR));
		}
		catch (PersonException ex) {
			System.out.println("The date of birth given is more than 100 years older than the current date.");
		}
		 
	}

	// Test an invalid phone # - one that doesn't match the required pattern
	@Test
	public void test3()  {
		try {
		ArrayList<Staff> staffList = new ArrayList<Staff>();
		// Provide details for Staff member with invalid phone #
		Calendar DOB7 = Calendar.getInstance();
		Calendar HireDate7 = Calendar.getInstance();
		DOB7.set(1952, 8, 12);
		HireDate7.set(2015, 8,3);
		staffList.add(new Staff("Jim", "Alexander", "Kleinhomer", DOB7.getTime(), "15 Forestal Circle, Newark, DE  19711",
				"302-740-2299", "jak@udel.edu", "8:00 a.m. - 10:00 a.m. MWF", 3, 50000.00, HireDate7.getTime(), eTitle.MR));
		}
		catch (PersonException ex) {
			System.out.println("The phone number provided is not in the correct (###)-###-#### format.");
		}
		 
	}

	
	
}
