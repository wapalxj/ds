package chapter_7_graph;

/**
 * 连通分量
 */
public class Components {
    Graph g;
    boolean[] visited;
    int ccount;//连通分量数
    int id[];// 每个节点所对应的联通分量标记

    public Components(Graph g) {
        this.g = g;
        visited = new boolean[this.g.V()];
        ccount = 0;
        for (int i = 0; i < this.g.V(); i++) {
            visited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < this.g.V(); i++) {
            if (!visited[i]) {
                //深度优先
                dfs(i);
                ccount++;
            }
        }
    }

    public int count() {
        return ccount;
    }

    /**
     * 对v结点进行深度优先遍历
     */
    private void dfs(int v) {
        visited[v] = true;
        id[v] = ccount;
        for (int i : this.g.adj(v)) {
            if (!visited[i]) {
                //没有被遍历过
                dfs(i);
            }
        }
    }

    /**
     * 2个结点是否相连
     * @param v
     * @param w
     * @return
     */
    public boolean isConnected(int v, int w) {
        assert (v >= 0 && v < g.V());
        assert (w >= 0 && w < g.V());
        return id[v] == id[w];
    }

    public static void main(String[] args) {
        // TestG1.txt
        String filename1 = "G:\\GIT\\datastructure\\datastructure_algorithm\\src\\chapter_7_graph\\testG1";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Components component1 = new Components(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "G:\\GIT\\datastructure\\datastructure_algorithm\\src\\chapter_7_graph\\testG2";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Components component2 = new Components(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());

    }
}
