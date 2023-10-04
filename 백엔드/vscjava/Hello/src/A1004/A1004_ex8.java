package A1004;

import java.util.Scanner;

public class A1004_ex8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int number = scanner.nextInt();

        if (number % 2 == 0) {
            System.out.println(number + "는 짝수입니다.");
        } else {
            System.out.println(number + "는 홀수입니다.");
        }
    }
}