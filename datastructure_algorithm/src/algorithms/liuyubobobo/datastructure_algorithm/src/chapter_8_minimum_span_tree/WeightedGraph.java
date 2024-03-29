package algorithms.liuyubobobo.datastructure_algorithm.src.chapter_8_minimum_span_tree;

public interface WeightedGraph <Weight extends Number & Comparable>{
    public int V();
    public int E();
    public void addEdge(Edge<Weight> e);
    boolean hasEdge(int v, int w);
    void show();
    public Iterable<Edge<Weight>> adj(int v);
}
