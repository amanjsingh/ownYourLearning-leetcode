package main.dailyChallenge.binaryTree;

import com.sun.source.tree.Tree;

import java.util.*;

public class ConstructFromInPre {

    int preIndex;
    Map<Integer, Integer> inorderMap;

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(9);
//        root.right = new TreeNode(20);
//
//        root.right.left = new TreeNode(15);
//        root.right.right = new TreeNode(7);

        int[] inorder = {9, 3, 15, 20, 7};
        int[] preorder = {3, 9, 20, 15, 7};

//        int[] inorder = {1,2};
//        int[] preorder = {1,2};

        TreeNode root = new ConstructFromInPre().buildTree(preorder, inorder);
        printLevelOrder(root);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return arrayToTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode arrayToTree(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        root.left = arrayToTree(preorder, start, inorderMap.get(rootVal) - 1);
        root.right = arrayToTree(preorder, inorderMap.get(rootVal) + 1, end);

        return root;
    }

    public static void printLevelOrder(TreeNode root) {

        if (root == null) {
            System.out.println("null");
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                System.out.print("null"+" ");
                continue;
            } else {
                System.out.print(curr.val+" ");
            }

            if (curr.left != null) {
                queue.offer(curr.left);
            } else {
                queue.offer(null);
            }

            if (curr.right != null) {
                queue.offer(curr.right);
            } else {
                queue.offer(null);
            }
        }
    }
}
