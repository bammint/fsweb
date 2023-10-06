package exam;

import java.util.Scanner;

public class ex16 {
    public static void main(String[] args) {
        // 10진수 8진수 바꾸기
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.printf("%o",num);
        // %o 는 8진수
        // %x 는 16진수
        System.out.printf("%x",num);
        scan.close();
    }
}
