package lb;

public class MyEnum {

    public static void main(String[] args) {
        System.out.println(Usershow.CHART.ordinal());
        System.out.println(Usershow.SCORE.ordinal());
        System.out.println(Usershow.SUBSCRIBE.ordinal());
        System.out.println(Usershow.ORDER.ordinal());
    }

    public enum Usershow{
        CHART,SCORE,SUBSCRIBE,ORDER;
    }
}
