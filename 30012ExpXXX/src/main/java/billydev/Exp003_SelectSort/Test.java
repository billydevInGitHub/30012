package billydev.Exp003_SelectSort;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};
		System.out.println("Before sorting: \n"+Arrays.toString(A)); 
        //System.out.println("After sorting:\n"+Arrays.toString(sort(A))); 
		System.out.println("After sorting of Billy:\n"+Arrays.toString(sortBilly(A))); 
	}

	private static int[] sort(int[] arrayInt) {
		   int min =0;
 
		for(int i=0; i<arrayInt.length;i++){
		   min=i;		   
		    // 
		   for(int j=i+1; j<arrayInt.length;j++){
			   if(arrayInt[j]<arrayInt[min]){
				   min=j;    
			   }
		   }
			if(min!=i){
				swap(arrayInt, min, i);
				
			}
			
		}

		return arrayInt;
		
	}

	private static void swap(int[] arrayInt, int min, int i) {
		int tmp=arrayInt[min];
		arrayInt[min]=arrayInt[i];
		arrayInt[i]=tmp; 
		
	}

	private static int[] sortBilly(int[] arrayInt) {
		//this is added by myself, kind of style simpler

		for(int i=0; i<arrayInt.length;i++){
	   
		    // 
		   for(int j=i+1; j<arrayInt.length;j++){
			   if(arrayInt[j]<arrayInt[i]){
				  swap(arrayInt, j,i);    //maybe more swap ??
			   }
		   }
			
		}

		return arrayInt;
		
	}

	
}
