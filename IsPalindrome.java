
import java.util.*;
public class IsPalindrome 
{
	static int Check(String st)
	{	
		Stack<Character> stack = new Stack<>();
		String rev = "";
		for(int i=0;i<st.length();i++)
			stack.push(st.charAt(i));
		while(!stack.isEmpty())
			rev+=stack.pop();
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

