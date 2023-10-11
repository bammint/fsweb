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

    //     Calculator c = new Calculator();
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("a를 입력하세요.");
    //     int  a = scanner.nextInt();
    //     System.out.println("b를 입력하세요.");
    //     int b= scanner.nextInt();
    //     double max =0;
    //     double[] arr= {c.plus(a, b),
    //                     c.plus(b, a),
    //                     c.minus(a, b),
    //                     c.minus(b, a),
    //                     c.multiply(a, b),
    //                     c.multiply(b, a),
    //                     c.divide(a, b),
    //                     c.divide(b, a),
    //                     c.pow(a, b),
    //                     c.pow(b, a)
    //     };

    //     System.out.printf("%d + %d = %.0f, ", a, b, arr[0]);
    //     System.out.printf("%d + %d = %.0f\n", b, a, arr[1]);
    //     System.out.printf("%d - %d = %.0f, ", a, b, arr[2]);
    //     System.out.printf("%d - %d = %.0f\n", b, a, arr[3]);
    //     System.out.printf("%d * %d = %.0f, ", a, b, arr[4]);
    //     System.out.printf("%d * %d = %.0f\n", b, a, arr[5]);
    //     System.out.printf("%d / %d = %.1f, ", a, b, arr[6]);
    //     System.out.printf("%d / %d = %.1f\n", b, a, arr[7]);
    //     System.out.printf("%d ^ %d = %.0f, ", a, b, arr[8]);
    //     System.out.printf("%d ^ %d = %.0f\n", b, a, arr[9]);

    //     for (int i =0; i < arr.length;i++){
    //         if (arr[i]>max){
    //             max=arr[i];
    //         }
    //     }
    //     System.out.printf("최대값 : %f", max );
    // }


    // static class Calculator{
    //     int a;
    //     int b;
    //         int plus (int a, int b){
    //             return a +b;
    //         }
    //         int minus (int a, int b){
    //             return a- b;
    //         }
    //         int multiply (int a, int b){
    //             return a *b;
    //         }
    //         double divide (int a, int b){
    //             return (double) a / b;
    //         }
    //         double pow(int a, int b){return Math.pow(a ,b);}
    //     }
    // }
    }
}

