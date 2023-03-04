/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.tests;

import hw5.simulation.Patron;
import org.junit.*;


import static org.junit.Assert.assertEquals;

/**
 * A test class for Patron class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestPatron {

    /** first testPatron */
    private static Patron testPatron1;

    /** second testPatron */
    private static Patron testPatron2;

    /** third testPatron */
    private static Patron testPatron3;

    @BeforeClass
    public static void init() {
        testPatron1 = new Patron("John Doe", 4,
                true);
        testPatron2 = new Patron("Jane Doe", 8,
                false);
        testPatron3 = new Patron("Jupiter", 8, true);
    }

    @Test
    public void test1Init() {
        assertEquals("testPatron1 name",
                "John Doe",
                testPatron1.getName());
        assertEquals("testPatron2 name",
                "Jane Doe",
                testPatron2.getName());
        assertEquals("testPatron3 name",
                "Jupiter",
                testPatron3.getName());
        assertEquals("testPatron1 coolness",
                4,
                testPatron1.getCoolness());
        assertEquals("testPatron2 coolness",
                8,
                testPatron2.getCoolness());
        assertEquals("testPatron3 coolness",
                8,
                testPatron3.getCoolness());
        assertEquals("testPatron1 regularity", "Regular ",
                testPatron1.getRegularity());
        assertEquals("testPatron2 regularity", "",
                testPatron2.getRegularity());
        assertEquals("testPatron3 regularity", "Regular ",
                testPatron3.getRegularity());
    }

    @Test
    public void test2Compare() {
        assertEquals("testPatron1 compared to testPatron2",
                -1, testPatron1.compareTo(testPatron2));
        assertEquals("testPatron3 compared to testPatron2",
                1, testPatron3.compareTo(testPatron2));
        assertEquals("testPatron2 compared to testPatron1",
                1, testPatron2.compareTo(testPatron1));
        assertEquals("testPatron2 compared to testPatron3",
                -1, testPatron2.compareTo(testPatron3));
    }

}
