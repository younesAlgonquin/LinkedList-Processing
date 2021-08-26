/**
 * <br>Processing data using Doubly Linked List CST8130 Data Structures, Computer
 * <br>Engineering Technology-Computer Science: Level 3
 * 
 * <br>Professor: James Mwangi PhD
 * 
 * 
 * <br>         Student Name: Younes Boutaleb
 * <br>			Student ID: 041019068
 * 
 * <br>	
 * <br>	
 * <br>CET - CS Academic Level 3
 * <br>Declaration: I declare that this is my own original work and is free from Plagiarism
 * <br>This class creates Linkedlist Nodes.
 * <br>Section #: 303
 * <br>Course: CST8130 - Data Structures
 * @author Younes Boutaleb.
 * @version 1.0
 */

//===================== class starts here=============================
class Node {

	/**This is the data item contained in the Node*/
	public int mData; 
	/**This is the next Node*/
	public Node next;
	/**This is the previous Node*/
	public Node previous;
	// -------------------------------------------------------------

	/**This is the parameterized constructor which instantiates Nodes that stores the data
	 * @param d this is the data that will be stored in the Node
	 */
	public Node(int d)
	{
		mData = d;
	}// end parameterized constructor

	// -------------------------------------------------------------
	/**
	 * This method prints the Node's data
	 */
	public void displayNode() {
		System.out.print(mData + " ");
	}// end displayNode
	// -------------------------------------------------------------
} // end class Node

//===================== class design starts here =============================

/**
 * <br>This class creates a doubly LinkedList and declares methods to process it.
 * @author Younes Boutaleb.
 * @version 1.0
 */
class DoublyLinkedList {

	/**This is the first Node in the LinkedList*/
	private Node first;
	/**This is the last Node in the LinkedList*/
	private Node last;

	// -------------------------------------------------------------

	/**
	 * This is the no-arg constructor which instantiates LinkedLists
	 */
	public DoublyLinkedList() {
		first = null;
		last = null;
	}// end constructor

	// -------------------------------------------------------------

	/**
	 * This methods checks if the weather the LinkedList id empty or not
	 * @return Returns true if it's empty otherwise false
	 */
	public boolean isEmpty() {
		return first == null;
	}// end isEmpty

	// -------------------------------------------------------------
	/**
	 * This method inserts a new Node at the head of the Linkedlist
	 * @param num This is the data contained in the new Node
	 */
	public void insertFirst(int num) {

		//this is the new Node to be inserted in the LinkedList
		Node newNode = new Node(num);

		//if the LinkedList is Empty then both first and last will point to new Node
		if (isEmpty())
			last = newNode; // last points continuously to newNode as it will remain the last node in the
		// linkedlist when adding more new nodes at the top
		else {
			first.previous = newNode;
			newNode.next = first;
		}
		first = newNode;
	}//end insertFirst

	// -------------------------------------------------------------
	/**
	 * This method inserts a new Node at the tail of the LinkedList
	 * @param num  This is the data contained in the new Node
	 */
	public void insertLast(int num) {

		//this is the new Node to be inserted in the LinkedList
		Node newNode = new Node(num);

		//if the LinkedList is Empty then both first and last will point to new Node
		if (isEmpty())
			first = newNode;
		else {
			last.next = newNode;
			newNode.previous = last;
		}
		last = newNode;
	}//end insertLast


	/**
	 * This method inserts newNumber just after numToFind
	 * @param numToFind is an existing number
	 * @param newNumber is a number to be inserted after numToFind
	 * @return Returns true if the newNumber is successfully inserted otherwise false
	 */
	public boolean insertAfter(int numToFind, int newNumber) { // (assumes non-empty list)

		//This is the current Node when the while loop is iterating through the LinkedList
		Node current = first;
		//the while loop takes each Node's data and compares it with the numToFind
		//it breaks when it finds the numToFind otherwise it returns false when it reaches the end of the lINKEDlIST
		while (current.mData != numToFind) {
			current = current.next;
			if (current == null)
				return false;
		}

		//This Node stores the newNumber
		Node newNode = new Node(newNumber);

		//inserts the newNode just after the Node containing the numToFind
		//if the current Node is the last what it puts the newNode as the last Node and the following node is null
		if (current == last) {
			newNode.next = null;
			last = newNode;

			//Otherwise the next Node to newNode will point to the next of current Node 
			//and the previous of the next of the current Node will point to the newNode 
		} else {
			newNode.next = current.next;
			current.next.previous = newNode;
		}
		newNode.previous = current;
		current.next = newNode;
		return true;
	}//end insertAfter

	//------------------------------------------------// delete first node

	/**
	 * This method deletes the first Node in the LinkedList
	 * @return Returns the new first Node
	 */
	public Node deleteFirstNode() {

		//The previous of the second Node will point to Null
		first.next.previous = null;
		//The first Node will point to second Node. The former first Node will be garbage collected
		first = first.next;

		return first;
	}//end deleteFirstNode

	// -----------------------------------------------// delete last node

	/**
	 * This method deletes the last Node in the LinkedList
	 * @return Returns the new last Node
	 */
	public Node deleteLastNode() {

		//The next of the before last Node will point to Null
		last.previous.next = null;
		//The last Node will point to the before last. The former last Node will be garbage collected
		last = last.previous;

		return last;
	}//end deleteLastNode

	// -----------------------------------------finds, deletes and returns the node that contains the given int value 

	/**
	 * This method deletes a specific number
	 * @param number This is the number to delete
	 * @return Returns the Node containing number if it exists otherwise returns Null
	 */
	public Node searchAndDelete(int number) {

		//This is the current Node when the while loop is iterating through the LinkedList  
		Node current = first;

		//the while loop takes each Node's data and compares it with the numToFind
		//it breaks when it finds the numToFind or when it reaches the end of the LinkedList
		while (current != null) {

			if(current.mData == number) {

				//When the number is found the containing Node is deleted by assigning its next and previous Nodes to the surrounding Nodes 
				current.previous.next = current.next;
				current.next.previous  = current.previous;
				break;

			}else {
				//Moves to the next Node if the current Node doesn't contain number
				current = current.next;
			}

		}//end while

		return current;
	}//end searchAndDelete


	// -------------------------------------------display data from first node to last node
	/**
	 * This method displays LinkedList data from first node to last node
	 */
	public void printForwards() {

		//This is the current Node when the while loop is iterating through the LinkedList beginning from the head
		Node current = first;

		//calls the displayNode method in each iteration 
		while (current != null) {

			current.displayNode();
			current = current.next;
		}
	}//end printForwards

	// -------------------------------------------display data from last node  to first node
	/**
	 * This method displays LinkedList data from last node to first node
	 */
	public void printBackwards() {

		//This is the current Node when the while loop is iterating through the LinkedList beginning from the tail
		Node current = last;

		//calls the displayNode method in each iteration 
		while (current != null) {

			current.displayNode();
			current = current.previous;
		}

	}//end printBackwards
	// -------------------------------------------------------------
} // end class DoublyLinkedList

// ==========================================================
