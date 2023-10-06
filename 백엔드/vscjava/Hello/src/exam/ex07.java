package exam;

import java.util.Scanner;

public class ex07 {
    public static void main(String[] args) {
        // 키보드로 입력한 정수값을 그대로 출력하는 프로그램을 작성해보자
        // Scanner scanner = new Scanner(System.in);
        // 상단 import java.utill.Scanner;
        // Scanner 클래스를 사용하면 된다. next() 메소드 사용
        // 상단에 import 가 안나올때는 Alt + Shift + O(영문자)
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        System.out.println(num);
        scan.close();
    }
}
