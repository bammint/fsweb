package exam.for_if_ex;

import java.util.Scanner;

public class ex10 {
    public static void main(String[] args) {
        // 정수 두 개를 차례로 입력받아 그대로 출력한다
        // 입력
        // 두 개의 정수가 차례대로 입력된다
        // 출력
        // 입력받은 두 정수를 공백으로 구분하여 그대로 출력
        // 입력 예시
        // 1
        // 2
        // 출력 예시
        // 1 2
        
        Scanner scan = new Scanner(System.in);
        System.out.println("첫번째 숫자를 입력하세요");
        int num1 = scan.nextInt();
        System.out.println("두번째 숫자를 입력하세요");
        int num2 = scan.nextInt();
        System.out.println(num1 + " " + num2);

        scan.close();
    }
}
