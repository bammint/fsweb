package 문제;

import java.util.Scanner;

public class A1005_0_39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("세개의 정수를 입력하세요.");
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        int[] num = {num1,num2,num3};

        int i = 0;
        int min = num[i];
        for(i=0; i<num.length; i++){
            if(num[i]<min){
                min = num[i];
            }
        }
        System.out.println("작은 수: " + min);
        scanner.close();
    }
}
