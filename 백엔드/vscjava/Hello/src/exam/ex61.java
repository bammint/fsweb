package exam;

import java.util.Scanner;

public class ex61 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("첫번째 숫자를 입력해주세요");
        int a = scan.nextInt();
        System.out.println("연산 기호를 입력해주세요");
        String cal = scan.next();
        System.out.println("두번째 숫자를 입력해주세요");
        int b = scan.nextInt();

        if(cal.equals("+")){
            System.out.println(a+b);
        }
        if(cal.equals("-")){
            System.out.println(a-b);
        }
        if(cal.equals("*")){
            System.out.println(a*b);
        }
        if(cal.equals("/")){
            System.out.println((double)a/b);
        }
    }
}
