package billydev.Exp008_HeapSorting;

import java.util.Arrays;

public class Test {

	
	public static void main(String[] args) {
		int[] a = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};

		//int[] a = new int[]{90,12,39,5};

		//int[] a=null;
        //int[] a = new int[]{};
		System.out.println("Before sorting: a1:\n"+Arrays.toString(a));

		System.out.println("After sorting:\n"+Arrays.toString(heapSort(a, a.length))); 
	}

	private static int[] heapSort(int[] a, int size) {
		int heapSize=size; 
		
		buildHeap(a,size); 
		
		while(heapSize>1){
			Swap(a,0, --heapSize);
			heapify(a,0, heapSize); 
		}
		
		
		return a;
	}

	private static void heapify(int[] a, int i,  int heapSize) {

		int left_child=i*2+1; 
		int right_child=i*2+2; 
		int max=i; 
		
//		if(left_child<heapSize&&a[left_child-1]>a[max]){
//			max=left_child-1;
//		}
//		if(right_child<heapSize&&a[right_child-1]>a[max]){  //if child is bigger than heapSize , I guess no need to compare !!
//			max=right_child-1;
//		}

		if(left_child<heapSize&&a[left_child]>a[max]){
			max=left_child;
		}
		if(right_child<heapSize&&a[right_child]>a[max]){  //if child is bigger than heapSize , I guess no need to compare !!
			max=right_child;
		}
		
		
		if(i!=max){
			Swap(a, i, max);
			heapify(a,max,heapSize);			
		}

		
	}

	private static void Swap(int[] a, int i, int j) {
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}

	private static void buildHeap(int[] a, int size) {
		for(int i=size/2-1; i>=0;i--){
			heapify(a,i,size); 
		}
		

	}

	
}
