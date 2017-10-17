package com.cisc181.core;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.UUID;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cisc181.eNums.eMajor;
import com.cisc181.eNums.eTitle;

public class Student_Test {
	static ArrayList<Course> CourseList = new ArrayList<Course>();
	static ArrayList<Semester> SemesterList = new ArrayList<Semester>();
	static ArrayList<Student> StudentList = new ArrayList<Student>();
	static ArrayList<Section> SectionList = new ArrayList<Section>();
	static ArrayList<Enrollment> EnrollmentList = new ArrayList<Enrollment>();

	@BeforeClass
	public static void setup() throws PersonException {

		/*
		 * Create three courses.
		 * I assumed that you did not want a constructor that took arguments. I set the
		 * attributes with the public methods.  I also assumed that GradePoints are the # of credit hours.
		 */
		Course Course1 = new Course();
		Course1.setCourseID(UUID.randomUUID());
		Course1.setCourseName("Chemistry 101");
		Course1.setGradePoints(4);
		Course1.setMajor(eMajor.CHEM);
		CourseList.add(Course1);

		Course Course2 = new Course();
		Course2.setCourseID(UUID.randomUUID());
		Course2.setCourseName("Biology 201");
		Course2.setGradePoints(4);
		Course2.setMajor(eMajor.NURSING);
		CourseList.add(Course2);

		Course Course3 = new Course();
		Course3.setCourseID(UUID.randomUUID());
		Course3.setCourseName("Business 101");
		Course3.setGradePoints(4);
		Course3.setMajor(eMajor.BUSINESS);
		CourseList.add(Course3);

		// Create the two semesters
		// Assumed you only wanted a no parameter constructor for Semester
		Calendar StartDate1 = Calendar.getInstance();
		Calendar EndDate1 = Calendar.getInstance();
		StartDate1.set(2017, 8, 27);
		EndDate1.set(2017, 12, 12);
		Semester Semester1 = new Semester();
		Semester1.setSemesterID(UUID.randomUUID());
		Semester1.setStartDate(StartDate1.getTime());
		Semester1.setEndDate(EndDate1.getTime());
		SemesterList.add(Semester1);

		Calendar StartDate2 = Calendar.getInstance();
		Calendar EndDate2 = Calendar.getInstance();
		StartDate2.set(2018, 2, 15);
		EndDate2.set(2018, 5, 25);
		Semester Semester2 = new Semester();
		Semester2.setSemesterID(UUID.randomUUID());
		Semester2.setStartDate(StartDate2.getTime());
		Semester2.setEndDate(EndDate2.getTime());
		SemesterList.add(Semester2);

		// Create the course sections
		// Assumed you only wanted a no parameter constructor for Sections
		int room = 200;
		int SectionIndex = 0;
		for (Semester semester : SemesterList) {
			for (Course course : CourseList) {
				SectionList.add(new Section());
				SectionList.get(SectionIndex).setCourseID(course.getCourseID());
				SectionList.get(SectionIndex).setRoomID(room);
				SectionList.get(SectionIndex).setSectionID(UUID.randomUUID());
				SectionList.get(SectionIndex).setSemesterID(semester.getSemesterID());
				room++;
				SectionIndex++;

			}
		}

		// Create 10 students		
		Calendar DOB1 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Jay", "Peter", "Reilly", DOB1.getTime(), eMajor.BUSINESS,
				"17 Maple Drive, Newark, DE  19711", "(302)-757-5899", "jreilly.gmail.com"));

		Calendar DOB2 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Jack", "Peter", "Smoke", DOB2.getTime(), eMajor.COMPSI,
				"3 Madison Drive, Newark, DE  19711", "(302)-757-5888", "jsmoke.gmail.com"));

		Calendar DOB3 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Claire", "Mariar", "Dickens", DOB3.getTime(), eMajor.NURSING,
				"4 1st Street, Newark, DE  19711", "(302)-757-5877", "cdickens.gmail.com"));

		Calendar DOB4 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Mary", "Ann", "Cooper", DOB4.getTime(), eMajor.PHYSICS,
				"502 Maple Lane, Claymont, DE  19703", "(302)-757-5866", "mcooper.gmail.com"));

		Calendar DOB5 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Beth", "Ann", "Kochie", DOB5.getTime(), eMajor.BUSINESS,
				"217 Tremont Circle, Newark, DE  19711", "(302)-757-5855", "bkochie.gmail.com"));

		Calendar DOB6 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Robert", "Peter", "Glass", DOB6.getTime(), eMajor.CHEM,
				"321 Somerset Lane, Newark, DE  19711", "(302)-757-5844", "rglass.gmail.com"));

		Calendar DOB7 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Mike", "John", "Jackson", DOB7.getTime(), eMajor.COMPSI,
				"5 Brennan Drive, Newark, DE  19711", "(302)-757-5833", "mjackson.gmail.com"));

		Calendar DOB8 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Maria", "Louisa", "Rodriguez", DOB8.getTime(), eMajor.NURSING,
				"415 Washington Avenue, Newark, DE  19711", "(302)-757-5822", "mrodriguez.gmail.com"));

		Calendar DOB9 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Jay", "Peter", "Smith", DOB9.getTime(), eMajor.BUSINESS,
				"32 Delaware Avenue, Newark, DE  19711", "(302)-757-5877", "jsmith.gmail.com"));

		Calendar DOB10 = Calendar.getInstance();
		DOB1.set(1965, 10, 25);
		StudentList.add(new Student("Kira", "Marie", "Dolbow", DOB10.getTime(), eMajor.BUSINESS,
				"34 Delaware Street, Newark, DE  19711", "(302)-757-5877", "kdolbow.gmail.com"));

	}

	@Test
	public void test() {

		// Enroll students in the sections
		for (Student student : StudentList) {
			for (Section section : SectionList) {
				EnrollmentList.add(new Enrollment(student.getStudentID(), section.getSectionID()));
			}
		}

		// Assign grades for each student in each of the courses they took
		double grade = 40.0;
		for (Enrollment enrollment : EnrollmentList) {
			enrollment.SetGrade(grade++);
		}

		// Calculate the students' gpa's.  Set the students' gpa
		for (Student student : StudentList) {
			System.out.println("\nStudent is  " + student.getFirstName() + " " + student.getLastName());
			System.out.println("Grades:  ");
			int GradePoints = 0;
			double CreditHoursAttempted = 0;
			double GPA = 0;
			for (Enrollment enrollment : EnrollmentList) {
				if (enrollment.getStudentID() == student.getStudentID()) {
					for (Section section : SectionList) {
						if (enrollment.getSectionID() == section.getSectionID()) {
							for (Course course : CourseList) {
								if (section.getCourseID() == course.getCourseID()) {
									CreditHoursAttempted = CreditHoursAttempted + course.getGradePoints();
									System.out.println(course.getCourseName() + ":  " + enrollment.getGrade());
									if (enrollment.getGrade() >= 93) {
										GradePoints = GradePoints + (4 * course.getGradePoints());
									} else if (enrollment.getGrade() >= 80)
										GradePoints = GradePoints + (3 * course.getGradePoints());
									else if (enrollment.getGrade() >= 70)
										GradePoints = GradePoints + (2 * course.getGradePoints());
									else if (enrollment.getGrade() >= 60)
										GradePoints = GradePoints + (1 * course.getGradePoints());
									else
										GradePoints = GradePoints += 0;
								}
							}
						}
					}
				}

			}
			student.setGPA(GradePoints/CreditHoursAttempted);
			System.out.println("Total grade points achieved = " + GradePoints);
			System.out.println("Total credit hour attempted = " + CreditHoursAttempted);
			System.out.println("GPA = " + GradePoints / CreditHoursAttempted);
		}

		// Check to make sure we are receiving the expected results
		assertEquals(0, StudentList.get(0).getGPA(),1);
		assertEquals(0, StudentList.get(1).getGPA(),1);
		assertEquals(0, StudentList.get(2).getGPA(),1);
		assertEquals(0.6, StudentList.get(3).getGPA(),1);
		assertEquals(1, StudentList.get(4).getGPA(),1);
		assertEquals(2, StudentList.get(5).getGPA(),1);
		assertEquals(2.3, StudentList.get(6).getGPA(),1);
		assertEquals(3, StudentList.get(7).getGPA(),1);
		assertEquals(3.6, StudentList.get(8).getGPA(),1);		
		assertEquals(4, StudentList.get(9).getGPA(),1);
		
		// Determine each course's average grade.  Set the Course's average grade.
		
		System.out.println("*********************************");
		for (Course course:CourseList) {
			System.out.println("\nCourse Name: "+course.getCourseName());
			System.out.println("Grades");

			double TotalOfCourseGrades = 0;
			int NumberOfStudents = 0;
			for (Section section:SectionList) {
				
				if (course.getCourseID()==section.getCourseID()) {
					for (Enrollment enrollment:EnrollmentList) {
						if (enrollment.getSectionID()==section.getSectionID()) {
						System.out.println(enrollment.getGrade());
						TotalOfCourseGrades += enrollment.getGrade();
						NumberOfStudents++;
						}
					}
				}
			}
			course.setAverageGrade(TotalOfCourseGrades/NumberOfStudents);
			System.out.println("Average grade: "+course.getAverageGrade());
		}
		
		// Check to make sure we are receiving the expected results
		assertEquals(68.5,CourseList.get(0).getAverageGrade(),1);
		assertEquals(69.5,CourseList.get(1).getAverageGrade(),1);
		assertEquals(70.5,CourseList.get(2).getAverageGrade(),1);
	}
}