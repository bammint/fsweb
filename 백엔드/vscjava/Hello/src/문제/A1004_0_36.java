package 문제;

import java.util.Scanner;

public class A1004_0_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("원하는 주사위의 값을 입력해주세요.");
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(n<=10&&m<=10){
                System.out.print("주사위의 값: " + i + " ");
                System.out.println(j);
                } else {
                    System.out.println("주사위의 값을 다시 입력해주세요.");
                }
            }
        }
        scanner.close();
    }
}
