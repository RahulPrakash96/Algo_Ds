/* Its just like segment trees but it can do the range sums in O(logn) times. which is much faster than the segment trees.
 * 
 */


package Tree;


public class Fenwick {
	
	int[] fenwickTree;
	
	public void updateFenwickTree(int index, int value)
	{
		for(int i=index; i<fenwickTree.length ; i+= i & (-i))
		{
			fenwickTree[i]+=value;
		}
	}
	
	public void initFenwickTree(int[] input)
	{
		fenwickTree = new int[input.length+1];
		
		for(int i=1;i<=input.length;i++)
		{
			updateFenwickTree(i,input[i-1]);
		}
		
	}
	
	public int getSum(int index)
	{
		int sum = 0;
		
		for(int i=index+1; i>0 ; i-= i & (-i))
		{
			sum+=fenwickTree[i];
		}
		
		return sum;
	}
	
	public static void main(String [] args)
	{
		int[] input = {1,2,3,4,5,6,7,8};
		
		Fenwick fw = new Fenwick();
		fw.initFenwickTree(input);
		System.out.println(fw.getSum(0));
		System.out.println(fw.getSum(2));
		System.out.println(fw.getSum(3));
		System.out.println(fw.getSum(4));
		System.out.println(fw.getSum(7));	
	}

}
