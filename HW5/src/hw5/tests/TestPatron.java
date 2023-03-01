package hw5.tests;

import hw5.simulation.HeapQueue;
import hw5.simulation.Patron;
import hw5.simulation.PriorityQueue;
import org.junit.*;
import org.junit.runners.MethodSorters;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * A test class for Patron class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestPatron {

    private static Patron testPatron1;

    private static Patron testPatron2;

    private static Patron testPatron3;

    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();

    @BeforeClass
    public static void init() {
        testPatron1 = new Patron("John Doe", 4,
                true);
        testPatron2 = new Patron("Jane Doe", 8,
                false);
        testPatron3 = new Patron("Charlie", 8, true);
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void test1Init() {
        assertEquals("testPatron1 name",
                "John Doe",
                testPatron1.getName());
        assertEquals("testPatron2 name",
                "Jane Doe",
                testPatron2.getName());
        assertEquals("testPatron1 coolness",
                4,
                testPatron1.getCoolness());
        assertEquals("testPatron2 coolness",
                8,
                testPatron2.getCoolness());
        assertEquals("testPatron3 name",
                "Charlie",
                testPatron3.getName());
        assertEquals("testPatron3 coolness",
                8,
                testPatron3.getCoolness());
    }

    @Test
    public void test2Compare() {
        assertEquals("testPatron1 compared to testPatron2",
                -1, testPatron1.compareTo(testPatron2));
        assertEquals("testPatron3 compared to testPatron2",
                1, testPatron3.compareTo(testPatron2));
    }

}
