import java.util.*;
import java.io.*;
interface Mystack
{	
	public void pop();
	public void push();
	public void display();
	}
class StackOpera implements Mystack{
	
	Scanner sc = new Scanner(System.in);
	//~ System.out.println("Enter Size of Array: ");
	int n = sc.nextInt();
	int stack[]=new int[n];
	int top=-1;
	public void push()
	{	
		if(top == (n-1))
		{	System.out.println("Stack Overflow");
			return ;
		}
		else
		{
			System.out.println("Enter element: ");
			int ele = sc.nextInt();
			stack[++top]=ele;
		}
	}
	public void pop()
	{	
		if(top < 0)
		{	
			System.out.println("Stack is Empty");
			return;
		}
		else{
			int popped = stack[top];
			top--;
			System.out.println("Popped element is: "+popped);
		}
	}
	public void display()
	{
		if(top < 0)
		{	
			System.out.println("Stack is Empty");
			return;
		}
		else
		{
			int x;
			for(int i=0;i<=top;i++)
				System.out.println(stack[i]);
		}
	}
	
	}
public class StackAdt{
	
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		StackOpera st = new StackOpera();
		System.out.println("Enter size: ");
		int size=sc.nextInt();
		System.out.println("1.For Push \n 2.For Pop \n 3.For Display");
		int ch;
		ch=sc.nextInt();
		switch(ch)
		{	
			case 1: for(int i=0;i<size;i++)
						st.push();
					break;
			case 2:
					st.pop();
					break;
			case 3: 
			        st.display();
		}
		//~ st.push();
		//~ st.push();
		//~ st.push();
		//~ st.pop();
		//~ st.display();
		
	}
}

