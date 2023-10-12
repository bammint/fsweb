package exam;

import java.util.Scanner;

public class ex56_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] s1 = new int[4];

        // 4가지 윷의 상태 입력
        for(int i=0; i<4; i++){
            s1[i] = scan.nextInt();
        }
        int count = 0;
        for(int state:s1){
            if(state==1){
                count++;
            }
        }
        switch(count){
            case 0:
            System.out.println("모 가 나왔습니다.");
            break;
            case 1:
            System.out.println("도 가 나왔습니다.");
            break;
            case 2:
            System.out.println("개 가 나왔습니다.");
            break;
            case 3:
            System.out.println("걸 가 나왔습니다.");
            break;
            case 4:
            System.out.println("윷 가 나왔습니다.");
            break;
            default :
            System.out.println("잘못된 값을 입력했습니다.");
            break;
        }
    }
}
