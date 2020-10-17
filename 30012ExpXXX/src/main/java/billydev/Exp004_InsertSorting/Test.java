package billydev.Exp004_InsertSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};
        		//int[] A=null;
		        //int[] A = new int[]{};
		System.out.println("Before sorting: \n"+Arrays.toString(A)); 
        System.out.println("After sorting:\n"+Arrays.toString(sort(A))); 

	}

	private static int[] sort(int[] a) {
		int temp=0;
		int j=0; 
		if(a==null||a.length==0){
			throw new RuntimeException("Input array is null or 0 length!"); 
		}
		for(int i=1;i<a.length;i++){
			temp=a[i];
			j=i-1; 
			while(j>=0&&a[j]>temp){
				a[j+1]=a[j];
				j--;
			}
			a[j+1]=temp; 
			
		}
		
		return a;
	}

	
	
}
