package selfpractice.tree.trinarytree;

class Node{
	int data;
	Node left;
	Node middle;
	Node right;

	public Node(int data){
		this.data = data;
		left = null;
		middle = null;
		right = null;
	}
}

class TrinaryTree{
	Node root;

	public TrinaryTree(){
		root = null;
	}

	//Insert Node into Tree
	public void insert(int value){
		Node newNode = new Node(value);

		if(root == null){		//if tree is empty, add newNode as root
			root = newNode;
			return;
		}

		Node curr = root;
		Node parent = null;

		while(curr != null) {			//Traverse the tree till we find the correct location for newNode
			parent = curr;

			if(value < curr.data){
				curr = curr.left;		//move left if value is less than root
			}else if(value > curr.data){
				curr = curr.right;		//move right if value is greater than root
			}else{
				curr = curr.middle;		//move middle if value is equal to root
			}			
		}

		if (value < parent.data){		//Add newNode to its correct parent
			parent.left = newNode;		
		}else if (value > parent.data){
			parent.right = newNode;
		}else {
			parent.middle = newNode;
		}
	}


	//Delete wrapper method
	public void Delete(int val) {
		root = Delete(root, val);
	}

	//Delete Node from Trinary tree
	private Node Delete(Node root, int value) 
	{
		if(root == null){		//if tree is empty, return null
			return null;
		}

		if (root.data > value) {		//traverse left as value to delete is less than root
			root.left = Delete(root.left, value);
		}else if(root.data < value) {	//traverse right as value to delete is greater than root
			root.right = Delete(root.right, value);
		}else {							
			if (root.middle != null) {	//if value is same as root, delete last middle if present
				root.middle = Delete(root.middle, value);
			}else if(root.right != null) {	//else find minimum node from right subtree and replace it with Node to be deleted 
				int min = findMinimum(root.right).data;
				root.data = min;
				root.right = Delete(root.right, min);
			}else {
				root = root.left;
			}
		}
		return root;
	}

	//Returns the minimum from right subtree by traversing left in right subtree
	private Node findMinimum(Node node) {
		if(node != null){ 
			while (node.left != null) {
				return findMinimum(node.left);
			}
		}
		return node;
	}


	//Utility method: Print the Trinary tree
	public void print(Node root){
		if(root != null){
			System.out.print(root.data + " ");
			print(root.left);
			print(root.middle);
			print(root.right);
		}
	}
}

public class TrinaryTreeApp {

	public static void main(String[] args) {
		TrinaryTree tree = new TrinaryTree();
		tree.insert(5);
		tree.insert(4);
		tree.insert(9);
		tree.insert(5);
		tree.insert(7);
		tree.insert(2);
		tree.insert(2);

		System.out.println("Initial Tree: ");
		tree.print(tree.root);

		tree.Delete(5);
		tree.Delete(2);
		tree.Delete(1);	//will not delete anything as 1 is not present
		
		System.out.println("\nAfter Delete:");
		tree.print(tree.root);
	}
}
