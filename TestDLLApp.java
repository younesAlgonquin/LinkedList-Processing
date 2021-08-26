/**
 * <br>Processing data using Doubly Linked List CST8130 Data Structures, Computer
 * <br>Engineering Technology-Computer Science: Level 3
 * 
 * <br>Professor: James Mwangi PhD
 * 
 * 
 * <br>         Student Name: Younes Boutaleb
 * <br>			Student ID: 041019068
 * <br>	
 * <br>	
 * <br>CET - CS Academic Level 3
 * <br>Declaration: I declare that this is my own original work and is free from Plagiarism
 * <br>This class implements the main method and tests the program.
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * @author Younes Boutaleb.
 * @version 1.0
 */

class TestDLLApp {
	
	/**
	 * This main method creates a new LinkedList and calls the DoublyLinked methods on it
	 * @param args command line arguments
	 */
	public static void main (String[] args) {
		
		//Instantiate a new LinkedList
		DoublyLinkedList newLL = new DoublyLinkedList();
		
		//add new elements at the head of the new LinkedList
		newLL.insertFirst(20);
		newLL.insertFirst(42);
		newLL.insertFirst(63);
		newLL.insertFirst(93);


		//add new elements at the tail of the new LinkedList
		newLL.insertLast(9);
		newLL.insertLast(34);
		newLL.insertLast(51);
		
		//Print the LinkedList elements from the first to the last
		System.out.print("Linked List: [From first_to_last]: ");
		newLL.printForwards();
		System.out.println();
		//Print the LinkedList elements from the last to the first
		System.out.print("Linked List: [From last_to_first]: ");
		newLL.printBackwards();
		
		//Delete first number, last number and number 9 and Print the LinkedList elements from the first to the last
		newLL.deleteFirstNode();
		newLL.deleteLastNode();
		newLL.searchAndDelete(9);
		System.out.println();
		System.out.print("Linked List: [From first_to_last]: ");
		newLL.printForwards();
		
		//insert more elements at a specific order and Print the LinkedList elements from the first to the last
		newLL.insertAfter(20, 69);
		newLL.insertAfter(34, 77);
		System.out.println();
		System.out.print("Linked List: [From first_to_last]: ");
		newLL.printForwards();

	} // end of main() method
} // end class TestDLLApp
