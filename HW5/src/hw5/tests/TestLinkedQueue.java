/*
 * HW5: Studio 54 Queue Simulation
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package hw5.tests;

import hw5.simulation.LinkedQueue;
import hw5.simulation.Patron;
import hw5.simulation.QueueNode;
import org.junit.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

/**
 * A test class for LinkedQueue class.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class TestLinkedQueue {

    /*** linked queue used for testing */
    public static LinkedQueue<Patron> testLinkedQueue;

    /*** first testPatron */
    public static Patron testPatron1;

    /*** second testPatron */
    public static Patron testPatron2;

    /*** third testPatron */
    public static Patron testPatron3;

    /** Used to test that expected System.out print's happen */
    private final ByteArrayOutputStream outContent =
            new ByteArrayOutputStream();

    @BeforeClass
    public static void init() {
        testLinkedQueue = new LinkedQueue<>();
        testPatron1 = new Patron("Kal", 9, true);
        testPatron2 = new Patron("Dan", 6, false);
        testPatron3 = new Patron("Joe", 8, true);
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
        assertEquals("Queue front",
                null,
                testLinkedQueue.getFront());
        assertEquals("Queue back",
                null,
                testLinkedQueue.getBack());
    }

    @Test
    public void test2EnqueueDequeue(){
        testLinkedQueue.enqueue(testPatron1);
        testLinkedQueue.enqueue(testPatron2);
        testLinkedQueue.enqueue(testPatron3);
        assertEquals("Queue ",
                    testPatron1,
                    testLinkedQueue.dequeue());
        assertEquals("Queue ",
                testPatron3,
                testLinkedQueue.dequeue());
        assertEquals("Queue ",
                testPatron2,
                testLinkedQueue.dequeue());
    }

}
