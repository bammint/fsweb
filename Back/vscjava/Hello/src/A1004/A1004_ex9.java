package a1004;

import java.util.Scanner;

public class A1004_ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("구구단을 출력할 숫자를 입력하세요: ");
        int number = scanner.nextInt();

        for (int i = 1; i <= 9; i++) {
            System.out.println(number + " x " + i + " = " + (number * i));
        }
    }
}
