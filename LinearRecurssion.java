import java.util.*;

public class LinearRecurssion{
	
	public static int Search(int arr[], int st, int e, int ele)
	{	
		if(e < st)
			return -1;
		else if(arr[st] == ele)
			return st;
		else if(arr[e] == ele)
			return e;
		else
			return Search(arr,st+1,e-1,ele);
	}
	public static void main (String[] args) {
		int size,arr[],i,start,end;
		Scanner s = new Scanner(System.in);
		size=s.nextInt();
		System.out.println("Enter "+size+"elements :");
		arr = new int[size];
		for(i=0;i<size;i++)
			arr[i]=s.nextInt();
		System.out.println("Enter search element: ");
		int ele = s.nextInt();
		start=0;
		end=size-1;
		int z=Search(arr, start, end, ele);
		if(z == -1)
			System.out.println("Element not found");
		else
			System.out.println("Position is "+z);
	}
}
