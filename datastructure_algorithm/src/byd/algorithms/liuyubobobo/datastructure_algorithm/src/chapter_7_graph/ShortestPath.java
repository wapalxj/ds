package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter_7_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;
/**
 * 广度优先遍历--最短路径
 */
public class ShortestPath {
    private Graph g;
    int src;//源点,起始点
    boolean[] visited;// 记录bfs中节点是否被访问
    int[] from;//路径的起点,记录路径, from[i]表示查找的路径上i的上一个节点
    int[] order;// 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。

    public ShortestPath(Graph g, int src) {
        this.g = g;
        assert (src >= 0 && src < this.g.V());
        visited = new boolean[this.g.V()];
        from = new int[this.g.V()];
        order = new int[this.g.V()];
        for (int i = 0; i < g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
            order[i] = -1;
        }
        this.src = src;
        Queue<Integer> queue = new LinkedList<>();

        //无向图最短路径算法
        queue.add(src);
        visited[src]=true;
        order[src]=0;
        while (!queue.isEmpty()){
            int v=queue.remove();
            for (int i : this.g.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i]=true;
                    from[i]=v;
                    order[i]=order[v]+1;
                }
            }
        }
    }

    //src到w是否有路径
    public boolean hasPath(int w) {
        assert (w >= 0 && w < this.g.V());
        return visited[w];
    }

    //src到w的路径,最短路径
    public Vector<Integer> path(int w) {
        assert hasPath(w) ;

        Vector<Integer> path=new Vector<>();
        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            //倒着往回走,通过from数组逆向查找到从s到w的路径, 存放到栈中
            stack.push(p);
            p = from[p];
        }
        while (!stack.empty()){
            path.add(stack.pop());
        }
        return path;
    }

    //src到w的最短路径打印
    public void showPath(int w) {
        assert hasPath(w) ;

        Vector<Integer> path=path(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i == path.size()-1) {
                System.out.println();
            }else {
                System.out.print("--->");
            }
        }
    }

    //src到w的最短路径长度
    public int length(int w){
        assert (w >= 0 && w < this.g.V());
        return order[w];
    }

    public static void main(String[] args) {
        String filename = "G:\\GIT\\datastructure\\datastructure_algorithm\\src\\chapter_7_graph\\testG";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        // 比较使用深度优先遍历和广度优先遍历获得路径的不同
        // 广度优先遍历获得的是无权图的最短路径
        Path dfs = new Path(g,0);
        System.out.print("DFS : ");
        dfs.showPath(4);

        ShortestPath bfs = new ShortestPath(g,0);
        System.out.print("BFS : ");
        bfs.showPath(4);
    }
}