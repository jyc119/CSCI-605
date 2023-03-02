/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.tests;

import hw5.simulation.Patron;
import hw5.simulation.QueueNode;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * A test class for QueueNode class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestQueueNode {

    /*** first testPatron */
    private static Patron testPatron1;

    /*** second testPatron */
    private static Patron testPatron2;

    /*** first testNode */
    private static QueueNode<Patron> testNode1;

    /*** second testNode */
    private static QueueNode<Patron> testNode2;

    /** Used to test that expected System.out print's happen */
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();

    @BeforeClass
    public static void init() {
        testPatron1 = new Patron("Kal", 9, true);
        testPatron2 = new Patron("Dan", 6, false);
        testNode1 = new QueueNode<>(testPatron1);
        testNode2 = new QueueNode<>(testPatron2);
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
                "Kal",
                testNode1.getKey().getName());
        assertEquals("testPatron1 coolness",
                9,
                testNode1.getKey().getCoolness());
        assertEquals("testPatron1 regularity",
                "Regular ",
                testNode1.getKey().getRegularity());
        assertEquals("testPatron1 linked node",
                    null,
                    testNode1.next);
        assertEquals("testPatron2 name",
                "Dan",
                testNode2.getKey().getName());
        assertEquals("testPatron2 coolness",
                6,
                testNode2.getKey().getCoolness());
        assertEquals("testPatron2 regularity",
                "",
                testNode2.getKey().getRegularity());
        assertEquals("testPatron2 linked node",
                null,
                testNode2.next);
    }

    @Test
    public void test2Link() {
        testNode1.next = testNode2;
        assertEquals("testNode1 linked node name",
                testNode2,
                    testNode1.next);
        assertEquals("testNode2 linked node name",
                null,
                testNode2.next);
    }
}
