package billydev.Exp036_slideWindow;

import jdk.nashorn.internal.runtime.Debug;
import sun.java2d.pipe.ShapeSpanIterator;

public class App {
    public static void main(String[] args) {
        int[] arr = {900, 100, 200, 800, 100};
        System.out.printf(String.valueOf(maxSum(arr, 2)));
    }

    private static int maxSum(int[] arr, int k) {
         ////////seems NOT WORKING???????????????????????
        int n=arr.length;
        int maxSum=0;
        for (int i = 0; i < k; i++) {
            maxSum += arr[i];
        }
        int sum=maxSum;
        for (int i = k; i <n; i++) {
            sum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
