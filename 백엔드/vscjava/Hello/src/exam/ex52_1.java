package exam;

import java.util.Scanner;

public class ex52_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("입력하세요");
        int num = scan.nextInt();

        if (num == 11 || num == 12 || num == 13) {
            System.out.println(num + "th");
        } else if (num % 10 == 1) {
            System.out.println(num + "st");
        } else if (num % 10 == 2) {
            System.out.println(num + "nd");
        } else if (num % 10 == 3) {
            System.out.println(num + "rd");
        } else {
            System.out.println(num + "th");
        }
        scan.close();
    }
}
