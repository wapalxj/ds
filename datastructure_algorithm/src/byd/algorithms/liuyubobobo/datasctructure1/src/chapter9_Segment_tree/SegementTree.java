package byd.algorithms.liuyubobobo.datasctructure1.src.chapter9_Segment_tree;

public class SegementTree<E> {
    private E[] data;
    private E[] tree;//线段树
    private Merger<E> merger;

    public SegementTree(E[] arr, Merger<E> merger) {
        if (merger == null) {
            throw new IllegalArgumentException("merger cannot be null");
        }
        this.merger = merger;//接口
        data = (E[]) new Object[arr.length];
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    //在treeIndex的位置创建区间[left...right]的线段树
    private void buildSegmentTree(int treeIndex, int left, int right) {
        if (left == right) {
            tree[treeIndex] = data[left];
            return;
        }
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
//        int mid=(left+right)/2;//l+r可能会溢出int范围
        int mid = left + (right - left) / 2;//防止溢出的写法

        buildSegmentTree(leftTreeIndex, left, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, right);

        //接口回调
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    public int getSize() {
        return data.length;
    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        return data[index];
    }

    //返回index索引的leftChild
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    //返回index索引的rightChild
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    /**
     * 查询操作
     * @param queryLeft
     * @param queryRight
     * @return
     */
    //返回区间[queryLeft,queryRight]的值
    public E query(int queryLeft, int queryRight) {
        if (queryLeft < 0 || queryLeft >= data.length ||
                queryRight < 0 || queryRight >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }

        return query(0, 0, data.length - 1, queryLeft, queryRight);
    }

    //在treeID 为根的线段树中[left...right]的范围里，搜索区间[queryLeft...queryRight]的值
    private E query(int treeIndex, int left, int right, int queryLeft, int queryRight) {
        if (left == queryLeft && right == queryRight) {
            //查询结果就是当前结点
            return tree[treeIndex];
        }
        int mid = left + (right - left) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryLeft >= mid + 1) {
            //查询结果在右边界
            return query(rightTreeIndex, mid + 1, right, queryLeft, queryRight);
        } else if (queryRight <= mid) {
            //查询结果在左边界
            return query(leftTreeIndex, left, mid, queryLeft, queryRight);
        }
        //左边、右边都有
        E leftResult=query(leftTreeIndex, left, mid, queryLeft, mid);
        E rightResult=query(rightTreeIndex, mid + 1, right, mid + 1, right);

        return merger.merge(leftResult,rightResult);
    }


    /**
     * 更新操作
     * @param index
     * @param e
     */
    public void set(int index,E e){
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("Index is illegal");
        }
        data[index]=e;
        set(0,0,data.length-1,index,e);
    }

    //在treeIndex为根的线段树中新index为e
    private void set(int treeIndex,int left,int right,int index,E e) {
        if (left==right) {
            tree[treeIndex]=e;
            return;
        }

        int mid=left+(right-left)/2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >=mid+1) {
            set(rightTreeIndex,mid+1,right,index,e);
        }else  {
            set(leftTreeIndex,left,mid,index,e);
        }
        tree[treeIndex]=merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("[");
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] != null) {
                res.append(tree[i]);
            } else {
                res.append("null");
            }

            if (1 != tree.length - 1) {
                res.append(", ");
            }
        }

        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegementTree<Integer> segementTree = new SegementTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                //求区间的和
                return a + b;
            }
        });
        //查看
//        System.out.println(segementTree);

//        System.out.println(segementTree.query(0,2));
//        System.out.println(segementTree.query(2,5));
//        System.out.println(segementTree.query(0,5));
        //更新
        System.out.println(segementTree.query(0,2));
        segementTree.set(1,2);
        System.out.println(segementTree.query(0,2));
    }
}
