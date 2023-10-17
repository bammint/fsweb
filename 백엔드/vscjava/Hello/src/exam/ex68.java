package exam;

import java.util.Scanner;

public class ex68 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();

        for(int i =0; i<=a; i++){
            System.out.println(i);
            if(a>100){
                System.out.println("다시 실행해주세요");
            }
        }
    }
}
