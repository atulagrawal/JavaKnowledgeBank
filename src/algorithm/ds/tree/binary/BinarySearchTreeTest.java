package algorithm.ds.tree.binary;

public class BinarySearchTreeTest {

	public static void main(String[] args) {
		BinarySearchTree tree = new BinarySearchTree();
		Node<Integer> node = new Node<>(100);
		tree.insert2(node, 75);
		tree.insert2(node, 50);
		tree.insert2(node, 80);
		tree.insert2(node, 25);
		tree.insert2(node, 60);
		tree.insert2(node, 125);
		tree.insert2(node, 110);
		tree.insert2(node, 175);
		tree.insert2(node, 175);
		TreeTraverse.inorder(node);
		

	}

}
