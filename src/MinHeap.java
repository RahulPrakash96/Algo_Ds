package Tree;

import java.util.ArrayList;
import java.util.List;

public class MinHeap {
	
	List<Integer> values;
 
	
	public MinHeap(int[] values)
	{
		this.values = new ArrayList<>();
		
		for(int v : values)
		{
			add(v);
		}
	}
	
	public void add(int val)
	{
		int index = values.size();
		values.add(val);
		
		while(index>0 && values.get((index-1)/2) > values.get(index))
		{
			int temp = values.get((index-1)/2);
			values.set((index-1)/2, values.get(index));
			values.set(index, temp);
			index = (index-1)/2;
		}
	}
	
	public void heapiFy(int index)
	{	
		int min = index;
		
		if((index*2)+1 < values.size() && values.get(min) > values.get(index*2+1))
		{
			min = (index*2)+1;
		}
		if(index*2+2 < values.size() && values.get(min) > values.get(index*2+2))
		{
			min = index*2+2;
		}
		if(min!=index)
		{
			int temp = values.get(index);
			values.set(index,values.get(min));
			values.set(min, temp);
			heapiFy(min);
		}
	}
	
	public int extractMin()
	{		
		int val = values.remove(values.size()-1);
		
		if(values.size()==1)
			return val;
		
		int min = values.get(0);
		
		values.set(0, val);
		
		heapiFy(0);
		
		return min;
		
	}
	
	
	public static void main(String [] args)
	{
		int input[]= { 5,6,2,1,9,7,3,8,4};
		MinHeap minHeap = new MinHeap(input);
		System.out.println(minHeap.values);
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		System.out.println(minHeap.extractMin());
		
	}

}
