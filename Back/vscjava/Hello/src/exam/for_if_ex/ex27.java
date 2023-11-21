package exam.for_if_ex;

import java.util.Scanner;

public class ex27 {
    public static void main(String[] args) {
        // 입력된 두 정수 a, b 중 큰 값을 출력하는 프로그램을 작성해보자
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요>");
        int a = scan.nextInt();
        System.out.print("정수를 입력하세요>");
        int b = scan.nextInt();
        // 삼항 연산자 조건 ? 참 : 거짓
        // int i = (a > b) ? a : b;
        // System.out.println(i);
        if (a > b) {
            System.out.println(a);
        } else {
            System.out.println(b);
        }
        scan.close();
    }
}
