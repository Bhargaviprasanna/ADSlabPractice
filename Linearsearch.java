

import java.util.*;

public class Linearsearch{
	
	public static int Search(int arr[], int size, int ele)
	{	
		for(int i=0;i<size;i++)
		{	
			if (arr[i] == ele)
				return i;
		}
		return 0;
	}
	public static void main (String[] args) {
		int size,arr[],i;
		Scanner s = new Scanner(System.in);
		size=s.nextInt();
		System.out.println("Enter "+size+"elements :");
		arr = new int[size];
		for(i=0;i<size;i++)
			arr[i]=s.nextInt();
		//~ for(i=0;i<size;i++)
			//~ System.out.println(i+"th element is "+arr[i]);
			
		System.out.println("Enter search element: ");
		int ele = s.nextInt();
		int z=Search(arr, size, ele);
		if(z == 0)
			System.out.println("Element not found");
		else
			System.out.println("Position is "+z);
	}
}

