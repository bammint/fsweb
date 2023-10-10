package exam;

import java.util.Scanner;

public class ex52 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        String[] str = { "st", "nd", "rd", "th" };
        if (num != 0 && num < 100) {
            if (num % 10 == 1 && num != 11) {
                System.out.println(num + str[0]);
            } else if (num % 10 == 2 && num != 12) {
                System.out.println(num + str[1]);
            } else if (num % 10 == 3 && num != 13) {
                System.out.println(num + str[2]);
            } else {
                System.out.println(num + str[3]);
            }
        }
        scan.close();
    }
}
