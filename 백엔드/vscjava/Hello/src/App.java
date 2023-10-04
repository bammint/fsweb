// import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // int sum = 0;
        // int i = 0;
        // for (i = 1; i <= 100; i++) {
        //     if(i%3 ==0){
        //         System.out.println(i);
        //         sum += i;
        //     }
        // } 
        // -------------------------------------------
        // for (i = 1; i <= 100; i++) {
        //     if(i%3 !=0){
        //         continue;
        //     } 
        //     sum += i;
        // }
        // System.out.println("1~100 3의 배수 합: " + sum);

        // ----------------------------------------------
        // while(true){
        //     int num1 = (int)(Math.random()*6) + 1;
        //     int num2 = (int)(Math.random()*6) + 1;
        //     if(num1+num2 != 5){
        //         continue;
        //     }
        //     System.out.println(num1+","+num2);
        //     break;
        // }
        //-----------------------------------------------------

        // for(int i=1; i<=10; i++){
        //     int num1= 4*i;
        //     for (int j=1; j<=10; j++){
        //         int num2= 5*j;
        //         if(num1+num2 ==60){
        //             System.out.println("("+i+","+j+")");
        //         }
        //     }
        // }
        //----------------------------------------------------
        
        for(int i=1; i<5; i++){
            System.out.println("*");
            for(int j=0; j<i; j++){
                System.out.print("*");
            }
        }
        System.out.print("*");
    }
}
