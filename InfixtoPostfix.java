
package infixtopostfix;
import java.util.*;
public class InfixtoPostfix {
    static int Precedence(char a)
    {
        switch(a)
        {
            case '*':
            case '/': return 2;
            case '+':
            case '-': return 1;   
            case '^':return 3;    
        }
        return -1;
    }

    static String Conversion(String ex)
        {
            Stack<Character> stack = new Stack<>();
            System.out.println("The string is: "+ex);
            char ch;
            String res = new String("");
             for(int i=0;i<ex.length();++i)
             {  
                 ch=ex.charAt(i);
                 if(Character.isLetterOrDigit(ch))
                     res+=ch;
                 else if(ch == '(')
                     stack.push(ch);
                 else if(ch == ')')
                 {  
                     while(!stack.isEmpty() && stack.peek()!= '(')
                          res+=stack.pop();
                     if(!stack.isEmpty() && stack.peek()!= '(')
                         return "Invalid expression";
                     else
                         stack.pop();
                 }
                 else
                 {  
                     while(!stack.isEmpty() && Precedence(ch)<= Precedence(stack.peek()))
                     {  
                         if(stack.peek()== '(')
                             return "Invalid Expression";
                         res+=stack.pop();
                     }
                     stack.push(ch);
                 }
                      
             }
             while(!stack.isEmpty())
             {  
                 if(stack.peek()== '(')
                     return "Invalid Expression";
                 res+=stack.pop();
             }
             return res;
        }
    public static void main(String[] args) {
       String ex = new String();
       Scanner s = new Scanner(System.in);
       ex=s.nextLine();
       System.out.println(Conversion(ex));
    }
  }
       
      
     