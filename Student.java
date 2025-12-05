import java.util.*;

// friend functionality for code review

/* 
defines the Student class fields, constructors, and methods
 
name = name of student as a String
schedule = 2D String array to store the Student's class schedule, first set is
[0-4] representing M-F, second set is [0-12] representing 8am to 7pm
*/

public class Student {
    private String name;
    private String[][] schedule;
    private ArrayList<String> friends;

    // constructor without a preset schedule, intializes the proper blank array
    public Student(String name) {
        this.name = name;
        this.schedule = new String[5][13];
        this.friends = new ArrayList<String>();
    }   

    // constructor with a preset schedule
    public Student(String name, String[][] schedule, ArrayList<String> friends) {
        this.name = name;
        this.schedule = schedule;
        this.friends = friends;
    }   

    // getter for name
    public String getName() {
        return name;
    }

    // getter for schedule
    public String[][] getSchedule() {
        return schedule;
    }

    public ArrayList<String> getFriends()
    {
        return friends;
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

    public void addFriend(String name)
    {
        friends.add(name);
    }

    public void removeFriend(String name)
    {
        friends.remove(name);
    }
}
