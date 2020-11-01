package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set;


import algorithms.liuyubobobo.datasctructure1.src.chapter12_AVL.AVLSet;

import java.util.ArrayList;

/**
 * 测试二分搜索书和链表实现的Set对比
 */
public class TestSet {

    private static double testSet(Set<String> set,String filename){
        long startTime=System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words)
                set.add(word);
            System.out.println("Total different words: " + set.getSize());
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000_000_000.0;
    }

    public static void main(String[] args) {
        String filename ="datasctructure1\\src\\pride-and-prejudice.txt";

        BSTSet<String> bstSet=new BSTSet<>();
        double time1=testSet(bstSet,filename);
        System.out.println("BST Set: " + time1 +"s");

        System.out.println("================================");

        LinkedListSet<String> linkedListSet=new LinkedListSet<>();
        double time2=testSet(linkedListSet,filename);
        System.out.println("LinkedListSet Set: " + time2 +"s");

        System.out.println("================================");


        AVLSet<String> avlSet=new AVLSet<>();
        double time3=testSet(avlSet,filename);
        System.out.println("LinkedListSet Set: " + time3 +"s");
    }
}
