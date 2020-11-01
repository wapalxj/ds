package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter_7_graph;

import java.util.Stack;
import java.util.Vector;

/**
 * 深度优先遍历
 */
public class Path {
    Graph g;
    boolean[] visited;// 记录dfs的过程中节点是否被访问
    int src;//源点,起始点
    int from[];//路径的起点,记录路径, from[i]表示查找的路径上i的上一个节点

    public Path(Graph g, int src) {
        this.g = g;
        assert (src >= 0 && src < this.g.V());

        visited = new boolean[this.g.V()];
        from = new int[this.g.V()];
        for (int i = 0; i < this.g.V(); i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.src = src;

        //寻路算法
        dfs(this.src);
    }

    /**
     * 对v结点进行深度优先遍历
     */
    private void dfs(int v) {
        visited[v] = true;
        for (int i : this.g.adj(v)) {
            if (!visited[i]) {
                //没有被遍历过
                from[i] = v;
                dfs(i);
            }
        }
    }

    //src到w是否有路径
    public boolean hasPath(int w) {
        assert (w >= 0 && w < this.g.V());
        return visited[w];
    }

    //src到w的路径
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

    //src到w的路径打印
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


    public static void main(String[] args) {
        String filename = "G:\\GIT\\datastructure\\datastructure_algorithm\\src\\chapter_7_graph\\testG";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}
