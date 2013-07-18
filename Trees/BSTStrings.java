package Trees;

public class BSTStrings{
	public static void main(String[] args) {
		BST stringTree = new BST();
		stringTree.insert("Doctor");
		stringTree.insert("Jack");
		stringTree.insert("Dona");
		System.out.println(stringTree);
	}
}