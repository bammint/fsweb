package A1004;

import java.util.Scanner;

public class A1004_0_36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i,j;
        int n=6, m=6;
        n = Integer.parseInt(scanner.nextLine());
        m = Integer.parseInt(scanner.nextLine());
        for(i=1;i<=n;i++){
            for(j=1;j<=m;j++){
                System.out.println(i+","+j);
            }
        }
    }
}
