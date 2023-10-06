package exam;

import java.util.Scanner;

public class ex48 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("생년월일 여섯자리를 입력해주세요");
        String birth = scan.nextLine();
        System.out.println("성별 번호를 입력해주세요");
        int sex = scan.nextInt();
        String x = "19" + birth.substring(0,2);
        String y = "20" + birth.substring(0,2);

        if(sex == 1 || sex == 3){
            System.out.println("남자");
        }else if(sex == 2 || sex == 4){
            System.out.println("여자");
        } else {
            System.out.println("다시 입력해주세요");
        }

        if(sex == 1 || sex == 2){
            System.out.println(2023-Integer.parseInt(x)+1);
        }
        if(sex == 3 || sex == 4){
            System.out.println(2023-Integer.parseInt(y)+1);
        }

        scan.close();    
    }
}
