import java.util.*;
class BNode{
	int data;
	BNode left;
	BNode right;
	BNode(int i)
	{
		data = i;
	}
	}
class BSTOp{
	
	public BNode insertTree(BNode p, int key){
		if( p == null)
			p = new BNode(key);
		else if(key < p.data)
			p.left = insertTree(p.left, key);
		else
			p.right = insertTree(p.right, key);
		return p;
	}
	public void bDisplay(BNode p)
	{
		if(p != null)
		{
			bDisplay(p.left);
			System.out.print(p.data+" ");
			bDisplay(p.right);
			}
		}
	public int leafNode(BNode p){
		int count=0;
		if(p != null)
		{
			if((p.left == null) && (p.right == null))
				{
					count = 1;
					System.out.print("leaf nodes "+p.data);
					}
			count = count+leafNode(p.left)+leafNode(p.right);
			}
		return count;
		}
	public BNode search(BNode p, int key)
	{
		while( p != null)
		{
			if(key < p.data)
				p = p.left;
			else if(key > p.data)
				p = p.right;
			else
				return p;
			}
		return null;
		}
	public BNode deleteTree(BNode root, int key)
	{
		BNode p,d;
		BNode parent=root;
		if(root == null)
			return null;
		p = root;
		while(p!=null && p.data != key)
		{
			parent = p;
			if(key < p.data)
				p=p.left;
			else
				p=p.right;
			}
		if(p == null )
			return null;
		d = p;
	// if key is a leaf node
	    if(p.left == null && p.right == null)	
		{
			if(parent.left == p)
				parent.left = null;
			else
				parent.right = null;
			}
	// key has left subtree
		if(p.left != null && p.right == null)
		{
			if(parent.left == p)
				parent.left = p.left;
			else
				parent.right = p.left;
			}
	// key has right subtree
		if(p.left == null && p.right != null)
		{
			if(parent.left == p)
				parent.left = p.right;
			else
				parent.right = p.right;
			}
	// key has both left and right subtrees then we can either replace key with smallest node in right subtree or largest node in left subtree
		if(p.left != null && p.right != null)
		{
			parent = p;
			BNode smallRight = p.right;
			while(smallRight != null)
			{
				parent = smallRight;
				smallRight = smallRight.left;
				}
			p.data = smallRight.data;
			p = smallRight;
			}
		return d;
		}
	}
public class BSTImple {
	
	public static void main (String[] args) {
		
		BSTOp bst = new BSTOp();
		BNode root = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size: ");
		int n = sc.nextInt();
		int a[];
		a = new int[n];
		for(int i=0; i<n; i++)
			root = bst.insertTree(root,sc.nextInt());
		BNode root1 = root;
		bst.bDisplay(root1);
		System.out.println("leaf nodes count:"+bst.leafNode(root1));
		System.out.println("Enter ele that is to be deleted: ");
		int x = sc.nextInt();
		System.out.println("The deleted node is: "+bst.deleteTree(root1,x));
		bst.bDisplay(root1);
		System.out.println("Enter ele that is to be searched: ");
		int s = sc.nextInt();
		System.out.println("The searched node is: "+bst.search(root1,s));
	}
}

