package 문제;

import java.util.Scanner;

public class A1004_0_37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사각형의 길이를 입력하세요.");
        int sqr = Integer.parseInt(scanner.nextLine());
        System.out.println("-----사각형-----");
        for(int i=1; i<=sqr; i++){
            for(int j=1; j<=sqr-1; j++){
                System.out.print("*");
            }
            System.out.println("*");
        }
        scanner.close();
    }
}
