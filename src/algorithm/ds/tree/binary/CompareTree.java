package algorithm.ds.tree.binary;


public class CompareTree {

	public static boolean compareTree(Node node1, Node node2) {
		boolean status = false;
		if(node1==null && node2==null) {
			status = true;
		}
		if(node1!=null && node2!=null) {
			System.out.println(node1.getData());
			status = (node1.equals(node2) && 
					compareTree(node1.getLeft(),node2.getLeft()) &&
					compareTree(node1.getRight(), node2.getRight()));
		}
		return status;
	}
	public static void main(String[] args) {
		Node<Integer> one = new Node<Integer>(1);
		Node<Integer> two = new Node<Integer>(2);
		Node<Integer> three = new Node<Integer>(3);
		Node<Integer> four = new Node<Integer>(4);
		Node<Integer> five = new Node<Integer>(5);
		Node<Integer> six = new Node<Integer>(6);
		Node<Integer> seven = new Node<Integer>(7);
		Node<Integer> eight = new Node<Integer>(8);
		Node<Integer> nine = new Node<Integer>(9);
		one.setLeft(two);
		one.setRight(three);
		two.setLeft(four);
		two.setRight(five);
		three.setLeft(six);
		four.setLeft(seven);
		six.setLeft(eight);
		six.setRight(nine);
		System.out.println(compareTree(one, one));
		
	}

}
