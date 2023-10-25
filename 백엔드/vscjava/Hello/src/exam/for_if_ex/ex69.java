package exam.for_if_ex;

import java.util.Scanner;

public class ex69 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int d = scan.nextInt();
        int n = scan.nextInt();

        int num = a;
        for(int i=0;i<n-1;i++){
            num = num+d;
        }
        System.out.println(num);
    }
}