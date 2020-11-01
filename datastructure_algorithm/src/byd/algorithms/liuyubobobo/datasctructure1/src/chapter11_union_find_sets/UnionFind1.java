package byd.algorithms.liuyubobobo.datasctructure1.src.chapter11_union_find_sets;

public class UnionFind1 implements UnionFind {

    private int[] ids;


    public UnionFind1(int size) {
        ids = new int[size];

        for (int i = 0; i < ids.length; i++) {
            ids[i] = i;
        }
    }

    @Override
    public int getSize() {
        return ids.length;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p)==find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pId=find(p);
        int qId=find(q);
        if (pId == qId) {
            return;
        }

        for (int i = 0; i < ids.length; i++) {
            if (ids[i] == pId) {
                ids[i] =qId;
            }
        }
    }

    //查找元素p的集合的编号
    private int find(int p){
        if (p<0|| p>=ids.length) {
            throw new IllegalArgumentException("p is out of bounds");
        }
        return ids[p];
    }


}
