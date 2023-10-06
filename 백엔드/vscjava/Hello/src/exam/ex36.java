package exam;

import java.util.Scanner;

public class ex36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("첫번째 주사위의 값을 입력해주세요.");
        int n = scanner.nextInt();
        System.out.println("두번째 주사위의 값을 입력해주세요.");
        int m = scanner.nextInt();

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(n<=10&&m<=10){
                System.out.println("주사위의 값: " + i + " " + j);
                } else {
                    System.out.println("주사위의 값을 다시 입력해주세요.");
                }
            }
        }
        scanner.close();
    }
}
