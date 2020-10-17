package billydev.Exp001_BubbleSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};
		
		//int[] A = new int[]{}; //seems ok 
		System.out.println("Before sorting: \n"+Arrays.toString(A)); 
        System.out.println("After sorting:\n"+Arrays.toString(sort(A))); 
	}

	private static int[] sort(int[] arrayInt) {
		
		for(int i=0; i<arrayInt.length; i++){
			for(int j=1; j<arrayInt.length-i; j++){
				if(arrayInt[j-1]>arrayInt[j]){  //so j will not go through all the array
					swap(arrayInt, j-1, j); 
				}
			}
		}
		return arrayInt;
	}

	private static void swap(int[] arrayInt, int i, int j) {
		int tmp; 
		tmp=arrayInt[i];
		arrayInt[i]=arrayInt[j];
		arrayInt[j]=tmp; 
		
	}

	
}
