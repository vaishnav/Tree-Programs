class test{

  class Node {
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

	private Node add(int data){
		return (new Node(data));
	}


	private Node LCA(Node root, int p, int q){
		if(root==null){
			return root;
		}else{
			if(root.data == p || root.data == q){
				return root;
			}
			Node l = LCA(root.left,p,q);
			Node r = LCA(root.right,p,q);
			if(l!=null && r!=null){
				return root;
			}
			else{
				if(l!=null){
					return l;
				}else{
					return r;
				}
			}
		}
	}


	public static void main(String arg[]){
		test obj = new test();
		obj.root = obj.add(100);
		obj.root.left = obj.add(200);
		obj.root.right = obj.add(400);
		obj.root.left.left = obj.add(140);
		obj.root.left.right = obj.add(560);
		obj.root.right.left = obj.add(460);
		obj.root.right.right = obj.add(790);
		obj.root.right.right.left = obj.add(222);
		Node res = obj.LCA(obj.root,460,200);
		System.out.println(res.data);
	}
}
