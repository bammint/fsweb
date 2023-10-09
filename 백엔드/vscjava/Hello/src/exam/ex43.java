package exam;

import java.util.Scanner;

public class ex43 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] arr = str.toCharArray();
        char[] unit1 = {' ','십','백','천'};
        // char[] unit2 = {' ','만'};
        char[] f = new char[arr.length];

        int i = 0;
        for(i=0; i<arr.length;i++){
            switch(arr[i]){
                case '1':
                    arr[i] = '일';
                    break;
                case '2':
                    arr[i] = '이';
                    break;
                case '3':
                    arr[i] = '삼';
                    break;
                case '4':
                    arr[i] = '사';
                    break;
                case '5':
                    arr[i] = '오';
                    break;
                case '6':
                    arr[i] = '육';
                    break;
                case '7':
                    arr[i] = '칠';
                    break;
                case '8':
                    arr[i] = '팔';
                    break;
                case '9':
                    arr[i] = '구';
                    break;
            }
            f = unit1[arr.length-1];
            // System.out.print(arr[i] + unit1[arr.length-1]);
        }
        // System.out.println(arr);
        // System.out.println(arr[i]);
    }
}
