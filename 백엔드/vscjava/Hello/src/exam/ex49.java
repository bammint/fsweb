package exam;

import java.util.Scanner;

public class ex49 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int h = scan.nextInt();
        int m = scan.nextInt();

        if(h>=0 && h<=23){
            if(m>=0 && m<=59){
                if(m == 0){
                    System.out.println("30분 전 시간");
                    System.out.println((h-1) + " " + (m+30));
                } else if(m>=30){
                    System.out.println("30분 전 시간");
                    System.out.println((h) + " " + (m-30));
                } else if(m<30){
                    System.out.println("30분 전 시간");
                    System.out.println((h-1) + " " + (m-30+60));
                }
            } else{
                System.out.println("다시 입력해주세요");
            }
        } else{
                System.out.println("다시 입력해주세요");
            }
        scan.close();
    }
}
