package com.prg.learning;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SumOfDeepestLeaves {
    public static void main(String[] args) {
        int[] inputs = {6, 7, 8, 2, 7, 1, 3, 9, -999, 1, 4, -999, -999, -999, 5};
        int n = 0;
        TreeNode root = new TreeNode(6);
        root = new SumOfDeepestLeaves().buildBT(root, inputs, 0);
        TreeNode temp = root;
        //   new SumOfDeepestLeaves().inOrder(temp);

        int result = new SumOfDeepestLeaves().findSum(root);
        System.out.println("result -> " + result);
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    private TreeNode buildBT(TreeNode root, int[] inputs, int i) {
        if (i < inputs.length) {
            if (inputs[i] == -999) {
                return null;
            }
            root = new TreeNode(inputs[i]);
            root.left = buildBT(root.left, inputs, i * 2 + 1);
            root.right = buildBT(root.right, inputs, i * 2 + 2);
        }
        return root;
    }

    private int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int sum = 0;
        while (!q.isEmpty()) {
            sum = 0;
            int qsize = q.size();
            while (qsize-- > 0) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
        }
        return sum;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            while (size-- > 0) {

                TreeNode temp = q.poll();
                list.add(temp.val);
                if (temp.left != null) q.offer(temp.left);
                if (temp.right != null) q.offer(temp.right);
            }
            res.add(list);
        }
        return res;
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    private boolean isValidBST(TreeNode root, int maxValue, int minValue) {
        if (root.val > minValue && root.val < maxValue) {
            return isValidBST(root, root.val, minValue) && isValidBST(root, maxValue, root.val);
        } else {
            return false;
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
