public class BinaryTree {
	Node root;

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.addNode(10, "Ryan");
		tree.addNode(5, "Bob");
		tree.addNode(3, "Peter");
		tree.addNode(6, "George");
		tree.addNode(15, "Meg");
		tree.addNode(20, "Rob");
		tree.inOrderTraverse(tree.root);
		System.out.println("--");
		tree.preOrderTraverse(tree.root);
		System.out.println("--");
		tree.postOrderTraverse(tree.root);
		System.out.println("--");
		System.out.println(tree.findNode(5));
	}

	public void addNode(int key, String name) {
		Node newNode = new Node(key, name);
		if (root == null)
			root = newNode;
		else {
			Node focusNode = root;
			Node parent;
			while (true) {
				parent = focusNode;
				if (key < focusNode.key) {
					focusNode = focusNode.leftChild;
					if (focusNode == null) {
						parent.leftChild = newNode;
						return;
					}
				} else {
					focusNode = focusNode.rightChild;
					if (focusNode == null) {
						parent.rightChild = newNode;
						return;
					}
				}
			}
		}
	}

	public void inOrderTraverse(Node focusNode) {
		if (focusNode != null) {
			inOrderTraverse(focusNode.leftChild);
			System.out.println(focusNode);
			inOrderTraverse(focusNode.rightChild);
		}
	}
	
	public void preOrderTraverse(Node focusNode){
		if(focusNode != null){
			System.out.println(focusNode);
			preOrderTraverse(focusNode.leftChild);
			preOrderTraverse(focusNode.rightChild);
		}
	}
	
	public void postOrderTraverse(Node focusNode){
		if(focusNode != null){
			postOrderTraverse(focusNode.leftChild);
			postOrderTraverse(focusNode.rightChild);
			System.out.println(focusNode);
		}
	}
	
	public Node findNode(int key){
		Node focusNode = root;
		while(focusNode.key != key){
			if(key < focusNode.key){
				focusNode = focusNode.leftChild;
			}
			else{
				focusNode = focusNode.rightChild;
			}
		}
		return focusNode;
	}

}

class Node {
	int key;
	String name;
	Node leftChild, rightChild;

	public Node(int key, String name) {
		this.key = key;
		this.name = name;
	}

	public String toString() {
		return name + " has key value of " + key;
	}
}
