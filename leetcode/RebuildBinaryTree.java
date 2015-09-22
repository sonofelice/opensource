package leetcode;

import java.util.Stack;

public class RebuildBinaryTree {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack2.push(node);
    }
    
    public int pop() {
    	Integer re = null;
    	if(!stack2.empty())
    		return stack2.pop();
    	else{
    		while(!stack1.empty()){
    			re = stack1.pop();
    			stack2.push(re);
    		}
    		return re;
    	}
    
    }
}
