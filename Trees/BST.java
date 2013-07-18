package Trees;

public class BST {
	
	private Node root;

	private class Node {
		public int data;
		public Node left;
		public Node right;

		public Node(int data , Node left , Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}


	}

	public BST(){
		root = null;
	}

	public void insert(int data) {
		root = insert(data,root);
	}

	public Node insert (int data , Node node) {
		if(node == null){
			return new Node(data , null , null);
		}

		if(data < node.data )
			node.left = insert(data,node.left);
		if(data > node.data)
			node.right = insert(data, node.right);
		return node;

	}

	public void traverse(){
		StringBuilder buffer = new StringBuilder();
		inorder_traverse(root , buffer);

	}

	private void inorder_traverse(Node node , StringBuilder buffer){
		if(node!=null){
			inorder_traverse(node.left, buffer);
			buffer.append(node.data);
			inorder_traverse(node.right, buffer);
		}
	}



	@Override
	public String toString(){
		StringBuilder buffer = new StringBuilder();
		inorder_traverse(root , buffer);
		return buffer.toString();
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		System.out.println(tree);
	}
}