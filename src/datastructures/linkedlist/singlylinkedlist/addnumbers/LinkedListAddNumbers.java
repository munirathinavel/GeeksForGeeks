package datastructures.linkedlist.singlylinkedlist.addnumbers;

/**
 * 
1. Add two numbers represented in linked list
eg:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
  
 */

class Node {
	int data;
	Node next;	
	public Node(int data) {
		this.data = data;
	}
}

class LinkedList{
	Node head;
	public LinkedList(){
		head = null;	//initialize as empty list
	}

	//Create LinkedList
	public void insertFirst(int data){
		Node node = new Node(data);
		node.next = head;
		head = node;
	}

	//Display LinkedList
	public void displayList() {
		Node current = head;
		while(current != null){
			System.out.print(current.data);
			if(current.next != null){
				System.out.print(" -> ");
			}
			current = current.next;
		}
	}

	//Reverse Lists
	public void reverse(){
		Node current = head;
		Node prev = null;
		Node next = null;

		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	//Add two lists
	public Node addList(Node head1, Node head2){
		Node curr1 = head1;
		Node curr2 = head2;

		Node head = new Node(0);	//head of summation list
		Node curr = head;				//set curr = sum head

		int advance = 0;
		while(curr1 != null && curr2 != null) {
			int sum = curr1.data + curr2.data + advance;
			advance = sum / 10;
			sum = sum % 10;

			curr.next = new Node(sum);	//add num node to curr node

			curr = curr.next;	//increment all pointers of list1, list2 and sum list
			curr1 = curr1.next;
			curr2 = curr2.next;			
		}		

		if(curr1 != null){			//if list1 has more numbers
			if(advance != 0) {
				curr.next = addList(curr1 , new Node(advance));
			}else{
				curr.next = curr1;
			}
		}else if(curr2 != null){	//if list2 has more numbers
			if(advance != 0) {
				curr.next = addList(curr2 , new Node(advance));
			}else{
				curr.next = curr2;
			}
		}else if(advance != 0){		//only carry is remaining
			curr.next = new Node(advance);
		}

		return head.next;
	}

}


public class LinkedListAddNumbers {

	public static void main(String[] args) {

		/**
		 * 1. Add two numbers represented in linked list
		 */
		System.out.println("********* Add two numbers represented in linked list *********");
		//Create both the lists
		System.out.println("List 1: ");
		LinkedList list1 = new LinkedList();
		list1.insertFirst(3); 
		list1.insertFirst(6); 
		list1.insertFirst(5);				
		list1.displayList();

		System.out.println("\nList 2: ");
		LinkedList list2 = new LinkedList();
		list2.insertFirst(2);
		list2.insertFirst(4);
		list2.insertFirst(8);
		list2.displayList();	

		//Reverse both the lists, as we want units digit at head
		System.out.println("\nReversed List 1: ");
		list1.reverse();
		list1.displayList();
		System.out.println("\nReversed List 2: ");
		list2.reverse();
		list2.displayList();

		//563 + 842 = 1405
		
		//Add both reversed lists with units digit at head
		System.out.println("\nSum List: ");
		LinkedList sumList = new LinkedList();
		sumList.head = list1.addList(list1.head, list2.head);
		sumList.displayList();
		System.out.println("\nFinal Sum: ");
		sumList.reverse();
		sumList.displayList();
	
	}

}

