import java.util.*;

interface Dq <Integer> {
	public void addFirst(int item);
	public void addLast(int item);
	public int removeFirst();
	public int removeLast();
	public boolean isEmpty();
	public void display();
	public int Size();
	
	}
class DequeueImple implements Dq{
	
	public class DequeNode {  
		  int data;   
		  DequeNode next;   
		  DequeNode( int item )
		  {
			  data = item;
			  }
		  } 
		  private DequeNode first,last,x;
		  private int count=0;  
		  public void addFirst(int item) { 
			  if( isEmpty() )    
			  {first = new DequeNode(item); last=first;}  
			  else  { 
				  DequeNode tmp = new DequeNode(item);    
				  tmp.next = first;       
				  first = tmp;   
				  }   
				  count++;  
				  }
		public int removeFirst()  {   
			if( isEmpty() )   
			{ System.out.println("Deque is empty");    
				return 0;   }   
			else   { 
				int item = first.data;    
				first = first.next;       
				count--;     
				return item;  
				 }  }
		public void addLast(int item)  
		{   if( isEmpty() )    
			{first = new DequeNode(item); last=first;}
			else   { 
				DequeNode tmp = new DequeNode(item);
				last.next = tmp;    
				last = tmp; 
				}   
				count++;  
				}
		public int removeLast()  {   
			if( isEmpty() )   { 
				System.out.println("Deque is empty");
				    return 0;   }   
		    else   { 
				DequeNode p=first;
				int j=0;
				while(j != (Size()-1))
				{ 
					x=p;
					p=p.next;
					j++;
				}
				System.out.println(last+" "+x);
				int item = last.data;      
				x.next = null;
				last=x;    
				count--;     
				return item;   
				}  }
		public void display()  { 
			DequeNode p = first;   
			System.out.print("Deque:");   
			while( p != null )   { 
				System.out.print( p.data + " " );    
				p = p.next;   
				}    
				System.out.print("\n");
				}     
		public boolean isEmpty()  { 
			return (count == 0); 
			 }   
		public int Size()
		{
			return count;
			}
	}
public class DequeueSL {
	
	public static void main (String[] args) {
		DequeueImple dsl = new DequeueImple();
		dsl.addFirst(10);
		dsl.addFirst(20);
		dsl.addFirst(30);
		dsl.display();
		dsl.removeFirst();
		dsl.addLast(5);
		dsl.display();
		System.out.println("The removed last "+dsl.removeLast());
		dsl.display();
		
	}
}

