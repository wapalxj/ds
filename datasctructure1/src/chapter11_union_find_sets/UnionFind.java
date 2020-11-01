package chapter11_union_find_sets;

public interface UnionFind {
    boolean isConnected(int p,int q);
    void unionElements(int p,int q);
    int getSize();
}
