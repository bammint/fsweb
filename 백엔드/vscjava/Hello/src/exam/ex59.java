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

        int[] lottoNum = { lottoNum1, lottoNum2, lottoNum3, lottoNum4, lottoNum5, lottoNum6 };
        System.out.println("나의 번호");
        int myNum1 = scan.nextInt();
        int myNum2 = scan.nextInt();
        int myNum3 = scan.nextInt();
        int myNum4 = scan.nextInt();
        int myNum5 = scan.nextInt();
        int myNum6 = scan.nextInt();
        int[] myNum = { myNum1, myNum2, myNum3, myNum4, myNum5, myNum6 };
        int[] n = new int[6];
        int count = 0;
        int bonusCount = 0;

        for (int i = 0; i < lottoNum.length; i++) {
            for (int j = 0; j < myNum.length; j++) {
                if (lottoNum[i] == myNum[j]) {
                    n[i] = myNum[j];
                    n[count] = myNum[j];
                    count++;
                    // System.out.println("n: "+n[i]);
                    // System.out.println("count" + count);
                }
            }
        }
        if (count == 6) {
            System.out.println("1 당첨");
        }else if(count == 5){
            for(int i=0; i<6; i++){
                if(myNum[i] == bonusNum){
                    bonusCount++;
                }
            }
            System.out.println("bonusC" + bonusCount);
            if(bonusCount>0){
                System.out.println("2 당첨");
            }else {
                System.out.println("3 당첨");
            }
        }
        if (count == 4) {
            System.out.println("4 당첨");
        }
        if (count == 3) {
            System.out.println("5 당첨");
        }
        if (count == 0 || count == 1 || count == 2) {
            System.out.println("0 꽝!");
        }
    }
}
