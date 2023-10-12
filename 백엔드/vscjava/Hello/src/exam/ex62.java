package exam;

import java.util.Scanner;

public class ex62 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] str = scan.nextLine().split(" ");
        
        while(true){

            for(int i=0;i<str.length; i++){
                str[i].replaceAll("[^0-9]", "");
                if(str[i].equals("")){
                    System.out.println("다시 입력해주세요");
                    str = scan.nextLine().split(" ");
                    continue;
                }else if(Integer.parseInt(str[0])<=3&&Integer.parseInt(str[1])<=20&&Integer.parseInt(str[2])<=999){
                if(str[1].length()==1){
                    str[1] = "0"+str[1];
                }
                if(str[2].length()==1){
                    str[2] = "00"+str[2];
                }
                if(str[2].length()==2){
                    str[2] = "0"+str[2];
                }
                }else{
                    System.out.println("다시 입력해주세요");
                    str = scan.nextLine().split(" ");
                    continue;
                }
            }
            break;
        }
    System.out.printf("%s%s%s", str[0],str[1],str[2]);
        // System.out.println("str[2]" + str[2]);
    }
}
