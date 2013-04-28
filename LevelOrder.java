import java.util.*;
class Main{
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
        
    public Node add(int data) {
        Node temp = new Node(data);
        return temp;
    }
    
    Node root = null;
    

    // Iterative method.
    void levelOrder(Node root){
        if(root==null){
            return;            
        } else {
            int level_count = 1;
            int present_count = 0;
            Queue<Node> q = new LinkedList<Node>();
            q.add(root);
            while(!q.isEmpty()){
                Node temp = q.poll();
                if(temp.left!=null){
                    q.add(temp.left);
                    present_count++;
                }
                if(temp.right!=null){
                    q.add(temp.right);
                    present_count++;
                }
                level_count--;
                System.out.print(temp.data+ " ");
                if(level_count == 0){
                    System.out.println();
                    level_count = present_count;
                    present_count = 0;
                }
                
            }
        }
    }
    
    public static void main(String arg[]){
        Main obj = new Main();
        obj.root = obj.add(100);    
        obj.root.left = obj.add(50);
        obj.root.right = obj.add(150);
        obj.root.left.left = obj.add(25);
        obj.root.left.right = obj.add(75);
        obj.root.right.left = obj.add(125);
        obj.root.right.right = obj.add(175);
        obj.root.right.right.right = obj.add(185);
        obj.levelOrder(obj.root);
    }
}
