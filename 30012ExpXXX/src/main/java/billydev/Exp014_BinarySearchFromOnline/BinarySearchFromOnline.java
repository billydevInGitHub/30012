package billydev.Exp014_BinarySearchFromOnline;

import java.util.Arrays;

public class BinarySearchFromOnline {

	public static void main(String[] args) {
     int[] array = {23,23, 26,1, 3434, 3454436,343,2375, 3232};
     Arrays.sort(array);
     int target=23; 
     
     System.out.println("Founnd:"+target+ " in "+binarySearch(array, target));

  
	}

	private static int binarySearch(int[] array, int target) {
		int begin=0;
		int end=array.length-1;
		int mid=(begin+end)/2; 
		
		if(array!=null){

			//need to consider if: nothing found; target in the begin position; target in the end position;  
			while(begin<=end){
				if(target>array[mid]){
					begin=mid+1; 
				}else if(target<array[mid]){
					end=mid-1;
				}else{
					return mid; 
				}
				mid=(begin+end)/2; 
				System.out.println("begin="+begin+" mid="+mid+" end="+end);
			}
			
			
		}
		return -1;
	}


}
