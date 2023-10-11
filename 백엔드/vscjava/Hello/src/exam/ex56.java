package exam;

public class ex56 {
    public static void main(String[] args) {
        int[] s1 = new int[5];
        int sum = 0;
        for(int i=0; i<4; i++){
            s1[i] += (int)(Math.random()*2);
            sum += s1[i];
            System.out.println(s1[i]);
        }
        if(sum==0){
            System.out.println("모");
            }
        if(sum==1){
            System.out.println("도");
            }
        if(sum==2){
            System.out.println("개");
            }
        if(sum==3){
            System.out.println("걸");
        }
        if(sum==4){
            System.out.println("윷");
        }
    }
}
