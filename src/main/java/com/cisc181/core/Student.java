package com.cisc181.core;

import com.cisc181.eNums.*;
import java.util.Date;
import java.util.UUID;

import com.cisc181.eNums.eMajor;

public class Student extends Person {

	private eMajor Major;
	private UUID StudentID;
	private double GPA;

	public Student(String FirstName, String MiddleName, String LastName,Date DOB, eMajor Major,
			String Address, String Phone_number, String Email) throws PersonException
	{
		super(FirstName, MiddleName, LastName, DOB, Address, Phone_number, Email);
		this.StudentID = UUID.randomUUID();
		this.Major = Major;		
	}

	
	public eMajor getMajor ( )
    {
        return this.Major;
    }
    public void setMajor (eMajor Major)
    {
        this.Major = Major;    
    }
    
    public UUID getStudentID(){
    	return this.StudentID;
    }
    
	
	@Override
	public void PrintName() {
		System.out.println(getLastName() + ","  + getFirstName() + ' ' + getMiddleName());
	}

	public void PrintName(boolean bnormal)
	{
		super.PrintName();
	}


	public double getGPA() {
		return GPA;
	}


	public void setGPA(double gPA) {
		GPA = gPA;
	}
}