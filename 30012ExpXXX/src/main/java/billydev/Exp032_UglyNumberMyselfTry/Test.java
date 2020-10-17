package billydev.Exp032_UglyNumberMyselfTry;

import java.util.ArrayList;
import java.util.Collections;

public class Test {

	static ArrayList<Integer> result=new ArrayList<>(); 
	
	public static void main(String[] args) {
		
		int n=20; 

		
		getUglyNumber(n);

	}

	private static void getUglyNumber(int n) {

		int  expOf2=(int)Math.ceil(Math.log(n)/Math.log(2))+1;
		int  expOf3=(int)Math.ceil(Math.log(n)/Math.log(3))+1;
		int  expOf5=(int)Math.ceil(Math.log(n)/Math.log(5))+1;
		
		int[] factorOf2= new int[expOf2];
		int[] factorOf3= new int[expOf3];
		int[] factorOf5= new int[expOf5]; 
		
		int tmp=1; 

		for(int i=0;i<expOf2;i++){
			factorOf2[i]=tmp;
			tmp*=2; 
		}
		tmp=1; 
		for(int i=0;i<expOf3;i++){
			factorOf3[i]=tmp;
			tmp*=3; 
		}
		tmp=1;
		for(int i=0;i<expOf5;i++){
			factorOf5[i]=tmp;
			tmp*=5; 
		}		
			
       for(int i=0;i<factorOf2.length;i++){
    	   for(int j=0; j<factorOf3.length; j++){
    		   for(int k=0; k<factorOf5.length; k++){
    			   tmp=factorOf2[i]*factorOf3[j]*factorOf5[k]; 
    			   if(tmp<n){
    				   result.add(tmp); 
    			   }
    		   }
    	   }
       }
        	
       Collections.sort(result);
       System.out.println(result.toString()); 

	}

}
