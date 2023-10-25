package exam.for_if_ex;

import java.util.Scanner;

public class ex60 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        int d = 170;

        if (a > d) {
            System.out.println("PASS");
            if (b > d) {
                System.out.println("PASS");
                if (c > d) {
                    System.out.println("PASS");
                } else {
                    System.out.println("CRASH " + c);
                }
            } else {
                System.out.println("CRASH " + b);
            }
        } else {
            System.out.println("CRASH " + a);
        }
    }
}
