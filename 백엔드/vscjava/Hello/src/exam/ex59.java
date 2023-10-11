package exam;

import java.util.Scanner;

public class ex59 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int lottoNum1 = scan.nextInt();
        int lottoNum2 = scan.nextInt();
        int lottoNum3 = scan.nextInt();
        int lottoNum4 = scan.nextInt();
        int lottoNum5 = scan.nextInt();
        int lottoNum6 = scan.nextInt();
        int bonusNum = scan.nextInt();

        int[] lottoNum = { lottoNum1, lottoNum2, lottoNum3, lottoNum4, lottoNum5, lottoNum6, bonusNum };
        // System.out.println(lottoNum);
        // for(int i=0; i<lottoNum.length; i++ ){
        // System.out.println(lottoNum[i]);
        // }
        System.out.println("나의 번호");
        int myNum1 = scan.nextInt();
        int myNum2 = scan.nextInt();
        int myNum3 = scan.nextInt();
        int myNum4 = scan.nextInt();
        int myNum5 = scan.nextInt();
        int myNum6 = scan.nextInt();
        int myNum7 = 0;
        int[] myNum = { myNum1, myNum2, myNum3, myNum4, myNum5, myNum6,myNum7 };
        int[] n = new int[7];

        for (int i = 0; i < lottoNum.length; i++) {
            for (int j = 0; j < myNum.length; j++) {
                if (lottoNum[i] == myNum[j]) {
                    // System.out.println(myNum[j]);
                    n[i] = myNum[j];
                }
            }
        }
        if (n[2] != 0 && n[3] == 0) {
            System.out.println("5 당첨");
        }
        if (n[3] != 0 && n[4] == 0) {
            System.out.println("4 당첨");
        }
        if (n[4] != 0 && n[5] == 0 && n[6] == 0) {
            System.out.println("3 당첨");
            System.out.println(n[6]);
        }
        if (n[5] != 0) {
            System.out.println("1 당첨");
        }
        if (n[5] == 0 && n[6] != 0) {
            System.out.println("2 당첨");
        }
    }
}
