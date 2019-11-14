
import java.util.*;
interface Dq <Integer> {
	public void addFirst(int item);
	public void addLast(int item);
	public int removeFirst();
	public int removeLast();
	public boolean isEmpty();
	
	}
class DoubleLinkedDequeue implements Dq{
	
	public class DequeNode {  
		  DequeNode prev;
		  int data;   
		  DequeNode next;   
		  DequeNode( int item )
		  {
			  data = item;
			  }
		  } 
		  private DequeNode first, last;
		  private int count;  
		  public void addFirst(int item) { 
			  if( isEmpty() )    
			  {first = new DequeNode(item); last=first; }  
			  else  { 
				  DequeNode tmp = new DequeNode(item);    
				  tmp.next = first;    
				  first.prev = tmp;    
				  first = tmp;   
				  }   
				  count++;  
				  }
		public void addLast(int item)  
		{   if( isEmpty() )    
			{first = new DequeNode(item);   last=first;}
			else   { 
				DequeNode tmp = new DequeNode(item);
				tmp.prev = last;    
				last.next = tmp;    
				last = tmp;   
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
				first.prev = null;    
				count--;     
				return item;  
				 }  }
		public int removeLast()  {   
			if( isEmpty() )   { 
				System.out.println("Deque is empty");
				    return 0;   }   
		    else   { 
				int item = last.data;    
				last = last.prev;    
				last.next = null;    
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
	}

public class DequeueDL {
	
	public static void main (String[] args) {
		DoubleLinkedDequeue dqdl = new DoubleLinkedDequeue();
		dqdl.addFirst(10);
		dqdl.addLast(20);
		dqdl.addFirst(30);
		dqdl.display();
		System.out.println("After removing first "+dqdl.removeFirst());
		dqdl.display();
		System.out.println("After removing last "+ dqdl.removeLast()); 
		dqdl.display();
	}
}

