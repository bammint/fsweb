package exam;

import java.util.Scanner;

public class ex39 {
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

        // int[] num = new int [3];
        // for(int i=0; i<3; i++){
        //     System.out.println();
        //     num[i] = scanner.nextInt();
        // }
        // int min = num[0];
        // for(i=0; i<num.length; i++){
        //     if(num[i]<min){
        //         min = num[i];
        //     }
        // }
        // System.out.println("최소값은? " + min);

        scanner.close();
    }
}
