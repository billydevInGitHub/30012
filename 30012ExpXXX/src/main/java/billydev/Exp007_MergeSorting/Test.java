package billydev.Exp007_MergeSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};

		//int[] A = new int[]{90,12,39,5};

		//int[] A=null;
        //int[] A = new int[]{};
		System.out.println("Before sorting: a1:\n"+Arrays.toString(A));

		int left=0;
		int right=A.length-1; 
		System.out.println("After sorting:\n"+Arrays.toString(mergeSort(A,left, right ))); 
	}

	
	private static int[] mergeSort(int[] a, int left, int right) {
		

		if(left==right){
			return a;
		}
	    int mid=(left+right)/2;
	    mergeSort(a, left,mid);  //when return array from left to mid is ordered
	    mergeSort(a, mid+1, right);   //when return array from mid to right is ordered
	    merge(a, left, mid, right);     //only merge from left to right !! left might not be 0 !! 
//		System.out.println(Arrays.toString(a));
		return a;
	}


	private static void merge(int[] a, int left, int mid, int right) {
		//
		int i=0;
		int j=0; 
		int k=left;//this line is very important !! when recursive call happen, it can only re-arrange the corresponding positions of the array!!
		int leftArrayLength=mid-left+1;  //take  0-7 length=8 array, mid=3 , leftArrayLength=4 and rightArrayLength=4
		int rightArrayLength=right-mid; 
		int[] leftArray= new int[leftArrayLength];
		int[] rightArray=new int[rightArrayLength];
		
		for(int ii=0;ii<leftArrayLength;ii++){
			leftArray[ii]=a[ii+left];
		}
		for(int ii=0;ii<rightArrayLength;ii++){
			rightArray[ii]=a[ii+mid+1];
		}
		
		while(i<leftArrayLength&&j<rightArrayLength){
		   if(leftArray[i]<rightArray[j]){
			   a[k]=leftArray[i];
			   i++;
		   }else{
			   a[k]=rightArray[j];
			   j++;
		   }
		   k++;
		}
		
		//need to add the remainder , I think for those elements with same values etc.
		//180825: I guess the reminder might be: leftarray all consumed, all elements bigger than right array, then need add all right array elements
		while(i<leftArrayLength){
			a[k++]=leftArray[i++];
		}
		while(j<rightArrayLength){
			a[k++]=rightArray[j++];
		}

	}

	
	
	
}
