package billydev.Exp011_RadixSorting;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {

		int[] a={999, 239, 128,237,645,825};
		System.out.println("Before soriting:"+Arrays.toString(a));
		
		System.out.println("After sorting:"+Arrays.toString(RadixSort(a)));

	}

	private static int[] RadixSort(int[] a) {
		int[] c= new int[10];  
		int dn=3; 
		int[] b= new int[a.length]; 
		
		for(int i=0; i<dn;i++){
			
			for(int j=0;j<c.length;j++){                  //each round c[] need a clean up
				c[j]=0; 
			}
			
			for(int j=0; j<a.length; j++){
				c[getDigit(a[j],i)]++; 
			}
	
		
			for(int j=1; j<c.length; j++){   //do not miss the array
				c[j]+=c[j-1]; 
			}
		
			for(int k=0; k<a.length; k++){
				b[--c[getDigit(a[k],i)]]=a[k];          //the order a[] is picked is important ! unless higher digit need a reorder, the previous ordered array's order is kept
			}
		
			for(int k=0; k<a.length; k++){
				a[k]=b[k]; 
			}
		}	
		return a;
	}

	private static int getDigit(int num, int d) {
		
		int powerOfTen=(int)Math.round(Math.pow(10, d));		
		return num/powerOfTen%10;   
		
		/**
		 * the above method could be improved without using Math.round and Math.pow
		 */
	}

	private static int getDigitNew(int num, int d){
		while(d>0){
			num=num/10;
			d--;
		}
		return num%10; 
	}
	
	
	
	
}
