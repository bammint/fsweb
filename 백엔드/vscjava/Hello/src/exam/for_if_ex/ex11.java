package exam.for_if_ex;

import java.util.Scanner;

public class ex11 {
    public static void main(String[] args) {
        // 두 개의 문자를 입력받은 후 순서를 바꿔 출력해보자
        
        Scanner scan = new Scanner(System.in);
        System.out.print("첫번째 문자를 입력 >");
        String str1 = scan.next();
        System.out.print("두번째 문자를 입력 >");
        String str2 = scan.next();

        System.out.println(str2 + " " + str1);

        scan.close();
    }
}
