import java.util.*;
public class ReverseLevelOrder{
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
	
	class LevelIter<Node> implements Iterable<Node> {
		Stack<Node> s = null;
		public LevelIter(Stack<Node> s) {
			this.s = (Stack<Node>)s.clone();
		}
		public Iterator<Node> iterator(){
			Iterator<Node> it = new Iterator<Node>() {
				private int index = 0;
				
				@Override
				public boolean hasNext(){
					return (index < s.size() && !s.isEmpty());
				}
				
				@Override
				public Node next(){
					return s.pop();
				}
				
				@Override
				public void remove(){
					s.pop();
				}
			};
			return it;
		}
	}
	
	Node root = null;
	public ReverseLevelOrder(int data) {
		root = new Node(data);
	}
	
	private Node add(int data) {
		return new Node(data);
	}
	
	private void reverseLevel(Node root) {
		Stack<Node> s = new Stack<Node>();
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);		
		while(!q.isEmpty()){
			Node temp = q.poll();
			if(temp.right!=null){
				q.add(temp.right);
			}
			if(temp.left!=null){
				q.add(temp.left);
			}			
			s.add(temp);
		}
		LevelIter<Node> l = new LevelIter<Node>(s);
		for(Node n:l){
			System.out.println(n.data);
		}
	}	
	
	
	public static void main(String arg[]){
		ReverseLevelOrder obj = new ReverseLevelOrder(100);
		obj.root.left = obj.add(20);
		obj.root.right = obj.add(400);
		obj.root.left.left = obj.add(13);
		obj.root.left.right = obj.add(34);
		obj.root.right.left = obj.add(156);
		obj.root.right.right = obj.add(590);
		obj.reverseLevel(obj.root);
	}
}
