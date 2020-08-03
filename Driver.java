
/** Driver Class
 * Program: Simulate 60 minutes of activity at the store. Each iteration of the program represents one minute.
 *   At each iteration (minute), the program will do the following:
 *   Check to see if new customers are added to the priority queue.
 *   There is a 25% chance that new customers show up (need to be added to the queue) every minute.
 *   Each iteration will have its own 25% chance.
 *   Update the customer object currently being serviced (if one exists). This will be the customer object at the front of the queue.
 *   If the customer has been completely serviced, remove them from the queue.
 * @author: Ivy P.
 * @version: July 20, 2020
 */
import java.util.Random;

public class Driver {

    public static void main(String[] args) {
        final int simulateTime = 60; // Set the simulation time for the program
        int time = 0; // count each minute of simulate time
        int serviceTime = 0; // time (in minute) to serve each customer
        int chance = 0; // find the chance when a customer shows up and join the line.

        PriorityQueue line = new PriorityQueue(); //Create a new linked list queue
        int maxLength = 0; // count max # of customers waiting in line at any given point
        int customersServed = 1; // count number customers have been served and remove from the line

        System.out.println(); // add a blank line

        //simulate 60 minutes of activities at the store. Each iteration of your program represents 1 minute
        int size = 0;
        for (time = 0; time < simulateTime; time++ ) {
            chance = new Random().nextInt(100) + 1;   // Randomly assign a chance when a new customer will show up


            //There is a 25% chance that new customers show up (need to be added to the queue) every minute
            if (chance < 26) {
                line.add(new PriorityCustomer()); // add a new customer to the queue
                System.out.println("      New customer added to the line. We have " + line.getSize() + " customer(s) in the line");
            }
            // get max # of customers waiting in line during the simulation
            size = line.getSize(); // get current size of the queue
            if (size > maxLength) { // check and update max number of customers in the queue
                maxLength = size;
            }
            /// check if there is a customer waiting in line. If yes, get service time needed to serve this customer.
            if (!line.isEmpty()) {
                serviceTime = line.getFrontCustomer().getServiceTime();
                System.out.println("      Time left to finish serving customer #" + customersServed + " is :  " + serviceTime + " min");
                if (serviceTime == 0) { // after service time is up, dequeue the customer from the line
                    line.remove();
                    System.out.print("      ---> Customer #" + customersServed + " is served & left. ");
                    System.out.println("The line now has " + line.getSize() + " customer(s).");
                    customersServed++; // update count of customers serviced
                } else {
                    line.getFrontCustomer().decServiceTime();
                }
            }
            // out put a line to identify when a minute passed.
            System.out.println("  " + (time + 1)  + " -------------------------------------------------------");
        }
        /// print simulation report to the console
        System.out.println("\n  ------------------------ Simulation time is up ------------------------------");
        System.out.println("\n  *************************** SIMULATION REPORT *******************************");
        System.out.println("  | Total number of customers have been serviced during the period is " + (customersServed - 1) +   ".     |");
        System.out.println("  | Maximum line length during the simulation is " + maxLength + " customers.                 |");
        System.out.println("  *****************************************************************************");

    }// end of main method

}// end of class
