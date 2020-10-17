package billydev.Exp013_BinearySearchMySelf;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		//Prepare 
		
		int[] array = { 12, 23,8979,23,12, 43,5656,4,9, 98,35,122};
		Arrays.sort(array);

		System.out.println("Array after sort is: "+Arrays.toString(array));

		int target=5656; //extreme case test  ,  11,   -1,  100000,  22000000000; 
		target=Integer.MAX_VALUE;
		System.out.println("Found target: "+target + " in "+(binarySearch(array,target)+1)+ " position") ;

		

	}

	private static int binarySearch(int[] array, int target) {
		int begin=0;
		int end=array.length-1;
		int mid=(begin+end)/2; 
		
		//comments:  1: check if array is null; 
        //           2:	no need to check the edge 
		//           3: only need to check below mid, above mid, 
		//           4: as the mid already checked( neither<mid nor >mid, then return mid), so we can do mid+1 or mid-1 move, finally reach  the mid!! then begin/end/mid are the same
		//           5: exit condition is begin and end the same ! it also has exit route 
		
		if(target<array[begin] ||target>array[end]) {
			return -1; 
		}
		
		while(mid<end){
			if(target==array[begin]){
				return begin; 
			}else if(target==array[end]){
				return end; 
			}
			if(target>array[begin]&&target<array[mid]){
				end=mid; 
				mid=(begin+end)/2; 
			}else{
				begin=mid;
				mid=(begin+end)/2;
			}
			if(begin==mid||mid==end){
				return -1; 
			}
			
		}
		return -1; 
		
	}
	
	
	

}
