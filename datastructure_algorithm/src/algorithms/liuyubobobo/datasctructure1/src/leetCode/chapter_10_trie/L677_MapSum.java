package algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_10_trie;


import java.util.TreeMap;

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */


public class L677_MapSum {

    private class Node {
        public int value;
        public TreeMap<Character, Node> next;

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public L677_MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;//字符串中表示单词末尾在此对应value
    }

    public int sum(String prefix) {
        //先遍历到prefix的最后一个字符
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        //计算cur开始的所有value和
        return sum(cur);
    }

    //遍历node及子树，将所有的value加起来
    private int sum(Node node) {
//        if (node.next.size()==0) {
//            //递归到底
//            //这个if可以省略，因为在叶子结点时候，下面的2不执行，3完全与此处等价
//            return node.value;
//        }


        int res = node.value;//1
        for (char c : node.next.keySet()) {//2
            res += sum(node.next.get(c));
        }
        return res;//3
    }
}
