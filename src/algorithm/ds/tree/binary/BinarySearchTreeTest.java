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
		System.out.println("\n ------------------------");
		System.out.println(tree.search(node, 80));
		System.out.println(tree.search(node, 60));
		System.out.println(tree.search(node, 100));
		System.out.println(tree.search(node, 25));
		System.out.println(tree.search(node, 175));
		System.out.println(tree.search(node, 500));
		System.out.println(tree.search(node, 5));

	}

}
