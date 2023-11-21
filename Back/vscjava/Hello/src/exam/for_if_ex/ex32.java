package exam.for_if_ex;

import java.util.Scanner;

public class ex32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("grade: ");
        char ch = scanner.nextLine().charAt(0);

        switch(ch){
            case 'D':
                System.out.println("slowly~");
                break;
            case 'C':
                System.out.println("run!");
                break;
            case 'B':
                System.out.println("good!!");
                break;
            case 'A':
                System.out.println("best!!!");
                break;
            default:
                System.out.println("what?");
                break;
        }
        scanner.close();
    }
}
