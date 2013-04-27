class Trie {
  //Create a Trie Node. Here I am assuming the the input to be ascii between 'a' and 'z'.
	class Node{
		Boolean is_end;
		int prefix_count;
		Node[] children = new Node[26];
		public Node(){
			this.is_end = false;
			this.prefix_count = 1;
		}
	}
	
	//Initialize the trie.
	Node root = null;
	public trie(){
		root = new Node();
	}

	//Add the new node to the trie recursiverly.
	private Node add(Node root, String data){
		//We stop adding new node to the tree when there are no more characters to add.
		if(data.equals("")){
			//To indicate that the word ends here.
			root.is_end = true;			
		} else {
			//Read the char at the 0th position.
			char ch = data.charAt(0);
			//Get the ascii representation. I am assuming they are between 'a' and 'z'. 
			//If you have to accept 'A-Z' then it is a slight modification. 
			int index = ch-'a';
				//If there is no child node, create one and assign it to the root's index.
			if(root.children[index]==null){
				Node temp = new Node();
				root.children[index] = add(temp, data.substring(1));				 
			}else {
				//Update the prefix count and move down the tree.
				root.prefix_count++;
				add(root.children[index], data.substring(1));
			}
		}
		return root;
	}

	
	// Function to search a string in the tire iteratively.
	private void search(Node head, String data){		
		if(data.equals("")){
			return;
		} else {
			//Read the first character.
			char ch = data.charAt(0);			
			int index = ch - 'a';
			//Save original data for display.
			String ori_data = data;
			//Iterate to the end of the word.
			while(head.children[index]!=null){				
				head = head.children[index];
				data = data.substring(1);
				//If this condition is encountered then the word is found.
				if(head.is_end == true && data.equals("")){
					System.out.println(ori_data + " found.");
					return;
				}
				//Else move on.
				ch = data.charAt(0);
				index = ch - 'a';
			}
		}		
		//If the string is a substring but not what we inserted then it is not present.
		if(!data.equals("")){
			System.out.println("Not found.");
		}
	}
	
	//This is an helper function to find the node with maximum words.
	int getMaxPrefixIndex(Node child) {
		if(child==null){
			return 0;
		}else{
			int max = 0;
			int max_index = -1;
			for(int i=0;i<26;i++){
				if(child.children[i]!=null && child.prefix_count > max) {
					max = child.children[i].prefix_count;
					max_index = i;
				}				
			}
			return max_index;
		}
	}
	
	//Get the longest string from the tire.
	void getLongestString(Node root) {
		if(root == null){
			return;
		}else {
			int index = getMaxPrefixIndex(root);
			if(index == -1){
				return;
			}
			System.out.print(Character.toString((char)('a'+index)));
			getLongestString(root.children[index]);
		}
	}
	

	public static void main(String arg[]){
		trie obj = new trie();
		String[] words = {"the","there","after","thereafter","reaf"};
		
		for(int j=0;j<words.length;j++){
		 obj.add(obj.root, words[j]);
		}

		obj.getLongestString(obj.root);
		System.out.println("");

		obj.search(obj.root,"as");
		obj.search(obj.root,"there");
	}
}
