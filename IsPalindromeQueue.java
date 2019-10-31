
import java.util.*;
public class IsPalindromeQueue
{
	static int Check(String st)
	{	
		//~ Stack<Character> stack = new Stack<>();
		Queue q = new LinkedList();
		String rev = "";
		for(int i=st.length()-1;i>=0;i--)
			q.add(st.charAt(i));
		while(!q.isEmpty())
			rev+=q.remove();
		System.out.println(rev);
		if(st.equals(rev))
			return 1;
		else
			return 0;
		
		}
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String st = sc.nextLine();
		int ot=Check(st);
		if(ot == 1)
			System.out.println("The string "+st+" is a palindrome");
		else
			System.out.println("The string is "+st+" not a palindrome");
	}
}
