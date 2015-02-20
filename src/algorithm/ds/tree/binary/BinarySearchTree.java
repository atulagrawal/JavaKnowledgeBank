package algorithm.ds.tree.binary;

public class BinarySearchTree {
	private Node<Integer> root;
	
	public BinarySearchTree(Integer val) {
		root = new Node<>(val);
	}
	
	public BinarySearchTree() {
		
	}
	
	public Node<Integer> search(Node<Integer> node, Integer value) {
		if(node==null) return null;
		if(value.equals(node.getData())) {
			return node;
		} else if(value > node.getData()){
			return search(node.getRight(),value);
		} else {
			return search(node.getLeft(),value);
		}
	}
	public boolean insert1(Node<Integer> root, Integer value) {
		//insert into the leaf node
		if(root!=null) {
			if(value > root.getData()) {
				if(root.getRight()==null) {
					root.setRight(new Node<>(value));
					return true;
				} else {
					insert2(root.getRight(),value);
				}
			} else if(value < root.getData()){
				if(root.getLeft()==null) {
					root.setLeft(new Node<>(value));
					return true;
				} else {
					insert2(root.getLeft(), value);
				}
			}
		}
		return false;
	}
	
	public Node<Integer> insert2(Node<Integer> node, Integer value) {
		if(node ==null) {
			return new Node<>(value);
		}
		
		if(node.getData() > value) {
			node.setLeft(insert2(node.getLeft(), value));
		} else if(node.getData() < value) {
			node.setRight(insert2(node.getRight(),value));
		}
		return node;
	}
}
