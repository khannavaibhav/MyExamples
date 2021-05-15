package facebook;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class zigzagLevelOrderBinaryTree {
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> op = new ArrayList<List<Integer>>();
        
        if(root == null) return op;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        boolean isEven = false;
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> element = new ArrayList<Integer>();
            for(int i = 0;i< size; i++){
                TreeNode curr = q.poll();
                if(isEven) element.add(0,curr.val);
                else  element.add(curr.val);
                
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            isEven = isEven?false:true;
            op.add(element);
        }
        
        return op;
        
    }
    
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root) {
        List<List<Integer>> op = new ArrayList<List<Integer>>();
        DFS(op,root,0);
        return op;
        
    }
    
    public void DFS(List<List<Integer>> op,TreeNode root, int ht){
        
        if(root == null) return;
        if(ht >= op.size()){
            op.add(new ArrayList<Integer>());
        }
         if(ht%2 == 0){
             op.get(ht).add(root.val);
         }
        else op.get(ht).add(0,root.val);
        
        DFS(op,root.left,ht+1);
        DFS(op,root.right,ht+1);        
    }
}