package com.cisc181.core;
import java.util.UUID;

import com.cisc181.eNums.eMajor;


public class Course {
	
	private UUID CourseID;
	private String CourseName;
	private int GradePoints;
	private eMajor Major;
	private double AverageGrade;

	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getGradePoints() {
		return GradePoints;
	}
	public void setGradePoints(int gradePoints) {
		GradePoints = gradePoints;
	}
	public eMajor getMajor() {
		return Major;
	}
	public void setMajor(eMajor major) {
		Major = major;
	}
	public double getAverageGrade() {
		return AverageGrade;
	}
	public void setAverageGrade(double averageGrade) {
		AverageGrade = averageGrade;
	}
	
	
}
