package algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set;

import java.util.*;

/**
 * 统计A Tale of Two Cities 和 Pride and Prejudice 字数
 */
public class Main {

    public static void main(String[] args) {
        //Pride and Prejudice
        System.out.println("Pride and Prejudice");

        ArrayList<String> words1 = new ArrayList<>();

        if(FileOperation.readFile("datasctructure1\\src\\pride-and-prejudice.txt", words1)) {
            System.out.println("Total words: " + words1.size());

            BSTSet<String> set1 = new BSTSet<>();
            for (String word : words1)
                set1.add(word);
            System.out.println("Total different words: " + set1.getSize());
        }

        System.out.println();


        //A Tale of Two Cities
        System.out.println("A Tale of Two Cities");

        ArrayList<String> words2 = new ArrayList<>();
        if(FileOperation.readFile("datasctructure1\\src\\a-tale-of-two-cities.txt", words2)){
            System.out.println("Total words: " + words2.size());

            BSTSet<String> set2 = new BSTSet<>();
            for(String word: words2)
                set2.add(word);
            System.out.println("Total different words: " + set2.getSize());
        }
    }
}