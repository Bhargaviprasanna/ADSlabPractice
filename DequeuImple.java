
import java.util.*;
interface Dq <Integer> {
	public void addFirst(int item);
	public void addLast(int item);
	public int deleteFirst();
	public int deleteLast();
	public boolean isEmpty();
	public int Size();
	}
class DqueueOp implements Dq
{
	static int first,last,size,count;
	static int q[];
	DqueueOp(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter size of queue: ");
	size=sc.nextInt();
	q=new int[size];
	first=-1;
	last=-1;
	count=0;
	}
	public void addLast(int item)
	{
		if(count == size)
			{	
				System.out.println("The Queue is Full");
				return;
				}
			last++;
			q[last]=item;
			if(first == -1 && last == 0)
				first=0;
		count++;
		}
	public void addFirst(int item)
	{
		if(count == size)
		{
			System.out.println("The Queue is Full");
				return;
			}
		if(first == 0)
			first = size-1;
		else if(first > 0)
		{	
		
		first--;
		}
		q[first]=item;
		count++;
		}
	public int deleteLast()
	{
		System.out.println("Last is "+last+"First is "+first);
		if(count == 0)
		{	
			System.out.println("The queue is empty");
			return 0; }
		int x = q[0];
		for(int i=0;i<=last;i++)
			q[i]=q[i+1];
		last--;
		count--;
		return x;
		}
	public int deleteFirst()
	{
		System.out.println("Last is "+last+"First is "+first);
		if(count == 0)
		{	
			System.out.println("The queue is empty");
			return 0; }
		int x = q[size-1];
		for(int i=size-1;i>first;i--)
			q[i]=q[i-1];
		first++;
		count--;
		return x;
		}
	public void display()
	{	
		System.out.println("");
		if(count == 0)
			return;
		for(int i=0;i<=last;i++)
			System.out.print(q[i]+" ");
		for(int i=first;i<=size-1;i++)
			System.out.print(q[i]+" ");
		
		}
		public boolean isEmpty()
		{
			return (count == 0);
			}
		public int Size()
		{
			return count;
			}
}
public class DequeuImple {
	
	public static void main (String[] args) {
		DqueueOp dq = new DqueueOp();
		dq.addLast(10);
		dq.addFirst(20);
		dq.addLast(30);
		dq.addFirst(40);
		dq.display();
		dq.addFirst(50);
		dq.display();
		dq.deleteLast();
		dq.display();
		dq.deleteFirst();
		dq.display();
		System.out.println("The queue is empty "+dq.isEmpty());
		System.out.println("The queue size is "+dq.Size());
		
	}
}

