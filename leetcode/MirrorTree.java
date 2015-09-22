package leetcode;

public class MirrorTree {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }
	}
    public void Mirror(TreeNode root) {
        if(null == root){
        	return ;
        }
        if(root.left == null && root.right == null)
        	return;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}
