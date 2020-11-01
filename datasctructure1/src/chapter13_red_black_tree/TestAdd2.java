package chapter13_red_black_tree;

import chapter12_AVL.AVLTree;
import chapter7_set_and_map.map.BSTMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * 仅测试添加操作--有序数
 */
public class TestAdd2 {

    public static void main(String[] args) {
        int n = 20_000_000;
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(i);
        }

        //Test BST
        long startTime ;
        long endTime;
        double time;
        //Test AVL
        startTime = System.nanoTime();
        AVLTree<Integer, Integer> avlTree = new AVLTree<>();
        for (Integer x : testData) {
            avlTree.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("AVL : " + time);


        //Test RBT
        startTime = System.nanoTime();
        RBTree<Integer, Integer> rbTree = new RBTree<>();
        for (Integer x : testData) {
            rbTree.add(x, null);
        }
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("RBT : " + time);


    }
}
