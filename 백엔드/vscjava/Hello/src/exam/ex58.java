package exam;

import java.util.Scanner;

public class ex58 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();

        if(c<a+b){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
