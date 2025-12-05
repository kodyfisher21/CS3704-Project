/* 
defines the Student class fields, constructors, and methods
 
name = name of student as a String
schedule = 2D String array to store the Student's class schedule, first set is
[0-4] representing M-F, second set is [0-12] representing 8am to 7pm
 */
import java.util.ArrayList;

// friend functionality for code review

// gpa functionality for code review
/*
 deines the gpa field and its getter and setter. that way students can also track
 their academic performance
 */

// student bio functionality for code review
/*
    allows students to describe themselves in a bio such as study habits
    and personal goals
*/

public class Student {

    private String name;
    private String[][] schedule;
    private double gradePointAverage;
    private String bio;

    // constructor without a preset schedule, intializes the proper blank array
    public Student(String name) {
        this.name = name;
        this.schedule = new String[5][13];
        this.gradePointAverage = 0.0;
        this.bio = "";
    }

    // constructor with a preset schedule
    public Student(String name, String[][] schedule, double gradePointAverage, String bio) {
        this.name = name;
        this.schedule = schedule;
        this.gradePointAverage = gradePointAverage;
        this.bio = bio;
    }

    // getter for name
    public String getName() {
        return name;
    }

    // getter for schedule
    public String[][] getSchedule() {
        return schedule;
    }

    // getter for GPA
    public double getGradePointAverage() {
        return gradePointAverage;
    }

    // adds class to the schedule on the correct day and time, does not add if invalid
    public void addClass(int day, int hour, int howManyHourBlocks, String className) {
        if (day < 0 || day > 4 || hour < 8 || hour > 19 || howManyHourBlocks < 1 || howManyHourBlocks > 13) {
            return;
        }

        for (int i = 0; i < howManyHourBlocks; i++) {
            schedule[day][hour - 8 + i] = className;
        }
    }

    public void setGradePointAverage(double gpa) {
        gradePointAverage = gpa;
    }

    // getter for student bio
    public String getBio() {
        return bio;
    }

    // allows student to set bio
    public void setBio(String description) {
        bio = description;
    }
}
