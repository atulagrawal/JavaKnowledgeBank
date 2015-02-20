package algorithm.ds.tree.binary;

import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class TreeTraverse {
	
	public static void preorder(Node<?> n) {
		if (n != null) {
			System.out.print(n.getData() + " ");
			preorder(n.getLeft());
			preorder(n.getRight());
		}
	}

	public static void inorder(Node<?> n) {
		if (n != null) {
			inorder(n.getLeft());
			System.out.print(n.getData() + " ");
			inorder(n.getRight());
		}
	}
	
	public static void inoderWithStack(Node<?> node) {
		if(node==null) return;
		Stack<Node<?>> stack = new Stack<Node<?>>();
		while(stack.isEmpty()==false || node!=null) {
			
			if(node!=null) {
				stack.push(node);
				node = node.getLeft();
			} else {
				node = stack.pop();
				System.out.print(node.getData() + " ");
				node = node.getRight();
			}
			
		}	
		
	}

	public static void postorder(Node<?> n) {
		if (n != null) {
			postorder(n.getLeft());
			postorder(n.getRight());
			System.out.print(n.getData() + " ");
		}
	}

	public static void levelorder(Node<?> n) {
		Queue<Node<?>> nodequeue = new LinkedList<Node<?>>();
		if (n != null)
			nodequeue.add(n);
		while (!nodequeue.isEmpty()) {
			Node<?> next = nodequeue.remove();
			System.out.print(next.getData() + " ");
			if (next.getLeft() != null) {
				nodequeue.add(next.getLeft());
			}
			if (next.getRight() != null) {
				nodequeue.add(next.getRight());
			}
		}
	}

	public static void main(final String[] args) {
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
		System.out.println("Preorder");
		preorder(one);
		System.out.println("\nInorder");
		inorder(one);
		System.out.println("\nPost Order");
		postorder(one);
		System.out.println("\nlevel order");
		levelorder(one);
		System.out.println("\nWith Stack - InOrder");
		inoderWithStack(one);
	}
}