package selfpractice.companies.pocketgems.largestsumpath;

/*
http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/

Given a bst where every node has an integer value, return the path from the root to any leaf that gives the largest sum.

Nodes are defined as the language appropriate equivalent of:
struct Node {
  int val;
  Node* left;
  Node* right;
};

implement List<Node> largestSumPath(Node * root)

 */

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Node{
    int val;
    Node left;
    Node right;

    public Node(int val){
        this.val = val;
    }
}

class BinarySearchTree{
    Node root;
    Node targetLeaf;
    int maxSum = Integer.MIN_VALUE;

    public BinarySearchTree(){
        root = null;
    }

    public List<Node> largestSumPath(Node root){
        List<Node> list = new LinkedList<>();

        helperFindTargetLeaf(root, 0);
        System.out.println("max sum = " + maxSum);
        System.out.println("target leaf = "+ targetLeaf.val);

        helperFindPath(root, targetLeaf, list);

        Collections.reverse(list);
        return list;
    }

    private boolean helperFindPath(Node curr, Node targetLeaf, List<Node> list) {
       if(curr == null)
           return false;

        //recursively add from left to root
        if(curr == targetLeaf
                || helperFindPath(curr.left, targetLeaf, list)
                || helperFindPath(curr.right, targetLeaf, list)){
            list.add(curr);
            return true;
        }

        return false;
    }


    private void helperFindTargetLeaf(Node node, int currSum){

        //base case for recursion
        if(node == null)
            return;

        currSum = currSum + node.val;

        if(currSum > maxSum){
            maxSum = currSum;
            targetLeaf = node;
        }

        //recursively do this for left and right subtree
        helperFindTargetLeaf(node.left, currSum);
        helperFindTargetLeaf(node.right, currSum);
    }
}


public class LargestSumPath {

    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.root = new Node(6);
        bst.root.left = new Node(4);
        bst.root.right = new Node(8);
        bst.root.left.left = new Node(-1);
        bst.root.left.right = new Node(5);

        List<Node> list = bst.largestSumPath(bst.root);

        //Print nodes
        for(Node n : list){
            System.out.print(n.val + " ");
        }
    }
}
