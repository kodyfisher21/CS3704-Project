
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Tests for the Main class they simulate user input via System.in and capture
 * the console output via System.out.
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
        } finally {
            System.setIn(originalIn);
            System.setOut(originalOut);
        }
    }
}
