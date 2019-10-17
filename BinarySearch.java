

import java.util.*;

public class BinarySearch {
	
	
	static int Search(int arr[], int st, int end, int ele)
	{	
		while(st < end)
		{
			int mid=(st+end)/2;
			if(arr[mid] == ele)
				return mid;
			else if(arr[mid] > ele)
			{	
				end=mid-1;
			}
			else
				st=mid+1;
		}
		return -1;
	}
	
	public static void main (String[] args) {
		int arr[], i, st, end, size;
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Size: ");
		size=s.nextInt();
		arr = new int[size];
		System.out.println("Enter "+size+" elements: ");
		for(i=0;i<size;i++)
			arr[i] = s.nextInt();
		//~ for(i=0;i<size;i++)
			//~ System.out.println(i+"th element is "+arr[i]);
		System.out.println("Enter search element: ");
		int ele = s.nextInt();
		st=0;
		end=size-1;
		int z=Search(arr, st, end, ele);
		if(z != -1)
			System.out.println("Element found at "+z);
		else
			System.out.println("Element not Found");
		
	}
}

