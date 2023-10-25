package exam.for_if_ex;

import java.util.Scanner;

public class ex46 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("터널의 높이를 입력하세요");
        int t = scan.nextInt();
        int car = 170;

        System.out.println("결과");
        if(t>car){
            System.out.println("PASS");
        } else {
            System.out.println("CRASH");
        }
        scan.close();
    }
}
