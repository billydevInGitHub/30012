package billydev.Exp012_BucketSort;

import java.util.Arrays;

public class Test {

	static int bn=5; 
	static int[] c=new int[bn]; 
	
	public static void main(String[] args) {
     int[] a={29,25,3,49,9,37,21,43}; 
     
     System.out.println("Before sorting:"+Arrays.toString(a)  );
     
     System.out.println("After sorting:"+ Arrays.toString(bucketSorting(a))); 

	}

	private static int[] bucketSorting(int[] a) {
		
		countSorting(a,a.length);
		
		for(int i=0;i<bn;i++){
			int left=c[i];
			int right=(i<bn-1?(c[i+1]-1):a.length-1);
			
			if(left<right){
				insertSort(a,left,right); 
			}
			
		}
		
		
		return a;
	}

	private static void insertSort(int[] a, int left, int right) {
		for(int i=left+1;i<=right;i++){
			
			int get=i;
			int tmp=a[i]; 
			int j=i-1; 
			
            while(j>=left&&a[j]>tmp){
            	
    			a[j+1]=a[j];
    		  j--; 
			}
			a[j+1]=tmp; 
		}
		
	}

	private static void swap(int[] a, int i, int j) {
		int tmp=a[i];
		a[i]=a[j];
		a[j]=tmp; 
		
	}

	private static void countSorting(int[] a, int length) {
		for(int i=0;i<bn;i++){
			c[i]=0; 
		}
		for(int j=0;j<a.length;j++){
			c[mapToBucket(a[j])]++;
		}
		for(int i=1; i<bn;i++){
			c[i]=c[i]+c[i-1]; 
		}
		
		int[] b = new int[a.length]; 
		for(int j=0;j<a.length;j++){    //the order can be optimized further 
			b[--c[mapToBucket(a[j])]]=a[j]; 
		}
		
		for(int j=0;j<a.length; j++){
			a[j]=b[j]; 
		}
	}

	private static int mapToBucket(int i) {	    
		return i/10;
	}

}
