package datastructures.linkedlist.singlylinkedlist;

/**
 * Write a function to reverse a linked list
 * http://www.geeksforgeeks.org/write-a-function-to-reverse-the-nodes-of-a-linked-list/
 Given pointer to the head node of a linked list, the task is to reverse the linked list.

 Examples:

 Input : Head of following linked list
 1->2->3->4->NULL
 Output : Linked list should be changed to,
 4->3->2->1->NULL

 Input : Head of following linked list
 1->2->3->4->5->NULL
 Output : Linked list should be changed to,
 5->4->3->2->1->NULL

 Input : NULL
 Output : NULL

 Input  : 1->NULL
 Output : 1->NULL
 */
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}


class LinkedList {
    Node head;

    //Initialize LinkedList head to NULL
    public LinkedList() {
        head = null;
    }

    //Print list
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    //Insert Node at start
    public void insertFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /** Function Reverse: 3 pointers: Draw on paper to visualize and write
     * In loop,
     * change next to prev,
     * prev to current
     * current to next.
     */
    public void reverse(){
        Node curr = head;
        Node prev = null;
        Node next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;    //update head of original list to prev, as prev points to new first node. Old head node is now last node
    }

    /**
     * Recursively update next to prev
     */
    public void reverseRecursive(Node curr, Node prev){

        //Base case: Reach last node
        if(curr.next == null){
            head = curr;

            //Update next to prev
            curr.next = prev;
            return;
        }

        Node temp = curr.next;  //Save to pass in recursive call
        //Update next to prev
        curr.next = prev;
        reverseRecursive(temp, curr);
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFirst(4);list.insertFirst(3);list.insertFirst(2);list.insertFirst(1);

        System.out.println("Original List");
        list.printList();

        System.out.println("\nReversed List");
        list.reverse();
        list.printList();

        System.out.println("\nReversed List Recursive");
        list.reverseRecursive(list.head, null);
        list.printList();

    }
}
