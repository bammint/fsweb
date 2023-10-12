package exam;

import java.util.Scanner;

public class ex59_1 {
    public static void main(String[] args) {
        int[] lotto = {13,23,24,35,40,45};
        int bonus = 7;
        int[] myNumber = {2,6,7,23,40,44};
        int count = 0;
        int bonusCount = 0;
        for(int i=0; i<6; i++){// 내번호
            for(int j=0; j<6; j++){// 당첨번호
                if(myNumber[i]==lotto[i]){
                    count++;
                }
            }
        }
        if(count==6){
            System.out.println("1둥 당첨");
        }else if(count==5){
            for(int i=0; i<6; i++){
                if(myNumber[i]==bonus){
                    bonusCount++;
                }
            }
            if(bonusCount>0){
                System.out.println("2등 당첨");
            } else{
                System.out.println("3등 당첨");
            }
        }else if(count==4){
            System.out.println("4등 당첨");
        } else if(count==3){
            System.out.println("5등 당첨");
        } else {
            System.out.println("꽝! 다음 기회에~");
        }
    }
}
