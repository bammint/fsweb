package 문제;

import java.util.Scanner;

public class A1005_0_40 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("공이 날아간 거리: ");
        float ball = scanner.nextFloat();
        System.out.println("결과");
        if(50<=ball&&ball<=60){
            System.out.println("win");
        } else {
            System.out.println("lose");
        }
        scanner.close();
    }
}