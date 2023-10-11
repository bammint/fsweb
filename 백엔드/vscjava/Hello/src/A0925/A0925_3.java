package a0925;

public class A0925_3 {
    public static void main(String[] args) {
        int hour = 3;
        int minute = 5;
        System.out.println(hour + "시간" + minute + "분");
        int totalMinute = (hour*60) + minute;
        System.out.println("총" + totalMinute + "분");
    }
}
