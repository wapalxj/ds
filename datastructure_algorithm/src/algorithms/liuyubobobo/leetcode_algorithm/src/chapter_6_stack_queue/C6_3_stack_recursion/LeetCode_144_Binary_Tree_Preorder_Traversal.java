package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_6_stack_queue.C6_3_stack_recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 遍历的非递归实现
 *
 * 栈模拟递归
 */
public class LeetCode_144_Binary_Tree_Preorder_Traversal {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //模拟指令类
    static class Command {
        String s;//go,print
        TreeNode node;

        Command(String s, TreeNode node) {
            this.s = s;
            this.node = node;
        }
    }

    static class Solution {
        public static List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }

            Stack<Command> stack = new Stack<>();
            stack.push(new Command("go", root));

            while (!stack.isEmpty()) {
                Command command = stack.pop();

                if (command.s.equals("print")) {
                    res.add(command.node.val);
                } else if (command.s.equals("go")) {

                    //后序遍历print放此处

                    if (command.node.right != null) {
                        stack.push(new Command("go", command.node.right));
                    }

                    //中序遍历print放此处

                    if (command.node.left != null) {
                        stack.push(new Command("go", command.node.left));
                    }

                    //前序遍历print
                    stack.push(new Command("print", command.node));
                }
            }

            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(Solution.preorderTraversal(root));
    }

}
