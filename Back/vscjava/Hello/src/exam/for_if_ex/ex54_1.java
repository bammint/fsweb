package exam.for_if_ex;

import java.util.Scanner;

public class ex54_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("a의 값을 입력하세요");
        int a = scan.nextInt();
        System.out.println("b의 값을 입력하세요");
        int b = scan.nextInt();

        int x = 0;
        if(b%a==0){
            x = b/a;
            System.out.println(a+"*"+x+"="+b);
        } else if(a%b==0){
            x = a/b;
            System.out.println(b+"*"+x+"="+a);
        } else {
            System.out.println("none");
        }

        
        scan.close();
    }
}
