package billydev.Exp002_CockTailSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};
		System.out.println("Before sorting: \n"+Arrays.toString(A)); 
        System.out.println("After sorting:\n"+Arrays.toString(sort(A))); 
	}

	private static int[] sort(int[] arrayInt) {
		int left=0;
		int right=arrayInt.length-1; 
		
		while(left<right){
			for(int i=left; i<right; i++){
				if(arrayInt[i]>arrayInt[i+1]){
					swap(arrayInt,i, i+1);
				}
			}
			right--;  //key here, because the right most alread arranged, so we do right-- here not left++; 
			
			for(int j=right;j>left;j--){
				if(arrayInt[j-1]>arrayInt[j]){
					swap(arrayInt,j, j-1); 
				}
			}
			left++;
		}
		
		return arrayInt;
	}

	private static void swap(int[] arrayInt, int i, int j) {
		int tmp=arrayInt[i];
		arrayInt[i]=arrayInt[j];
		arrayInt[j]=tmp; 
		
	}

}
