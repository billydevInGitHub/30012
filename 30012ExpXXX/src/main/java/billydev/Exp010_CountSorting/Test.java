package billydev.Exp010_CountSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] a = new int[]{2,4,5,1,2,3,4};
		//int[] a=null;
		//int[] a = new int[]{};	
		System.out.println("Before sorting: a1:\n"+Arrays.toString(a));

		System.out.println("After sorting:\n"+Arrays.toString(countSort(a))); 
	}

	private static int[] countSort(int[] a) {
		int[] c= new int[100];  // an array from 0 to 99
		
		for(int i=0;i<c.length;i++){
			c[i]=0;
		}
		
		for(int i=0;i<a.length; i++){
			c[a[i]]++;
		}
		
		for(int j=1; j<c.length;j++){
			c[j]+=c[j-1];
		}
		
		int[] b= new int[a.length];
		for(int i=0; i<a.length;i++){
			b[--c[a[i]]]=a[i];
		}
		
		
		for(int i=0;i<a.length; i++){
			a[i]=b[i];
		}
		return a;
	}
	
	
	
}
