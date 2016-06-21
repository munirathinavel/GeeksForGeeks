package datastructures.linkedlist.singlylinkedlist.mergelists;

/**
 * http://www.geeksforgeeks.org/merge-two-sorted-linked-lists-such-that-merged-list-is-in-reverse-order/
 *
 Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).

Input:  a: 5->10->15->40
        b: 2->3->20 
Output: res: 40->20->15->10->5->3->2

Input:  a: NULL
        b: 2->3->20 
Output: res: 20->3->2
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
		Node curr = head;
		while(curr != null){
			System.out.print(curr.data);
			if(curr.next != null){
				System.out.print(" -> ");
			}
			curr = curr.next;
		}
	}

	//Merge Lists
	public Node mergeListsInDecreasingOrder(Node head1, Node head2){
		Node curr1 = head1;
		Node curr2 = head2;

		Node result = null;

		//Add nodes in front of result list => Thus it becomes Descending Order
		while(curr1 != null && curr2 != null){
			if(curr1.data <= curr2.data){		//V.v.imp logic to add Node in front
				Node temp = curr1.next;
				curr1.next = result;
				result = curr1;
				curr1 = temp;
			}else{					
				Node temp = curr2.next;
				curr2.next = result;
				result = curr2;
				curr2 = temp;
			}
		}
		
		//Add rest from list1
		while(curr1 != null){
			Node temp = curr1.next;
			curr1.next = result;
			result = curr1;
			curr1 = temp;
		}
		//Add rest from list2
		while(curr2 != null){
			Node temp = curr2.next;
			curr2.next = result;
			result = curr2;
			curr2 = temp;
		}		
		return result;
		
	}

}


public class LinkedListMerge {

	public static void main(String[] args) {

		/**
		 * 2. Given two linked lists sorted in increasing order. 
		 * Merge them such a way that the result list is in decreasing order (reverse order).
		 */
		System.out.println("\n******* Merge Lists in Decreasing Order *********");
		//Create both the lists
		System.out.println("List 1: ");
		LinkedList list3 = new LinkedList();
		list3.insertFirst(40); 
		list3.insertFirst(15); 
		list3.insertFirst(10);
		list3.insertFirst(5);
		list3.displayList();

		System.out.println("\nList 2: ");
		LinkedList list4 = new LinkedList();
		list4.insertFirst(20);
		list4.insertFirst(3);
		list4.insertFirst(2);
		list4.displayList();

		LinkedList mergedList = new LinkedList();
		mergedList.head = list3.mergeListsInDecreasingOrder(list3.head, list4.head);
		System.out.println("\nMerged List: ");
		mergedList.displayList();


	}

}
