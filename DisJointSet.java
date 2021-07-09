package Tree;

import java.util.HashMap;

class Node{
	Node parent;
	int rank;
	int val;
	Node(int val)
	{
		this.val = val;
		this.rank = 0;
		this.parent = this;
	}
}
public class DisJointSet {
	
	
	HashMap<Integer,Node> nodeMap = new HashMap<>();
	
	public void makeSet(int val)
	{
		Node n = new Node(val);
		nodeMap.put(val,n);
	}
	
	public void union(int n1, int n2)
	{
		Node node1 = nodeMap.get(n1);
		Node node2 = nodeMap.get(n2);
		
		Node parent1 = node1.parent;
		Node parent2 = node2.parent;
		
		if(parent1.rank >= parent2.rank)
		{
			parent1.rank = (parent1.rank == parent2.rank) ? parent1.rank+1 : parent1.rank;
			
			parent2.parent = parent1;
			
		}
		else
		{
			parent1.parent = parent2;
		}
	}
	
	public Node getParent(Node n)
	{
		if(n.parent == n)
			return n;
		
		n.parent = getParent(n.parent);
		
		return n.parent;
	}
	
	public int getSet(int val)
	{
		Node n = nodeMap.get(val);
		n = getParent(n);
		return n.val;
	}

	public static void main(String [] args)
	{
		int[] input = {1,2,3,4,5,7,8,6};
		
		DisJointSet djs = new DisJointSet();
		
		for(int i : input)
		{
			djs.makeSet(i);
		}
		
		djs.union(1,2);
		djs.union(2,3);
		
		System.out.println(djs.getSet(2));
		System.out.println(djs.getSet(3));
		System.out.println(djs.getSet(1));
		System.out.println(djs.getSet(4));
		System.out.println(djs.getSet(8));
		djs.union(4,3);
		System.out.println(djs.getSet(4));
		
		
		
	}
}
