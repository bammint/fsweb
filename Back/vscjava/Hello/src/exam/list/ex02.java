package exam.list;

import java.util.ArrayList;

public class ex02 {
    public static void main(String[] args) {
        // 문제 2: ArrayList 요소 합계 계산
        // ArrayList에 정수 요소를 추가하고, 이 요소들의 합계를 계산하여 출력하세요.

        ArrayList<Integer> list = new ArrayList<Integer>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        System.out.println(sum);
    }
}
