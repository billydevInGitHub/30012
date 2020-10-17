package billydev.Exp009_QuickSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};

		//int[] a = new int[]{90,12,39,5};

		//int[] a=null;
        //int[] a = new int[]{};
		System.out.println("Before sorting: a1:\n"+Arrays.toString(a));

		System.out.println("After sorting:\n"+Arrays.toString(quickSort(a, 0, a.length-1))); 

	}

	private static int[] quickSort(int[] a, int low , int high) {
		
		if(low<high){
			int pivot=partition(a, low, high);
			quickSort(a,low, pivot-1);
			quickSort(a,pivot+1, high); 
		}
		
		return a;
	}

	private static int partition(int[] a, int low, int high) {
		
		int pivot=a[high];
		int i=low-1; 
		for(int j=low; j<high;j++){
			if(a[j]<pivot){
				i++; 
				Swap(a, j, i);   //190407: go through all elements, once found less than pivot, then 
				                 //"absorb" it through element swap
				                 // "i" is the "manager" index of guys which are all smaller than pivot
				                 //   when swapping happen, "manager i" only devote the "next" guy, not 
				                 // the one already swapped
		     }		
		}
		Swap(a,i+1, high);   //finally the "manager i"'s next position is filled by pivot
		return i+1;          //from low to i+1 are all bigger/equal to pivot, that "i+1"  the next pivot position!!
	}

	private static void Swap(int[] a, int j, int i) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp; 		
	}

}
