class FindNodeDepth{

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


	private int depthNode(Node root, int data, int level){
		if(root==null){
			return 0;
		}else{
			if(root.data == data){
				return level;
			}

			int left = depthNode(root.left, data, level+1);
			int right = depthNode(root.right, data, level+1);

			return Math.max(left,right);
		}
	}

	public static void main(String arg[]){
		FindNodeDepth obj = new FindNodeDepth();
		obj.root = obj.add(100);
		obj.root.left = obj.add(200);
		obj.root.right = obj.add(400);
		obj.root.left.left = obj.add(140);
		obj.root.left.right = obj.add(560);
		obj.root.right.left = obj.add(460);
		obj.root.right.right = obj.add(790);
		obj.root.right.right.left = obj.add(222);
		int res = obj.depthNode(obj.root,14,1);
		System.out.println(res);
	}
}
