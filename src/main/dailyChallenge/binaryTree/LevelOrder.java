package main.dailyChallenge.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.left.left = new TreeNode(1);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(8);

        System.out.println(levelOrder(root));
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if(root == null){
            return list;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> subList;
        int queueSize;

        while(!queue.isEmpty()){
            subList = new ArrayList<>();
            queueSize = queue.size();
            for(int i=0; i<queueSize; i++){
                TreeNode curr = queue.poll();

                subList.add(curr.val);

                if(curr.left != null){
                    queue.offer(curr.left);
                }
                if(curr.right != null){
                    queue.offer(curr.right);
                }
            }
            list.add(subList);
        }
        return list;
    }
}
