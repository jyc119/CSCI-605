/*
 * HW9: Secret Lives of Bees
 * Jordan Chin, jc9627@rit.edu
 * Charlie Leyens, cal3368@rit.edu
 */

package world;

import bee.Worker;


/**
 * The field of flowers that are ripe for the worker bees to gather the nectar
 * and pollen resources. The bees can arrive in any order and they are
 * immediately allowed to start gathering, as long as there is a free flower.
 * Otherwise the bee must wait until a flower becomes free.
 *
 * @author Jordan Chin, jc9627@rit.edu
 * @author Charlie Leyens, cal3368@rit.edu
 */
public class FlowerField {

    /** the maximum number of workers allowed in the field at the same time */
    public static final int MAX_WORKERS = 10;
    private int num_workers;
//    private int workers_flowers;

    /**
     * Create the flower field. Initially there are no worker bees in the field.
     */
    public FlowerField(){
        this.num_workers = 0;
//        this.workers_flowers = 0;
    }

    /**
     * When a worker bee requests entry in to the field, you should first
     * display a message:
     *
     * *FF* {bee} enters field
     *
     * There is only one condition that would cause a bee to have to wait -
     * if there are no flowers because all the other bees are gathering from
     * them. In this case they have to wait until a bee exits the field to see
     * if they can go next. There is no control over the order the bees will
     * follow.
     *
     * @param worker the worker bee entering the field
     */
    public void enterField(Worker worker) {
        synchronized (worker) {
            if (num_workers < MAX_WORKERS) {
                System.out.println("*FF* " + worker + " enters field");
                this.num_workers += 1;
            } else {
                try {
                    worker.wait();
                } catch (InterruptedException e) {
                }
            }
        }
    }

    /**
     * When a worker bee is done gathering from a flower, it uses this routine
     * to indicate they are leaving, and to notify a single bees that may be
     * waiting that they should wake up and check that there is indeed a free
     * flower now. At the end of this routine you should print the message:
     *
     * *FF* {bee} leaves field
     *
     * @param worker the worker bee leaving the field
     */
    public void exitField(Worker worker) {
        synchronized (worker){
            this.num_workers -= 1;
//            this.workers_flowers -= 1;
            System.out.println("*FF* " + worker + " leaves field");
            worker.notify();
        }
    }
}
