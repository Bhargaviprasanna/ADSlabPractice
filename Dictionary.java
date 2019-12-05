

import java.util.*;

class Entry{
	public int key;
	public String value;
	public Entry(int k, String name)
	{
		key = k;
		value = name;
	}
}
class Hashtable{
	
	Entry[] ha;
	int size;
	int count;
	public Hashtable(int s)
	{
		size = s;
		count = 0;
		ha = new Entry[size];
		}
	int hashFun(int k)
	{
		int hkey;
		hkey = k % size;
		if(hkey < 0)
			hkey += size;
		return hkey;
		}
		public void insert(int k, String str)
		{	
			if(!isFull()){
			int hkey = hashFun(k);
			while(ha[hkey] != null)
			{
				++hkey;
				hkey = hkey % size;
				}
			ha[hkey] = new Entry(k,str);
			count++;
			}
			else{
				System.out.println("Table is full");
				}
		}
		public Entry delete(int k)
		{
			if(!isEmpty()){
			int hkey = hashFun(k);
			while(ha[hkey] != null)
			{
				if(ha[hkey].key == k)
				{
					Entry tmp = ha[hkey];
					ha[hkey] = null;
					count--;
					return tmp;
					}
				++hkey;
				hkey = hkey % size;
				}
			}
			else{
				System.out.println("Table is empty");
				}
			return null;
			}
		public Entry search(int k)
		{
			int hkey = hashFun(k);
			while(ha[hkey] != null)
			{
				if(ha[hkey].key == k)
					return ha[hkey];
				++hkey;
				hkey = hkey % size;
				}
			return null;
			}
		public void display(){
			System.out.println("Dictionary is");
			for(int i=0; i<size; i++)
			{
				if(ha[i] != null)
					System.out.println(ha[i].key+" "+ha[i].value);
				}
			}
		public boolean isEmpty()
		{
			return count == 0;
			}
		public boolean isFull()
		{
			return count == size;
			}
		public int Size()
		{
			return count;
			}
	}
public class Dictionary {
	
	public static void main (String[] args) {
		
		Hashtable ht = new Hashtable(10);
		ht.insert(1,"Bhargavi");
		ht.insert(2,"Prasannna");
		ht.insert(3,"Bommidi");
		ht.display();
		Entry x = ht.search(3);
		System.out.println("The key "+x.key+" value is "+x.value);
		ht.delete(2);
		ht.display();
		
	}
}

