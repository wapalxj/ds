package byd.algorithms.liuyubobobo.datasctructure1.src.chapter10_trie;


import algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set.BSTSet;
import algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set.FileOperation;
import algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set.Set;

import java.util.ArrayList;


/**
 * 比较Trie和Set
 */
public class TestTrie_Set {

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1_000_000_000.0;
    }

    public static void main(String[] args) {
        String filename = "datasctructure1\\src\\pride-and-prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        //Set
        long startTime = System.nanoTime();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            Set<String> bstSet = new BSTSet<>();

            for (String word : words)
                bstSet.add(word);
            for (String word : words)
                bstSet.contains(word);

            System.out.println("Total different words: " + bstSet.getSize());
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("BSTSet : " + time);
        System.out.println("================================================== ");


        //Trie
        startTime = System.nanoTime();
        System.out.println("Total words: " + words.size());
        Trie trie = new Trie();

        for (String word : words)
            trie.add(word);
        for (String word : words)
            trie.contains(word);

        System.out.println("Total different words: " + trie.getSize());

        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("Trie : " + time);

    }
}
