package exam;

import java.util.Scanner;

public class ex66 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요> ");
        int a = scan.nextInt();
        int sum = 0;
        /* for (int i = 0; i<=a; i++) {
            sum = sum+i;
            if(sum>=a){
                break;
            }
        } */
        int i = 1;
        while(true){
            sum = sum + i;
            if(sum>=a){
                break;
            }
            System.out.print(i + "+");
            i++;
        }
        System.out.println();
        System.out.println(sum + "입력한 수보다 크거나 같으므로 종료합니다");
    }
}
