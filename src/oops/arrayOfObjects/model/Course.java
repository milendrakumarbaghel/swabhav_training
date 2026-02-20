package oops.arrayOfObjects.model;

import java.util.UUID;

public class Course {
    protected final String courseId;
    protected String courseName;
    protected double baseFee;

    public static int totalCourses = 0;

    public Course(String courseName, double baseFee) {
        this.courseId = UUID.randomUUID().toString();

        if(courseName.isBlank()) {
            System.out.println("Enter valid course name");
            return;
        }
        this.courseName = courseName;

        if(baseFee<=0) {
            System.out.println("Enter valid base fee (greater than zero)");
            return;
        }
        this.baseFee = baseFee;
        totalCourses++;
    }

    public Course() {
        this.courseId = UUID.randomUUID().toString();
    }

    public double calculateFee()  {
        return baseFee;
    }

    public void displayCourse() {
        System.out.println("Course Id is: " +  courseId);
        System.out.println("Course Name is: " + courseName);
    }
}
