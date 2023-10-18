package exam.list;

import java.util.ArrayList;

public class ex03 {
    public static void main(String[] args) {
        // list.add("apple");
        // list.add("banana");
        // list.add("cherry");
        // list.add("date");
        // 바나나 지우기
        
        ArrayList<String> list = new ArrayList<String>();

        list.add("apple");
        list.add("banana");
        list.add("cherry");
        list.add("date");

        list.remove("banana");

        System.out.println(list);
    }
}
