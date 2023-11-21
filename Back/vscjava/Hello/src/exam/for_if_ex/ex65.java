package exam.for_if_ex;

import java.util.Scanner;

public class ex65 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        for(int i = 1; i<=a; i++){
            if(a>=1&&a<=10){
                if(i%3==0){
                    System.out.print("X");
                }else{
                    System.out.print(i);
                }
            }else{
                System.out.println("다시 입력해주세요");
            }
            // System.out.println(i);
        }
    }
}
