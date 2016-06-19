package datastructures.linkedlist.singlylinkedlist.swap;

/**
 * Swap nodes in a linked list without swapping data
 * http://www.geeksforgeeks.org/swap-nodes-in-a-linked-list-without-swapping-data/
 *
 * Given a linked list and two keys in it, swap nodes for two given keys. Nodes should be swapped by changing links.
 * Swapping data of nodes may be expensive in many situations when data contains many fields.
 It may be assumed that all keys in linked list are distinct.
 Examples:

 Input:  10->15->12->13->20->14,  x = 12, y = 20
 Output: 10->15->20->13->12->14

 Input:  10->15->12->13->20->14,  x = 10, y = 20
 Output: 20->15->12->13->10->14

 Input:  10->15->12->13->20->14,  x = 12, y = 13
 Output: 10->15->13->12->20->14
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
    public LinkedList() {
        head = null;
    }

    //Print list
    public void printList(){
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    //Insert Node at start
    public void insertFirst(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    /**
     * Swap nodes with keys x and y in list.
     * Cases:
        1. x and y may or may not be adjacent nodes
        2. Either x or y may be head node
        3. Either x or y may be last node
        4. x and/or y may not be present in list

     * Approach:
        1. 4 pointers: prevX, currX, prevY, currY
        2. First change Prev pointers, then change Curr pointers
     */
    public void swap(int x, int y){

        //Return as x and y are same nodes
        if(x == y)
            return;

        Node prevX = null, currX = head;
        Node prevY = null, currY = head;

        //Search X
        while(currX != null && currX.data != x){
            prevX = currX;
            currX = currX.next;
        }
        //Search Y
        while(currY != null && currY.data != y){
            prevY = currY;
            currY = currY.next;
        }

        //If x or y are not present
        if(currX == null || currY == null)
            return;

        //If x or y are head node then Change Previous pointers accordingly
        if(prevX == null){
            head = currY;
        }else{
            prevX.next = currY;
        }

        if(prevY == null){
            head = currX;
        }else{
            prevY.next = currX;
        }

        //Change Current pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

}
public class SwapNodesLinkedList {
    public static void main(String[] args) {
        //10->15->12->13->20->14
        LinkedList list = new LinkedList();

        list.insertFirst(14);list.insertFirst(20);list.insertFirst(13);
        list.insertFirst(12);list.insertFirst(15);list.insertFirst(10);

        System.out.println("Before Swap");
        list.printList();

        list.swap(14,10);

        System.out.println("\nAfter Swap");
        list.printList();

    }
}
