package byd.algorithms.liuyubobobo.datasctructure1.src.chapter10_trie;

import java.util.Map;
import java.util.TreeMap;

public class Trie {
    private class Node {
        public boolean isWord;//是否单词结尾
        public TreeMap<Character, Node> next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next=new TreeMap<>();
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    public int getSize() {
        return size;
    }

    //向Trie添加一个单词
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;//表示单词末尾
            size++;
        }
    }


    //查询
    public boolean contains(String word) {
        Node cur=root;
        for (int i = 0; i < word.length(); i++) {
            char c=word.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur=cur.next.get(c);
        }
        //注意不能直接返回true
        return cur.isWord;
    }



    //查询是否在Trie中有单词以prefix为前缀
    public boolean isPrefix(String prefix) {
        Node cur=root;
        for (int i = 0; i < prefix.length(); i++) {
            char c=prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur=cur.next.get(c);
        }
        return true;
    }




    //向Trie添加一个单词--递归
    public void add2(String word) {
        Node cur = root;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
//            if (cur.next.get(c) == null) {
//                cur.next.put(c, new Node());
//            }
//            cur = cur.next.get(c);
            add(root,c);
        }
        if (!cur.isWord) {
            cur.isWord = true;//表示单词末尾
            size++;
        }
    }

    private Node add(Node node,char c){
        if (node.next.get(c) == null) {
            return new Node();
        }

        return null;
    }
}
