package leetcode;

public class NumOfOne {
	public int countDigitOne(int n){
		int count =0;
		int wei = (n+"").length();
		if(n == (int)Math.pow(10, wei-1)){
			count++;
			n--;
			wei--;
		}
		if(n<=0){
			return count;
		}
		while(wei>0){
			if(wei == 1){
				if(n>=1)
					count++;
				break;
			}
			int tenN = (int)Math.pow(10,wei-1);
			if(n/tenN == 1){
				count +=count(wei-1);
			}
			else
				count += (n/tenN)*count(wei-1) + tenN;
			n = n%tenN;
			wei = (n+"").length();
		}
		return count;
	}
	public int count(int wei){
		int x = 0;
		for(int i=1; i<= wei; i++){
			x = x*10 + (int)Math.pow(10, i-1);
		}
		return x;
	}
	public int NumberOf1(int n){
		int number = 0;
		
		for(int i=1; i<=n; i++){
			number += countOne(i);
		}
		return number;
	}
	public int countOne(int n){
		int number = 0;
		while(n!=0){
			if(n%10 == 1)
				number ++;
			n /= 10;
		}
		return number;
	}
}
