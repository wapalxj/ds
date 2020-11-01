package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.map;



import algorithms.liuyubobobo.datasctructure1.src.chapter12_AVL.AVLMap;
import algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set.FileOperation;

import java.util.ArrayList;

/**
 * 测试二分搜索书和链表实现的Map对比
 */
public class TestMap {

    private static double testMAP(Map<String,Integer> map,String filename){
        long startTime=System.nanoTime();
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());
            for (String word : words)
                if (map.contains(word)) {
                    map.set(word,map.get(word)+1);
                }else {
                    map.add(word,1);
                }

            System.out.println("Total different words: " + map.getSize());
        }
        long endTime=System.nanoTime();
        return (endTime-startTime)/1000_000_000.0;
    }

    public static void main(String[] args) {
        String filename ="datasctructure1\\src\\pride-and-prejudice.txt";

        BSTMap<String,Integer> bstMap=new BSTMap<>();
        double time2=testMAP(bstMap,filename);
        System.out.println("BST Map: " + time2 +"s");
        System.out.println("================================");

        LinkedListMap<String,Integer> linkedListMap=new LinkedListMap<>();
        double time1=testMAP(linkedListMap,filename);
        System.out.println("LinkedList Map: " + time1 +"s");
        System.out.println("================================");

        AVLMap<String,Integer> avlMap=new AVLMap<>();
        double time3=testMAP(avlMap,filename);
        System.out.println("AVL Map: " + time3 +"s");

    }
}
