package exam;

import java.util.Scanner;

public class ex54 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        for(int x=2; x<100; x++){
            if(a*x==b){
                System.out.println(a+"*"+x+"="+b);
                break;
            } else if(b*x==a){
                System.out.println(b+"*"+x+"="+a);
                break;
            } else if(a*x!=b || b*x!=a) {
                System.out.println("none");
                break;
            }
        }
        scan.close();
    }
}
