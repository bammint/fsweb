package exam.for_if_ex;

import java.util.Scanner;

public class ex55 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int grade = scan.nextInt();

        if (grade >= 90 && grade <= 100) {
            System.out.println("A");
            return;
        }
        if (grade >= 80 && grade < 90) {
            System.out.println("B");
            return;
        }
        if (grade >= 70 && grade < 80) {
            System.out.println("C");
            return;
        }
        if (grade >= 60 && grade < 70) {
            System.out.println("D");
            return;
        }
        if (grade < 60 && grade >= 0) {
            System.out.println("F");
            return;
        }
        if (grade > 100 || grade < 0) {
            System.out.println("점수를 다시 입력해주세요");
            return;
        }
        scan.close();
    }
}
