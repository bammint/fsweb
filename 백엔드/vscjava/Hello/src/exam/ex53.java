package exam;

import java.util.Scanner;

public class ex53 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        double a = scan.nextInt();
        double b = scan.nextInt();

        double[] arr = {a+b,b+a,a-b,b-a,a*b,b*a,a/b,b/a,Math.pow(a, b),Math.pow(b, a)};

        double max = 0; 
        for(int i=0; i<arr.length; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        System.out.printf("%.6f",max);
        scan.close();
    }
}
