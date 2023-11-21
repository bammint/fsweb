

import java.util.Scanner;

public class A20_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        O: while (true) {
            System.out.println("================================================");
            System.out.println("1. 계좌 생성 | 2. 계좌목록 | 3.예금 | 4.출금 | 5.종료");
            System.out.println("================================================");
            System.out.print("선택 > ");
            String select = scanner.nextLine();
            switch (select) {
                // 1. 계좌 생성
                case "1":
                    System.out.print("계좌번호 : ");
                    String _acc = scanner.nextLine();
                    System.out.print("계좌주 : ");
                    String _name = scanner.nextLine();
                    System.out.print("초기입급액 : ");
                    String _money = scanner.nextLine();
                    Account.add(_acc, _name, _money);
                    break;
                // 2. 계좌목록
                case "2":
                    System.out.println("--------------");
                    System.out.println("   계좌 목록   ");
                    System.out.println("--------------");
                    Account.display();
                    break;
                // 3. 예금
                // 계좌번호, 금액을 받아 해당 계좌번호를 가진 Account에 금액 추가
                case "3":
                    System.out.print("계좌번호 : ");
                    String depAcc = scanner.nextLine();
                    System.out.print("입급액 : ");
                    String depMoney = scanner.nextLine();
                    Account.deposit(depAcc, depMoney);
                    break;
                // 4.출금
                // 계좌번호, 금액을 받아 해당 계좌번호를 가진 Account에 긍액 제거
                case "4":
                    System.out.print("계좌번호 : ");
                    String wdAcc = scanner.nextLine();
                    System.out.print("출금액 : ");
                    String wdMoney = scanner.nextLine();
                    Account.withdrawal(wdAcc, wdMoney);
                    break;
                // 5.종료
                case "5":
                    System.out.println("프로그램 종료");
                    break O;
            }
        }
    }
}

class Account {
    private static String[][] accArr = new String[100][3];
    public static boolean rel;
    public static int sum;
    private static int index = 0;

    static void add(String acc, String name, String balance) {
        if (index < 100) {
            for (int i = 0; i < accArr[0].length; i++) {
                accArr[index][0] = acc;
                accArr[index][1] = name;
                accArr[index][2] = balance;
            }
            System.out.println("결과 : 계좌가 생성되었습니다.");
            index += 1;
        } else {
            System.out.println("더 이상 계좌를 생성 할 수 없습니다.");
        }
    }

    public static void display() {
        for (int i = 0; i < index; i++) {
            System.out.printf("%s\t%s\t%s\n", accArr[i][0], accArr[i][1], accArr[i][2]);
        }
    }

    public static void deposit(String accNumber, String balance) {
        rel = true;
        for (int i = 0; i < index; i++) {
            if (accArr[i][0].equals(accNumber) && Integer.parseInt(balance) > 0) {
                rel = false;
                sum = Integer.parseInt(accArr[i][2]) + Integer.parseInt(balance);
                accArr[i][2] = String.valueOf(sum);
            }
        }
        if (rel)
            System.out.println("계좌 번호 및 입금 금액을 확인해 주세요.");
    }

    public static void withdrawal(String accNumber, String balance) {
        rel = true;
        for (int i = 0; i < index; i++) {
            if (accArr[i][0].equals(accNumber)) {
                rel = false;
                if (Integer.parseInt(accArr[i][2]) < Integer.parseInt(balance) || Integer.parseInt(balance) < 0) {
                    System.out.println("잔액이 모자랍니다 \n 출금액을 확인해 주세요.");
                } else {
                    sum = Integer.parseInt(accArr[i][2]) - Integer.parseInt(balance);
                    accArr[i][2] = String.valueOf(sum);
                    System.out.println("결과 : 출금이 성공되었습니다.");
                }
            }
        }
        if (rel)
            System.out.println("계좌 번호를 확인해 주세요.");
    }
}