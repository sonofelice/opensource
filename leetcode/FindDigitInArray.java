package leetcode;

public class FindDigitInArray {
    public boolean Find(int [][] array,int target) {
		boolean found = false;
        if(array.length!=0){
            int row=0;
            int rows = array.length;
            int coloums = array[0].length-1;
            int coloum = array[0].length-1;
            while (row<rows && coloum>0){
            	if(array[row][coloum] == target){
            		found = true;
            		break;
            	}
            	else if(array[row][coloum]>target)
            		--coloum;
            	else ++row;
            }
        }
        return found;
    }
}
