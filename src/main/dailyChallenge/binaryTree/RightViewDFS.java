package main.dailyChallenge.binaryTree;

import java.util.ArrayList;
import java.util.List;

public class RightViewDFS {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);

        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        rightView(root, list, 0);

        return list;
    }

    public static void rightView(TreeNode curr, List<Integer> list, int currDepth) {
        if (curr == null) {
            return;
        }

        if (list.size() == currDepth) {
            list.add(curr.val);
        }

        rightView(curr.right, list, currDepth + 1);
        rightView(curr.left, list, currDepth + 1);
    }
}
