class  SortedArrayToBST{
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
    
    Node add(Node root, int data){
        if(root==null){
            Node temp = new Node(data);
            return temp;
        }else{
            if(data<root.data){
                root.left = add(root.left, data);
            }else{
                root.right = add(root.right, data);
            }
        }
        return root;
    }
    
    public Node createTree(Node root, Integer[] arr, int low, int high){
        if(arr.length == 0 || high<low){
            return null;
        }else{
            int mid = (high+low)/2;
            root = add(root,arr[mid]);
            root.left = createTree(root.left,arr,low,mid-1);
            root.right = createTree(root.right,arr,mid+1,high);
            return root;
        }
    }
    
    void inorder(Node root){
      if(root!=null){
    		inorder(root.left);
    		System.out.println(root.data);
    		inorder(root.right);
    	}
    }
    
    int getHeight(Node root){
    	if(root == null){
    		return 0;
    	}else {
    		return Math.max(getHeight(root.left), getHeight(root.right))+1;
    	}
    }
    
    public static void main(String arg[]){
        SortedArrayToBST obj = new SortedArrayToBST();
        Integer[] arr = {10,12,14,19,21,23,45};
        obj.root = obj.createTree(obj.root,arr,0,arr.length-1);
        obj.inorder(obj.root);
        System.out.println("The height of the tree - "+obj.getHeight(obj.root));
    }
}
