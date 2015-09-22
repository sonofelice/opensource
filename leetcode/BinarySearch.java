package leetcode;

public class BinarySearch {
	private int rcount = 0;
	public int getRcount() {
		return rcount;
	}

	public void setRcount(int rcount) {
		this.rcount = rcount;
	}

	public int getLcount() {
		return lcount;
	}

	public void setLcount(int lcount) {
		this.lcount = lcount;
	}

	private int lcount = 0;
	
	public int searchRecursive(int[] sortedData,int start,int end,int findValue){
		rcount++;
		if(start<=end){
			int mid = (start+end)>>1;
			int midValue = sortedData[mid];
			if(findValue == midValue){
				return mid;
			}else if(findValue > midValue){
				return searchRecursive(sortedData,mid+1,end,findValue);
			}else{
				return searchRecursive(sortedData,start,mid-1,findValue);
			}
		}else
			return -1;
	}
}
