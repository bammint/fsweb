package exam;

import java.util.Scanner;

public class ex58_2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        int[] arr = new int[3];
        arr[0] = a;
        arr[1] = b;
        arr[2] = c;

        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if (maxLength < arr[i]) {
                maxLength = arr[i];
            }
        }
        if (maxLength == arr[0]) {
            if (a < b + c) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } else if (maxLength == arr[1]) {
            if (b < a + c) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        } else if (maxLength == arr[2]) {
            if (c < a + b) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
