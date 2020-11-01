package chapter13_red_black_tree;

import chapter12_AVL.AVLTree;
import chapter14_hash.HashTable;
import chapter7_set_and_map.map.BSTMap;
import chapter7_set_and_map.set.FileOperation;

import java.util.ArrayList;

/**
 * 比较BST和AVL
 */
public class TestAVL_BST_RBT {
    public static void main(String[] args) {
        String book = "pride-and-prejudice";
        System.out.println(book);
        ArrayList<String> words = new ArrayList<>();

        //Test BSTMAP
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
//            Collections.sort(words);//按顺序放，BST退化成链表
            long startTime = System.nanoTime();

            BSTMap<String, Integer> map = new BSTMap<>();
            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map. add(word, 1);
                }
            }
            for (String word : words) {
                map.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("BSTMap : " + time);

        }
        words.clear();


        //TestAVL
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
//            Collections.sort(words);//按顺序放也非常快
            long startTime = System.nanoTime();

            AVLTree<String, Integer> avlTree = new AVLTree<>();
            for (String word : words) {
                if (avlTree.contains(word)) {
                    avlTree.set(word, avlTree.get(word) + 1);
                } else {
                    avlTree.add(word, 1);
                }
            }
            for (String word : words) {
                avlTree.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("AvlTree : " + time);
        }

        words.clear();

        //TestRBT
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
//            Collections.sort(words);//按顺序放也非常快
            long startTime = System.nanoTime();

            RBTree<String, Integer> rbTree = new RBTree<>();
            for (String word : words) {
                if (rbTree.contains(word)) {
                    rbTree.set(word, rbTree.get(word) + 1);
                } else {
                    rbTree.add(word, 1);
                }
            }
            for (String word : words) {
                rbTree.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("RBTree : " + time);
        }

        words.clear();

        //TestHashTable
        if (FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words)) {
//            Collections.sort(words);//按顺序放也非常快
            long startTime = System.nanoTime();

            HashTable<String, Integer> hashTable = new HashTable<>();
            for (String word : words) {
                if (hashTable.contains(word)) {
                    hashTable.set(word, hashTable.get(word) + 1);
                } else {
                    hashTable.add(word, 1);
                }
            }
            for (String word : words) {
                hashTable.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1_000_000_000.0;
            System.out.println("HashTable : " + time);
        }
    }
}
