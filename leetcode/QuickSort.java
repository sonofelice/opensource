package leetcode;

public class QuickSort {
	//ÍÚ¿Ó
	public int ajustArray(int s[], int l, int r){
		int i=l,j=r;
		int x = s[l];
		while(i<j){
			while(i<j && s[j]>=x)
				j--;
			if(i<j){
				s[i++] = s[j];
			}
			
			while (i<j && s[i] < x)
				i++;
			if(i<j){
				s[j--] = s[i];
			}
		}
		s[i]=x;
		return i;
	}
	public void quickSort(int s[], int l, int r){
		if(l<r){
			int i = ajustArray(s,l,r);
			quickSort(s,l,i-1);
			quickSort(s,i+1,r);
		}
	}
	
	public void betterQuickSort(int s[], int l, int r){
		if(l<r){
		int i=l,j=r, x = s[l];
		while(i<j){
			while(i<j && s[j]>=x)
				j--;
			if(i<j)
				s[i++] = s[j];
			while(i<j && s[i]<x)
				i++;
			if(i<j)
				s[j--] = s[i];
		}
		s[i] = x;
		betterQuickSort(s,l,i-1);
		betterQuickSort(s,i+1,r);
		}
	}
		
}
