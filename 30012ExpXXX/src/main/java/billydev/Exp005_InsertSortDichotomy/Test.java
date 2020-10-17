package billydev.Exp005_InsertSortDichotomy;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		//int[] A = new int[]{39,90,12,32,34,5,6,34,39,101,2,17};
		//int[] A = new int[]{0,4,12,15}; 
		int[] A=null;
        //int[] A = new int[]{};
		System.out.println("Before sorting: \n"+Arrays.toString(A)); 
		System.out.println("After sorting:\n"+Arrays.toString(sort(A))); 

	}


	/** my orig not working 
	private static   int[] sortOrig(int[] a) {
		
		if(a==null||a.length==0){
			throw new RuntimeException("Array is null or array length is zero!"); 
		}
		int temp=0;
		int left=0; 
		int right=0;
		int mid=0; 
		for(int i=1; i<a.length;i++){
			temp=a[i];
			left=0; 
			right=i-1; 

			while(left<right){     //need to add <=
				mid=(left+right)/2;
				if(temp<a[mid]){
					right=mid-1;
				}else if(temp>a[mid]){  //no compare here 
					left=mid+1;
				}else{           //no else 
					left=mid;
					right=mid;
				}	
			}
			
	        for (int j=i; j>left;j--){
	        	a[j]=a[j-1];
	        }
	        a[left]=temp; 
			
		}
		return a;
	}
*/
	

	
	
	//finally got one from: https://blog.csdn.net/u012831423/article/details/55107673
	private static   int[] sort(int[] a) {
    int start;
    int end;
    int temp=0;
    int mid,j;
    
    
    //[bl]  the following check is added by myself, especially working for null case 
	if(a==null||a.length==0){
		throw new RuntimeException("Array is null or array length is zero!"); 
	}
    
    for(int i=1;i<a.length;i++)
    {
        start=0;
        end=i-1;
        temp=a[i];

        while(start<=end)
        {
            mid=(start+end)/2;
            if (temp<a[mid])
            {
                end=mid-1;
            }
            else 
            {
                start=mid+1;
            }
        }
        
        //while循环完后，start=end+1,此时start为当前插入数字所待坑位！
        //把坑位给当前插入的数据挪出来
        for( j = i-1;j >= start;j-- )
        {
            a[j+1] = a[j];
        }
        //将当前插入数字挪入它该待的坑位
        a[start] = temp;


    }
    return a; 
	}
}
