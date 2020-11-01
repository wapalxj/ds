package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.map;

import algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set.FileOperation;

import java.util.ArrayList;
import java.util.stream.BaseStream;

public class BSTMap<K extends Comparable<K>, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BSTMap(){
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


    @Override
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
            BSTMap<String, Integer> map = new BSTMap<>();
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
