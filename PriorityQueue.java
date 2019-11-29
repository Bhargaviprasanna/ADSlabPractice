
import java.util.*;
class Node{
	int data;
	Node next;
	int pr;
	Node(int i, int p){
		data = i;
		pr = p;
		}
	}
class LPQueue{
	Node head;
	public void insert(int item, int pt)
	{
		Node tmp = new Node(item, pt);
		int k;
		if(head == null)
		{
			head = tmp;
			head.next = null;
			}
		else if(tmp.pr > head.pr)
		{
			Node x = head;
			head = tmp;
			tmp.next = x;
			}
		else
		{
			Node p=head;
			Node prev=p;
			Node bnode = null;
			while( p != null)
			{
				if(tmp.pr > p.pr){
					bnode = p;
					break;
					}
				else
				{
					prev = p;
					p = p.next;
					}
				}
			tmp.next = bnode;
			prev.next = tmp;
			}
		}
	public Node delete(){
		if(isEmpty())
			return null;
		Node tmp = head;
		head = head.next;
		return tmp;
		}
	public void displatPq()
	{
		Node p = head;
		System.out.println("Priority Queue: ");
		while(p != null){
			System.out.println(p.data+" priority is "+p.pr);
			p = p.next;
			}
		System.out.println();
		}
	public boolean isEmpty()
	{
		return (head == null);
		}
		
		
	}
public class PriorityQueue {
	
	public static void main (String[] args) {
		
		LPQueue pq = new LPQueue();
		int s;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size and then few elements with priority: ");
		s = sc.nextInt();
		for(int i=0; i<s; i++)
			pq.insert(sc.nextInt(),sc.nextInt());
		pq.displatPq();
		pq.delete();
		pq.displatPq();
		
	}
}

