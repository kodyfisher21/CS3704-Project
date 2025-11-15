Implementation Log

Kody Fisher
What was implemented:
Updated the main class to match the student class and it's class schedule parameters. Ask the user for input on their name, class taken, day taken, and time taken. Compare this with a random list of students and their random schedules in order to test if the user matches with one of them.

How it was implementated:
Used pair programming with Jay as we worked together to update the student class and main class to match parameters and structure. This allowed us to collaboratively figure out a base structure for our system and have a simple, but understandable design.

How it relates to overall system design:
This relates to our low level design of the behavioral design pattern family. This is because we had a chain of responsibility between group members and what they were to implement for the beginning of this design. I made updates to the implementation and base design in order for our main class and student class to work together.

Jay Foti
What was implemented:
I implemented the revised Student class that contains the student name and schedule. The schedule is in the form of a 2-D array, with one set representing the hours and the other representing the days. Because the schedule is being stored in Student, I deleted the other student schedule class because it was unneeded. 
How it was implementated:
I used pair programming with Kody to update both Student and main so the program was somewhat functional and made sense. We gave feedback to each other to improve our code.
How it relates to overall system design:
This relates to the overall system design because we are using a chain of responsiblity design amongst our group to determine who will implement what functionality/aspect of our program.

Yash Atal
What was implemented: Togethe with Nicolas we have implemented the basic function of out app that will take the users name, class informationa and the timing that they will take the class. Finally the code will go through the timing and will match the students with each other.
How it was implementated:

We built the basic system using three Java classes: Student, ClassSchedule, and Main. The program takes the user’s name, course, and preferred time using a Scanner, creates a list of random students, and then compares each student based on matching course and time. Any students who match are printed as potential study partners.

How it relates to overall system design:

This implementation forms the core of our study-group matching feature. It shows how user data is collected, stored, and matched, which directly supports the main requirements of our system. It also provides the foundation for future features like group chat, scheduling tools, and a full user interface.

Nicolas Goossens
What was implemented:
Together with Yash we created the bare bones of the project and kicked off the development process. We started with defining a student class consisting of basic student attributes like student name and student availibility. We decided initially we would randomly assign students a class and time prefernce and then afterwards pair students with likewise schedules.
How it was implementated:
Together, Yash and I worked on one laptop to create the skeleton of the project. We bounced ideas off eachother to make a MVP. Initially we planned to create a simple algorithm matcher and basic student and course classes. 
How it relates to overall system design: 
All four of us wanted to initially begin the coding portion of this project however quickly we realised that it would be much easier if we had a strong foundation where we could all work from. Therefore Yash and I implemented the basics allowing for Kody and Jay to easily build on our work. This was a crucial step to our system design and allowed us to make progress without overwriting eachothers work