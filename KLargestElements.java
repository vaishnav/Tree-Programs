import java.util.Comparator;
import java.util.PriorityQueue;

//MinHeap
class minHeap implements Comparator<Integer> {
  public int compare(Integer n, Integer m){
		return (n-m);
	}
}

public class KLargestElements {
	public static void main(String[] arg) {
  
		Comparator<Integer> cmp = new minHeap();
		PriorityQueue<Integer> q = new PriorityQueue<Integer>(3,cmp);
		
    % Given input array of numbers.
    Integer[] arr = {10,2,34,455,12,34,567,123,454,677,120,356,124};
		
    % Building the heap.
    int i=1;	  
    for(Integer num:arr){
			if(i<=3){
				q.add(num);
			} else {
				if(num > q.peek()){
					q.poll();
					q.add(num);
				}
			}
			i++;
		}
		
        		
    % Iterator to print all the values in the heap.
    for(Integer num:q){
			System.out.println(num);
		}
    
	}
}
