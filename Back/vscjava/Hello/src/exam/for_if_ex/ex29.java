package exam.for_if_ex;

import java.util.Scanner;

public class ex29 {
    public static void main(String[] args) {
        // 입력된 두 정수 a, b, c 가 입력되었을 때, 짝수 출력

        Scanner scan = new Scanner(System.in);
        System.out.print("정수를 입력하세요>");
        int a = scan.nextInt();
        System.out.print("정수를 입력하세요>");
        int b = scan.nextInt();
        System.out.print("정수를 입력하세요>");
        int c = scan.nextInt();
        int[] num = { a, b, c };

        int i;
        for (i = 0; i < num.length; i++) {
            if (num[i] % 2 == 0) {
                System.out.println("even");
            } else {
                System.out.println("odd");
            }
        }

        scan.close();
    }
}
