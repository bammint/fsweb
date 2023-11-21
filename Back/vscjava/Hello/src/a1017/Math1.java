package a1017;

import java.util.Random;

public class Math1 {
    public static void main(String[] args) {
        System.out.println((int)(Math.random()*100));

        Random ran = new Random();
        System.out.println(ran.nextInt(100));
    }
}
