/* 
 * defines the Student class fields, constructors, and methods
 * 
 * name = name of student as a String
 * schedule = 2D String array to store the Student's class schedule, first set is
 * [0-4] representing M-F, second set is [0-12] representing 8am to 7pm
 * 
*/

public class Student {
    private String name;
    private String[][] schedule;

    // constructor without a preset schedule, intializes the proper blank array
    public Student(String name) {
        this.name = name;
        this.schedule = new String[5][13];
    }   

    // constructor with a preset schedule
    public Student(String name, String[][] schedule) {
        this.name = name;
        this.schedule = schedule;
    }   

    // getter for name
    public String getName() {
        return name;
    }

    // getter for schedule
    public String[][] getSchedule() {
        return schedule;
    }

    // adds class to the schedule on the correct day and time, does not add if invalid
    public void addClass(int day, int hour, int howManyHourBlocks, String className) {
        if(day < 0 || day > 4 || hour < 8 || hour > 19 || howManyHourBlocks < 1 || howManyHourBlocks > 13) {
            return;
        }

        for(int i = 0; i < howManyHourBlocks; i++) {
            schedule[day][hour - 8 + i] = className;
        }
    }


}
