package billydev.Exp006_ShellSort;

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
		int h=1; 
		int temp=0;
		int j=0; 
		while(h<=a.length/3){
			h=h*3+1; 
		}
		
		while(h>=1){
			for(int i=h;i<a.length;i+=h){
				temp=a[i];
				j=i-h; 
				while(j>=0&&a[j]>temp){
					a[j+h]=a[j];
					j=j-h; 
				}
				a[j+h]=temp; 
				
			}
			
			h=(h-1)/3; 
		}
		
		
		return a;
	}

	
	
}
