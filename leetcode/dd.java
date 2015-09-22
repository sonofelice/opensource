package leetcode;

import java.util.Scanner;

public class dd {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n = Integer.valueOf(input.nextLine());
		String inputstr = input.nextLine();
		String[] data = inputstr.split(" ");
		int interval=0;
		for(int i=0;i<data.length-1;i++){
			int a = Integer.valueOf(data[i+1]);
			int b = Integer.valueOf(data[i]);
			if((a-b)>interval)
				interval = a-b;
		}
		System.out.println(interval);

	}

}
