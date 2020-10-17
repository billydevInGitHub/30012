package billydev.Exp031_FibonacciBottomUp;

public class Fibonacci {

	public static final int MAX=100; 
	
	public static void main(String[] args){
		int n =40; 
		System.out.println(fibonacci(n));
	}

	private static int fibonacci(int n) {
		int[] f=new int[MAX];
		 
		f[0]=0;
		f[1]=1;
		
		for(int i=2; i<=n;i++){
			f[i]=f[i-1]+f[i-2]; 
		}
		return f[n];
	}
}
