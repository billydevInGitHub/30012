package billydev.Exp029_MinimaxAlgorithm;

public class GFG {


	// Returns the optimal value a maximizer can obtain.
	// depth is current depth in game tree.
	// nodeIndex is index of current node in scores[].
	// isMax is true if current move is of maximizer, else false
	// scores[] stores leaves of Game tree.
	// h is maximum height of Game tree
	 static int minimax(int depth, int nodeIndex, boolean  isMax,
	            int scores[], int h)
	{
		 int firstValue=0;
		 int secondValue=0; 
		 
		 //the following is added by Billy
		 //System.out.println("depth is:"+depth+" nodeIndex: "+nodeIndex+" isMax:"+isMax);
		 
	    // Terminating condition. i.e leaf node is reached
	    if (depth == h){
	    	System.out.println("return score is: "+scores[nodeIndex]+" depth:"+depth+" nodeIndex: "+nodeIndex);  //added by Billy
	        return scores[nodeIndex];
	    }
	    // If current move is maximizer, find the maximum attainable
	    // value
	    if (isMax){
	   
	    	firstValue=minimax(depth+1, nodeIndex*2, false, scores, h);
	    	secondValue=minimax(depth+1, nodeIndex*2 + 1, false, scores, h);

	    	System.out.println(generateSpace(depth)+"isMax --- First value is: "+firstValue+" Second value is:"+secondValue); 
	    	if(firstValue>=secondValue){
	    		//System.out.println("Going to return firstValue:  "+firstValue);
	    		return  firstValue;	    		
	    	}else{
	    		//System.out.println("Goting to reuturn secondValue:  "+secondValue);
	    		return secondValue; 
	    	}


//	    	return Math.max(firstValue,secondValue);
//	        return Math.max(minimax(depth+1, nodeIndex*2, false, scores, h),
//	                minimax(depth+1, nodeIndex*2 + 1, false, scores, h));
	    }
	    // Else (If current move is Minimizer), find the minimum
	    // attainable value
	    else{
	    	firstValue=minimax(depth+1, nodeIndex*2, true, scores, h);
	    	secondValue= minimax(depth+1, nodeIndex*2 + 1, true, scores, h);
	    	System.out.println(generateSpace(depth)+"isMin --- First value is: "+firstValue+" Second value is:"+secondValue); 
	    	if(firstValue<=secondValue){
	    		//System.out.println("Going to return firstValue:  "+firstValue);
	    		return  firstValue;	    		
	    	}else{
	    		//System.out.println("Goting to reuturn secondValue:  "+secondValue);
	    		return secondValue; 
	    	}


//	    	return Math.min(firstValue,secondValue);
//	        return Math.min(minimax(depth+1, nodeIndex*2, true, scores, h),
//	                minimax(depth+1, nodeIndex*2 + 1, true, scores, h));
	    	
	    }

	}
	 
	private static String generateSpace(int depth) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<=depth;i++){
			sb.append("======="); 
		}
		return sb.toString();
	}

	// A utility function to find Log n in base 2
	 static int log2(int n)
	{
	return (n==1)? 0 : 1 + log2(n/2);
	}
	 
	// Driver code
	 
	    public static void main (String[] args) {
	            // The number of elements in scores must be
	    // a power of 2.
	    int scores[] = {3, 5, 2, 9, 12, 5, 23, 23};
	    int n = scores.length;
	    int h = log2(n);
	    int res = minimax(0, 0, true, scores, h);
	    System.out.println( "The optimal value is : "  +res); 
	         
	    }
	
}
