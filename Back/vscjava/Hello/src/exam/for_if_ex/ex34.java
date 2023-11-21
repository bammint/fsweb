package exam.for_if_ex;

import java.util.Scanner;

public class ex34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // while(true){
        //     int num = scanner.nextInt();
        //     System.out.println(num);
        //     if(num ==0){
        //         break;
        //     }
        // }
        while(true){
            System.out.println("숫자를 입력해주세요");
            int num = scanner.nextInt();
            if(num !=0){
                System.out.println(num);
                continue;
            } else {
                System.out.println("종료");
                break;
            }
        }
        // for(;;){
        //     System.out.println("숫자를 입력해주세요");
        //     int num = scanner.nextInt();
        //     if(num !=0){
        //         System.out.println(num);
        //         continue;
        //     } else {
        //         System.out.println("종료");
        //         break;
        //     }
        // }
        scanner.close();
    }
}
