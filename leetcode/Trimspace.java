package leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Trimspace {
	public  int getBlankNumber(String s,int index){
		if(index < s.length()){
			if(s.charAt(index) == ' ')
				return getBlankNumber(s,index+1)+1;
			else 
				return 0;
		}else
			return 0;
	}
	public  String mergeBland(String s){
		int blankNumber = 0;
		String s1;
		String s2;
		for(int index=0; index < s.length(); index++){
			blankNumber = getBlankNumber(s,index);
			if(blankNumber >= 2){
				s1 = s.substring(0, index);
				s2 = s.substring(index+blankNumber-1, s.length());
				s= s1+s2;
			}
			
		}
		return s;
	}
	public  String trim(String s){
		if(s.charAt(0) == ' ')
			s = s.substring(1, s.length());
		if(s.charAt(s.length()-1) == ' ')
			s = s.substring(0, s.length()-1);
		return s;
	}
	public  String removeSpace(String s){
		s = mergeBland(s);
		s = trim(s);
		return s;
	}
}
