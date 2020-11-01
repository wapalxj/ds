package chapter_7_graph;

import java.util.Iterator;
import java.util.Vector;

/**
 * 相邻结点遍历
 */
public class TestGraph {
    public static void main(String[] args) {
        int N=20;
        int M=100;
        SparseGraph sparseGraph=new SparseGraph(N,false);
        DenseGraph denseGraph=new DenseGraph(N,false);
        //稀疏图
        for (int i = 0; i < M; i++) {
            int a= (int) (Math.random()*N);
            int b= (int) (Math.random()*N);
            sparseGraph.addEdge(a,b);
            denseGraph.addEdge(a,b);
        }
        for (int v = 0; v < N; v++) {
            Vector<Integer> vector = (Vector) sparseGraph.adj(v);
            System.out.print(v+": ");
            for (Integer i:vector){
                System.out.print(i+" ");
            }
            System.out.println();
        }

        System.out.println("//稠密图///////////////////////////////////////////");
        //稠密图/////////////////////////////////////////////////////////


        for (int v = 0; v < N; v++) {
            Vector<Integer> vector = (Vector) denseGraph.adj(v);
            System.out.print(v+": ");
            for (Integer i:vector){
                System.out.print(i+" ");
            }
            System.out.println();
        }

    }
}
