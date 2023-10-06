package exam;

import java.util.Scanner;

public class ex41 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        float ball = scan.nextFloat();

        if (ball >= 30 && ball <= 40 || ball >= 60 && ball <= 70) {
            System.out.println("win");
        } else {
            System.out.println("lose");
        }

        scan.close();
    }
}
