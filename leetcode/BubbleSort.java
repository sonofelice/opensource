package leetcode;

public class BubbleSort {
	public void bubbleSort(int[] values ){
		int temp;
		for(int i=0;i<values.length;i++){
			for(int j=0;j<values.length-i-1;j++){
				if(values[j]<values[j+1]){
					temp = values[j];
					values[j] = values[j+1];
					values[j+1] = temp;
				}
			}
		}
	}
}
