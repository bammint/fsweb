package exam.for_if_ex;

import java.util.Scanner;

public class ex14 {
    public static void main(String[] args) {
        // 시간이 특정 형식에 맞추어 입력될 때 그대로 출력하는 프로그램을 작성 해보자.
        
        Scanner scan = new Scanner(System.in);
        System.out.println("시를 입력하세요");
        int h = scan.nextInt();
        System.out.println("분을 입력하세요");
        int m = scan.nextInt();

        System.out.println("시간\n" + h + ":" + m);

        scan.close();
    }
}
