
import java.util.*;

class CQueue {
	 
	 static int front,rear,size;
	static int q[];
	CQueue(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter size of queue: ");
	size=sc.nextInt();
	q=new int[size];
	front=-1;
	rear=-1;
	}
	public void add(int v){
		if((rear == size-1 && front==0))
		{	
			System.out.println("Queue is full");
			return;
		}
		else if((rear == size-1) && (front!=0))
			rear=0;
		else if(front == -1)
		{
			front=0; rear=0;
			}
		else
			rear++;
		q[rear]=v;
	}
	public int del(){
		int v;
		if(front == -1)
			{
				System.out.println("Queue is empty!");
				return 0;
				}
		v = q[front];
		q[front]=-1;
		if(front == rear)
			{front = -1; rear = -1;}
		else if(front == size-1)
				front=0;
		else
		front++;
		return v;
		}
	public void disp()
	{	
		int i;
		//~ System.out.println("\n front , rear"+front+rear);
		if(front == -1)
		{
			System.out.println("Queue is empty!");
				return;
			}
		if(front<= rear)
		{	for(i=front; i<=rear; i++)
				System.out.print(q[i]+" ");
			}
		else
		{
			for(i=front; i<=size-1; i++)
				System.out.print(q[i]+" ");
			for(i=0; i<=rear; i++)
				System.out.print(q[i]+" ");
		}
	}
}
public class CircleQueue {
	
	public static void main (String[] args) {
		
		CQueue qa = new CQueue();
		Scanner sc = new Scanner(System.in);
		System.out.println("The Queue is empty so enter x elements");
		int x = sc.nextInt(); 
		for(int i=0;i<x;i++)
			qa.add(sc.nextInt());
		qa.disp();
		qa.del();
		qa.disp();
		//~ qa.del();
		qa.add(sc.nextInt());
		qa.disp();
		//~ qa.add(sc.nextInt());
		//~ qa.disp();
		
	}
}
