import java.util.*;

class QueueOpera{
	static int front,rear,size;
	static int q[];
	QueueOpera(){
	Scanner sc = new Scanner(System.in);
	System.out.println("Enter size of queue: ");
	size=sc.nextInt();
	q=new int[size];
	front=0;
	rear=0;
	}
	static void qEnqueue(int e)
	{	
		if(rear == size)
		{	
			System.out.println("The Queue is Full");
			return;
		}
		else
		{	
			q[rear]=e;
			rear++;
		}
		return;
	}
	static void qDequeue()
	{	
		if(rear == front)
		{	
			System.out.println("The Queue is empty");
			return;
		}
		else
		{	int del = q[front];
			System.out.println("The delete element is "+del);
			for(int i=0;i<rear-1;i++)
				q[i]=q[i+1];
		}
		rear--;
		return;
	}
	static void qDisplay()
	{	
		if(rear == front)
		{	
			System.out.println("The Queue is empty");
			return;
		}
		else
		{	System.out.println("The Queue elements are");
			for(int i=front;i<rear;i++)
				System.out.print(q[i]+" ");
		}
		return;
	}
	}
public class QueueImple {
	
	public static void main (String[] args) {
		
		QueueOpera qa = new QueueOpera();
		Scanner sc = new Scanner(System.in);
		System.out.println("The Queue is empty so enter x elements");
		int x = sc.nextInt(); 
		for(int i=0;i<x;i++)
			qa.qEnqueue(sc.nextInt());
		qa.qDequeue();
		qa.qDisplay();
		
	}
}

