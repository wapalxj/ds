package chapter_7_binaryTree.C7_3_end_condition_of_recursion;

import chapter_7_binaryTree.C7_2_invert_Binary_Tree.LeetCode_226;

public class LeetCode_112_Path_sum {
    public static boolean hasPathSum(LeetCode_226.TreeNode root, int sum) {
        //递归终止条件,错误的写法
//        if (root == null) {
//            return sum == 0;
//        }

        //递归终止条件
        if (root == null) {
            return false;
        }
        //递归终止条件
        //root为叶子结点,才终止
        if (root.left==null && root.right==null) {
            return sum == root.val;
        }

        //左子树的和是否sum-root.val
        if (hasPathSum(root.left, sum - root.val)) {
            return true;
        }

        //右子树的和是否sum-root.val
        if (hasPathSum(root.right, sum - root.val)) {
            return true;
        }

        return false;
    }

}
