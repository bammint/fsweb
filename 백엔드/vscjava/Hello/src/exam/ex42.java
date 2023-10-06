package exam;

import java.util.Scanner;

public class ex42 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float ball = scan.nextFloat();

        if (ball >= 50 && ball <= 60 || ball%6 == 0) {
            System.out.println("win");
        } else {
            System.out.println("lose");
        }

        scan.close();
    }
}
