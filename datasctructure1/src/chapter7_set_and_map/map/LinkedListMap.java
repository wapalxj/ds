package chapter7_set_and_map.map;
import chapter7_set_and_map.set.FileOperation;
import java.util.ArrayList;

public class LinkedListMap<K, V> implements Map<K, V> {

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(key);
        return node == null ? null : node.value;
    }
    @Override
    public void set(K key, V newValue) {
        Node node = getNode(key);
        if (node == null) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        node.value = newValue;
    }

    @Override
    public void add(K key, V value) {
        Node node = getNode(key);
        if (node == null) {
            dummyHead.next = new Node(key, value, dummyHead.next);
            size++;
        } else {
            //1.抛出异常 2.更新value 3.忽略
            node.value = value;
        }
    }


    @Override
    public V remove(K key) {
        Node prv = dummyHead;
        while (prv.next != null) {
            if (prv.next.key.equals(key)) {
                break;
            }
            prv = prv.next;
        }
        if (prv.next != null) {
            Node delNode = prv.next;
            prv.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }

        return null;
    }


    public static void main(String[] args) {
        String book = "pride-and-prejudice";
        System.out.println(book);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
            LinkedListMap<String, Integer> map = new LinkedListMap<>();
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
