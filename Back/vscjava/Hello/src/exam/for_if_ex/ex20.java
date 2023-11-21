package exam.for_if_ex;

import java.util.Scanner;

public class ex20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("세개의 숫자를 입력하세요");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int num3 = scan.nextInt();
        int[] num = {num1,num2,num3};

        float sum = 0;
        for(int i=0; i<num.length; i++){
            sum += num[i];
        }
        System.out.println("합계");
        System.out.println(sum);
        System.out.println("평균");
        System.out.println((double)sum/num.length);
        // System.out.printf("%.1f",sum/num.length);

        scan.close();
    }
}
