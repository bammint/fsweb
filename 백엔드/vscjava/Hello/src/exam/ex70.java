package exam;

import java.util.Scanner;

public class ex70 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int r = scan.nextInt();
        int n = scan.nextInt();

        int num = a;
        for(int i=0; i<n-1; i++){
            num = num*r;
        }
        System.out.println(num);
    }
}
