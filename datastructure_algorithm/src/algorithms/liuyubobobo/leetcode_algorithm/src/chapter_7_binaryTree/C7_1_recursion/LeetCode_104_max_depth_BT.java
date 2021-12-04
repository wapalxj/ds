package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_7_binaryTree.C7_1_recursion;

public class LeetCode_104_max_depth_BT {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }

        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            if (root.left == null && root.right == null) {
                return 1;
            }

            int ret = Integer.MAX_VALUE;
            if (root.left != null) {
                ret=Math.min(ret, minDepth(root.left) + 1);
            }
            if (root.right != null) {
                ret=Math.min(ret, minDepth(root.right) + 1);
            }
            return ret;
        }
    }
}
