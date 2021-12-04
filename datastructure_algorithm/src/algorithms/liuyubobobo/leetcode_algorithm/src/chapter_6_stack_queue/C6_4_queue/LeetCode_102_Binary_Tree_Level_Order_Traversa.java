package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_6_stack_queue.C6_4_queue;

import javafx.util.Pair;

import java.util.*;


/// 二叉树的层序遍历
/// 时间复杂度: O(n), n为树的节点个数
/// 空间复杂度: O(n)
/**
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */

/**
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class LeetCode_102_Binary_Tree_Level_Order_Traversa {
    //   Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            //map---<node,node所在层>
            Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
            q.add(new Pair<>(root, 0));
            while (!q.isEmpty()) {
                TreeNode node = q.peek().getKey();
                int level = q.peek().getValue();
                q.remove();

                if (level == res.size()) {
                    //新一层
                    res.add(new ArrayList<>());
                }
                res.get(level).add(node.val);

                if (node.left != null) {
                    q.add(new Pair<>(node.left, level + 1));
                }

                if (node.right != null) {
                    q.add(new Pair<>(node.right, level + 1));
                }
            }

            return res;
        }
    }
}