package leetcode;

public class FirstRepeatLetter {
	public char findFirstRepeat(String A, int n){
		char a[] = A.toCharArray();
		boolean b = true;
		for(int i=0;i<n;i++){
			int recount = 0;
			while(recount<i){
				if(a[recount] == a[i])
					return a[recount];
				recount++;
			}
		}
		return 0;
	}
}
