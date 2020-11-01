package chapter13_red_black_tree;

import chapter12_AVL.AVLTree;
import chapter1_array.Array;
import chapter6_binary_search_tree.BST;
import chapter7_set_and_map.map.BSTMap;

import java.util.ArrayList;
import java.util.Random;

/**
 * 仅测试添加操作--随机数
 */
public class TestAdd {

    public static void main(String[] args) {
        int n = 20_000_000;
        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        //Test BST
        long startTime = System.nanoTime();
        BSTMap<Integer, Integer> bst = new BSTMap<>();
        for (Integer x : testData) {
            bst.add(x, null);
        }
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1_000_000_000.0;
        System.out.println("BST : " + time);

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
