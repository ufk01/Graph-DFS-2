//-------------------------------------------------------------------------------------
// Title: Node class
// Author: H�seyin Ufuk Y�lmaz
// ID: 21826286904
// Section: 02
// Assignment: 1
// Description: This class provides to hold data and next method for other classes with using generic. 
//--------------------------------------------------------------------------------------
public class Node<Item> {
	public Item item;
	public Node<Item> next;

	public Node() {        // Constructor of Node class
		this.item = null;
	}

}
