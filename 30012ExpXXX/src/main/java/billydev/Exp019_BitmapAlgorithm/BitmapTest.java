package billydev.Exp019_BitmapAlgorithm;

public class BitmapTest {

	public static final int _1MB = 1024 * 1024;

	public static byte[] flags = new byte[ 512 * _1MB ];


	public static void main(String[] args) {

	    int[] array = {255, 1024, 0, 65536}; 

	    /**
	     * Comment out original code 

	    int index = 0;
	    for(int num : array) {
	        if(!getFlags(num)) {
	            //未出现的元素
	            array[index] = num;
	            index = index + 1;
	            //设置标志位
	            setFlags(num);
	        }
	    }
   	     */
	    
//	    for (byte i = 0; i < _1MB; i++){
//	    	clearFlags(i);
//	    }
	    
	    setFlags(4); 
	    
	    System.out.println("Insert 4 successfully!");
	    
	    boolean containFour=getFlags(4); 
	    
	    System.out.println("Does array contains four? "+containFour);
	    
        boolean containFive=getFlags(5); 
	    
	    System.out.println("Does array contains five? "+containFive);

	    
        boolean containBigNumber=getFlags(1000000); 
	    
	    System.out.println("Does array contains bigNumber? "+containBigNumber);
	    
	    setFlags(1000000); 
	    
        containBigNumber=getFlags(1000000); 
	    
	    System.out.println("Does array contains bigNumber after reset? "+containBigNumber);
	    
	    setFlags(1000000); 
	}

	//added the new method
	public static void clearFlags(int num){
		int shift = num & 0x07;
		int arrindex = num >> 3;
		int bitPos = ~(1 << shift);
		flags[arrindex] &= (byte)(bitPos);
	}
	
	public static void setFlags(int num) {
		
		//merge code from: http://www.cnblogs.com/huangxincheng/archive/2012/12/06/2804756.html
		int shift=num & (0x07);
		int arrindex = num >> 3;
		int bitPos = 1 << shift;
		flags[arrindex] |= (byte)bitPos;
	    // original code:  flags[num >> 3] |= 0x01 << (num & (0x07));
	}

	public static boolean getFlags(int num) {
	    //original code: return flags[num >> 3] >> (num & (0x07)) & 0x01;
		
		int j = flags[num >> 3] & (1 << (num & 0x07));
		
		if(j==0){
			return false; 
		}
		return true; 
	}

	
}
