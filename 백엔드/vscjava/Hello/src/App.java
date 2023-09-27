import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // int score = 69;

        // if(score>=90){
        // System.out.println("점수가 90점 이상입니다.");
        // System.out.println("등급은 A입니다.");
        // } else if (score>=80){
        // System.out.println("점수가 80점 이상입니다.");
        // System.out.println("등급은 B입니다.");
        // } else if (score>=70){
        // System.out.println("점수가 70점 이상입니다.");
        // System.out.println("등급은 C입니다.");
        // } else {
        // System.out.println("점수가 70점 미만입니다.");
        // System.out.println("등급은 F입니다.");
        // }

        // System.out.println(score);

        Scanner scanner = new Scanner(System.in);
        System.out.print("점수 입력: ");
        String score = scanner.nextLine();
        int scr = Integer.parseInt(score);
        if (scr >= 90) {
            System.out.println("점수가 90점 이상입니다.");
            System.out.println("등급은 A입니다.");
        } else if (scr >= 80) {
            System.out.println("점수가 80점 이상입니다.");
            System.out.println("등급은 B입니다.");
        } else if (scr >= 70) {
            System.out.println("점수가 70점 이상입니다.");
            System.out.println("등급은 C입니다.");
        } else {
            System.out.println("점수가 70점 미만입니다.");
            System.out.println("등급은 F입니다.");
        }

        
    }
}
