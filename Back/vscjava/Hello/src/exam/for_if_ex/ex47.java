package exam.for_if_ex;

import java.util.Scanner;

public class ex47 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("연도를 입력하세요");
        int Y = scan.nextInt();

        if(Y%4==0&&Y%100!=0 || Y%400==0){
            System.out.println("윤년입니다");
        } else {
            System.out.println("윤년이 아닙니다");
        }
        scan.close();
    }
}
