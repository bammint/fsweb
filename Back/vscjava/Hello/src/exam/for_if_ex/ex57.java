package exam.for_if_ex;

import java.util.Scanner;

public class ex57 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m1 = scan.nextInt();
        int m2 = scan.nextInt();

        // int 치즈버거 = 400;
        // int 야채버거 = 340;
        // int 우유 = 170;
        // int 계란말이 = 100;
        // int 샐러드 = 70;

        int[] menu = {400,340,170,100,70};

        if(m1<6&&m2<6&&m1!=0&&m2!=0){
            if(menu[m1-1]+menu[m2-1]<=500){
                System.out.println("no angry");
            }
            if(menu[m1-1]+menu[m2-1]>500){
                System.out.println("angry");
            }
        }
    }
}
