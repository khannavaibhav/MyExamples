package Structures;

public class DiameterOfBinaryTree {
	
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		
		
	}
	
	
	public int diameterOfBinaryTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return 0;
        int max = 0;
        int count = 0;
        TreeNode n = root;
        max = Math.max(getCount(n),getforNodes(root,0));

        return max;
    }
     
    public int getforNodes(TreeNode root,int max){
        if(root == null) return max;
        max =  Math.max(getCount(root.left),getCount(root.right) );
        max = Math.max(getforNodes(root.left,max),max);
        max = Math.max(getforNodes(root.right,max),max);
        return max;
    }
    public int getCount(TreeNode root){
        if(root == null || (root.left == null && root.right == null)) return 0;
        int count = 0;
        if(root.left!= null){
            count ++;
            count = count + getHeight(root.left);
        }
        if(root.right!= null){
            count ++;
            count = count + getHeight(root.right);
        }
        return count;
    }
    
    public int getHeight(TreeNode root){
        if(root == null) return -1;
        return Math.max(getHeight(root.right),getHeight(root.left))+1;
    }
    

}
