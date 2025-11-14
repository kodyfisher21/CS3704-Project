public class main {
      public static void main(String[] args) {
        //create an array of students with random times and courses ()
        //String[] students = new array of student[20];

        Scanner scanner  =  new Scanner(System.in);

        String[] courses = {"CS101", "CS102", "CS103", "CS104", "CS105"};
        String[] times = {"Morning", "Afternoon", "Evening"};

        //id only make 4 or 5 courses and only a handful of times. maybe morning, afternoon, and evening 

       
          System.out.println("Enter your name:");
          String name = scanner.nextLine();
         
         System.out.println("Enter your course from the following options: CS101, CS102, CS103, CS104, CS105");
         String course = scanner.nectLine();

         System.out.println("Enter your preferred time: Morning", "Afternoon", "Evening");
         String time = scanner.nextLine();


         student you = new student(name, course, time);
         Randaon ram = new Random();


         for(int i =0; i < student.length; i++){

          String randName = "Student"+(i+1);
          String randCourse = courses[ram.nextInt(courses.length)];
          String randTime = times[ram.nextInt(times.length)];

         }

         System.out.println("--Match Time--");
         System.out.println("Looking for students in " + course+ " during" + time+"...\n");

         boolean foundMatch = false;

         for (Students s : students){
          if(s.course.equals(course) && s.time.equals(time) && !s.name.equals(you.name)){
            System.out.println("Matched with: " + s);
            foundMatch = true;
          }
         }

         if(!foundMatch){
            System.out.println("No match was found.");
          }

          scanner.close();
         



        // ask the classes that they are taking for the list

        // ask the time that they will take the class or the time they preffer

        //then loop through the students and randomly match students with same course and time

        //then print the pairs of students

        //
      }

}
