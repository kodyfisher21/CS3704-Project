
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Test;

/**
 * Tests for the Main class they simulate user input via System.in and capture
 * the console output via System.out.
 *
 * ------ AI USAGE NOTES ------ AI PROMPT: Please write integration tests for
 * the Main class that simulate user input via System.in and capture the console
 * output via System.out. The tests should verify that the Main class behaves as
 * expected when given specific inputs.
 *
 * Prompt:java -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar"
 * org.junit.runner.JUnitCore MainTest Picked up JAVA_TOOL_OPTIONS:
 * -Dstdout.encoding=UTF-8 -Dstderr.encoding=UTF-8 JUnit version 4.13.2 .E.E
 * Time: 0.024 There were 2 failures:

 *  *testMainRunsWithValidInput(MainTest) java.lang.NullPointerException: Cannot
 * invoke "String.equals(Object)" because "Student.getSchedule()[<local8>][...]"
 * is null at Main.main(Main.java:40) at
 * MainTest.testMainRunsWithValidInput(MainTest.java:49)
 * testMainRunsWithDifferentInput(MainTest) java.lang.NullPointerException:
 * Cannot invoke "String.equals(Object)" because
 * "Student.getSchedule()[<local8>][...]" is null at Main.main(Main.java:40) at
 * MainTest.testMainRunsWithDifferentInput(MainTest.java:83) FAILURES!!! Tests
 * run: 2, Failures: 2

 *  *Response: The tests are failing because of a NullPointerException at line 40
 * in Main.java. Let me check the Student class to understand the issue:

 *  *Read Student.java

 *  *I found the problem! In Main.java line 40, the code tries to call .equals()
 * on a potentially null value in the schedule array. When the schedule slot is
 * empty (no class scheduled), it's null, not an empty string.

 *  *Here's the fix:

 *  *Read Main.java, lines 35 to 52

 *  *main.java+1-1 Fixed! I changed s.getSchedule()[day][time - 8].equals(course)
 * to course.equals(s.getSchedule()[day][time - 8]). This way, if the schedule
 * slot is null, it won't throw a NullPointerException - it will just return
 * false.

 *  *Now recompile and run the tests:
 *

 *  *javac -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar" Student.java Main.java
 * MainTest.java Enable shell integration to improve command detection
 *

 *  *java -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar"
 * org.junit.runner.JUnitCore MainTest Enable shell integration to improve
 * command detection

 *  *✅ All tests are now passing! The issue was that when checking if schedules
 * match, the code was calling .equals() on a potentially null schedule slot. By
 * reversing it to course.equals(scheduleSlot), null values are handled safely.
 *
 * Used AI to identify areas where the tests are failing and to siggest fixes.
 *
 * Also used AI to troubleshoot the tests when they were not working initially
 * with JUNIT.
 */
public class MainTest {

    // -------- INTEGRATION TESTS --------
    @Test
    public void testMainRunsWithValidInput() {
        // Simulated input lines as if typed in the command line
        // count to match thje prompts:
        // name, course, time, day, etc.
        String simulatedInput
                = "Alice\n"
                + // name
                "CS101\n"
                + // course
                "9\n"
                + // time 
                "0\n";// day 

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        // Save originals
        java.io.InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(ps);

            // Call the program under test
            Main.main(new String[0]);

            String output = out.toString();

            //program should print *something*
            assertNotNull(output);
            assertFalse(output.isEmpty());
        } finally {
            // Restore originals so other tests are not affected
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }

    @Test
    public void testMainRunsWithDifferentInput() {
        String simulatedInput
                = "Bob\n"
                + "CS105\n"
                + "14\n"
                + // 2pm
                "4\n";     // Friday

        ByteArrayInputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(out);

        java.io.InputStream originalIn = System.in;
        PrintStream originalOut = System.out;

        try {
            System.setIn(in);
            System.setOut(ps);

            Main.main(new String[0]);

            String output = out.toString();

            // Check that some output was produced
            assertNotNull(output);
            assertFalse(output.isEmpty());
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
