package A1004;

import java.util.Scanner;

public class A1004_ex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean bank = true;
        int money = 0;

        while (bank) {
            System.out.println("--------------------------------------");
            System.out.println("1. 예금 | 2. 출금 | 3. 잔고 | 4. 종료");
            System.out.println("--------------------------------------");
            System.out.print("선택> ");
            String strNum = scanner.nextLine();

            if (strNum.equals("1")) {
                System.out.print("예금액> ");
                String num = scanner.nextLine();
                money = money + Integer.parseInt(num);
            } else if (strNum.equals("2")) {
                System.out.print("출금액> ");
                String num = scanner.nextLine();
                money = money - Integer.parseInt(num);
            } else if (strNum.equals("3")) {
                System.out.print("잔고> ");
                System.out.println(money);
            } else if (strNum.equals("4")) {
                bank = false;
            }
        }
        System.out.println("프로그램 종료");
        scanner.close();
    }
}
