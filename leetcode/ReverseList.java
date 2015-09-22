package leetcode;

public class ReverseList {
	public class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
    public ListNode ReverseList(ListNode head) {
    	
    	if(head == null || null == head.next)
    		return head;
    	ListNode pre = head;
    	ListNode cur = head.next;
    	ListNode next;
    	while(null != null){
    		next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	head.next = null;
    	head = pre;
    	return head;    	
    }
}
