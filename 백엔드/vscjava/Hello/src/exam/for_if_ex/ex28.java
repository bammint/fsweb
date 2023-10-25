package exam.for_if_ex;

import java.util.Scanner;

public class ex28 {
    public static void main(String[] args) {
        // 입력된 두 정수 a, b, c 중 큰 값을 출력하는 프로그램을 작성해보자
        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요>");
        int a = scan.nextInt();
        System.out.print("정수를 입력하세요>");
        int b = scan.nextInt();
        System.out.print("정수를 입력하세요>");
        int c = scan.nextInt();

        if(a%2 == 0){
            System.out.println(a);
        }
        if(b%2 == 0){
            System.out.println(b);
        }
        if(c%2 == 0){
            System.out.println(c);
        }

        scan.close();
    }
}
