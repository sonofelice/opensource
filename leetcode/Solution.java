package leetcode;

public class Solution {

    public int limitedMaxSum(int[] arr, int length, int limit) {
        int[]  sum = new int[length*(length+1)/2];
        int sumIndex = 0;
        for(int i=0;i<length;i++){
            for(int j=i;j<length;j++){
                int s = arr[i] + arr[j];
                sum[sumIndex++] = s;
            }
        }
        int min = 0;
        for(int i=0;i<sum.length;i++ ){            
        	if(sum[i] <= limit){
        		if(sum[i]>min)
        			min = sum[i];
        	}
        }
        return min;
    }
}
