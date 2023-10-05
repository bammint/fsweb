package 문제;

import java.util.Scanner;

public class A1004_0_33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ch = Integer.parseInt(scanner.nextLine());
        switch(ch){
            case 12:
            case 1:
            case 2:
            System.out.println("winter");
            break;
            case 3:
            case 4:
            case 5:
            System.out.println("spring");
            break;
            case 6:
            case 7:
            case 8:
            System.out.println("summer");
            break;
            case 9:
            case 10:
            case 11:
            System.out.println("fall");
            break;
        }
        scanner.close();
    }
}
