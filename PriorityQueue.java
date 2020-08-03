/** Program: Priority Queue class that will represent the data structure for holding the Customer objects.
 *  In this class, it will create a heap that will act as the priority queue.
 *  This class also includes methods to get size, get the customer object in front of the line, add or remove object(s) from the line
 * @author: Ivy Pham
 * @version: 07/20/2020
 */

public class PriorityQueue {

  private PriorityCustomer[] heap; // variable for a Priority Customer Array
  private int size;                // variable for the size of the line

    /** Constructor with default Array size = 40 elements
     *  Set default current size of the line = 0
     */
  public PriorityQueue() {
      heap = new PriorityCustomer[40];
      size = 0;
  }// end of method
    /**
     Constructor to create a Priority Customer Array with the size base on the passed in parameter
     Set default current size of the line = 0
     */
  public PriorityQueue(int s) {
      heap = new PriorityCustomer[s];
      size = 0;
  }// end of method
  /**
    getSize(): This method to get the current size of the Array
    @param: none
    @return: size
   */
  public int getSize() {
      return size;
  }// end of method
  /**
    isEmpty(): This method to check if the line is empty
    @param: none
    @return: True if the line has no object.
   */
  public boolean isEmpty(){
      return size == 0;
  }// end of method

    /** getFrontCustomer(): This method will get the object reference of the customer in index # 1
     * @return Customer object at index 1
     */
  public PriorityCustomer getFrontCustomer() {
      return heap[1];
  }// end of method
  /**
    add(c): This method will check and add new customer to the array line
          Increase the size of the line
          Check with the parent index and swap the index location if the child's priority > parent's priority,
          except if the parent is at the front of the line then we stop swapping.
   @param: customer object
   @return: none
   */
  public void add(PriorityCustomer c) {
      //Make sure the heap isn't full
      if (size + 2 > heap.length) {
          System.out.println ("The heap is full");
          return;
      }
      size ++;  //increase the size
      heap[size] = c;  //add new object to the next open position in the heap
      int index = size;  //create a variable to keep track of where our object is in the heap

      //continuing to compare the object to it's parents until it reaches the root
      while (index > 1) {
          int parentIndex = index / 2;  //grab parent's index
          //compare object to its parent and swap it if needed. If a new customer is added to the line with a higher priority than the front customer,
          // the new customer should not be put in front of the customer being serviced, only those that are also waiting in line
          if (heap[index].getPriority() > heap[parentIndex].getPriority() && parentIndex != 1) {
              //swapping objects
              PriorityCustomer temporary = heap[index];
              heap[index] = heap[parentIndex];
              heap[parentIndex] = temporary;
              //update index to parent's index after swap
              index = parentIndex;
          } else {
              //parent value is larger -> no swap needed. Stop swapping.
              break;
          }
      } // end of while loop
  } // end of add() method

    /** remove(): This method will check if there is a customer waiting at the front.
     *            If there is customer, remove it from the line
     *            Check and move the child object(s) up the heap until the heap is balance.
     * @param: none
     * @return temporary: The customer object that was removed.
     */
  public PriorityCustomer remove() {
      //make sure the heap isn't empty
        if (isEmpty()) {
            System.out.println("The heap is already empty");
            return null;
        }
        //store temporary reference to root object, so we can we return it at the end
        PriorityCustomer temporary = heap[1];      //move object in the last position to the root
        heap[1] = heap[size];
        heap[size] = null;
        size--;
        //store the index of the object we moved to the root
        int index = 1;
        //continue to compare index to its children as long as there are children
        while (index <= size / 2) {
            //store index and values of children
            int leftChildIndex = index * 2;
            int rightChildIndex = leftChildIndex + 1;
            int leftChildValue = heap [leftChildIndex].getPriority();
            int rightChildValue = Integer.MIN_VALUE;
            //is there a right child
            if (rightChildIndex <= size) {
                rightChildValue = heap [rightChildIndex].getPriority();
            }
            //determine the larger of the two children
            int largerValue;
            int largerIndex;
            if (rightChildValue > leftChildValue) {
                largerValue = rightChildValue;
                largerIndex = rightChildIndex;
            } else {
                largerValue = leftChildValue;
                largerIndex = leftChildIndex;
            }
            //determine if a swap should be made with the parent and the larger child
            if (heap[index].getPriority() < largerValue) {
                //swap
                PriorityCustomer swap = heap [index];
                heap [index] = heap [largerIndex];
                heap [largerIndex] = swap;
                //update the index since we moved it to a child position
                index = largerIndex;
            } else {
                //parent value is larger...no swap needed...break out
                break;
            }
        }      //return the original root
        return temporary;
  } // end of remove() method

} //end of class
