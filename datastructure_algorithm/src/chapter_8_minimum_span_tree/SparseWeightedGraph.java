package chapter_8_minimum_span_tree;

import chapter_7_graph.Graph;

import java.util.Vector;

/**
 * 稀疏图--邻接表
 */
public class SparseWeightedGraph<Weight extends Number & Comparable> implements WeightedGraph {
    private int n;  // 节点数
    private int m;  // 边数
    private boolean directed;    // 是否为有向图
    private Vector<Edge<Weight>>[] g; // 图的具体数据

    // 构造函数
    public SparseWeightedGraph(int n, boolean directed) {
        assert n >= 0;
        this.n = n;
        this.m = 0;    // 初始化没有任何边
        this.directed = directed;
        // g初始化为n个空的vector, 表示每一个g[i]都为空, 即没有任和边
        g = (Vector<Edge<Weight>>[])new Vector[n];
        for (int i = 0; i < n; i++)
            g[i] = new Vector<>();
    }

    public int V() {
        return n;
    } // 返回节点个数

    public int E() {
        return m;
    } // 返回边的个数

    // 向图中添加一个边
    public void addEdge(Edge e) {

        assert e.v() >= 0 && e.v() < n ;
        assert e.w() >= 0 && e.w() < n ;

        //判断时间复杂度交低，所以这里不处理平行边问题


        g[e.v()].add(new Edge(e));
        if( e.v() != e.w() && !directed )
            g[e.w()].add(new Edge(e.w(), e.v(), e.wt()));

        m++;
    }

    // 验证图中是否有从v到w的边
    //O(n)
    public boolean hasEdge(int v, int w) {

        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        for (int i = 0; i < g[v].size(); i++)
            if( g[v].elementAt(i).other(v) == w )
                return true;
        return false;
    }

    @Override
    public void show() {
//        for( int i = 0 ; i < n ; i ++ ){
//            System.out.print("vertex " + i + ":\t");
//            for( int j = 0 ; j < g[i].size() ; j ++ )
//                System.out.print(g[i].elementAt(j) + "\t");
//            System.out.println();
//        }
        for( int i = 0 ; i < n ; i ++ ){
            System.out.print("vertex " + i + ":\t");
            for( int j = 0 ; j < g[i].size() ; j ++ ){
                Edge e = g[i].elementAt(j);
                System.out.print( "( to:" + e.other(i) + ",wt:" + e.wt() + ")\t");
            }
            System.out.println();
        }
    }

    // 返回图中一个顶点的所有邻边
    // 由于java使用引用机制，返回一个Vector不会带来额外开销,
    public Iterable<Edge<Weight>> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

    public static void main(String[] args) {
        String filename = "G:\\GIT\\datastructure\\datastructure_algorithm\\src\\chapter_8_minimum_span_tree\\testG1";
        SparseWeightedGraph<Double> g1 = new SparseWeightedGraph<Double>(8, false);
        ReadWeightedGraph readGraph1 = new ReadWeightedGraph(g1, filename);
        System.out.println("test G1 in Sparse Weighted Graph:");
        g1.show();
    }
}
