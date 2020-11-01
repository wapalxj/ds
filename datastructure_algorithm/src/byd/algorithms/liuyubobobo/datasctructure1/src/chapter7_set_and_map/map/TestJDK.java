package byd.algorithms.liuyubobobo.datasctructure1.src.chapter7_set_and_map.map;

import java.util.*;
import java.util.Map;

public class TestJDK {
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "a");
        map.put("2", "b");
        map.put("3", "c");
        map.put("4", "d");

//        Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
//
//        System.out.println("以下是accessOrder=true的情况:");
//
//        map = new LinkedHashMap<String, String>(10, 0.75f, true);
//        map.put("1", "a");
//        map.put("2", "b");
//        map.put("3", "c");
//        map.put("4", "d");
//        map.get("2");//2移动到了内部的链表末尾
//        map.get("4");//4调整至末尾
//        map.put("3", "e");//3调整至末尾
//        map.put(null, null);//插入两个新的节点 null
//        map.put("5", null);//5
//        iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }

        LinkedHashMap linkedHashMap=new LinkedHashMap();
        linkedHashMap.entrySet().iterator();
        linkedHashMap.keySet().iterator();
        linkedHashMap.values().iterator();

        System.out.println(~0);
    }


    static class Parent{
        public boolean hasNext(){
            return true;
        }
    }

    class Child extends Parent implements MyIterator{
        @Override
        public Object next() {
            return null;
        }
    }

    interface MyIterator<E>{
        boolean hasNext();

        E next();
    }
}