import java.util.Stack;
import java.util.EmptyStackException;
class nthElement{

  // Define the BST node.
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

	// Function to add nodes in a BST.
	public Node add(Node root, int data){
		if(root==null){
			Node temp = new Node(data);
			return temp;
		}else{
			if(root.data<data){
				root.right = add(root.right,data);
			}else{
				root.left = add(root.left,data);
			}
			return root;
		}
	}

	public void nth(Node root,int k){
		if(root==null){
			return;
		} else{
			Node left_node = root;
			Node current_element = null;			
			Stack<Node> s = new Stack<Node>();

			// Traverse to the left most part to the tree.
			while(left_node!=null){
				s.push(left_node);
				left_node = left_node.left;
			}

			while(true){
				// If there is an empty stack that means the k value is more than the 
				// the number of lead nodes in the graph.
				try{
					current_element = s.pop();
					k--;
				} catch(EmptyStackException e){
					System.out.println("Invalid number.");
					break;
				}

				// Go down the left subtree of the right node to find out the next 
				// inordr successor.
				if(current_element.right != null){
					left_node = current_element.right;
					while(left_node!=null){
						s.push(left_node);
						left_node = left_node.left;
					}
				}

				//If we have reached the desired node print it an exit.
				if(k==0){
					System.out.println("Node at the requested position "+ ele.data);
					break;
				}
			}
		}
	}

	public static void main(String arg[]){
		nthElement o = new nthElement();
		o.root = o.add(o.root,100);
		o.root = o.add(o.root,150);
		o.root = o.add(o.root,200);
		o.root= o.add(o.root,50);
		o.root = o.add(o.root,75);
		o.nth(o.root,20);
	}
}
