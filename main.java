import java.util.Scanner;
import java.util.Random;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        String[] courses = {"CS101", "CS102", "CS103", "CS104", "CS105"};
        Student[] students = new Student[20]; // array of students for match testing

        // user input for student
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        System.out.println("Enter your course: CS101, CS102, CS103, CS104, CS105");
        String course = scanner.nextLine();
        System.out.println("Enter your preferred time -> 8-19 for 8am-7pm:");
        int time = scanner.nextInt();
        System.out.println("Enter the day -> 0 = Monday, 1 = Tuesday, 2 = Wednesday, 3 = Thursday, 4 = Friday:");
        int day = scanner.nextInt();

        // create student
        Student you = new Student(name);
        you.addClass(day, time, 1, course);

        // get random students for comparing puropses
        for(int i = 0; i < students.length; i++){
            String randomName = "Student" + (i + 1); 
            String randomCourse = courses[rand.nextInt(courses.length)]; // random cs course
            int randomDay = rand.nextInt(5); // 0-4 
            int randomTime = rand.nextInt(12) + 8; // 8-19
            students[i] = new Student(randomName);
            students[i].addClass(randomDay, randomTime, 1, randomCourse);
        }

        boolean foundMatch = false; // check if schedules match based on day and time
        for (Student s : students){
            if(s.getSchedule()[day][time - 8].equals(course)){
                System.out.println("Succesfully matched with: " + s.getName());
                foundMatch = true;
            }
        }

        if(!foundMatch){
            System.out.println("No match was found.");
        }
        scanner.close();
    }
}