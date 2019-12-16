
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
	
	Stack<BNode> stk = new Stack<BNode>(); 
	
	public BNode insertTree(BNode p, int key){
		if( p == null)
			p = new BNode(key);
		else if(key < p.data)
			p.left = insertTree(p.left, key);
		else
			p.right = insertTree(p.right, key);
		return p;
	}
	// Inorder using recursion
	public void inOrder(BNode p)
	{
		if(p != null)
		{
			inOrder(p.left);
			System.out.print(p.data+" ");
			inOrder(p.right);
			}
		}
	// Inorder using Iteration
	public void inorderIterative(BNode p)
   {   if(p == null )   
	   { System.out.println("Tree is empty");    
		   return; 
		 }
	    while( !stk.isEmpty() || p != null )   
	    {    if( p != null )    
			{ stk.push(p); // push left-most path onto stack    
			  p = p.left;    
			  }   
			 else    
			 {     
				 p = stk.pop(); // assign popped node to p     
				 System.out.print(p.data + " "); // print node data     
				 p = p.right; // move p to right subtree 
				}
			}
		}
	// Preorder using recursion
	public void preOrder(BNode p)
	{
		if(p != null)
		{
			System.out.print(p.data+" ");
			preOrder(p.left);
			preOrder(p.right);
			}
		}
	// Preorder using Iteration
	public void preorderIterative(BNode p)  
	{   if(p == null )   
		{ System.out.println("Tree is empty");    
			return;   
			}   
		stk.push(p);   
		while( !stk.isEmpty() )   
		{    p = stk.pop();    
			if( p != null )    
			{   System.out.print(p.data + " ");     
				stk.push(p.right);     
				stk.push(p.left);    
			}  
		}
	} 
	// Postorder using recursion
	public void postOrder(BNode p)
	{
		if(p != null)
		{
			postOrder(p.left);
			postOrder(p.right);
			System.out.print(p.data+" ");
			}
		}
	// Postorder using iteration
	 public void postorderIterative(BNode p)  
	 {   if(p == null )   
		 { System.out.println("Tree is empty");    
			 return;   
			 }   
		BNode tmp = p;   
		while( p != null )   
		{    while( p.left != null )    
			{ stk.push(p);     
			  p = p.left;    
				} 
	   while( p != null && (p.right == null || p.right == tmp ))    
	   { System.out.print(p.data + " "); // print node data     
		 tmp = p;     
		 if( stk.isEmpty() )      
		 return;     
		 p = stk.pop();    
		 }         
		 stk.push(p);    
		 p = p.right;   
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
public class BSTInPrePost {
	
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
		System.out.println("The Inorder of tree using recurrsion is: ");
		bst.inOrder(root1);
		//~ System.out.println("\nThe Preorder of tree using recurrsion is: ");
		bst.preOrder(root1);
		//~ System.out.println("\nThe Postorder of tree using recurrsion is: ");
		bst.postOrder(root1);
		System.out.println("\nThe Inorder of tree using iteration is: ");
		bst.inorderIterative(root1);
		//~ System.out.println("\nThe Preorder of tree using iteration is: ");
		bst.preorderIterative(root1);
		//~ System.out.println("\nThe Postorder of tree using iteration is: ");
		bst.postorderIterative(root1);
		
	}
}

