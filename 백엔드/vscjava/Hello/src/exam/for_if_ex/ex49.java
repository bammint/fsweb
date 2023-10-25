package exam.for_if_ex;

import java.util.Scanner;

public class ex49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("시를 입력해주세요");
        int h = scan.nextInt();
        System.out.println("분을 입력해주세요");
        int m = scan.nextInt();

        if (h >= 0 && h <= 23 && m >= 0 && m <= 59) {
            if (m == 0) {
                System.out.println("30분 전 시간");
                if (h == 0) {
                    System.out.println((h - 1 + 24) + " " + (m + 30));
                } else {
                    System.out.println((h - 1) + " " + (m + 30));
                }
            } else if (m >= 30) {
                System.out.println("30분 전 시간");
                System.out.println((h) + " " + (m - 30));
            } else if (m < 30) {
                System.out.println("30분 전 시간");
                if (h == 0) {
                    System.out.println((h - 1 + 24) + " " + (m + 30));
                } else {
                    System.out.println((h - 1) + " " + (m + 30));
                }
            }
        } else {
            System.out.println("다시 입력해주세요");
        }
        scan.close();
    }
}
