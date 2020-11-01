package hm_zhihuibeijing;

public class _11_Recursion {
    public static void main(String[] args) {
//        System.out.println(sum(5));

        move2(3,'a','b','c');
        System.out.println("数量=="+3+",移动次数=="+moveCount);
    }

    public static int sum(int number) {
        if (number < 1) {
            throw new RuntimeException("number must >0 ");
        }

        if (number == 1) {
            return 1;
        } else {
            // sum(5)==
            // 5+       sum(4)==
            // 5+4+     sum(3)==
            // 5+4+3+   sum(2)==
            // 5+4+3+2+ sum(1);
            return number + sum(number - 1);
        }
    }


    /**
     *          汉诺塔
     * @param panNum  盘子数
     * @param a       柱子a---起点柱
     * @param b       柱子b---辅助柱
     * @param c       柱子c---目标柱
     */
    public static void move(int panNum,char a,char b,char c){
        if (panNum == 1) {
            System.out.println("盘："+panNum+"从"+a+"柱移动"+c+"柱");
        }else {
            //先把N-1个盘，从a借助c移动到b
            move(panNum-1,a,c,b);
            //第N个盘从a移动到c
            System.out.println("盘："+panNum+"从"+a+"柱移动"+c+"柱");
            //把N-1个盘，从b借助a移动到c
            move(panNum-1,b,a,c);
        }
    }


    /**
     *  代码优化
     * @param panNum
     * @param a
     * @param b
     * @param c
     */
    private static int moveCount;//移动步数
    public static void  move2(int panNum,char a,char b,char c){
        moveCount++;
        if (panNum != 1) {
            //先把N-1个盘，从a借助c移动到b
            move2(panNum-1,a,c,b);
            //第N个盘从a移动到c
            //把N-1个盘，从b借助a移动到c
            move2(panNum-1,b,a,c);
        }
    }







}
