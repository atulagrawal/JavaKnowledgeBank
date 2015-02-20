package algorithm.ds.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class TreeTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//setup tree
		Node root = new Node(10);
		root.setLeftChild(new Node(100));
		root.setRightChild(new Node(12));
		
		root.getLeftChild().setLeftChild(new Node(23));
		root.getLeftChild().setRightChild(new Node(45));
		
		root.getRightChild().setLeftChild(new Node(500));
		root.getRightChild().setRightChild(new Node(1000));
		
		//travarse tree
		System.out.println("Traversing using DFS...");
		traverseDFS(root);
		
		System.out.println("Traversing the tree with BFS...");
		traverseBFS(root);
	}

	public static void visit(Node node) {
		if(node!=null)
		System.out.println("Value = " + node.getValue());
	}
	
	public static void traverseBFS(Node node) {
		Queue<Node> que = new LinkedBlockingQueue<Node>();
		que.add(node);
		while(que.isEmpty()==false) {
			
			Node item = que.poll();
			visit(item);
			if(item.getLeftChild() !=null) que.add(item.getLeftChild());
			if(item.getRightChild() !=null) que.add(item.getRightChild());
			
		}
	}
	public static void traverseDFS(Node node) {
		if(node !=null) {
			visit(node);
			
			//traverse left child
			if(node.getLeftChild() !=null) {
				traverseDFS(node.getLeftChild());
			}
			
			//traverse right child
			if(node.getRightChild() !=null) {
				traverseDFS(node.getRightChild());
			}
			
			
		}
	}
	
}
