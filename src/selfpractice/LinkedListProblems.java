package selfpractice;

/**
 * 
1. Add two numbers represented in linked list
eg:
  First List: 5->6->3  // represents number 563
  Second List: 8->4->2 //  represents number 842
Output
  Resultant list: 1->4->0->5  // represents number 1405
 *
 *
 2) Given two linked lists sorted in increasing order. Merge them such a way that the result list is in decreasing order (reverse order).

Input:  a: 5->10->15->40
        b: 2->3->20 
Output: res: 40->20->15->10->5->3->2

Input:  a: NULL
        b: 2->3->20 
Output: res: 20->3->2
 */

class ListNode {
	int data;
	ListNode next;	
	public ListNode(int data) {
		this.data = data;
	}
}

class LinkedList{
	ListNode head;
	public LinkedList(){
		head = null;	//initialize as empty list
	}

	//Create LinkedList
	public void insertFirst(int data){
		ListNode node = new ListNode(data);
		node.next = head;
		head = node;
	}

	//Display LinkedList
	public void displayList() {
		ListNode current = head;
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
		ListNode current = head;
		ListNode prev = null;
		ListNode next = null;

		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
	}

	//Add two lists
	public ListNode addList(ListNode head1, ListNode head2){
		ListNode curr1 = head1;
		ListNode curr2 = head2;

		ListNode head = new ListNode(0);	//head of summation list
		ListNode curr = head;				//set curr = sum head

		int advance = 0;
		while(curr1 != null && curr2 != null) {
			int sum = curr1.data + curr2.data + advance;
			advance = sum / 10;
			sum = sum % 10;

			curr.next = new ListNode(sum);	//add num node to curr node

			curr = curr.next;	//increment all pointers of list1, list2 and sum list
			curr1 = curr1.next;
			curr2 = curr2.next;			
		}		

		if(curr1 != null){			//if list1 has more numbers
			if(advance != 0) {
				curr.next = addList(curr1 , new ListNode(advance));
			}else{
				curr.next = curr1;
			}
		}else if(curr2 != null){	//if list2 has more numbers
			if(advance != 0) {
				curr.next = addList(curr2 , new ListNode(advance));
			}else{
				curr.next = curr2;
			}
		}else if(advance != 0){		//only carry is remaining
			curr.next = new ListNode(advance);
		}

		return head.next;
	}
	
	
	//Merge Lists
	public ListNode mergeListsInDecreasingOrder(ListNode head1, ListNode head2){
		ListNode curr1 = head1;
		ListNode curr2 = head2;
		
		ListNode result = null;
		
		while(curr1 != null && curr2 != null){
			if(curr1.data <= curr2.data){
				ListNode temp = curr1.next;
				curr1.next = result;
				result = curr1;
				curr1 = temp;
			}else{					
				ListNode temp = curr2.next;
				curr2.next = result;
				result = curr2;
				curr2 = temp;
			}
		}
		
		//Add rest from list1
		while(curr1 != null){
			ListNode temp = curr1.next;
			curr1.next = result;
			result = curr1;
			curr1 = temp;
		}
		//Add rest from list2
		while(curr2 != null){
			ListNode temp = curr2.next;
			curr2.next = result;
			result = curr2;
			curr2 = temp;
		}		
		return result;
		
	}

}


public class LinkedListProblems {

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

		//Reverse both the lists
		System.out.println("\nReversed List 1: ");
		list1.reverse();
		list1.displayList();
		System.out.println("\nReversed List 2: ");
		list2.reverse();
		list2.displayList();

		//Add both reversed lists with units digit at head
		System.out.println("\nSum List: ");
		LinkedList sumList = new LinkedList();
		sumList.head = list1.addList(list1.head, list2.head);
		sumList.displayList();
		System.out.println("\nFinal Sum: ");
		sumList.reverse();
		sumList.displayList();

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
