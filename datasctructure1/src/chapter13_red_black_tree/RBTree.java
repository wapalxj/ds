package chapter13_red_black_tree;

import chapter7_set_and_map.map.Map;
import chapter7_set_and_map.set.FileOperation;
import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;

public class RBTree<K extends Comparable<K>, V> implements Map<K, V> {

    //颜色常量
    private static final boolean RED=true;
    private static final boolean BLACK=false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;//

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color=RED;//默认是红色
        }
    }

    private Node root;
    private int size;

    public RBTree(){
        root=null;
        size=0;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    //某个结点的颜色
    //null结点为黑色
    private boolean isRed(Node node){
        if (node == null) {
            return BLACK;
        }
        return node.color;
    }

    @Override
    public void add(K key, V value) {
        root = add(root, key, value);
        //根节点设为黑色
        root.color=BLACK;
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //       node                            x
    //       / \                           /   \
    //      x   T2    向右旋转 (y)        y    node
    //     / \       - - - - - - - ->          / \
    //    y   T1                              T1  T2

    private Node rightRotate(Node node){
        Node x=node.left;

        //右旋转
        node.left=x.right;
        x.right=node;

        //颜色
        x.color=node.color;
        node.color=RED;

        return x;
    }


    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //  node                            x
    //  /  \                           /  \
    // T1   x      向左旋转  (x)     node  T3
    //     / \   - - - - - - - ->   / \
    //    T2  T3                    T1 T2
    private Node leftRotate(Node node){
        Node x=node.right;

        //左旋转
        node.right=x.left;
        x.left=node;

        //颜色
        x.color=node.color;
        node.color=RED;
        return x;
    }

    //颜色翻转
    private void flipColord(Node node){
        node.color=RED;
        node.left.color=BLACK;
        node.right.color=BLACK;
    }

    //向以node为root的红黑树中插入元素k,v,递归算法
    //返回添加新结点后红黑树的root
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            //more插入红色结点
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        //维护逻辑链条过程

        if (isRed(node.right) && !isRed(node.left)) {
            //右孩子是红色，左孩子不是红色
            node=leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            //右孩子是红色，左孩子不是红色
            node=rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            //右孩子，左孩子-是红色
            flipColord(node);
        }


        return node;
    }


    //返回以node为root的BST中，key所在的结点
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exits!");
        }
        node.value = newValue;
    }


    @Override
    public V remove(K key) {
        Node node=getNode(root,key);
        if (node != null) {
            root=remove(root,key);
            return node.value;
        }
        return null;
    }

    //删除以node为root的树的值为e结点--递归
    //返回删除结点后新的树的root
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key)<0) {
            node.left=remove(node.left,key);
            return node;
        }else if (key.compareTo(node.key)>0) {
            node.right=remove(node.right,key);
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

    //寻找最小元素--递归
    public Node minimum(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimum(node.left);
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


    public static void main(String[] args) {
        String book = "pride-and-prejudice";
        System.out.println(book);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
            RBTree<String, Integer> map = new RBTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                }else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total words is "+words.size());
            System.out.println("Total different words is "+map.getSize());
            System.out.println("Frequency of pride "+map.get("pride"));
            System.out.println("Frequency of prejudice "+map.get("prejudice"));
        }
    }
}
