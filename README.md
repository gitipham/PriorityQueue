# PriorityQueue

Instructions
For your second programming assignment, modify your first programming assignment to store your Customer objects in a priority queue instead of a regular queue.  
An updated PriorityCustomer class is provided for you. You must use that class, without alternations, for the creation of your PriorityCustomer objects. 
You must analyze the class and use the provided methods to achieve the desired functionality of the program.  You will also need to create two additional classes. 
The first will be a PriorityQueue class that will represent the data structure for holding your Customer objects. 
In your PriorityQueue class, you will create the actual heap that will act as the priority queue.  You must use an array representation of a heap. 
No ArrayLists or linked structures! The second class you will need to create is a driver where your store simulation will take place.
Customers with a priority value higher than other existing customers should be placed in front of them. 
This is simulated by utilizing a Max Heap to implement your priority queue.  
The only exception to this is for the customer in the front of the line (the one currently being serviced).
If a new customer is added to the line with a higher priority than the front customer, the new customer should not be put in front of the customer being serviced – only those that are also waiting in line. The store simulation with regards to the service time of customers, probability that new customers show up, and program output will be the same as it was for the first program.
The program (driver) should simulate 60 minutes of activity at the store. Each iteration of your program should represent one minute.

At each iteration (minute), your program should do the following:
•	Check to see if new customers are added to the queue.  There is a 25% chance that new customers show up (need to be added to the queue) every minute. 
  This does not mean you should add a customer every four iterations, but rather each iteration should have its own 25% chance.
•	Update the customer object currently being serviced (if one exists).  This will be the customer object at the front of the queue. 
  If the customer has been completely serviced, remove them from the queue.

During execution, your program should output the following information:
•	When a new customer is added to the queue, output, “New customer added!  Queue length is now X” where X is the size of the queue after the new customer has been added.
•	When a customer has been completely serviced, output, “Customer serviced and removed from the queue. 
  Quest length is now X” where X is the size of the queue after the customer has been removed.
•	At the end of each iteration (minute), output, “---------------------------------------------------“  to visually identify the passing of time.

When your simulation ends, your program should also output the following information:
•	Total number of customers serviced
•	Maximum line length during the simulation 
