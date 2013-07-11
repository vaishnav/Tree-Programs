import java.util.*;
public class SpiralTraversal{
  class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
	
	
	Node root = null;
	public ReverseLevelOrder(int data) {
		root = new Node(data);
	}
	
	private Node add(int data) {
		return new Node(data);
	}
	
	
	private void spiralTraverse(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Queue<Node> q1 = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty() || !q1.isEmpty()){
			
			while(!q.isEmpty()) {
				Node temp = q.poll();			
				System.out.print(temp.data+" ");
				if(temp.left!=null){
					q1.add(temp.left);
				}
				if(temp.right!=null){
					q1.add(temp.right);
				}
			}
			System.out.println("");
			while(!q1.isEmpty()){
				Node temp = q1.poll();
				System.out.print(temp.data+" ");
				if(temp.left!=null){
					q.add(temp.left);
				}
				if(temp.right!=null){
					q.add(temp.right);
				}
			}
			System.out.println("");
		}
	}
	
	
	public static void main(String arg[]){
		SpiralTraversal obj = new SpiralTraversal(100);
		obj.root.left = obj.add(20);
		obj.root.right = obj.add(400);
		obj.root.left.left = obj.add(13);
		obj.root.left.right = obj.add(34);
		obj.root.right.left = obj.add(156);
		obj.root.right.right = obj.add(590);
		obj.spiralTraverse(obj.root);
	}
}
