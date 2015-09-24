package leetcode;
//小米三面在线编程题：去掉代码中的注释，输出去掉注释后的代码片段
public class removeComments{
	    public  String removeCommentsXiaomi(String code){  
	        StringBuilder sb = new StringBuilder();  
	        int commentnum = 0;  
	        boolean flag = false;  
	        for (int i = 0; i < code.length(); i++){
	            if(!flag){ //not quote
	                if(code.charAt(i) == '\"'){   //quote 
	                    sb.append(code.charAt(i));  
	                    flag = true;  
	                    continue;  
	                }  
	                else if(i+1 < code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '/'){  
	                    while(code.charAt(i) != '\n') i++;
	                    i--;//防止删除"//"注释后面的换行符"
	                    continue;  
	                }else{  
	                    if(commentnum == 0){  
	                        if(i+1 < code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '*'){  
	                            commentnum ++;  
	                            i ++;  
	                            continue;  
	                        }  
	                    }else{  
	                        if(i+1 < code.length() && code.charAt(i) == '*' && code.charAt(i+1) == '/'){  
	                            commentnum --;  
	                            i++;  
	                            continue;  
	                        }
	                        if(i+1 < code.length() && code.charAt(i) == '/' && code.charAt(i+1) == '*'){  
	                        	commentnum ++;  
	                            i++;  
	                            continue;  
	                        }  
	                    }  
	                    if(commentnum == 0){	          
	                        sb.append(code.charAt(i));  
	                        continue;  
	                    }  
	                }  
	            }else{
	                if(code.charAt(i) == '\"' && code.charAt(i-1) != '\\'){  
	                    sb.append(code.charAt(i));  
	                    flag = false;  
	                }else{  
	                	//sb.append(code.charAt(i-1));
	                    sb.append(code.charAt(i));  
	                }  
	            }  
	        }  
	        return sb.toString();  
	    }  
}
