package exam.for_if_ex;

import java.util.ArrayList;
import java.util.Scanner;

public class ex72 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Integer> arr = new ArrayList<>();
        int max = 0;

        while(true){
            System.out.println();
            System.out.print("숫자를 입력하세요> ");
            int num = scan.nextInt();
            System.out.println();

            arr.add(num);

            for(int i=0;i<arr.size();i++){
                if(max<arr.get(i)){
                    max = arr.get(i);
                }
                System.out.print(arr.get(i)+", ");
            }
            System.out.println();
            System.out.println("입력받은 숫자의 최대값은?" + max);
        }
    }
}
