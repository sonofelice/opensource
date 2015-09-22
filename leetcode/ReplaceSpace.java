package leetcode;

public class ReplaceSpace {
    public String replaceSpace(StringBuffer str) {
    	if(str == null || str.length() <=0 )
    		return "";
    	int length = str.length();
    	int newLength = length + 2*getBlankNumber(str);
    	char[] tempArray = new char[newLength];
    	int indexOfOriginal = length - 1;
    	int indexOfNew = newLength - 1;
    	System.arraycopy(str.toString().toCharArray(), 0, tempArray, 0, str.toString().toCharArray().length);
    	while(indexOfOriginal>=0 && indexOfOriginal != indexOfNew){
    		if(tempArray[indexOfOriginal] == ' '){
    			tempArray[indexOfNew--] = '0';
    			tempArray[indexOfNew--] = '2';
    			tempArray[indexOfNew--] = '%';
    		}else{
    			tempArray[indexOfNew--] = tempArray[indexOfOriginal];
    		}
    		indexOfOriginal--;
    	}
    	String res = new String(tempArray);
    	return res;
    }
    public int getBlankNumber(StringBuffer str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            String temp = String.valueOf(str.charAt(i));
            if(temp.equals(" "))
            	count++;
        }
        return count;
    }
}	
