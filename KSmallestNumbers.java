import java.util.Comparator;
import java.util.PriorityQueue;

% MaxHeap
class maxHeap implements Comparator<Integer> {
  public int compare(Integer n, Integer m){
		return (m-n);
	}
}

public class KSmallestNumbers {
	public static void main(String[] arg) {
		Comparator<Integer> cmp = new maxHeap();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(3,cmp);
		
    % Input array
    Integer[] arr = {10,2,34,455,12,34,567,123,454,677,120,356,124};
    
    % Build heap.
		int i=1;
		for(Integer num:arr){
			if(i<=3){
				q.add(num);
			} else {
				if(num < q.peek()){
					q.poll();
					q.add(num);
				}
			}
			i++;
		}
	
    % Print the contents of the heap.
		for(Integer num:q){
			System.out.println(num);
		}
	}
}
