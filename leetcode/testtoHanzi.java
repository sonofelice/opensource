package leetcode;

public class testtoHanzi {
	public String toHanzi(String num){
		String res = "";
		char[] numstr = {'零','一','二','三','四','五','六','七','八','九'};
		//char[] weistr = {'百亿','十亿','亿','千万','百万','十万','万','千','百','十',''};
		String[] weistr = {" ","十","百","千","万","十万","百万","千万","亿","十亿","百亿"};
		StringBuffer newstrb = new StringBuffer();
		newstrb.append(num);
		int firstl = 0;
		for( firstl = 0; firstl < newstrb.length(); firstl ++ ){
			if(newstrb.charAt(firstl) != '0')
				break;
		}
		String newstr  = newstrb.toString().substring(firstl);
		String str = "";
		for(int i = newstr.length()-1; i >= 0 ; i--){
		int index = Integer.parseInt(String.valueOf(newstr.charAt(newstr.length()-i-1)));
		str = str + numstr[index] + weistr[i];
		}
		res = str.replaceAll("零百亿","零").replaceAll("零十亿","零").replaceAll("零亿","零").replaceAll("零千万","零").replaceAll("零百万","零").replaceAll("零万","零").replaceAll("零千","零").replaceAll("零百","零").replaceAll("零十","零").replaceAll("零 ","零");
		if(res.charAt(res.length()-1) == '零'){
		res = res.substring(0,res.length()-1);
		}
		return res;
		}
}