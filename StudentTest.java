import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class StudentTest {

    // -------- UNIT TESTS --------

    @Test
    public void testConstructorWithoutSchedule() {
        Student s = new Student("Alice");

        assertEquals("Alice", s.getName());
        assertNotNull(s.getSchedule());
        assertEquals(5, s.getSchedule().length);
        assertEquals(13, s.getSchedule()[0].length);
    }

    @Test
    public void testConstructorWithSchedule() {
        String[][] sched = new String[5][13];
        sched[0][0] = "Math";

        Student s = new Student("Bob", sched);

        assertEquals("Bob", s.getName());
        assertEquals("Math", s.getSchedule()[0][0]);
    }

    @Test
    public void testAddClassValidSingleBlock() {
        Student s = new Student("Charlie");

        s.addClass(2, 10, 1, "CS1114");

        assertEquals("CS1114", s.getSchedule()[2][10 - 8]);
    }

    @Test
    public void testAddClassValidMultiBlock() {
        Student s = new Student("Dana");

        s.addClass(1, 9, 3, "ENG2000");

        assertEquals("ENG2000", s.getSchedule()[1][1]); // 9am → index 1
        assertEquals("ENG2000", s.getSchedule()[1][2]);
        assertEquals("ENG2000", s.getSchedule()[1][3]);
    }

    @Test
    public void testAddClassInvalidDay() {
        Student s = new Student("Eve");

        s.addClass(6, 10, 1, "BIO1200"); // invalid day

        for (int d = 0; d < 5; d++) {
            for (int h = 0; h < 13; h++) {
                assertNull(s.getSchedule()[d][h]);
            }
        }
    }

    @Test
    public void testAddClassInvalidHour() {
        Student s = new Student("Frank");

        s.addClass(1, 20, 1, "HIST3000"); // 20 is invalid

        for (int h = 0; h < 13; h++) {
            assertNull(s.getSchedule()[1][h]);
        }
    }


    // -------- INTEGRATION TEST --------
    // Uses: constructor → addClass → getters

    @Test
    public void testFullScheduleIntegration() {
        Student s = new Student("Grace");

        s.addClass(0, 8, 2, "Math");
        s.addClass(0, 10, 1, "CS");
        s.addClass(4, 15, 2, "Physics");

        String[][] sched = s.getSchedule();

        assertEquals("Math", sched[0][0]);
        assertEquals("Math", sched[0][1]);
        assertEquals("CS", sched[0][2]);
        assertEquals("Physics", sched[4][7]);
        assertEquals("Physics", sched[4][8]);
    }
}
