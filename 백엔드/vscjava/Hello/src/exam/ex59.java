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
        // System.out.println(lottoNum);
        // for(int i=0; i<lottoNum.length; i++ ){
        // System.out.println(lottoNum[i]);
        // }
        int myNum1 = scan.nextInt();
        int myNum2 = scan.nextInt();
        int myNum3 = scan.nextInt();
        int myNum4 = scan.nextInt();
        int myNum5 = scan.nextInt();
        int myNum6 = scan.nextInt();
        int[] myNum = { myNum1, myNum2, myNum3, myNum4, myNum5, myNum6 };

        for(int i=0; i<lottoNum.length; i++ ){
            if((lottoNum[i]==myNum[i])){

            }
        }
    }
}
