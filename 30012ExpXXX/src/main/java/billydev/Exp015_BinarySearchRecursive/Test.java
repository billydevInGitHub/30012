package billydev.Exp015_BinarySearchRecursive;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
	  int[] a ={87,3,45,23,34,12,36,87,2,12};
		//int[] a={87};
	  Arrays.sort(a);
	  System.out.println("Sorted Array is: "+Arrays.toString(a));
	  int target =3; 
	  
	  target=31;
	  
	  System.out.println("After binary search, the target is:"+binarySearch(a,0,a.length-1, target)); 

	}

	private static int  binarySearch(int[] a, int left, int right, int target) {	

		int mid=(right-left)/2+left; 
		if(a[mid]==target){
			return mid; 
		}
		
		if(left>=right){   //if left==right, then left==right==mid, so impossible here left==right
			return -1; //should throw exception !!
		}		

		if(target>a[mid]){
			return binarySearch(a,mid+1, right, target); 
		}else if(target<a[mid]){
			return binarySearch(a, left, mid-1,target);
		}
		
		return -1; //seems this -1 is unreachable
	}

}
