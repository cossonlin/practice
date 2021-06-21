package algorithm.sort;

public class TreeSort {
	Node root;

	TreeSort() {
		root = null;
	}

	public static void main(String[] args) {
		TreeSort tree = new TreeSort();
		int arr[] = {5, 4, 7, 2, 11};
		tree.treeInsert(arr);
		tree.inorderTraversal(tree.root);
	}

	void insert(int key) {
		root = insertRec(root, key);
	}

	Node insertRec(Node node, int key) {
		if (node == null) {
			node = new Node(key);
			return node;
		}

		if (key < node.key)
			node.left = insertRec(node.left, key);
		else
			node.right = insertRec(node.right, key);

		return node;
	}

	void inorderTraversal(Node root) {
		if (root != null) {
			inorderTraversal(root.left);
			System.out.print(root.key + " ");
			inorderTraversal(root.right);
		}
	}

	void treeInsert(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			insert(arr[i]);
		}

	}

	class Node {
		int key;
		Node left, right;

		public Node(int item) {
			key = item;
			left = right = null;
		}
	}
}
