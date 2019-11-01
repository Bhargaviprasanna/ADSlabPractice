import java.util.*;
interface ListAdt<Integer>{
		void add_front(int e);
		public int remove();
		public int length(); 
		public boolean isEmpty();
		void add_back(int e);
		void add_pos(int pos, int e);
		public int get_curr(); 
		public int get_atindex(int ind);
		public int get_last();
		public void remove_atpos(int pos);
		}
class ListOpera<Integer> implements ListAdt<Integer>{
		
		private int lA[];
		private int msize;
		private int listsize;
		private int curr;
		ListOpera()
		{	
			Scanner sc = new Scanner(System.in);
			int size = sc.nextInt();
			lA = new int[size];
			msize = size;
			listsize = curr = 0;
			}
		public void add_front(int ele)
		{
			if(listsize >= msize)
			{	
				System.out.println("Maxsize exceeded");
				return;
			}
			else
			{
				for(int i=listsize;i>curr;i--)
					lA[i] = lA[i-1];
				lA[curr]=ele;
				listsize++;
				}
			}
		public void add_back(int  ele)
		{
			if(listsize >= msize)
			{ 
				System.out.println("Maxsize exceeded");
				return;
			}
			lA[listsize++] = ele;
			return;
		}
		public int remove() {
			if((curr<0) || (curr>=listsize)) return 0;
			int  removed = lA[curr];
			for(int i=curr; i<listsize-1; i++)
				lA[i] = lA[i+1];
			listsize--;
			return removed;
		}
		void display()
		{	int i;
			for(i=0;i<listsize-1;i++)
				System.out.print(lA[i]+"<-->");
			System.out.print(lA[i]);
			
			return;
		}
		public int length()
		{
			return listsize;
			}
		public boolean isEmpty()
		{
			if(listsize == 0)
				return true;
			else
				return false;
			}
		public int get_atindex(int ind) 
		{
			if ((curr < 0) || (curr >= listsize)) 
			{
				System.out.println("Searching outside the list");
				return 0;
			}	
        return lA[ind];
     }
     public int get_last() 
		{
			if ((curr < 0) || (curr >= listsize)) 
			{
				System.out.println("Searching outside the list");
				return 0;
			}	
        return lA[listsize];
	   }
	public int get_curr() 
		{
			if ((curr < 0) || (curr >= listsize)) 
			{
				System.out.println("Searching outside the list");
				return 0;
			}	
        return lA[curr];
		}
	public void add_pos(int pos, int ele)
	{	
		listsize++;
		int i = listsize;
		for(;i>=pos;)
		{	lA[i+1]=lA[i];
			System.out.println(lA[i]+" "+i);
			i--;
		}
		lA[pos]=ele;
		
		}
	public void remove_atpos(int pos)
	{	
		int i;
		for(i=pos;i<listsize;i++)
		{	lA[i]=lA[i+1];
			System.out.println(lA[i]+" "+i);
			
		}
		listsize--;
		
		}
	}
public class ListImple{
	
	public static void main (String[] args) {
		ListOpera<Integer> lo = new ListOpera<>();
		Scanner sc = new Scanner(System.in);
		System.out.println("Add a few elements ");
		int few = sc.nextInt();
		for(int i=0;i<few;i++)
			lo.add_front(sc.nextInt());
		lo.add_back(23);
		lo.display();
		System.out.println("\nRemoved element is "+lo.remove());
		lo.display();
		System.out.println("The length of list is "+lo.length());
		if(!lo.isEmpty())
			System.out.println("The list is not empty");
		else
			System.out.println("The list is empty");
		System.out.println("The value of list first element is "+lo.get_curr());
		System.out.println("The value of list last element is "+lo.get_last());
		System.out.println("Enter index of element to be found in list");
		int ind = sc.nextInt();
		System.out.println("The value of list at index"+ind+"  is "+lo.get_atindex(ind));
		int pos,e;
		pos = sc.nextInt();
		e=sc.nextInt();
		lo.add_pos(pos,e);
		System.out.println("The element "+e+" adds at position "+pos);
		lo.display();
		pos = sc.nextInt();
		lo.remove_atpos(pos);
		System.out.println("The element removed at position "+pos);
		lo.display();
	}
}

