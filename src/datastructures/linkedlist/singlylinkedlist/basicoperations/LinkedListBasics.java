package datastructures.linkedlist.singlylinkedlist.basicoperations;

/**
 * A basic Singly LinkedList in Java with basic operations
 *
 * http://quiz.geeksforgeeks.org/linked-list-set-1-introduction/
 * http://quiz.geeksforgeeks.org/linked-list-set-2-inserting-a-node/
 * http://quiz.geeksforgeeks.org/linked-list-set-3-deleting-node/
 * http://quiz.geeksforgeeks.org/delete-a-linked-list-node-at-a-given-position/
 * http://quiz.geeksforgeeks.org/find-length-of-a-linked-list-iterative-and-recursive/
 */

//Represent the Node of linkedlist
class Node {
    int data;
    Node next;

    public Node(int data){
        this.data = data;
    }
}

//Represent LinkedList
class LinkedList {
    Node head;      //points to head linkedlist

    //Initialize LinkedList head to NULL
    public LinkedList(){
        head = null;
    }

    /**
     * Basic Methods
     */
    public boolean isEmpty(){
        return head == null;
    }

    //Print LinkedList
    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    /** Add node at beginning of LinkedList
     * Steps:
     * 1. Create a newNode with data
     * 2. Make next of newNode as head
     * 3. Move the head to point to newNode
     */
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        newNode.next = head;    //Make next of newNode as head
        head = newNode;         //Move the head to point to newNode, as newNode is added to beginning
    }

    /** Add a node after a node, at given position
     *  Steps:
     *  1. If position = 0, then list is empty so its insertFirst
     *  2. Else, increment current till it reaches node before the position
     *  3. Update newNode next point to current next
     *  4. Update current next to newNode.
     */
    public void insertAtPosition(int data, int position){
        Node newNode = new Node(data);

        if(position == 0){  //List is empty, so its insertFirst
            newNode.next = head;
            head = newNode;
        }else{
            //goto to node before position
            Node curr = head;
            for(int i=0; i < position-1; i++){
                curr = curr.next;
            }
            newNode.next = curr.next;       //Update newNode next point to current next
            curr.next = newNode;            //Update current next to newNode.
        }
    }

    /** Add node at end of list
     * Steps:
     * 1. Keep 2 pointers, curr and prev. curr = goes to end of list & prev = points to 2nd last node
     * 2. Create newNode and set its next to NULL
     * 3. Update prev node next to newNode
     */
    public void insertLast(int data){
        Node curr = head;
        Node prev = head;

        //goto end of list. curr = goto end of list & prev = points to 2nd last node
        while(curr != null){
            prev = curr;
            curr = curr.next;
        }
        Node newNode = new Node(data);      //Create newNode and set its next to NULL
        newNode.next = null;
        prev.next = newNode;                //Update prev nodes next to newNode
    }

    /**
     * Given a key, deletes the first occurrence of key in linked list
     * Steps:
     * 1. Keep 2 pointers, curr and prev. Search for key which points to current & prev points to its prev node
     * 2. If head is key, mode head forward
     * 3. Update prev nodes next to curr next i.e unlink current node
     */
    public void deleteNodeByKey(int key){
        Node curr = head;
        Node prev = head;

        //If head is key
        if(head != null && head.data == key){
            head = curr.next;
            return;
        }
        //Search for node with key
        while(curr != null && curr.data != key){
            prev = curr;
            curr = curr.next;
        }
        //Unlink curr i.e update prev next to curr next
        prev.next = curr.next;
    }

    /**
     * Delete a Linked List node at a given position
     Example:
     Input: position = 1, Linked List = 8->2->3->1->7
     Output: Linked List =  8->3->1->7

     Input: position = 0, Linked List = 8->2->3->1->7
     Output: Linked List = 2->3->1->7
     * Steps:
     * 1. If position = 0, move head forward
     * 2. Traverse till prev node of position & update curr next to next.next node
     */
    public void deleteNodeAtPosition(int position){
        Node curr = head;
        //Node prev = head;

        //If position = 0 i.e head
        if(position == 0){
            head = curr.next;
        }
        //Traverse curr till prev node of position
        for(int i=0; i < position-1; i++){
            curr = curr.next;
        }
        //Unlink curr next i.e update curr next to curr's next next node
        curr.next = curr.next.next;
    }

    /**
     * Find length Iterative
     * 1. Initialize length as 0
     * 2. Initialize a node pointer, current = head.
     * 3. While current is not NULL
            a) current = current -> next
            b) length++;
     * 4. Return length
     */
    public int getLengthIter(){
        int length = 0;
        Node curr = head;
        while(curr != null){
            length++;
            curr = curr.next;
        }
        return length;
    }

    /**
     * Find Length Recursive
     * Steps:
     * 1. BASE CASE: If curr is NULL, return 0.
     * 2. Else return 1 + getLength(curr.next)
     */
    public int getLengthRecur(Node curr){
        //Base case
        if(curr == null){
            return 0;
        }
        return 1 + getLengthRecur(curr.next);
    }

}

//Main class
public class LinkedListBasics {

    public static void main(String[] args) {
        //Create LinkedList
        LinkedList list = new LinkedList();

        //Insert nodes at beginning
        list.insertFirst(50);
        list.insertFirst(40);
        list.insertFirst(30);
        list.insertFirst(20);
        list.insertFirst(10);

        //Insert at Nth position
        list.insertAtPosition(35, 3);

        //Insert at end of list
        list.insertLast(60);
        list.insertLast(5);

        //Print list
        System.out.println("Inital List");
        list.printList();

        System.out.println("\nList length Iterative: "+ list.getLengthIter());
        System.out.println("List length Recursive: "+ list.getLengthRecur(list.head));

        System.out.println("List after deletion");
        list.deleteNodeByKey(5);
        list.deleteNodeAtPosition(3);
        list.printList();

        System.out.println("\nList length Iterative: "+ list.getLengthIter());
        System.out.println("List length Recursive: "+ list.getLengthRecur(list.head));

    }
}
