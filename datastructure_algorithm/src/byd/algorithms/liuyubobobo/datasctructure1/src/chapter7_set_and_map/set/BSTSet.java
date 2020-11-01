package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.set;

import algorithms.liuyubobobo.datasctructure1.src.chapter6_binary_search_tree.BST;

/**
 * 基于BST的Set
 */
public class BSTSet<E extends Comparable<E>> implements Set<E>{
    private BST<E> bst;

    public BSTSet(){
        bst=new BST<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
