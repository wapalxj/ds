package chapter6_binary_search_tree;

import java.util.*;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }


    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (root == null) {
//            root=new Node(e);
//            size++;
//        }else {
//            add(root,e);
//        }

        root = add(root, e);
    }

    //向以node为root插入元素e,递归
    //返回插入新结点后树的根
    private Node add(Node node, E e) {
        //递归终止条件
//        if (e.equals(node.e)) {
//            return;
//        }else if (e.compareTo(node.e)<0 && node.left==null) {
//            node.left=new Node(e);
//            size++;
//            return;
//        }else if(e.compareTo(node.e)>0 && node.right==null){
//            node.right=new Node(e);
//            size++;
//            return;
//        }

//        if (e.compareTo(node.e)<0) {
//            add(node.left,e);
//        }else {
//            add(node.right,e);
//        }


        //递归终止条件
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }

        return node;
    }


    //查询以node为root的树种是否包含e,递归算法
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            //递归终止条件
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            //递归终止条件
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //前序遍历，非递归
    public void preOrderNR() {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                //先压入右子树
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }


    //前序遍历，递归
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为root的树，递归
    private void preOrder(Node node) {
        if (node == null) {
            //递归终止条件
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    //中序遍历以node为root的树，递归
    private void inOrder(Node node) {
        if (node == null) {
            //递归终止条件
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历
    public void postOrder() {
        postOrder(root);
    }

    //后序遍历以node为root的树，递归
    private void postOrder(Node node) {
        if (node == null) {
            //递归终止条件
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }


    /**
     * 广度优先遍历——层序遍历
     */
    public void levelOrder(){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur=queue.remove();
            System.out.println(cur.e);

            if (cur.left != null) {
                queue.add(cur.left);
            }

            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }


    /**
     * 寻找最小元素
     * @return
     */
    public E minimum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        //递归
        return minimum(root).e;
    }

    //寻找最小元素--递归
    public Node minimum(Node node){
        if (node.left==null) {
            return node;
        }
        return minimum(node.left);
    }

    //寻找最小元素--非递归
    public Node minimumNR(Node node){
        Node resNode=node;
        while (resNode.left!=null){
            resNode=resNode.left;
        }
        return resNode;
    }

    /**
     * 寻找最大元素
     * @return
     */
    public E maximum(){
        if (size == 0) {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).e;
    }

    public Node maximum(Node node){
        if (node.right==null) {
            return node;
        }
        return maximum(node.right);
    }


    /**
     * 删除最小值结点,并返回
     * @return
     */
    public E removeMin(){
        E ret=minimum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为root的树的最小结点
    //返回删除结点后新的树的root
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除最大值结点,并返回
     * @return
     */
    public E removeMax(){
        E ret=maximum();
        root = removeMin(root);
        return ret;
    }

    //删除以node为root的树的最小结点
    //返回删除结点后新的树的root
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 删除
     */
    public void remove(E e){
        root=remove(root,e);
    }

    //删除以node为root的树的值为e结点--递归
    //返回删除结点后新的树的root
    private Node remove(Node node, E e) {
        if (node == null) {
            return null;
        }

        if (e.compareTo(node.e)<0) {
            node.left=remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0) {
            node.right=remove(node.right,e);
            return node;
        }else {
            if (node.left == null) {
                //待删除结点左子树为空
                Node rightNode=node.right;
                node.right=null;
                size--;
                return rightNode;
            }

            if (node.right == null) {
                //待删除结点右子树为空
                Node leftNode=node.left;
                node.left=null;
                size--;
                return leftNode;
            }

            //待删除结点左、右子树都不空
            //找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
            //用这个结点顶替待删除结点

            Node successor=minimum(node.right);
            successor.right=removeMin(node.right);
            successor.left=node.left;

            node.left=node.right=null;

            return successor;
        }

    }


    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    private void generateBSTString(Node node, int depth, StringBuilder res) {
        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }
        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }

        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};

        for (int num : nums) {
            bst.add(num);
        }

        System.out.println(bst);
        System.out.println();
        ///////////////////
        //      5        //
        //    /   \      //
        //   3     6     //
        //  / \     \    //
        // 2   4     8   //
        ///////////////////

        //前序遍历
//        bst.preOrder();

        //中序遍历
//        bst.inOrder();

        //后序遍历
//        bst.postOrder();

        //前序遍历-非递归
//        bst.preOrderNR();

        //层序遍历
//        bst.levelOrder();




        //删除元素
        BST<Integer> bst2 = new BST<>();
        Random random=new Random();
        int n=20;
        for (int i = 0; i < n; i++) {
            bst2.add(random.nextInt(100));
        }

        ArrayList<Integer> nums2=new ArrayList<>();
        while (!bst2.isEmpty()){
            nums2.add(bst2.removeMin());
        }

        System.out.println(nums2);

    }

}
