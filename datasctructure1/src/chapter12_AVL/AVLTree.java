package chapter12_AVL;

import chapter1_array.Array;
import chapter7_set_and_map.map.Map;
import chapter7_set_and_map.set.FileOperation;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public int height;//结点高度

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            height = 1;
        }
    }

    private Node root;
    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    //判断是不是一棵平衡二叉树
    public boolean isBalanced() {
        return isBalanced(root);
    }

    //判断是不是一棵平衡二叉树
    private boolean isBalanced(Node node) {
        if (node == null) {
            //递归到底
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }

        return isBalanced(node.left) && isBalanced(node.right);
    }

    //判断是不是一棵二分搜索树
    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
//            System.out.println(" " + keys.get(i-1));
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                //中序遍历不是升序，就是不是BST
                return false;
            }
        }
        return true;
    }

    //中序遍历
    private void inOrder(Node node, List<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.add(node.key);
        inOrder(node.right, keys);
    }

    //获得结点的高度
    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    //获得结点node的平衡因子
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }


    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node T3 = x.right;

        //右旋转
        x.right = y;
        y.left = T3;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }

    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T4   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T3  z                     T4 T3 T1 T2
    //      / \
    //     T1 T2

    private Node leftRotate(Node y) {
        Node x = y.right;
        Node T3 = x.left;

        //左旋转
        x.left = y;
        y.right = T3;

        //更新height
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    //向以node为root的BST中插入元素k,v,递归算法
    //返回添加新结点后BST的root
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }

        //height更新
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));


        //计算平衡因子
        int balanceFactor = getBalanceFactor(node);
//        if (Math.abs(balanceFactor) > 1) {
//            //不是平衡二叉树
//            System.out.println("unbalanced " + balanceFactor);
//        }


        //维护平衡性

        //LL
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            //左子树更高导致不平衡,并且其左子树更高
            //右旋转
            return rightRotate(node);//返回新的根节点
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            //右子树更高导致不平衡,并且其右子树更高
            //左旋转
            return leftRotate(node);//返回新的根节点
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            //左子树更高导致不平衡,并且其右子树更高
            //先左旋转成LL
            node.left = leftRotate(node.left);
            //LL
            return rightRotate(node);//返回新的根节点
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            //右子树更高导致不平衡,并且其左子树更高
            //先右旋转成RR
            node.right = rightRotate(node.right);
            //RR
            return leftRotate(node);//返回新的根节点
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

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }


    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exits!");
        }
        node.value = newValue;
    }


    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
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

        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode= node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode=  node;
        } else {
            if (node.left == null) {
                //待删除结点左子树为空
                Node rightNode = node.right;
                node.right = null;
                size--;
                retNode= rightNode;
            } else if (node.right == null) {
                //待删除结点右子树为空
                Node leftNode = node.left;
                node.left = null;
                size--;
                retNode= leftNode;
            }else {
                //待删除结点左、右子树都不空
                //找到比待删除结点大的最小结点，即待删除结点右子树的最小结点
                //用这个结点顶替待删除结点
                Node successor = minimum(node.right);
                //注意下面行代码和BST的区别，removeMin时候也需要维护平衡
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;

                node.left = node.right = null;

                retNode= successor;
            }
        }
        if (retNode == null) {
            //删除一个叶子结点的情况
            return null;
        }
        //得到retNode后，维护其平衡,以下逻辑和add中完全一样
        //height更新
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));

        //计算得到retNode后平衡因子
        int balanceFactor = getBalanceFactor(retNode);

        //LL
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0) {
            //左子树更高导致不平衡,并且其左子树更高
            //右旋转
            return rightRotate(retNode);//返回新的根节点
        }

        //RR
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) <= 0) {
            //右子树更高导致不平衡,并且其右子树更高
            //左旋转
            return leftRotate(retNode);//返回新的根节点
        }

        //LR
        if (balanceFactor > 1 && getBalanceFactor(retNode.left) < 0) {
            //左子树更高导致不平衡,并且其右子树更高
            //先左旋转成LL
            retNode.left = leftRotate(retNode.left);
            //LL
            return rightRotate(retNode);//返回新的根节点
        }

        //RL
        if (balanceFactor < -1 && getBalanceFactor(retNode.right) > 0) {
            //右子树更高导致不平衡,并且其左子树更高
            //先右旋转成RR
            node.right = rightRotate(retNode.right);
            //RR
            return leftRotate(retNode);//返回新的根节点
        }

        return retNode;

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
            AVLTree<String, Integer> map = new AVLTree<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total words is " + words.size());
            System.out.println("Total different words is " + map.getSize());
            System.out.println("Frequency of pride " + map.get("pride"));
            System.out.println("Frequency of prejudice " + map.get("prejudice"));


            System.out.println("is BST " + map.isBST());
            System.out.println("is isBalanced " + map.isBalanced());


            for (String word:words) {
                map.remove(word);
                if (!map.isBST() || !map.isBalanced()) {
                    //检测我们的程序在进行remove操作时的正确性
                    throw new RuntimeException("Error");
                }
            }
        }
    }
}